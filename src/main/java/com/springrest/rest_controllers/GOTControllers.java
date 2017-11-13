package com.springrest.rest_controllers;
import com.springrest.model.GOT.GOTQuotes;
import com.springrest.services.GOTService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.xml.ws.Service;

@RestController
public class GOTControllers {

    @Autowired
    GOTService service;


    @RequestMapping("/got/")
    public GOTQuotes loadGOTQuotes() {
        return service.loadGOTQuotes();

}



}
