/**********************************************************************************************
* Starter code used was from http://introcs.cs.princeton.edu/java/84network/Mail.java.html
* Robert McDevitt
************************************************************************************************/

import java.io.*;
import java.net.*;
import java.util.*;

public class SmtpClient {
    public static void main(String[] args) throws Exception {
        
        if(args.length != 2){
		System.out.println("You must provide Email server address and port number!");
		System.exit(0);
	}
	
	InetAddress host = InetAddress.getByName(args[0]);
	
        int port = Integer.parseInt(args[1]);
        Socket socket = new Socket(host, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
	Scanner input = new Scanner(System.in);

        System.out.println("Enter From email address:");
	String From = input.nextLine();

        out.println("MAIL From: " + From);
        System.out.println(in.readLine());

        // send to this address
	System.out.println("Enter the To email address:");
	String To = input.nextLine();
        out.println("RCPT To: "+ To);
        System.out.println(in.readLine());
	System.out.println("Enter A Message:");
	String message = input.nextLine();
        if(message.charAt(message.length() -1) != '.'){
		message = message + ".";
	}
        out.println("DATA");
        System.out.println(in.readLine());


        out.println("From: <"+From+">");
        out.println("Subject: Test");
        out.println("To: " + To);

        out.println(message);
        out.println(".");
        System.out.println(in.readLine());
	System.out.println("Message accepted for delivery.");


        out.close();
        in.close();
        socket.close();
    }
}

