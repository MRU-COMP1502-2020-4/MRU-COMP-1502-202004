package comp1502.otherpackages;

import comp1502.packages.*;

// our package should be ca.mtroyal.comp1502.packages, but that's dumb

public class ExampleC {

	public static void main (String[] args) {
		
		
		ExampleA a = new ExampleA(50);
		ExampleA.classMethod();
		a.print();
		
		ExampleA a2 = new ExampleA(100);
		ExampleA.classMethod();
		a2.print();
		
		
		
	}
	
}
