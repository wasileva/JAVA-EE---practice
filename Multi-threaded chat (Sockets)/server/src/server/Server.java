package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class Server {

    static Vector<ClientHandler> activeClients = new Vector<>();
       
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket server =  new ServerSocket(30333);

        int numClient = 1;
        
        while (true) {
            Socket soc = server.accept();
            System.out.println("Client " + soc.getPort() + " connected");
 
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(soc.getInputStream()));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(soc.getOutputStream()));

            ClientHandler cHandler = new ClientHandler(reader, writer, soc, "C"+numClient);
            Thread t = new Thread(cHandler);
            activeClients.add(cHandler);
            t.start();         
            numClient++;  
        }

    }
    
}
