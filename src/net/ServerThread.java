package net;

import model.Library;

import java.net.Socket;

import db.DataBaseHelper;

import java.net.InetAddress;
import java.io.*;
import java.net.SocketException;

public class ServerThread extends Thread{
	private PrintStream os;
	private BufferedReader is;
	private InetAddress addr;
	private static int counter=0;
	ObjectInputStream cois = null;
	ObjectOutputStream coos =null;
	Responce responce=new Responce();
	DataBaseHelper dbHelper;

	public ServerThread(Socket s) {
		try {
			dbHelper=new DataBaseHelper();
			cois =new ObjectInputStream(s.getInputStream());
			coos =new ObjectOutputStream(s.getOutputStream());
			is = new BufferedReader(new InputStreamReader(s.getInputStream()));
			dbHelper.getDBConnection();
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
			while((responce = (Responce) cois.readObject())!=null) {
				/*responce = (Responce) cois.readObject();*/
				choise = responce.getChoise();
				switch (choise) {
					case 1: { System.out.println("Case 1");dbHelper.getDBConnection();/*coos.writeObject("������ �����������"); coos.flush();*/
						break;
					}
					case 2: { System.out.println("Case 2"); dbHelper.getDBConnection();
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
