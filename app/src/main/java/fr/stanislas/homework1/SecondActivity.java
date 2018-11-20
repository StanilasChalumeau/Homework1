package fr.stanislas.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText txt1, txt2, txt3;
    String a,b,c;

    String myRgbColorValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        txt1 = findViewById(R.id.red_input);
        txt2 = findViewById(R.id.green_input);
        txt3 = findViewById(R.id.blue_input);



    }

// function to get back the 3 values given by the user, concatenation of this 3 values
    public void onOKButtonClick(View v){
        a = txt1.getText().toString();
        b = txt2.getText().toString();
        c = txt3.getText().toString();


        // if the user enters only one or to number value complete with 0
        if (txt1.getText().toString().length()==1){
           a = "00"+txt1.getText().toString();

        }

        if (txt1.getText().toString().length()==2){
            a = "0"+txt1.getText().toString();

        }




        if (txt2.getText().toString().length()==1){
            b = "00"+txt2.getText().toString();

        }

        if (txt2.getText().toString().length()==2){
            b = "0"+txt2.getText().toString();

        }



        if (txt3.getText().toString().length()==1){
            c = "00"+txt3.getText().toString();

        }

        if (txt3.getText().toString().length()==2){
            c = "0"+txt3.getText().toString();

        }



        myRgbColorValue = a + b + c;

        Intent intent = new Intent();
        intent.putExtra(MainActivity.KEY, myRgbColorValue); //KEY Way of decoding
        setResult(RESULT_OK, intent);
        finish();

    }


    // function to discard the choice
    public void onCANCELButtonClick(View v){

        txt1.setText("");
        txt2.setText("");
        txt3.setText("");

    }



}
