import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class dboxRunnable implements Runnable {
	protected Socket clientSocket = null;
	
	public dboxRunnable(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	public void run() {
		try {
		
//			File myFile = new File("test_received.txt");
//			//byte[] b=new byte[(int) myFile.length()];
//			byte[] b=new byte[2048];
//			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
//			bis.read(b, 0, b.length);
//			OutputStream os = clientSocket.getOutputStream();
//			os.write(b, 0, b.length);
//			os.flush();
//			bis.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String arg1 = in.readLine();
			System.out.println("Client at address: "+ clientSocket.getInetAddress() + ", port: " + clientSocket.getPort() + " says "+ arg1);
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			out.println("Thanks for the message!!!");
			out.close();
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
