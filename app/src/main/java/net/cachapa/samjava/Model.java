package net.cachapa.samjava;

public class Model {
    private State state;
    private Gif data;

    public Model(State state) {
        this.state = state;
    }

    void propose(Gif data) {
        this.data = data;
        state.trigger(this);
    }

    public Gif getData() {
        return data;
    }
}
