************************************************
Program: Client-Server Application             *
Authors: Group 7                               *
Deepthi Warrier, Sumitha Ravindran and Mayuree *
************************************************
About:
This is a Client Server Application where a connection is established between the client and the server.

At first the server is started with the portnumber as the argument. The server listens to the clients on this port number.
Once the Socket connection is established, the client can read and send mesages to the server and server can read the client's message and replies back to the client. 

Once the Server is started, we run the command to start the client. The Client accepts two arguments - The IP Address and the same port number as the Server.

This is a chatting application where the server is pre-populated with an English to Spanish dictionary for the days of the week, soon after the client establishes a connection with the Server.

English to spanish dictionary:
"Monday"    - "Lunes"
"Tuesday"   - "Martes"
"Wednesday" - "Miercoles"
"Thursday"  - "Jueves"
"Friday"    - "Viernes"
"Saturday"  - "Sabado"
"Sunday"    - "Domingo" 

Once the server is prepopulated with the values, the user can enter a Day of the week in English language, client reads and sends that message to server. The spanish translation for the Day will be sent back to the client from the server.

If a word that doesnt exist in the dictionary is entered, the server returns a message - "Spanish Word - Not Found!"

When the client enters the word - "End", Connection between the client and the server is closed.

Both the client and server displays the request timestamp and its response timestamp.

***********************************************************************************************************************************

Steps to Follow for running the program:
	  
************************************************
Program: Server.java                           *
Authors: Group 7                               *
Arguments: args[0] for port number             *
                                               *
************************************************ 
1. Open Command Prompt
2. Navigate to the bin folder of the project.
  For example: If the project is extracted to the following folder structure
  C:\Users\deept\Desktop\MSCSS\558 C - ADC\ADC_HW_Eclipse_WS\ClientServerApp

  The cmd command would be:
  cd C:\Users\deept\Desktop\MSCSS\558 C - ADC\ADC_HW_Eclipse_WS\ClientServerApp\bin

3. Once navigated, run the command - java clientserverapp.Server portNumber
    For eg.the portnumber could be - 1342

4. A message will be displayed - Server started!

    a. The server then listens to the client on this port Number.
    b. Server responds back to the client messages by sending Spanish word from the dictionary with timestamps(Timestamp format: date HH:MM:SS:MILLISECONDS).
    c. If the requested word is not in the dictionary, the server will send "Spanish Word - Not Found!" message to the client.
    d. When the server receives "End" message, Connection is closed.  	  

************************************************
Program: Client.java                           *
Authors: Group 7                               *
Arguments: args[0] for ip address,             *
           args[1] for port number             *
************************************************
1. Open Command Prompt
2. Navigate to the bin folder of the project.
  For example: If the project is extracted to the following folder structure
  C:\Users\deept\Desktop\MSCSS\558 C - ADC\ADC_HW_Eclipse_WS\ClientServerApp

  The cmd command would be:
  cd C:\Users\deept\Desktop\MSCSS\558 C - ADC\ADC_HW_Eclipse_WS\ClientServerApp\bin

3. Once navigated, run the command - java clientserverapp.Client [IP Address] [portNumber]
    For eg.the IP Address would be of the machine on which the program runs - for eg: 10.0.0.192
            portNumber : same as the one on which server is started - 1342

4. Following message will be displayed - 
    Client: IPAddress:10.0.0.192
    Client: PortNumber:1342
    Client: Connected!

5. A message would be displayed - Client: Enter the day: 
    Enter any day of the week - mentioned above - say Monday or Tuesday etc.

6. The Server responds back with the Spanish transalation for that Day.

7. If a word that is not part of the dictionary mentioned in the About section is entered, the server responds back as - "Spanish Word - Not Found!" 

8. When the Client enters - "End", the connection between the Client & Server is closed.
  

  