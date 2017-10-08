package net.cachapa.samjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SAM Initialisation
        View view = new View(this);
        State state = new State(view);
        Model model = new Model(state);
        Actions actions = new Actions(model);
        view.setActions(actions);
        state.setActions(actions);
        
        // Trigger first action
        actions.loadGif();
    }
}
