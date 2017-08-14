 //One to many server program

import java.io.*;
import java.net.*;
import java.util.*;

public class Mserver
{
 public static Socket s[]=new Socket[10];
 public static String user[]=new String[10];
 public static int total;
 
 public static void main(String []args)
 {
  int i=0;
  
  try
  {
   ServerSocket ss=new ServerSocket(2016);
  System.out.println("\t\t\t\tServer Started .....\n"); 
   while(true)
   {
    s[i]=ss.accept();
    BufferedReader br=new BufferedReader(new InputStreamReader(s[i].getInputStream()));
    String msg=br.readLine();
    user[i]=msg;
    System.out.println(msg +" Connected To Server ");
    
    try
    {
     ReqHandler req=new ReqHandler(s[i],i);
     total=i;
     i++;
     Thread t=new Thread(req);
     t.start();
    }

    catch(Exception e)
    {
     System.out.println(e + " Client Disconnected ");
    }
   } 
  }

  catch(Exception e)
  {
   System.out.println(e);
  }
 }
}