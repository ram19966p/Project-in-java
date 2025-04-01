/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serverchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket ;


class Server {
       
    private ServerSocket serverSocket ;
    
     Server(ServerSocket serverSocket ){
        this.serverSocket = serverSocket ;
    }
    
     public void starServer(){
         try{
             while( ! serverSocket.isClosed()){
                 Socket socket = serverSocket.accept();
                 System.out.println(" A new client has connected!");
                 ClientHandler clientHandler  = new ClientHandler(socket);
                 
                 Thread thread  = new Thread(clientHandler);
                 thread.start();
             }
}catch(IOException e){

}
                     
         }
public void closeServerSocket(){
    try{
        if(serverSocket != null){
            serverSocket.close();
        }
    }catch(IOException e){
        e.printStackTrace();
    }
    
     }

    public static void main(String[] args) throws IOException {
        ServerSocket  serverSocket = new  ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.starServer();
        System.out.println("Hello World!");
    }
}
