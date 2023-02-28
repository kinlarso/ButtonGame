package com.example.buttongame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

/**
 * @author Kincaid Larson
 * @version February 2023
 * sources cited: FlappyBird2_classA
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonModel model = new ButtonModel();
        Button reset = findViewById(R.id.resetbutton);
        ButtonView view = new ButtonView(model, reset);

        //add buttons
        view.addButton(0, 0, findViewById(R.id.b_11));
        view.addButton(0, 1, findViewById(R.id.b_12));
        view.addButton(0, 2, findViewById(R.id.b_13));
        view.addButton(0, 3, findViewById(R.id.b_14));
        view.addButton(1, 0, findViewById(R.id.b_21));
        view.addButton(1, 1, findViewById(R.id.b_22));
        view.addButton(1, 2, findViewById(R.id.b_23));
        view.addButton(1, 3, findViewById(R.id.b_24));
        view.addButton(2, 0, findViewById(R.id.b_31));
        view.addButton(2, 1, findViewById(R.id.b_32));
        view.addButton(2, 2, findViewById(R.id.b_33));
        view.addButton(2, 3, findViewById(R.id.b_34));
        view.addButton(3, 0, findViewById(R.id.b_41));
        view.addButton(3, 1, findViewById(R.id.b_42));
        view.addButton(3, 2, findViewById(R.id.b_43));
        view.addButton(3, 3, findViewById(R.id.b_44));

        //on startup, board should be shuffled
        view.shuffleButtons();
        view.checkSolutions();

        ButtonController controller = new ButtonController(model, view);
        view.setListener(controller);
        reset.setOnClickListener(controller);
    }
}