package com.example.android.hexme;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeColor(View view){
        String randColor = "#"+ genValue()+genValue()+genValue();
        RelativeLayout background = (RelativeLayout) findViewById(R.id.container);
        background.setBackgroundColor(Color.parseColor(randColor));
        TextView colorText = (TextView) findViewById(R.id.colorText);
        colorText.setText(randColor);
    }
    /**
     *Generates a string of two characters that
     *correspont to a hexadecimal value from 00 to FF
     *Three of these strings represent
     *a color combining red, green, and blue (RGB).
     *@return a hex value from 00 to FF
     */
    private static String genValue(){
        String[] letters = {"A", "B", "C", "D", "E", "F"};//array of letters for hexadecimal value

        boolean digitZero = getRandomBoolean();//if true, the 0th digit of the hex number is a letter (A to F), and a number (0-9) if false
        boolean digitOne = getRandomBoolean();//if true, the 1st digit of the hex number is a letter (A to F), and a number (0-9) if false

        String toReturn;//String object to be returned

        //determine if the 0th digit is a letter or a number
        if(digitOne){
            toReturn = letters[(int)(Math.random()*5)];
        }else{
            toReturn = Integer.toString((int)(Math.random()*9));
        }

        //determine if the 1st digit is a letter or a number
        if(digitZero){
            toReturn = toReturn + letters[(int)(Math.random()*5)];
        }else{
            toReturn = toReturn + Integer.toString((int)(Math.random()*9));
        }

        return toReturn;
    }

    /**
     *Generates a random boolean value.
     *@return a random boolean (true or false)
     */
    private static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
