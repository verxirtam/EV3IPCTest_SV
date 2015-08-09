import java.io.*;
import java.net.*;

public class EV3IPCTest_SV
{
	public static void main(String[] args)
	{
		int port = 50000;

		ServerSocket s_s=null;
		try {
			s_s = new ServerSocket(port);
			System.out.println("Ready to Transfer");
			for (;;) {
				Socket s = s_s.accept( );
				new Connect(s).start();
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				s_s.close();
			}
			catch(IOException ioe){}
		}
	}
}
/*
          新しい接続
*/
class Connect extends Thread
{
	private Socket s;

	public Connect(Socket s_i)
	{
		s = s_i;
	}

	public void run()
	{

		try {
					// ファイル名
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			//out.println("This is test message by Java.AAAA:0");
			//out.println("This is test message by Java.AAAAAAAAA:1");
			//out.println("This is test message by Java.:2");
			
			out.println("MESSAGE_1.0");
			out.println("EV3LineTracer_1.0");
			out.println("NullCommand");
			out.println("OK");
			out.println("");
			

			s.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}