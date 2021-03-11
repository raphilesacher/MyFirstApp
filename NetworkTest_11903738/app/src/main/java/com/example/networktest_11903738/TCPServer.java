package com.example.networktest_11903738;
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        String clientSentence;
        String capitalizedSentence;

        ServerSocket welcomeSocket = new ServerSocket(53212);
        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            try {
               BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
               DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

               clientSentence = inFromClient.readLine();
               capitalizedSentence = clientSentence.toUpperCase() + '\n';

               outToClient.writeBytes(capitalizedSentence);
           }catch (Exception e) {
               System.out.println(e.getMessage());
           }
        }
    }
}
