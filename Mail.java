/**********************************************************************************************
* Starter code used was from http://introcs.cs.princeton.edu/java/84network/Mail.java.html
* Robert McDevitt
************************************************************************************************/

import java.io.*;
import java.net.*;

public class Mail {
    public static void main(String[] args) throws Exception {
	
	InetAddress host = InetAddress.getByName(args[0]);
        int port = Integer.parseInt(args[1]);       
        Socket socket       = new Socket(host, port);
        BufferedReader in   = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out     = new PrintWriter(socket.getOutputStream(), true);

        out.println("MAIL From: mcdevitt@ksu.edu");
        System.out.println(in.readLine());

        // send to this address
        out.println("RCPT To: mcdevitt@ksu.edu");
        System.out.println(in.readLine());

        out.println("DATA");
        System.out.println(in.readLine());


        out.println("From: Robert <mcdevitt@ksu.edu>");
        out.println("Subject: Test");
        out.println("To: mcdevitt@ksu.edu");

        out.println("This is a test");
        out.println(".");
        System.out.println(in.readLine());
	System.out.println("QUIT");


        out.close();
        in.close();
        socket.close();
    }
}

