 //One to many chat application

import java.net.*;
import java.io.*;

public class Mclient
{
 public static void main(String []args)
 {
  BufferedReader in;
  PrintWriter pw;
  try
  {
   Socket s=new Socket("localhost",2016);
   System.out.println("Enter name:");
   in=new BufferedReader(new InputStreamReader(System.in));
   String msg=in.readLine();
   pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
   pw.println(msg+"\n");
   pw.flush();

   while(true)
   {
    ReadData rd=new ReadData(s);
    Thread t=new Thread(rd);
    t.start();
    msg=in.readLine();
    if(msg.equals("quit"))
		    System.exit(0);
    pw.println(msg);
    pw.flush();
   }
  }  

  catch(Exception e)
  {
   System.out.println(e);
  }
 }
}