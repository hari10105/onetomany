  //ReadData class for One to many chat application

import java.io.*;
import java.net.*;

class ReadData implements Runnable
{
 public Socket s;
 
 public ReadData(Socket s)
 {
  this.s=s;
 }
 
 public void run()
 {
  BufferedReader br;
  try
  {
   while(true)
   {
    br=new BufferedReader(new InputStreamReader(s.getInputStream()));
    String msg=br.readLine();
    System.out.println(msg);
   }
  }
  catch(Exception e)
  {
   System.out.println(e.getMessage());
  }
 }
}
