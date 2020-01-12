package com.vaj.vmovies;

public class Config {


   public static String API_URL="https://api.themoviedb.org/3/";
    public static String API_KEY="56d71d78d135d869ab6b64f2c09d63a9";
    public static String API_KEY_URL="?api_key="+API_KEY+"&";

    public static String API_SEARCH_MOVIE_URL=API_URL+""+"search/movie"+API_KEY_URL;
}
