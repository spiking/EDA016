package lab7;

public class Patiens {

	public static void main(String[] args) {

		CardDeck deck = new CardDeck();
		int fail = 0;
		int tries = 1000000;
		int n = 0;

		for (int i = 0; i < tries; i++) {
			deck.shuffle();

			while (deck.moreCards()) {

				n = (n - 1) % 3 + 1; 

				if (deck.getCard().getRank() == n) {
					fail++;
					break;
				}
				n++;
			}
		}

		System.out.println("Probability: " + (double) (tries - fail) / tries);
	}
}
