package com.example.buttongame;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

/**
 * @author Kincaid Larson
 * @version February 2023
 * sources cited: FlappyBird2_class
 */
public class ButtonView {

    private Button[][] buttons;
    private ButtonModel model;
    private Button resetbutton;

    public ButtonView(ButtonModel m, Button r){
        model = m;
        buttons = new Button[4][4];
        resetbutton = r;
    }//ctor

    public void addButton(int row, int col, Button b){
        buttons[row][col] = b;
    }//addButton

    public void exchangeButtons(int row1, int col1, int row2, int col2){
        //store number text associated to buttons
        CharSequence temp1 = buttons[row1][col1].getText();
        CharSequence temp2 = buttons[row2][col2].getText();

        //exchange text
        buttons[row2][col2].setText(temp1);
        buttons[row2][col2].setVisibility(View.VISIBLE);
        buttons[row2][col2].setClickable(true);

        buttons[row1][col1].setText(temp2);
        buttons[row1][col1].setVisibility(View.INVISIBLE);
        buttons[row1][col1].setClickable(false);
    }//exchangeButtons

    public void shuffleButtons(){
        //randomly switch tiles set amount of times (moves must be valid for puzzle to be solvable)
        //probably not the most effective randomizer
        for (int i = 0; i <= 1200; i++) {
            //pick a random tile
            model.setRow(model.rng());
            model.setCol(model.rng());

            //swap buttons if valid
            if (model.row() != findEmptyRow() || model.col() != findEmptyCol()) {
                exchangeButtons(model.row(), model.col(), findEmptyRow(), findEmptyCol());
            }
        }
    }//shuffleButtons

    public boolean isResetButton(View v){
        Button b = (Button)v;
        return b == resetbutton;
    }//isResetButton

    public boolean checkIsEmpty(Button b) {
        if (b.getVisibility() == View.INVISIBLE) {
            return true;
        }
        else {
            return false;
        }
    }//checkIsEmpty

    public int findEmptyRow() {
        //check if a surrounding tile to above or below is empty
        //return the row of which button is empty
        //return the button's own position if there is no empty tile around

        //above
        if (model.row() - 1 >= 0) {
            if (checkIsEmpty(buttons[model.row() - 1][model.col()])) {
                return model.row() - 1;
            }
        }
        //down
        if (model.row() + 1 < 4) {
            if (checkIsEmpty(buttons[model.row() + 1][model.col()])) {
                return model.row()+1;
            }
        }
        return model.row();
    }//findEmptyRow

    public int findEmptyCol() {
        //check if a surrounding tile to the left or right is empty
        //return the col of which button is empty
        //return the button's own position if there is no empty tile around

        //left
        if (model.col() - 1 >= 0) {
            if (checkIsEmpty(buttons[model.row()][model.col() - 1])) {
                return model.col() - 1;
            }
        }
        //right
        if (model.col() + 1 < 4) {
            if (checkIsEmpty(buttons[model.row()][model.col() + 1])) {
                return model.col() + 1;
            }
        }
        return model.col();
    }//findEmptyCol

    public void checkSolutions() {
        //this seems horrendous
        if (buttons[0][0].getText().equals("1")){
            buttons[0][0].setBackgroundColor(Color.GREEN);
        } else {buttons[0][0].setBackgroundColor(Color.BLUE);}
        if (buttons[0][1].getText().equals("2")){
            buttons[0][1].setBackgroundColor(Color.GREEN);
        } else {buttons[0][1].setBackgroundColor(Color.BLUE);}
        if (buttons[0][2].getText().equals("3")){
            buttons[0][2].setBackgroundColor(Color.GREEN);
        } else {buttons[0][2].setBackgroundColor(Color.BLUE);}
        if (buttons[0][3].getText().equals("4")){
            buttons[0][3].setBackgroundColor(Color.GREEN);
        } else {buttons[0][3].setBackgroundColor(Color.BLUE);}
        if (buttons[1][0].getText().equals("5")){
            buttons[1][0].setBackgroundColor(Color.GREEN);
        } else {buttons[1][0].setBackgroundColor(Color.BLUE);}
        if (buttons[1][1].getText().equals("6")){
            buttons[1][1].setBackgroundColor(Color.GREEN);
        } else {buttons[1][1].setBackgroundColor(Color.BLUE);}
        if (buttons[1][2].getText().equals("7")){
            buttons[1][2].setBackgroundColor(Color.GREEN);
        } else {buttons[1][2].setBackgroundColor(Color.BLUE);}
        if (buttons[1][3].getText().equals("8")){
            buttons[1][3].setBackgroundColor(Color.GREEN);
        } else {buttons[1][3].setBackgroundColor(Color.BLUE);}
        if (buttons[2][0].getText().equals("9")){
            buttons[2][0].setBackgroundColor(Color.GREEN);
        } else {buttons[2][0].setBackgroundColor(Color.BLUE);}
        if (buttons[2][1].getText().equals("10")){
            buttons[2][1].setBackgroundColor(Color.GREEN);
        } else {buttons[2][1].setBackgroundColor(Color.BLUE);}
        if (buttons[2][2].getText().equals("11")){
            buttons[2][2].setBackgroundColor(Color.GREEN);
        } else {buttons[2][2].setBackgroundColor(Color.BLUE);}
        if (buttons[2][3].getText().equals("12")){
            buttons[2][3].setBackgroundColor(Color.GREEN);
        } else {buttons[2][3].setBackgroundColor(Color.BLUE);}
        if (buttons[3][0].getText().equals("13")){
            buttons[3][0].setBackgroundColor(Color.GREEN);
        } else {buttons[3][0].setBackgroundColor(Color.BLUE);}
        if (buttons[3][1].getText().equals("14")){
            buttons[3][1].setBackgroundColor(Color.GREEN);
        } else {buttons[3][1].setBackgroundColor(Color.BLUE);}
        if (buttons[3][2].getText().equals("15")){
            buttons[3][2].setBackgroundColor(Color.GREEN);
        } else {buttons[3][2].setBackgroundColor(Color.BLUE);}
        buttons[3][3].setBackgroundColor(Color.BLUE);
    }//checkSolutions

    public void setListener(View.OnClickListener ocl){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].setOnClickListener(ocl);
            }
        }
    }//setListener
}
