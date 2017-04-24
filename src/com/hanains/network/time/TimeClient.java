package com.hanains.network.time;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
//import java.util.Scanner;

public class TimeClient {
	private static final String SERVER_IP = "192.168.1.37";
	private static final int PORT = 6666;
	public static void main(String[] args) {
		DatagramSocket socket = null;
//		Scanner scanner = new Scanner(System.in);
		try {
			socket = new DatagramSocket();
			
//			System.out.println("현재 시간을 알고 싶으면 아무거나 전송하시오.");
//			System.out.print(">>");
//			String message = scanner.nextLine();
			String message = "";
			
			byte[] sendData = message.getBytes("utf-8");
			DatagramPacket packet = new DatagramPacket(sendData, sendData.length, new InetSocketAddress(SERVER_IP, PORT));
			
			socket.send(packet);
			
			packet = new DatagramPacket(new byte[1024], 1024);
			socket.receive(packet);
			
			message = new String(packet.getData(),0,packet.getLength(),"utf-8");
			System.out.println(message);
			
		}  catch (SocketException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(socket != null && socket.isClosed()==false){
				socket.close();
			}
			socket.close();
		}

	}

}
