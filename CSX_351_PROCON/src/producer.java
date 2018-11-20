import java.util.Vector;
public class producer implements Runnable {
	
	Vector queue;
    int size,i=0;
    //constructor 
    public producer(Vector queue, int size) {
        this.queue = queue;
        this.size = size;
    }
    //overridden
    public void run() {
    	while(true)
    	{
    		produce(i++);
    	}
    	
    }
    public void produce(int i) 
    {
    	synchronized(queue) {
    	while(queue.size()==size)
    	{
    		  System.out.println("queue is full. Producer Thread is in waiting state");	
    		 try { 
    			 queue.wait();
    			 }
    		 catch(Exception e) {};
    	}
    	synchronized(queue) 
 	 	{ 
 	 	 	System.out.println("\nProducer Produce an item: "+i); 
 	 	 	//here the value i is added in the Buffer  	 	 	
 	 	 	queue.add(i); 
 	 	 	try{Thread.sleep(100);}
 	 	 	catch(Exception e) {}; 
 	 	 	//it is notifying 
 	 	 	queue.notify(); 
 	 	} 

    	
    	}
    	
    }
}
