package com.springrest.mappers;
import com.springrest.model.beer.Beer;
import com.springrest.model.beer.Category;
import com.springrest.model.beer.Data;
import com.springrest.model.beer.Style;
import com.springrest.model.nyt.Results;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface BeerMapper {





        String INSERT_Data = "INSERT INTO `beer`.`data` (`id`, `name`, `nameDisplay`, `description`, `abv`, `styleId`, " +
                "`isOrganic`, `statusDisplay`, `createDate`, `updateDate`) VALUES " +
                "(#{id}, #{name}, #{nameDisplay}, #{description}, #{abv}, #{styleId}, " +
                "#{isOrganic}, #{statusDisplay}, #{createDate}, #{updateDate})";

        String INSERT_Style ="INSERT INTO `beer`.`style` (`id`, `categoryId`, `name`, `shortName`, `description`, `ibuMin`, " +
                "`ibuMax`,`abvMin` ,`srmMin`, `ogMin`, `fgMin`, `createDate`, `updateDate`) VALUES " +
                "(#{id}, #{categoryId}, #{name}, #{shortName}, #{description}, #{ibuMin}, #{ibuMax}, #{abvMin} ,#{srmMin}," +
                "#{ogMin}, #{fgMin}, #{createDate}, #{updateDate})";


        String INSERT_Category ="INSERT INTO `beer`.`category` (`id`,`name`,`createDate`) VALUES " +
                "(#{id}, #{name}, #{createDate})";

        String SELECT_DATA = "Select * from `beer`.`data` where name = #{name}";

        String SELECT_ONE = "Select * from `beer`.`data` limit 1";

        String SELECT_STYLE = "select * from `beer`.`style` where id = #{id}";

        String SELECT_Category_By_Id ="select id from `beer`.`category` where id = #{id}";

        String GET_Category_By_Id ="select * from `beer`.`category` where id = #{id}";





    @Insert(INSERT_Data)
    public int insertData(Data data);

    @Insert(INSERT_Style)
    public int insertStyle(Style style);

    @Insert(INSERT_Category)
    public int insertCategory(Category category);


    @Select(SELECT_DATA)
    public Data GetDataName(String name);



    @Select(SELECT_STYLE)
    public Style getStyle(int styleId);

    @Select(GET_Category_By_Id)
    public Category getCategoryById(int categoryId);



        //Postman

        String DELETE = "Delete From `beer`.data  WHERE id = #{id}";

        String UPDATE = "UPDATE `beer`.data SET name= #{name}, nameDisplay= #{nameDisplay}, description= #{description}," +
                "abv= #{abv}, styleId= #{styleId}, isOrganic= #{isOrganic}, status= #{status}, statusDisplay= #{statusDisplay}," +
                "createDate= #{createDate}, updateDate= #{updateDate} WHERE id= #{id}";


        @Select(SELECT_ONE)
        public Data GetOneData();

        @Delete(DELETE)
        public int deleteData(String id);

        @Update(UPDATE)
        public int updateData(Data data);
}

