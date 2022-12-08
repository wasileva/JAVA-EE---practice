package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
 
    public static void main(String[] args) throws IOException {
        
        Socket soc = new Socket("localhost",30333);
        
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(soc.getOutputStream()));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(soc.getInputStream()));
        
     
        Thread write = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true) {
                    try {
                        Scanner scan = new Scanner(System.in);
                        System.out.print(">");
                        String str = scan.nextLine();
                        writer.write(str);
                        writer.write("\n");
                        writer.flush();
                        
                        if ("close".equals(str)) {
                            soc.close();
                            break;
                        }
                        
                    } catch (IOException ex) {                      
                        System.out.println(ex.getMessage());
                    }
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
               
        
        Thread read = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true) {
                    try {
                        if (soc.isClosed()) break;
                        
                        String str = reader.readLine();
                        System.out.println(str);
                       
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        
        write.start();
        read.start();     
      
    }

    
}
