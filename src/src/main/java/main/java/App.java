package main.java;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception{

        //fazer requisicao HTTP e buscar os top 250 filmes

        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
//        System.out.println(body);


        Gson gson = new Gson();
        String json = "{\"items\":[{\"title\":\"A Bela e a Fera\", \"image\":\"teste\",\"rank\":\"2\",\"year\":\"1990\"},{\"title\":\"Lion King\", \"image\":\"teste\",\"rank\":\"2\",\"year\":\"1990\"}],\"error\":\"\"}";
        JsonObject jsonObject = gson.fromJson(json,JsonObject.class);

        System.out.println(jsonObject);
        MoviesApi items = gson.fromJson(jsonObject,MoviesApi.class);
        List<Movies> moviesList = List.of(items.getItems());
        System.out.println("O tamando da lista extraida do jsonObject: "+moviesList.size());

        //extrair apenas as infos do objeto jsonObject

        Movies movie;
        for (int i=0; i < moviesList.size() ; i++ ){
            movie = moviesList.get(i);
            System.out.println(movie.getTitle());
            System.out.println(movie.getRank());
            System.out.println(movie.getImage());
            System.out.println(movie.getYear());
            System.out.println();
        }


        //extrair apenas os dados que interessam (titulo,poster, classificacao)
        var parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);

        System.out.println("O tamando da lista extraida da API: "+listaDeFilmes.size());

        // exibir e manipular os dados
//        for (Map<String,String> filme : listaDeFilmes) {
//            System.out.println(filme.get("title"));
//            System.out.println(filme.get("image"));
//            System.out.println(filme.get("imDbRating"));
//            System.out.println();
//        }
    }
}
