package main.java;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ExtratorDeConteudoDeMeme extends ExtratorMovieConteudo {

    public List<Conteudo> extraiConteudos(String json) {
        Gson gson = new Gson();

        MemeImage[] listaDeAtributos = gson.fromJson(json,MemeImage[].class);
        List<Conteudo> conteudos = new ArrayList<>();
        //popular a lista de conteudo
        for (MemeImage image : listaDeAtributos) {

            String titulo = image.getMeme();
            String url = image.getUrlImagem();
            var conteudo = new Conteudo(titulo,url);
            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
