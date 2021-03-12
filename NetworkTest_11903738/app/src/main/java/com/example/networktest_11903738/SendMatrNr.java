/**
 * Name: Raphael Lesacher
 * Matrikelnummer: 11903738
 */
package com.example.networktest_11903738;

import java.io.BufferedReader;
import java.io.DataOutputStream;

import java.io.*;

import java.net.*;

public class SendMatrNr implements Runnable{
    String matrNr;
    String fromServer;
    public SendMatrNr(String matrNr) {
        this.matrNr = matrNr;
    }

    @Override
    public void run() {

        try {
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader serverResponse = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(matrNr + '\n');
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
