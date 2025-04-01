/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serverchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

class Client {
     private Socket  socket ;
     private BufferedReader  bufferedReader ;
     public BufferedWriter  bufferedWriter ;
     private String  username ;
     
     
     public Client (Socket socket , String username) throws IOException{
         try{
             this.socket = socket ;
             this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             this.bufferedReader =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
             this.username = username ;
             
               
             
         
     }catch(IOException e ){
         closeEverythings(socket , bufferedReader , bufferedWriter);
         
         
     }
     }  
      public void sendMessage(){
          try{
              bufferedWriter.write(username);
              bufferedWriter.newLine();
              bufferedWriter.flush();
              Scanner scanner = new Scanner(System.in);
              while(socket.isClosed()){
                  String messageToSend = scanner.nextLine();
                  bufferedWriter.write( username + " :"+ messageToSend);
                  bufferedWriter.newLine();
                  bufferedWriter.flush();
              }
          }catch( IOException p){
              closeEverythings(socket , bufferedReader , bufferedWriter);
              
          }
      }
public void lisenForMessage(){
    new Thread( new Runnable() {
        @Override
        public void run() {
              String  mesFromGroupChat;
              while(socket.isConnected()){
                  try{
                      mesFromGroupChat  = bufferedReader.readLine();
                      System.out.println(mesFromGroupChat);
                  }catch( IOException e){
                  closeEverythings(socket , bufferedReader , bufferedWriter);
                      
                  }
              }
               }
    }).start();
           
}

public void closeEverythings( Socket socket , BufferedReader bufferereder , BufferedWriter bufferedWriter){
    try{
               if( bufferedReader   != null ){
                    bufferedReader.close();
               
           }
               if(  bufferedWriter  != null){
                   bufferedWriter.close();
               }
               
               if( socket != null  ){
                   socket.close();
               }
                       
                 
           }catch(IOException e){
           e.printStackTrace();
       }
       }

public static void main( String arg[]) throws IOException{
    Scanner scanner = new Scanner(System.in);
    System.out.println(" Enter your username for the group chat :");
    String  username = scanner.nextLine();
    Socket scoket  = new Socket( "localhost" , 1234);
    Client client = new Client(scoket,username);
    client.lisenForMessage();
    client.sendMessage();
}
}