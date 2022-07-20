package main.java;

public class MoviesApi {
    private Movies items[];
    private String error;


    public MoviesApi(Movies [] items, String error){

        this.items = items;
        this.error = error;
    }

    public Movies[] getItems(){
        return items;
    }

}
