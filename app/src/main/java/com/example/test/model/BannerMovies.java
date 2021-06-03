package com.example.test.model;

public class BannerMovies {
    Integer id;
    String MovieName;
    String imageurl;
    String fileurl;

    public BannerMovies(int id, String movieName, String imageurl, String fileurl){
        this.id = id;
        this.MovieName = movieName;
        this.imageurl = imageurl;
        this.fileurl = fileurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }
}

