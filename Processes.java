package Q2Classes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Processes
{
	
public static void main(String [] args) throws IOException 
{
    //Create a Process Builder
	ProcessBuilder pB = new ProcessBuilder();
    
	//Process Builder command
	pB.command("cmd.exe","/c","ping -n 10 google.com");
	
	//Starting processBuilder
	Process p = pB.start();
	
	//Buffered reader that writes the output(ping response) to the console
	BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String l;
	while((l=br.readLine())!=null){
		System.out.println(l);
	}
}




}