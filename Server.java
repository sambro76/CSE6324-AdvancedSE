import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			
			serverSocket = new ServerSocket(8000);
			System.out.println("Server has started...");
			
			while(true) {
				try {
					Socket clientSocket = serverSocket.accept();
					dboxRunnable d = new dboxRunnable(clientSocket);
					new Thread(d).start();


				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	} // end main
}
