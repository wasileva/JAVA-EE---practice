package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;


public class ClientHandler implements Runnable {
    
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket soc;
    private String name;
    boolean isLoggedIn;

    ClientHandler(BufferedReader reader, BufferedWriter writer, Socket soc, String name){
        this.reader = reader;
        this.writer = writer;
        this.soc = soc;
        this.name = name;
        this.isLoggedIn = true;
    }  

    @Override
    public void run() {
         while (true){
             try {
                 String str = reader.readLine();
     
                 if ("close".equals(str)){
                    this.isLoggedIn = false;
                    this.soc.close();           
                    System.out.println("Client " + name + " closed connection");
                    break;
                 }
                               
                 StringTokenizer data = new StringTokenizer(str, "#");
                 String msg = data.nextToken();
                 String recipient = data.nextToken();
                 
                 System.out.println(name + " sent " + str);
                 
                 for (ClientHandler client : Server.activeClients) {
                     if (client.name.equals(recipient) && client.isLoggedIn){
                          client.writer.write(name + ": " + msg+"\n");
                          client.writer.flush();
                          break;
                     } else if (client.name.equals(recipient) && !client.isLoggedIn) {
                          writer.write("$$$$ " + client.name + " is not available $$$$"+"\n");
                          writer.flush();
                          break;
                     }
                 }
                
             } catch (IOException ex) {
                 System.out.println(ex.getMessage());
             }
        }
         
        try {
            this.reader.close();
            this.writer.close();  
            
        } catch(IOException e){
            e.printStackTrace();
        }      
    }
       
}
