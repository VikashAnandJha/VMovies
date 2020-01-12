package com.vaj.vmovies.Modal;

public class MoviesListModal {
    int id;
    String imdbId,title,posterUrl,thumbUrl,desc,rating,releaseDate,lang;

    public MoviesListModal(int id, String imdbId, String title, String posterUrl, String thumbUrl, String desc, String rating, String releaseDate, String lang) {
        this.id = id;
        this.imdbId = imdbId;
        this.title = title;
        this.posterUrl = posterUrl;
        this.thumbUrl = thumbUrl;
        this.desc = desc;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.lang = lang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
