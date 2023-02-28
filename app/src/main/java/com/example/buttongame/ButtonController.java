package com.example.buttongame;

import android.view.View;
import android.widget.Button;

/**
 * @author Kincaid Larson
 * @version February 2023
 * sources cited: FlappyBird2_classA
 */
public class ButtonController implements View.OnClickListener{

    private ButtonView view;
    private ButtonModel model;

    public ButtonController(ButtonModel m, ButtonView v){
        model = m;
        view = v;
    }

    public void onClick(View v){
        //check if the reset button is being clicked
        if (view.isResetButton(v)){
            Button b = (Button)v;
            view.shuffleButtons();
            view.checkSolutions();
        }
        else {
            Button b = (Button)v;

            //this is very bad but i couldn't figure out a different way to update moel
            if (b.getId() == R.id.b_11) {model.setRow(0); model.setCol(0);}
            else if (b.getId() == R.id.b_12) {model.setRow(0); model.setCol(1);}
            else if (b.getId() == R.id.b_13) {model.setRow(0); model.setCol(2);}
            else if (b.getId() == R.id.b_14) {model.setRow(0); model.setCol(3);}
            else if (b.getId() == R.id.b_21) {model.setRow(1); model.setCol(0);}
            else if (b.getId() == R.id.b_22) {model.setRow(1); model.setCol(1);}
            else if (b.getId() == R.id.b_23) {model.setRow(1); model.setCol(2);}
            else if (b.getId() == R.id.b_24) {model.setRow(1); model.setCol(3);}
            else if (b.getId() == R.id.b_31) {model.setRow(2); model.setCol(0);}
            else if (b.getId() == R.id.b_32) {model.setRow(2); model.setCol(1);}
            else if (b.getId() == R.id.b_33) {model.setRow(2); model.setCol(2);}
            else if (b.getId() == R.id.b_34) {model.setRow(2); model.setCol(3);}
            else if (b.getId() == R.id.b_41) {model.setRow(3); model.setCol(0);}
            else if (b.getId() == R.id.b_42) {model.setRow(3); model.setCol(1);}
            else if (b.getId() == R.id.b_43) {model.setRow(3); model.setCol(2);}
            else if (b.getId() == R.id.b_44) {model.setRow(3); model.setCol(3);}

            //initiate exchange of buttons
            if (model.row() != view.findEmptyRow() || model.col() != view.findEmptyCol()) {
                view.exchangeButtons(model.row(), model.col(), view.findEmptyRow(), view.findEmptyCol());
                view.checkSolutions();
            }

        }
    }//onClick
}
