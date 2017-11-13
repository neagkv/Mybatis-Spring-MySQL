
package com.springrest.rest_controllers;

import java.util.ArrayList;

import com.springrest.model.nyt.CustomResponseObject;
import com.springrest.model.nyt.NYTTopStories;
import com.springrest.model.nyt.Results;
import com.springrest.services.NYTService;
import exceptions.SectionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.xml.ws.Service;

@RestController
@RequestMapping("/nyt")
public class NYTController {

    @Autowired
    NYTService service;

    @RequestMapping("/topstories")
    public ArrayList<Results> getNYTTopStroies(@RequestParam(value = "query", required = false, defaultValue = "null") String query) {
            return service.getNYTTopStories(query);




    }


    @RequestMapping("/topstories/{section:.+}")

    public ResponseEntity<CustomResponseObject> topStoriesBySection(@PathVariable("section") String section)
    throws SectionNotFoundException {

        CustomResponseObject response = new CustomResponseObject();

        // new ResponseEntity(service.topStoriesBySection(section), HttpStatus.OK);

        System.out.println("section = " + section);

        ArrayList<Results> nyt = null;


        try {

            nyt = service.topStoriesBySection(section);

            response.setMessage("sucess");
            response.setData(nyt);
            response.setStatus_code(200);


            return new ResponseEntity(response, HttpStatus.OK);

        } catch (SectionNotFoundException down) {

            throw down;

//            response.setMessage("error");
//            response.setError(e);
//            response.setStatus_code(400);

//            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }


    }




    @RequestMapping("/topstories/load")
    public NYTTopStories loadNYTTopStrories() {
        return service.loadNYTTopStories();
    }




    }






