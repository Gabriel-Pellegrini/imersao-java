package main.java;

public class MemeImage {

    private final String meme;
    private final String urlImagem;

    public MemeImage(String meme, String urlImagem) {
        this.meme = meme;
        this.urlImagem = urlImagem;
    }

    public String getMeme() {
        return meme;
    }

    public String getUrlImagem() {
        return urlImagem;
    }
}
