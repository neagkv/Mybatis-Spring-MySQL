package com.springrest.mappers;

import com.springrest.model.GOT.GOTQuotes;
import com.springrest.model.User;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

@Mapper
public interface GOTMapper {


    String INSERT_GOTQuotes = "INSERT INTO `Game_of_Thrones`.`quote` (quote, character) values (#{quote}, #{character})";

    @Insert(INSERT_GOTQuotes)
    public int insertGOTQuotes(GOTQuotes gotq);






    }


