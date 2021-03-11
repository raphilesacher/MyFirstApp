package com.example.networktest_11903738;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SendMatrNr implements Runnable{
    String matrNr;
    public SendMatrNr(String matrNr) {
        this.matrNr = matrNr;
    }
    @Override
    public void run() {

        PrintWriter serverWriter;
        try {
            serverWriter = new PrintWriter(matrNr);
            serverWriter.println(matrNr);
            serverWriter.flush();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
