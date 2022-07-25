package main.java;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception{

        //fazer requisicao HTTP e buscar os top 250 filmes

        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //Tratando dados via Gson
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(body,JsonObject.class);
        MoviesList items = gson.fromJson(jsonObject, MoviesList.class);
        List<Movie> moviesList = List.of(items.getItems());
        System.out.println("O tamando da lista extraida do jsonObject: "+moviesList.size());
        System.out.println();
        System.out.println("Inicio da lista");

        var geradora = new GeradorDeFigurinhas();

        //extrair apenas as infos do objeto jsonObject
        for (Movie movie: moviesList){
            System.out.println(movie.getTitle());
            System.out.println(movie.getRank());
            System.out.println(movie.getImage());
            System.out.println(movie.getYear());
            System.out.println("---//---");
            String urlImagem = movie.getImage();
            String titulo = movie.getTitle();

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "src/src/main/java/images/"+titulo + ".png";
            geradora.cria(inputStream, nomeArquivo);
            System.out.println(titulo);

        }
        System.out.println("Fim da lista");

        //extrair apenas os dados que interessam (titulo,poster, classificacao)
//        var parser = new JsonParser();
//        List<Map<String,String>> listaDeFilmes = parser.parse(body);
//        System.out.println();
//        System.out.println("O tamando da lista extraida da API: "+listaDeFilmes.size());

        // exibir e manipular os dado's
//        for (Map<String,String> filme : listaDeFilmes) {
//            System.out.println(filme.get("title"));
//            System.out.println(filme.get("image"));
//            System.out.println(filme.get("imDbRating"));
//            System.out.println();
        }
    }
