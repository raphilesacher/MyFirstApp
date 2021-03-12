package com.example.networktest_11903738;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendToServerBtn = findViewById(R.id.button);
        TextView serverResponse = findViewById(R.id.serverResponse);
        TextInputEditText matrInput = findViewById(R.id.matrInput);

        Button calculateBtn = findViewById(R.id.button2);



        //set OnClickListener to sendToServerBtn for button action
        sendToServerBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                SendMatrNr send = new SendMatrNr(matrInput.getText().toString());
                Thread thread = new Thread(send);
                thread.start();

                try {
                    thread.join();
                }catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                serverResponse.setText(send.returnServerMessage());
            }
        });

        //set OnClickListener to sendToServerBtn for button action
        calculateBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                MatrSort sorter = new MatrSort(Long.parseLong(matrInput.getText().toString()));
                sorter.init();
                matrInput.setText(sorter.getText());

            }
        });



    }
}