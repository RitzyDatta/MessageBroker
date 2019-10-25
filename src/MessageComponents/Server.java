package MessageComponents;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable {
	private ServerSocket server;
	
	Server(int port) throws IOException{
		server= new ServerSocket(port);
		//server.setSoTimeout(90000);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}