package com.springrest.services;

import com.springrest.mappers.NYTMapper;
import com.springrest.model.nyt.Multimedia;
import com.springrest.model.nyt.NYTTopStories;
import com.springrest.model.nyt.Results;
import exceptions.SectionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class NYTService {

        @Autowired
        RestTemplate restTemplate;

        @Autowired
        NYTMapper mapper;

        public NYTTopStories loadNYTTopStories(){

            NYTTopStories top =restTemplate.getForObject(

                    "http://api.nytimes.com/svc/topstories/v2/home.json?apikey=bae493523d714a96a74585c6bc2d1312", NYTTopStories.class);

            insertTopStories(top);

            return top;

        }

        public void insertTopStories(NYTTopStories stories) {

            //for every result (story) in the NYT repsonse

            for (Results results : stories.getResults()){

                //check to see if the story already exists in our DB
                int id;

                try {
                     id = mapper.getStoryId(results.getUrl());

                } catch (Exception e) {
                    id = 0;
                }
                //if id is 0, that means it does not exist in our DB - we can insert it
                if (id == 0){
                    //insert story
                    int success = mapper.insertTopStory(results);
                   //insertTopStory retubrs the number of rows inserted - if the number is
                    //greater than 0 - that means the story was inserted - now we can insert
                    // the associated multimedia
                    if(success > 0) {
                        //get the id of the newly inserted story to use for each multimedia record
                        id = mapper.getStoryId(results.getUrl());
                       // for every multimedia record in the story
                        for(Multimedia media : results.getMultimedia()){
                            //set the story_id on the multimedia object (associate it with a story in our db)
                            media.setTop_story_id(id);
                            //insert multimedia
                            mapper.insertMultiMedia(media);
                        }
                    }


                }
            }
        }

    public ArrayList<Results> getNYTTopStories(String query) {

            if (!query.equalsIgnoreCase("null")){

                return mapper.searchNYTTopStories( "%" + query + "%");

            } else {
                return mapper.getAllNYTTopStories();
            }


    }


    public ArrayList<Results> topStoriesBySection(String section) throws SectionNotFoundException{


        try {

            int tempID = mapper.checkIfSectionExists(section);

        } catch (Exception npe) {

       // try {

               // if (tempID < 1) {

                    //throw new SectionNotFoundException("Unkown section: " + section, 400);

               // }

           // } catch (NullPointerException npe) {

                throw new SectionNotFoundException("Unkown section: " + section, 400);
            }

            return mapper.searchBySection(section);
    }



}

