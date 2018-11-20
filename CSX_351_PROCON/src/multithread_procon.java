import java.util.Vector;
//main method 
public class multithread_procon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//queue using vector created
		Vector queue = new Vector();
        int size = 5;
        //producer thread created
        Thread t_prod = new Thread(new producer(queue, size));
        //consumer thread created
        Thread t_con = new Thread(new consumer(queue, size));
        //producer thread started
        t_prod.start();
        //consumer thread started
        t_con.start();
	}

}
