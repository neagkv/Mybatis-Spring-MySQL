package com.springrest.services;
import com.springrest.mappers.BeerMapper;
import com.springrest.model.beer.Beer;
import com.springrest.model.beer.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Service
public class BeerService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BeerMapper mapper;



    public Beer loadBeer() {

        Beer beer = restTemplate.getForObject("http://api.brewerydb.com/v2/beer/random?key=e04176f66e6b8dda1f4e78e0effdc7b4", Beer.class);

        //mapper.insertBeer(beer);

        dataInsert(beer);

        return beer;
    }


    public void dataInsert(Beer beer) {

        int id = 0;

        Data d = beer.getData();

        if (d != d) {

            int success = mapper.insertData(d);

            if (success > 0) {

                // mapper.insertLabel(d.getLabels()); // write query in mapper to insert label object into label table

                mapper.insertStyle(d.getStyle()); // same as above

                mapper.insertCategory(d.getStyle().getCategory()); // same as above

            }

            System.out.println(id);

        }
    }


    // query for outer Data (data) object


    public Data getData(String name) {

        if (!name.equalsIgnoreCase("null")) {

            Data d = mapper.GetDataName(name);

            if (d.getId() != null) {

                d.setStyle(mapper.getStyle(d.getStyleId()));

                d.getStyle().setCategory(mapper.getCategoryById(d.getStyle().getCategoryId()));
            }

        }

        return null;

    }



    //Postman Methods

    //delete
    public int deleteById(String id) {
        return mapper.deleteData(id);
    }

    //post
    public Data updateData(Data data) {
        mapper.updateData(data);
        return mapper.GetDataName(data.getName());
    }

    //get
    public Data getOne(){
        return mapper.GetOneData();
    }


    //put
    public Data createData(Data data) {
        mapper.createData();
        return mapper.GetDataName(data.getName());
    }


}




