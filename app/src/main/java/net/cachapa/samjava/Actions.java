package net.cachapa.samjava;

import android.os.Handler;

import net.cachapa.samjava.Util.GifLoader;

public class Actions {
    private static final String ADDRESS = "http://thecodinglove.com/random";

    private Model model;
    private Handler handler;

    public Actions(Model model) {
        this.model = model;
        this.handler = new Handler();
    }

    void loadGif() {
        model.propose(null);

        new Thread(() -> {
            Gif gif = GifLoader.getGif(ADDRESS);
            handler.post(() -> model.propose(gif));
        }).start();
    }
}
