package com.springrest.mappers;
import com.springrest.model.nyt.Multimedia;
import com.springrest.model.nyt.NYTTopStories;
import com.springrest.model.nyt.Results;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface NYTMapper {

    //a query to check if topstory already exists in db using url

    String Top_Story_EXISTS ="SELECT id FROM `users`.nyt_top_stories where url = #{url}";

    // a query to insert a new top story

    String INSERT_NYTTopStories = "INSERT INTO `users`.nyt_top_stories (" + "section, subsection, title, url, byline, item_type, updated_date," +
            "created_date, published_date, material_type_facet, kicker, short_url) values (#{section}, #{subsection}, " +
            "#{title}, #{url}, #{byline}, #{item_type}, #{updated_date}, #{created_date}, #{published_date}, #{material_type_facet}, " +
            "#{kicker}, #{short_url})";

    //a query to get the id from the latest top story that can be used to insert multimedia

    String INSERT_MULTIMEDIA = "INSERT INTO `users`.multimedia (top_story_id, url, format, height, width, type, subtype," +
             "caption, copyright) values (" +
            " #{top_story_id}, #{url}, #{format}, #{height}, #{width}, #{type}, #{subtype}, #{caption}, #{copyright})";

    String SELECT_ALL_TOP_STORIES = "Select * from `users`.nyt_top_stories";

    String SELECT_WITH_SEARCH_PARAM = "Select * from `users`.nyt_top_stories where title like #{query}";

    String SELECT_STORIES_BY_SECTION = "Select * from `users`.nyt_top_stories where section = #{section} " +
            "Order by updated_date desc limit 10";


    String CHECK_SECTION_EXISTS = "Select id from `users`.nyt_top_stories where section = #{section} " + "limit 1";





    @Select(Top_Story_EXISTS)
    public int getStoryId(String url);

    @Select(SELECT_ALL_TOP_STORIES)
    public ArrayList<Results> getAllNYTTopStories();

    @Select(SELECT_WITH_SEARCH_PARAM)
    public ArrayList<Results> searchNYTTopStories(String query);

    @Select(SELECT_STORIES_BY_SECTION)
    public ArrayList<Results> searchBySection(String section);

    @Select(CHECK_SECTION_EXISTS)
    public int checkIfSectionExists(String section);

    @Insert(INSERT_NYTTopStories)
    public int insertTopStory(Results story);

    @Insert(INSERT_MULTIMEDIA)
    public int insertMultiMedia(Multimedia multimedia);






}
