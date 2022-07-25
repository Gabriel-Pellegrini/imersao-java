package main.java;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        API minhaApi = API.NASA;

        var http = new ClienteHttp();
        String json = http.buscaDados(minhaApi.url());

        List<Conteudo> conteudos = minhaApi.extrator().extraiConteudos(json);

        System.out.println(conteudos.size());

        //Tratando dados via Gson
//        Gson gson = new Gson();
//        MoviesList items = gson.fromJson(body, MoviesList.class);
//        List<Movie> moviesList = List.of(items.getItems());
//        System.out.println("O tamando da lista extraida do jsonObject: "+moviesList.size());
//        System.out.println();
//        System.out.println("Inicio da lista");

        var geradora = new GeradorDeFigurinhas();

        for (Conteudo conteudo : conteudos) {
            System.out.println(conteudo.getTitle());
            System.out.println(conteudo.getUrlImagem());
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "src/main/java/images/" + conteudo.getTitle() + ".png";
            geradora.cria(inputStream, nomeArquivo);


        }
//
//        //extrair apenas as infos do objeto jsonObject
//        for (Movie movie: moviesList){
//            System.out.println(movie.getTitle());
//            System.out.println(movie.getRank());
//            System.out.println(movie.getImage());
//            System.out.println(movie.getYear());
//            System.out.println("---//---");

//
//             }
//        System.out.println("Fim da lista");
    }
    }
