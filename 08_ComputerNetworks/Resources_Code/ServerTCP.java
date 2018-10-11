// Class with server code using TCP
import java.net.*;
import java.io.*;

public class ServerTCP {
     public static void main ( String argv[] ) throws IOException {
		
		String clientSentence;
		String capitalizedSentence;
		
		ServerSocket welcomeSocket = new ServerSocket ( Integer.parseInt(argv[0]) );
		while (true)
		 {
			Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader (new InputStreamReader (connectionSocket.getInputStream() ) );
			DataOutputStream outToClient = new DataOutputStream (connectionSocket.getOutputStream());

			clientSentence = inFromClient.readLine();
			capitalizedSentence = clientSentence.toUpperCase () + "Bye all" + '\n';
                        System.out.println(clientSentence);
			outToClient.writeBytes(capitalizedSentence);
		   
		 } //End while

	 } //End main

} //End ServerTCP
