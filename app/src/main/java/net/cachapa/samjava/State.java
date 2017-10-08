package net.cachapa.samjava;

public class State {
    private View view;
    private Actions actions;

    public State(View view) {
        this.view = view;
    }

    public void trigger(Model model) {
        Gif gif = model.getData();

        if (gif == null) {
            view.showLoading();
        } else if (gif.getError() != null) {
            Exception e = gif.getError();
            e.printStackTrace();
            view.showError(e);
        } else {
            view.showGif(gif);
        }
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }
}
