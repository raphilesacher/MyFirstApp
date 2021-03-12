package com.example.networktest_11903738;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.PrintWriter;
import java.net.*;

public class SendMatrNr implements Runnable{
    String matrNr;
    String fromServer;
    public SendMatrNr(String matrNr) {
        this.matrNr = matrNr;
    }

    @Override
    public void run() {

        String toServer;


        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(userInput);
        System.out.println(matrNr);
        try {
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader serverResponse = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            toServer = userInput.readLine();
            outToServer.writeBytes(toServer + '\n');
            fromServer = serverResponse.readLine();
            System.out.println(fromServer);
            clientSocket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String returnServerMessage() {
        return fromServer;
    }
}
