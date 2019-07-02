import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket clientSocket;
		PrintWriter out;
		BufferedReader in;
		InputStreamReader ir;
		Scanner sc = new Scanner(System.in);
		String msg;		
		int i = 0;
		try {
			while(i<1) {
				clientSocket = new Socket("localhost", 8000);
				System.out.println("\nConnected to server...");
				
//				byte[] b = new byte[2048];
//				InputStream is = clientSocket.getInputStream();
//				FileOutputStream fos = new FileOutputStream("test.txt");
//				BufferedOutputStream bos = new BufferedOutputStream(fos);
//				int bytesRead = is.read(b, 0, b.length);
//				bos.write(b, 0, bytesRead);
//				//bos.close();
				
				System.out.println("Input message to send: ");
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				msg = sc.nextLine();
				out.println(msg);
	
				//message from Server
				ir = new InputStreamReader(clientSocket.getInputStream());
				in = new BufferedReader(ir);
				System.out.println("Server says: " + in.readLine());
				ir.close();
				in.close();
				out.close();
				clientSocket.close();
			}
		} catch (UnknownHostException e) {
			//System.exit(1);
		} catch (IOException e) {
			//System.exit(1);
		}
		sc.close();
	} //end main

}
