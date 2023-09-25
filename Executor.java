package Q2Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Instantiate class which implements Callable
public class Executor implements Callable <String>{

public static void main(String [] args) throws IOException
{
	//Create Executor service
	ExecutorService servicePool = Executors.newSingleThreadExecutor();
	
   //Create a Process Builder
	ProcessBuilder pB = new ProcessBuilder();
    //Process Builder command 
	pB.command("cmd.exe","/c","ping -n 10 google.com");
	//Start the process Builder 
	Process p = pB.start();
	 
	//Create an arraylist to store furtue objects in callable
	 ArrayList<Future<String>> list = new ArrayList<Future<String>>();
	 
	 //Create a callable instance
	 Callable<String> callable = new Executor();
	 
	 for (int i = 0; i < 5; i++);
	 {
		//Call submit on servicePool'
		Future<String> future = servicePool.submit(callable);
		list.add(future);
	 }
	 
	 for (Future<String> future: list)
	 {
		 //Read the results from the Future object by calling one of the Future.get() method
		 try {
			System.out.println(new String() + "" + future.get());
		} catch (InterruptedException | ExecutionException e) {
		//and print it out to the console
			e.printStackTrace();
		}
	 }
		 
}


public String call() throws Exception {
	Thread.sleep(500);
	//Return a future object
	return Thread.currentThread().getName();
}




}
