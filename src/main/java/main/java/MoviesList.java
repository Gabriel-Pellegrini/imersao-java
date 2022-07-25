package main.java;


public class MoviesList {
    private Movie items[];
    private String error;


    public MoviesList(Movie[] items, String error){

        this.items = items;
        this.error = error;
    }

    public Movie[] getItems(){
        return items;
    }

}
