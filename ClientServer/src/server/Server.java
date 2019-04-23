package server;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import client.Command;



public class Server {
	static Map<Integer, String> map = new HashMap<>();
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		        
		ServerSocket server = new ServerSocket(12345);
		
		System.out.println("Waiting for connection...");

		Socket client = server.accept();
		System.out.println("Got connection from " +     
				client.getInetAddress().getHostAddress());
		while(true) {
	
			ObjectInputStream input = new ObjectInputStream(client.getInputStream());
			OutputStream output = client.getOutputStream();
        
			Command cmd = (Command) input.readObject();
			
			System.out.println("Command =" + cmd.ncommand + "Key = "+ cmd.key + "value =" + cmd.value+ "\n");
			DataOutputStream serverWriter = new DataOutputStream(output);
			Scanner input1 = new Scanner("DEU CERTO PORRRA");
			PrintStream output1 = new PrintStream(client.getOutputStream());
			output1.println(input1.nextLine());
		}   
        
	}
	
	public static synchronized void commandProcessing(int ncommand, Integer key, String value) {
		switch(ncommand) {
			case 1:
				if(map.containsKey(key)) {
					
					System.out.println("Error! This key already exists on the map.");
				}
				 
				else {
					map.put(key,value);
					System.out.println("Success! Inserted key");
				}
				break;
				
			case 2:
				if(map.containsKey(key)) {
					value = map.get(key);
					System.out.println(value);
					
				}
				
				else {
					System.out.println("This key doesn't exist on the map.");
				
				}
				break;
			case 3:
				if (map.containsKey(key)) {
					map.put(key,value);
					System.out.println("Success!, Updated Key");
				}
				else {
					System.out.println("Error! impossible to update key that doesn't exist.");						
				}
				
				
			case 4:
				
				if(map.containsKey(key)) {
					map.remove(key);
					System.out.println("Success, Removed key.");
				}
				else {
					System.out.println("Error! impossible to remove key that doesn't exist.");						
				}
				
												
			case 5: 
				break;
		}	
	}		
		
}	
