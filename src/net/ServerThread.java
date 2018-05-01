package net;

import model.Library;

import java.net.Socket;
import java.net.InetAddress;
import java.io.*;

public class ServerThread extends Thread{
	private PrintStream os;
	private BufferedReader is;
	private InetAddress addr;
	private static int counter=0;
	ObjectInputStream cois = null;
	ObjectOutputStream coos =null;
	Responce responce=new Responce();

	public ServerThread(Socket s) {
		try {
			cois =new ObjectInputStream(s.getInputStream());
			coos =new ObjectOutputStream(s.getOutputStream());
			is = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addr = s.getInetAddress();
		counter++;
	}
	public static int getCounter(){return counter;}

	public void run() {
        int choise;
		try {
			while(true) {
				responce = (Responce) cois.readObject();
				choise = responce.getChoise();
				switch (choise) {
					case 1: { System.out.println("Case 1");/*coos.writeObject("������ �����������"); coos.flush();*/
						break;
					}
					case 2: { /*myLib.addAllStorages(); myLib.workWhithStorages(choise);*/
						System.out.println("Case 2");
						/*coos.writeObject(myLib);*/
						coos.flush();
						break;
					}
					default: {}
				}
			}
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
		
	public void disconnect() {
		try {

			if (is != null) { is.close(); }
			if (cois != null) cois.close();
			if (coos != null) coos.close();
			System.out.println(addr.getHostName() + " disconnecting");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.interrupt();
		}
	}
}
