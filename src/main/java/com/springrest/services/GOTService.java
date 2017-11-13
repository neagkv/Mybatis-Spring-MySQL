package com.springrest.services;


import com.springrest.mappers.GOTMapper;
import com.springrest.model.GOT.GOTQuotes;
import com.springrest.model.User;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GOTService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GOTMapper mapper;


    public GOTQuotes loadGOTQuotes() {
        GOTQuotes gotq = restTemplate.getForObject(
                "https://got-quotes.herokuapp.com/quotes", GOTQuotes.class);


        mapper.insertGOTQuotes(gotq);


        return gotq;



    }



    }









