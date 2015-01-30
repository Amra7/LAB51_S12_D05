package ba.bitcamp.lecture.tarik.threads;

import java.util.ArrayList;

public class WriteRandomHash extends Thread {

	private String name;
	
	/**
	 * @param name
	 */
	public WriteRandomHash(String name) {
		super();
		this.name = name;
	}

	public void run(){
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Jedva");
		strings.add("cekam");
		strings.add("vikend");
		strings.add("da");
		strings.add("se");		
		strings.add("naspavam.");
		
		for (String s : strings){
			System.out.println("Thread name: "+  name + "String: " + s);
		}
	}
}
