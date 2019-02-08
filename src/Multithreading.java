import java.io.IOException;

public class Multithreading {
MergeSort mergeobject = new MergeSort();
HeapSort heapsortobject = new HeapSort();
TimSort timsortobject = new TimSort();

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA a = new ThreadA();
		a.start();
		ThreadB b = new ThreadB();
		b.start();
		ThreadC c = new ThreadC();
		c.start();
		//new ThreadA().start();
	    //new ThreadB().start();
	   // new ThreadC().start();
	    

	}
}
class ThreadA extends Thread{


	  public void run(){
		  
	     
			try {
				MergeSort.main(new String[] {});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	  }
}

class ThreadB extends Thread{

	  public void run(){
		 
				HeapSort.main(new String[] {});
			
	  }
	}
class ThreadC extends Thread{

	  public void run(){
		 
				TimSort.main(new String[] {});
			
	  }
	}




