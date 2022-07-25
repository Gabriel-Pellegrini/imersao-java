package main.java;

public enum API {

    MOVIE("https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json",
            new ExtratorMovieConteudo()),

    NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json",
            new ExtratorDeConteudoDaNasa());

//    MEME("https://api.mocki.io/v2/549a5d8b/Memes", new ExtratorDeConteudoDeMeme());

    private String url;
    private ExtratorConteudo extrator;

    API(String url, ExtratorMovieConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String url() {
        return url;
    }

    public ExtratorConteudo extrator() {
        return extrator;
    }
}