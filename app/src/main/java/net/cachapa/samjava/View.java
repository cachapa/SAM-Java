package net.cachapa.samjava;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

public class View implements android.view.View.OnClickListener {
    private TextView textView;
    private ImageView imageView;
    private ProgressBar progressBar;
    private Button button;

    private Actions actions;

    public View(MainActivity activity) {
        textView = activity.findViewById(R.id.text_view);
        imageView = activity.findViewById(R.id.image_view);
        progressBar = activity.findViewById(R.id.progress_bar);

        Button button = activity.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void onClick(android.view.View v) {
        actions.loadGif();
    }

    void showGif(Gif gif) {
        textView.setText(gif.getTitle());
        Ion.with(imageView.getContext())
                .load(gif.getGifUrl())
                .progressBar(progressBar)
                .intoImageView(imageView);
        progressBar.setVisibility(android.view.View.GONE);
    }

    void showLoading() {
        textView.setText("Loading...");
        imageView.setImageDrawable(null);
        progressBar.setVisibility(android.view.View.VISIBLE);
    }

    void showError(Exception e) {
        textView.setText(e.getLocalizedMessage());
        imageView.setImageDrawable(null);
        progressBar.setVisibility(android.view.View.GONE);
    }
}
