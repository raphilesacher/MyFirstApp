package com.example.networktest_11903738;
import java.io.*;
import java.net.*;

public class TCPClient {
    private static String fromServer;

    public static void main(String[] args) throws Exception{
        String toServer;


        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader serverResponse = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        toServer = userInput.readLine();
        outToServer.writeBytes(toServer);
        fromServer = serverResponse.readLine();

        clientSocket.close();
    }

    public static String returnServerMessage() {
        return fromServer;
    }
}
