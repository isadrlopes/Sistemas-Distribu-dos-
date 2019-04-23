package client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
	
static int ncommand;
static String key; 
static String value;
static String command;
	
	
 	public static void main(String[] args) 
 			throws UnknownHostException, IOException {
				Socket client = new Socket("127.0.0.2", 12345);
				while(true) {
					System.out.println("Client connected to the server");
        		
					ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
					output.flush();
        		
					InputStreamReader input = new InputStreamReader(client.getInputStream());
					BufferedReader serverReader = new BufferedReader(input);
        		
					BufferedReader inUserReader = new BufferedReader(new InputStreamReader(System.in));
        		
        			
					System.out.println("Enter the command number(CRUD): \n 1.CREATE \n 2.READ \n 3.UPDATE \n 4.DELETE \n 5.EXIT \n ");
					@SuppressWarnings("resource")
					Scanner option = new Scanner (System.in);
					ncommand = option.nextInt();
					if (ncommand <= 0 || ncommand > 5) {
						System.out.println("Invalid command!");
					}
        		
					switch(ncommand) {
        				case 1:
        				
        					System.out.println("Insert the key: ");
        					key = inUserReader.readLine();
        				
        					System.out.println("Insert the value: ");
        						
        					value = inUserReader.readLine();     
        					
        					break;
        					       				
        				case 2:
	        				
        					System.out.println("Insert the key");
        					key = inUserReader.readLine();
        						
        					break;
        						
        				case 3:
	        				
        					System.out.println("Insert the key: ");
        					key = inUserReader.readLine();
	        				
        					System.out.println("Insert the value: ");
        					value = inUserReader.readLine();
        						
       					break;
        						
	        			
        				case 4:
	        				
        					System.out.println("Insert the key: ");
        					key = inUserReader.readLine();
	        				
        					System.out.println("Insert the value: ");
        					value = inUserReader.readLine();
	        				
        					break;
        						
        				case 5:
        					break;
        						
        				}
					
					Command cmd1 = new Command(Integer.valueOf(ncommand),Integer.valueOf(key),value);
					output.writeObject(cmd1);
					output.flush();
//					String response = serverReader.readLine();
//					System.out.println(response + "\n");
					Scanner s = new Scanner(client.getInputStream());
			       
			        System.out.println(s.nextLine());
					

        		}	
 	}
 	}

        		
        		//Scanner input = new Scanner(System.in);
        		//PrintStream output = new PrintStream(client.getOutputStream());

        		//while (input.hasNextLine()) {
        		//	output.println(input.nextLine());
        		//}

        		//output.close();
        		//input.close();
        		//client.close();
    	
 


