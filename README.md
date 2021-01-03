# A Client Server Application

This is a **Client Server Application** where a connection is established between the client and the server.

1. At first the server is started with the portnumber as the argument. The server listens to the clients on this port number.  
2. Once the Socket connection is established, the client can read and send mesages to the server and server can read the client's message and replies back to the client.
3. Once the Server is started, we run the command to start the client. The Client accepts two arguments - The IP Address and the same port number as the Server.  
4. This is a chatting application where the server is pre-populated with an English to Spanish dictionary for the days of the week, soon after the client establishes a connection with the Server.  

* English to spanish dictionary:  
"Monday"    - "Lunes"  
"Tuesday"   - "Martes"  
"Wednesday" - "Miercoles"  
"Thursday"  - "Jueves"  
"Friday"    - "Viernes"  
"Saturday"  - "Sabado"  
"Sunday"    - "Domingo"  

5. Once the server is prepopulated with the values, the user can enter a Day of the week in English language, client reads and sends that message to server. The spanish translation for the Day will be sent back to the client from the server.  
6. If a word that doesnt exist in the dictionary is entered, the server returns a message - "Spanish Word - Not Found!"  
7. When the client enters the word - "End", Connection between the client and the server is closed.  
8. Both the client and server displays the request timestamp and its response timestamp.

###### *Please contact deepthi.warrier@gmail.com for more info on the code*
