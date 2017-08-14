 //ReqHandler class for One to many chat application

import java.net.*;
import java.io.*;

class ReqHandler implements Runnable
{
 public int n;
 public Socket s;
 
 public ReqHandler(Socket soc,int i)
 {
  s=soc;
  n=i;  
 }

 public void run()
 {
  BufferedReader br;
  PrintWriter pw;
  try
  {
   while(true)
   {
    br=new BufferedReader(new InputStreamReader(s.getInputStream()));
    String msg=br.readLine();

    //if(msg.equals("quit") || msg==null)
if(msg==null)
{
    Mserver.total--;
throw new Exception( " Client is Disconnected From Server ");
}
    else
    System.out.println("\t\t\t" + Mserver.user[n]+"-->" + (n+1) +"/" + (Mserver.total+1)  +"::"+msg);
 
    if(Mserver.total==-1)
    {
     System.out.println("server disconnected");
     System.exit(0);
    } 
    
    for(int k=0;k<=Mserver.total;k++)
    {
     if(!Mserver.user[k].equals(Mserver.user[n]) && (!msg.equals("quit")))
     {
      pw=new PrintWriter(new OutputStreamWriter(Mserver.s[k].getOutputStream()));
      pw.println(Mserver.user[n]+"=>"+msg+"\n");
      pw.flush();
     }
    }

   }
  }
  
  catch(Exception e)
  {
   System.out.println(e.getMessage());
  }
 }
}