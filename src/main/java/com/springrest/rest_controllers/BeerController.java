package com.springrest.rest_controllers;


import com.springrest.model.beer.Beer;
import com.springrest.model.beer.Data;
import com.springrest.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BeerController {


    @Autowired
    BeerService service;

    @RequestMapping("/beer/")
    public Beer loadBeer() {
        return service.loadBeer();
    }





    //POSTMAN METHODS


    //patch
    @RequestMapping(method = RequestMethod.PATCH, value = "/patch")
    public Data updateData(@RequestBody Data data) {
        service.updateData((data));
        return data;
    }


    //Put
    @RequestMapping(method = RequestMethod.PUT, value = "/put")
    public Data createData(@RequestBody Data data) {
        service.createData((data));
        return data;
    }






    //Delete // could return a json message saying successfully deleted
    @RequestMapping(method= RequestMethod.DELETE, value ="/")
    public void deleteById(@RequestBody Data data){
        Data d = data;
        service.deleteById(data.getId());

    }

    //GET
    @RequestMapping(method= RequestMethod.GET, value="/one")
    public Data selectOne() {
        Data d = service.getOne();
        return d;


    }
}




