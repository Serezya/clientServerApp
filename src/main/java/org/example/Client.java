package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    static String host = "netology.homework";
    static int port = 8080;
    public static void main(String [] args) {
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("User");
            String resp = in.readLine();
            System.out.println(resp);
            System.out.println(in.readLine());
            out.println("Sergey");
            System.out.println("Sergey");

            System.out.println(in.readLine());
            out.println("no");
            System.out.println("no");
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}