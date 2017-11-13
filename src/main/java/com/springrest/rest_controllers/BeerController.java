package com.springrest.rest_controllers;


import com.springrest.model.beer.Beer;
import com.springrest.model.beer.Data;
import com.springrest.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {


    @Autowired
    BeerService service;

    @RequestMapping("/beer/")
    public Beer loadBeer() {
        return service.loadBeer();
    }





    //POSTMAN METHODS

    @RequestMapping(method = RequestMethod.PATCH, value = "/patch")
    public Data updateData(@RequestBody Data data) {
        service.updateData((data));
        return data;
    }



    //Delete // could return a json message saying successfully deleted
    @RequestMapping(method= RequestMethod.DELETE, value="/")
    public void deleteById(@RequestBody Data data){
        Data d = data;
        service.deleteById(data.getId());

    }

    //GET
    @RequestMapping(method= RequestMethod.GET, value="/one")
    public Data getOne(){
        Data d = service.getOne();
        return d;

    }

}


