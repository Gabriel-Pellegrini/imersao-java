package main.java;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ExtratorDeConteudoDaNasa extends ExtratorMovieConteudo {

    @Override
    public List<Conteudo> extraiConteudos(String json) {
        Gson gson = new Gson();

        NasaImage[] listaDeAtributos = gson.fromJson(json,NasaImage[].class);

        List<Conteudo> conteudos = new ArrayList<>();
        //popular a lista de conteudo
        for (NasaImage image : listaDeAtributos) {

            String titulo = image.getTitle();
            String url = image.getUrl();
            var conteudo = new Conteudo(titulo,url);
            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
