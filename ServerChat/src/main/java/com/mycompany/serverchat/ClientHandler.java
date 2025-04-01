/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serverchat;

/**
 *
 * @author ramla
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList ;


public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler>  clientHandlers = new  ArrayList<>();
    private  Socket  socket ;
    private BufferedReader bufferedReder ;
    private BufferedWriter  buffereWriter;
    private String clientUsername;

    
    public ClientHandler(Socket socket){
        try{
            this.socket = socket ;
           this.buffereWriter = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
           this.bufferedReder=new BufferedReader(new InputStreamReader(socket.getInputStream()));
           this.clientUsername = bufferedReder.readLine();
           clientHandlers.add(this);
           broadcastMessage(" SERVER: "+ clientUsername + " has entered the chat!");
        }catch( IOException e){
              closeEverythings(socket , bufferedReder ,  buffereWriter);
            
        }
    }
    @Override
    public void run() {
         String messageFromClient ;
          while(socket.isConnected()){
              try{
                  messageFromClient  = bufferedReder.readLine();
                  broadcastMessage(messageFromClient);
                  
                  
                  }catch(  IOException e){
                  closeEverythings(socket , bufferedReder , buffereWriter) ;
                  break;
             
              }
          }
        
    }
    
    
    
      public void broadcastMessage( String messageToSend){
          try{
          for( ClientHandler clientHandler  :  clientHandlers){
          
          if(! clientHandler.clientUsername.equals(clientUsername)){
                clientHandler.buffereWriter.write(messageToSend);
                clientHandler.buffereWriter.newLine();
                clientHandler.buffereWriter.flush();
                
              }
          }
      }catch(IOException e){
          closeEverythings(socket , bufferedReder , buffereWriter) ;
                 
      }
                
      }
      public void removeClientHandler(){
              clientHandlers.remove( this);
        broadcastMessage(  " SERVER: " + clientUsername + " has left the chat " );
        
}
      
       
       public void closeEverythings( Socket socket , BufferedReader bufferereder , BufferedWriter bufferedWriter){
           
           removeClientHandler();
           
           try{
               if( bufferedReder  != null ){
               bufferedReder.close();
               
           }
               if( bufferedWriter  != null){
                   bufferedWriter.close();
               }
               
               if( socket != null  ){
                   socket.close();
               }
                       
                 
           }catch(IOException e){
           e.printStackTrace();
       }
       }
}
