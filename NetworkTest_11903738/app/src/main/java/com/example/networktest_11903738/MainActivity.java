package com.example.networktest_11903738;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextView serverResponse = findViewById(R.id.serverResponse);
        TextInputEditText matrInput = findViewById(R.id.matrInput);


        //set OnClickListener to button for button action
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //just a test
                SendMatrNr send = new SendMatrNr(matrInput.getText().toString());
                Thread thread = new Thread(send);
                thread.start();

                try {
                    thread.join();
                }catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }


                serverResponse.setText(TCPClient.returnServerMessage());

            }
        });



    }
}