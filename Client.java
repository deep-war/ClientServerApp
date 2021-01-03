/**
 * Client.java
 * @author Group 7 - Deepthi Warrier, Mayuree Binjolkar, Sumitha Ravindran 
 * @Date 29/Jan/2020
 * Client that could send single/multiple messages
 * Passes a map object to pre-populate the server with English to Spanish Dictionary. 
 * Waiting for a client input and passes the string to the server to retrieve the 
 * Spanish translated word returned.  
 */
package clientserverapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Client {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// Initialize socket, Input & Output Streams
		Socket socket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		ObjectOutputStream objOut = null;
		DataInputStream in2 = null;
		try {

			System.out.println("Client: IPAddress:" + args[0]);
			System.out.println("Client: PortNumber:" + args[1]);

			// Convert the port number passed as string argument to int
			int portNumber = Integer.parseInt(args[1]);

			// Makes a Socket Connection.
			socket = new Socket(args[0], portNumber);
			System.out.println("Client: Connected!");

			//English to Spanish Dictionary
			Map<String, String> engSpanishDictionary = new HashMap<String, String>();
			engSpanishDictionary.put("Monday", "Lunes");
			engSpanishDictionary.put("Tuesday", "Martes");
			engSpanishDictionary.put("Wednesday", "Miercoles");
			engSpanishDictionary.put("Thursday", "Jueves");
			engSpanishDictionary.put("Friday", "Viernes");
			engSpanishDictionary.put("Saturday", "Sabado");
			engSpanishDictionary.put("Sunday", "Domingo");

			// Pass the Map Object to the ObjectOutputStream
			objOut = new ObjectOutputStream(socket.getOutputStream());
			objOut.writeObject(engSpanishDictionary);

			
			// Reads the input
			in = new DataInputStream(System.in);			

			// Output stream set to the socket outputstream
			out = new DataOutputStream(socket.getOutputStream());
			
			//For reading the data returned from the server
			in2 = new DataInputStream(socket.getInputStream());

			String line = "";

			// Keep Reading until Client sends "End" as input
			while (!line.equals("End")) {
				// Waits for the client to input the day.
				System.out.println("\nClient: Enter the day:");
				
				line = in.readLine();
				if(line == null || line.equals("End")) {
					System.out.println("\nEnding the Chat!");
					out.writeUTF(line);	
					break;
				}
				
				//Time Stamp when input is typed in
				long inputTime = System.currentTimeMillis();
				Timestamp inputTS = new Timestamp(inputTime);
				
				System.out.println("Client: Current Time Stamp When Input Passed:" + inputTS);
				out.writeUTF(line);		
				
				//Returned Spanish Translation
				String spanishWord = in2.readUTF();
				System.out.println("Client: Spanish Translation for: " + line + " : " + spanishWord);

				long resultTime = System.currentTimeMillis();
				Timestamp resultTS = new Timestamp(resultTime);
				System.out.println("Client: Result Returned TimeStamp:" + resultTS);
			}

		} catch (IOException ioException) {
			ioException.printStackTrace();
			System.out.println("Oops.. There is an IO Exception" + ioException.getMessage());
		} catch (Exception e) {
			System.out.println("Oops.. There was an Exception" + e.getMessage());
		} finally {
			if (socket != null) {
				try {
					// Close the socket, input and output
					socket.close();
					in.close();
					out.close();					
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("close:" + e.getMessage());
				}
			}

		}

	}

}
