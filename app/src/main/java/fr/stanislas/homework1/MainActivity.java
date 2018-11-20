package fr.stanislas.homework1;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyboardShortcutGroup;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainActivityColor;
    int r, g, b;

    Button button1, button2, button3;
    String receivedColor;

    public MediaPlayer musicStan;


    public static final String KEY = "";

    public static int BUTTON_REQUEST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = findViewById(R.id.button_backgID);
        button2 = findViewById(R.id.button_buttons_backID);
        button3 = findViewById(R.id.button_fontID);

        musicStan =  MediaPlayer.create(MainActivity.this, R.raw.stamina);



        //Floating Button Action for the music
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (musicStan.isPlaying()) {
                    musicStan.pause();
                } else {
                    musicStan.start();
                }
            }

        });



        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


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



    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    //                                   MY FUNCTIONS
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


// according to the button clicked BUTTON_REQUEST takes a value and starts the second activity
    public void onButtonClick (View v){

        switch(v.getId()){

            case R.id.button_backgID:
                   BUTTON_REQUEST = 1;
                break;
            case R.id.button_buttons_backID:
                    BUTTON_REQUEST = 2;
                break;
            case R.id.button_fontID:
                      BUTTON_REQUEST = 3;
                break;
            default:
                break;
        }

        Intent pickColorCode = new Intent(getApplicationContext(), SecondActivity.class);
        musicStan.pause();
        startActivityForResult(pickColorCode, BUTTON_REQUEST);


    }


    // Get back of the value of the second activity call a different function according to the value of BUTTON_REQUEST
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);



        if ((resultCode == RESULT_OK)&& (requestCode == BUTTON_REQUEST)){  //resultCode check if everything was fine, requestCode Request given

             receivedColor = data.getStringExtra(KEY);   // check this later
        }

        switch (BUTTON_REQUEST){

            case 1 :
                backgroundEditor(receivedColor);
                break;

            case 2 :
                buttonBackgroundEditor(receivedColor);
                break;

            case 3 :
                textColorEditor(receivedColor);
                break;

            default:
                break;
        }

    }



    // These 3 functions are called by the previous function according to the value of BUTTON_REQUEST

    public void backgroundEditor (String backgroundColor){


        String myColor =  backgroundColor;
        r = Integer.parseInt(myColor.substring(0,3));
        g = Integer.parseInt(myColor.substring(3,6));
        b = Integer.parseInt(myColor.substring(6,9));
        mainActivityColor = findViewById(R.id.content_main);
        mainActivityColor.setBackgroundColor(Color.rgb(r, g, b));

    }


    public void buttonBackgroundEditor (String backgroundColor){

        String myColor =  backgroundColor;
        r = Integer.parseInt(myColor.substring(0,3));
        g = Integer.parseInt(myColor.substring(3,6));
        b = Integer.parseInt(myColor.substring(6,9));

        button1.setBackgroundColor(Color.rgb(r, g, b));
        button2.setBackgroundColor(Color.rgb(r, g, b));
        button3.setBackgroundColor(Color.rgb(r, g, b));

    }

    public void textColorEditor (String backgroundColor){

        String myColor =  backgroundColor;
        r = Integer.parseInt(myColor.substring(0,3));
        g = Integer.parseInt(myColor.substring(3,6));
        b = Integer.parseInt(myColor.substring(6,9));

        button1.setTextColor(Color.rgb(r, g, b));
        button2.setTextColor(Color.rgb(r, g, b));
        button3.setTextColor(Color.rgb(r, g, b));


    }



}
