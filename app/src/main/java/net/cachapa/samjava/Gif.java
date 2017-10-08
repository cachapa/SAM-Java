package net.cachapa.samjava;

public class Gif {
    private String title;
    private String gifUrl;
    private Exception error;

    public Gif(String title, String gifUrl) {
        this.title = title;
        this.gifUrl = gifUrl;
    }

    public Gif(Exception error) {
        this.error = error;
    }

    public String getTitle() {
        return title;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public Exception getError() {
        return error;
    }
}
