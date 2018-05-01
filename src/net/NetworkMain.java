package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkMain {

	public static void main(String[] args) {
		try(ServerSocket server=new ServerSocket(8071,10,InetAddress.getLocalHost())) {
			System.out.println("initialized: " + server.getInetAddress());
			while(true) {
				Socket socket=server.accept();//�������� ����������� �������
				System.out.println(socket.getInetAddress() + " connected");
				//�������� ���������� ������ ��� ������ ������� � ������������� ��������
				ServerThread thread = new ServerThread(socket);
				thread.start();
				System.out.println(socket.getInetAddress() + " � "+ServerThread.getCounter()+ " started");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
