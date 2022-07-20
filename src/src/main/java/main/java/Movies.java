package main.java;

public class Movies {
    private String title;
    private String rank;
    private String image;
    private String year;


    Movies (String title, String rank , String image , String year){
        this.title = title;
        this.rank = rank;
        this.image = image;
        this.year = year;
    }


    public String getImage() {
        return image;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}
