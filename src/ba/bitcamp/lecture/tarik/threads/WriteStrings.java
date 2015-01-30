package ba.bitcamp.lecture.tarik.threads;

import java.util.ArrayList;

public class WriteStrings  extends Thread{

	private String name;
	
	
	/**
	 * @param name
	 */
	public WriteStrings(String name) {
		super();
		this.name = name;
	}


	public void run(){
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Mi");
		strings.add("Vi");
		strings.add("Oni");
		strings.add("Ti");
		strings.add("Svi");		
		strings.add("Ja");
		
		for (String s : strings){
			System.out.println("Thread name: "+  name + "String: " + s);
		}
	}
}
