/**
 * 	Server.java
 *  @author Group 7 - Deepthi Warrier, Mayuree Binjolkar, Sumitha Ravindran
 *  @Date 29/Jan/2020
 *  Server Class Reads the input from the client creates a Dictionary.
 *  It then returns the spanish transalation of the words the client requests.
 */
package clientserverapp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Server {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Initialize socket, input and output streams
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		DataInputStream in = null;
		ObjectInputStream objIn = null;
		DataOutputStream out = null;

		try {

			// Port number is passed as an argument
			int serverPort = Integer.parseInt(args[0]);

			// Create a server socket connection which waits for client requests
			serverSocket = new ServerSocket(serverPort);
			System.out.println("Server: Server Started!");

			// Plain old socket to communicate with the client
			clientSocket = serverSocket.accept();
			System.out.println("Server: Client Accepted!");

			// Read the Object from the client
			objIn = new ObjectInputStream(clientSocket.getInputStream());
			
			Map<String, String> dictionary = (HashMap<String, String>) objIn.readObject();
			System.out.println("\nServer: Reading the dictionary Passed:" + dictionary.toString());

			// Read Message from the client
			in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));

			out = new DataOutputStream(clientSocket.getOutputStream());

			String line = "";

			// Read message until over is sent
			while (!line.equals("End")) {
				
				// If the dictionary doesnt have such a word it returns - Not found
				String spanishWord = "Spanish Word - Not Found!";
				
				//Reading the string passed from client
				line = in.readUTF();
				
				if(line == null || line.equals("End")) {
					System.out.println("\nEnd Command Received from the Client! " + line);
					break;
				}
				
				//Time Stamp when input was received
				long inputTime = System.currentTimeMillis();
				Timestamp inputTS = new Timestamp(inputTime);	
				System.out.println("\nServer: Time Stamp When Input Received:" + inputTS);
				
				if(dictionary.containsKey(line)) {
					spanishWord = dictionary.get(line);				
				}	
				
				//Writing the Spanish Translation of the word back to Client
				System.out.println("Server: Returned spanish word for: " + line + " : " + spanishWord);
				
				//TimeStamp when the Spanish word was passed back to the client
				long resultTime = System.currentTimeMillis();
				Timestamp resultTS = new Timestamp(resultTime);
				System.out.println("Server: Result Returned TimeStamp:" + resultTS);				
				out.writeUTF(spanishWord);
			}
		} catch (IOException e) {
			System.out.println("Oops... Theres an IO Exception:" + e.getMessage());
		} catch (Exception ex) {
			System.out.println("Oops... Theres an Exception:" + ex.getMessage());
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					System.out.println("Server Socket Close: IO Exception:" + e.getMessage());
				}
			}
			if (clientSocket != null) {
				try {
					clientSocket.close();
					in.close();
					out.close();
				} catch (IOException e) {
					System.out.println("Click Socket Close: IO Exception::" + e.getMessage());
				}
			}
		}
	}

}
