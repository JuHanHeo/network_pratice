package com.hanains.network.time;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
	private static final int PORT=6666;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(PORT);
			
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			
			socket.receive(packet); //수신 데이터 오기를 기다리고 있는다 . . . . .
			
			String message = new String(packet.getData(),0,packet.getLength(),"utf-8");
			System.out.println("[UDP Echo Server] 시간 요청 받음 - "+message);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
			String data = format.format(new Date());
			packet = new DatagramPacket(data.getBytes(), data.getBytes().length,packet.getSocketAddress());
			socket.send(packet);
			
		} catch (SocketException e) {
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
		}

	}

}
