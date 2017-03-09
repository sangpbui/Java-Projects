class Shufflel {
	public static void main(String[] args) {
		
		int x = 3;
		

	 	while (x > 0) {

	 		if (x > 2) {
	 		System.out.print("a");
	 		}

	 		x = x - 1;
	 		System.out.print("-");

	 		if (x == 2) {
	 			System.out.print("b c");
	 		}

	 		if (x == 1) {
	 			System.out.println("d");
	 		}

	 	}

	 	/* compile but gets stuck
	 	int y = 1;
	 	while (y < 10) {
	 		if (y > 3){
	 			System.out.println("big y");
	 		}
	 	}
	 	*/

	 	int z = 5;
	 	while (z > 1) {
	 		z = z - 1;
	 		if (z < 3) {
	 			System.out.println("small z");
	 		}
	 	}

	 	int a = 5;
	 	while (a > 1) {
	 		a = a -1;
	 		if (a < 3){
	 			System.out.println("small a");
	 		}
	 	}

	 	int b = 0;
	 	int c = 0;

	 	while (b < 5) {
	 		b = b + 1;
	 		c = c + b;
	 		System.out.print(b + "" + c + " ");
	 		b = b + 1;
	 	}
	}
}