package ba.bitcamp.lecture.tarik.threads;

public class WriteInt extends Thread{

	private String name;
	
	/**
	 * @param name
	 */
	public WriteInt(String name) {
		super();
		this.name = name;
	}

	public void run(){
		
		for ( int i=0; i<5; i++){
			System.out.println("Number: " + i);
		}
	}
}
