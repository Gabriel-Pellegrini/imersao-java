package main.java;

public class NasaImage {

    private final String title;
    private final String url ;

    NasaImage (String title, String url){
        this.title = title;
        this.url = url ;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
