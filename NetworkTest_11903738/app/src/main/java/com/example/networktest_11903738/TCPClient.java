package com.example.networktest_11903738;
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        String toServer;
        String fromServer;

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader serverResponse = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        toServer = userInput.readLine();
        outToServer.writeBytes(toServer);
        fromServer = serverResponse.readLine();
        System.out.println(fromServer);

        clientSocket.close();
    }
}
