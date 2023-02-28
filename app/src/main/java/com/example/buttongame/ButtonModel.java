package com.example.buttongame;

import java.util.Random;

/**
 * @author Kincaid Larson
 * @version February 2023
 * sources cited: FlappyBird2_classA,
 * https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
 */
public class ButtonModel {

    private int row;
    private int col;
    private Random rng;

    public ButtonModel(){rng = new Random();}
    public int rng(){return rng.nextInt(4);}
    public void setRow(int r){row = r;}
    public void setCol(int c){col = c;}
    public int row(){return row;}
    public int col(){return col;}
}
