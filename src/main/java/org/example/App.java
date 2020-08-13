package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        try {
            int port = 8080;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server start");
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            System.out.println("Connection accept");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            out.println("Write your name");
            final String userName = in.readLine();
            out.println("Are you child?(yes/no)");
            final String child = in.readLine();
            if ("no".equals(child)){
                out.println("Welcome to the adult zone, " +userName +" ! Have a good rest, or a good working day!");
            }else {
                out.println("Welcome to the kids area, " +userName +" ! Let's play!");
            }
            clientSocket.close();
            out.close();
            in.close();
        }
        catch (IOException e) {
            System.out.println();
        }
    }
}

