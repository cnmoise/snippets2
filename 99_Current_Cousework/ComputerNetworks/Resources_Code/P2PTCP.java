// Class with server code using TCP
import java.net.*;
import java.io.*;

public class P2PTCP {
     public static void main ( String argv[] ) throws IOException {
		
		//Launching thread for server
		  new ServerConnection(Integer.parseInt(argv[1])).start();
        
        //Client Code
		String sentence;
		String modifiedSentence;

		BufferedReader inFromUser = new BufferedReader 
				(new InputStreamReader (System.in) );
		
		Socket clientSocket = new Socket (argv[0],Integer.parseInt(argv[1]) );

		DataOutputStream outToServer = new DataOutputStream 
				(clientSocket.getOutputStream());

		BufferedReader inFromServer = new BufferedReader 
				(new InputStreamReader (clientSocket.getInputStream() ) );

        System.out.println ("Write sentence for server" + '\n' );
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println ("From Server: " + modifiedSentence );
        clientSocket.close();
		

	 } //End main

} //End ServerTCP


//Server code
class ServerConnection extends Thread {
	 int portnnum;
	 ServerConnection(int portnum) throws SocketException {
		 this.portnnum = portnum;
	 }

    public void run( ) {
	try{
		String clientSentence;
		String capitalizedSentence;
		
		ServerSocket welcomeSocket = new ServerSocket ( portnnum );
		while (true)
		 {
			Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader 
				(new InputStreamReader (connectionSocket.getInputStream() ) );
			DataOutputStream outToClient = new DataOutputStream 
				(connectionSocket.getOutputStream());

			clientSentence = inFromClient.readLine();
			capitalizedSentence = clientSentence.toUpperCase () + '\n';
			outToClient.writeBytes(capitalizedSentence);
		   
		 } //End while
       }

	   catch ( IOException e ) {
		System.out.println( "I/O error: " + e);
                                }
    }
  }


