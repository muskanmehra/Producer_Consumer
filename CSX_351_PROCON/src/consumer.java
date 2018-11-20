import java.util.Vector;
public class consumer implements Runnable {
	
	Vector queue;
    int size;
    //constructor 
    public consumer(Vector queue, int size) {
        this.queue = queue;
        this.size = size;
    }
    //overridden
    public void run() {
    	while(true)
    	{
    		consume();
    	}
    }
    public void consume() 
 	{ 
 	 	synchronized(queue) 
 	 	{ 
   //if the queue is Empty then queue is taken into Empty state 
 	 	 	while(queue.isEmpty()) { 
 	 	 	 	System.out.println("\nqueue is Empty.Consumer Thread  in waiting state."); 
 	 	 	 	try{queue.wait();}
 	 	 	 	catch(Exception e) {} 
 	 	 	} 
 	 	} 
 	 	synchronized(queue) 
 	 	{ 
//consumer consumes if not empty
 	 		System.out.print("\nConsumer Consumes item: "+queue.remove(0)); 
 	 	 	try{Thread.sleep(1000);}
 	 	 	catch(Exception e) {}; 
 	 	 	queue.notify(); 
 	 	} 
 	} 

}
