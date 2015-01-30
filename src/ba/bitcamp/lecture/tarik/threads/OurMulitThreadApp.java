package ba.bitcamp.lecture.tarik.threads;

public class OurMulitThreadApp {

	public static void main(String[] args) {
		
		WriteInt wi  = new WriteInt("Integers");
		WriteStrings ws  = new WriteStrings("Strings");
		WriteRandomHash  wrh= new WriteRandomHash("Hash");
		Thread t= new Thread(wrh);
		t.start();
		wi.start();
		ws.start();
	}
}
