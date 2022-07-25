package main.java;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ExtratorMovieConteudo implements ExtratorConteudo {

    public List<Conteudo> extraiConteudos (String json){
        Gson gson = new Gson();

        MoviesList movies = gson.fromJson(json,MoviesList.class);
        Movie[] listaDeAtributos = movies.getItems();

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Movie movie : listaDeAtributos) {

            String titulo = movie.getTitle();
            String urlImagem = movie.getImage()
                    .replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        return conteudos;
    }

}
