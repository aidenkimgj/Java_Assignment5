package sait.sll.utility;

public class test {

	public static void main(String[] args) {
		SLL sl = new SLL();
		
		sl.prepend("xyz");
		sl.append("jkl");
		sl.append("def");
		sl.delete(0);
		sl.delete(1);
		sl.prepend("xyz");;
		System.out.print(sl.retrieve(0));
		System.out.print(sl.retrieve(0));
		System.out.print(sl.retrieve(1));
	}

}
