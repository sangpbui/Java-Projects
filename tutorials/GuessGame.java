class GuessGame {
	Player p1;
	Player p2;
	Player p3;

	public void startGame() {
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();

		int guessp1 = 0;
		int guessp2 = 0;
		int guessp3 = 0;

		boolean p1Right = false;
		boolean p2Right = false;
		boolean p3Right = false;

		int targetNumber = (int) (Math.random() * 10);
		System.out.println("I'm thinking of a number between 0 and 9 ...");

		while (true) {
			System.out.println("Number to guess is " + targetNumber);

			p1.guess();
			p2.guess();
			p3.guess();

			// Assign the guess number from each player
			guessp1 = p1.number;
			System.out.println("Player 1 guesses" + " " + guessp1);

			guessp2 = p2.number;
			System.out.println("Player 2 guesses" + " " + guessp2);

			guessp3 = p3.number;
			System.out.println("Player 3 guesses" + " " + guessp3);

			if (guessp1 == targetNumber) {
				p1Right = true;
			}

			if (guessp2 == targetNumber) {
				p2Right = true;
			}

			if (guessp3 == targetNumber) {
				p2Right = true;
			}

			// Declare the winner	
			if (p1Right || p2Right || p3Right) {
				System.out.println("We found the winner");
				System.out.println("Player 1 is " + p1Right);
				System.out.println("Player 2 is " + p2Right);
				System.out.println("Player 3 is " + p3Right);
				break;
			} else {
				// If nobody guesses correctly
				System.out.println("Everyone is wrong! Try again!");
			}
		}
	}
}