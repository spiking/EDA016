package lab7;

import se.lth.cs.ptdc.cardGames.Card;
import java.util.Random;

public class CardDeck {
	private Card[] cards;
	private int current;
	private static Random rand = new Random();

	/**
	 * Skapar en kortlek som inte är blandad.
	 */

	public CardDeck() {
		cards = new Card[52];
		current = 0;
		for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
			for (int rank = 1; rank < 14; rank++) {
				cards[current] = new Card(suit, rank);
				current++;
			}
		}
	}

	/**
	 * Blandar kortleken.
	 */

	/**
	 * Skapar först ett kort (card) på index [nbr]. Byter plats på elementen
	 * (korten), på index [nbr], med kortet på index [i]
	 */

	public void shuffle() {
		for (int i = 51; i > 0; i--) {
			int nbr = rand.nextInt(i + 1);
			Card card = cards[nbr];
			cards[nbr] = cards[i];
			cards[i] = card;

		}
		current = 52;
	}

	/**
	 * Undersöker om det finns fler kort i kortleken.
	 * 
	 * @return true om det finns fler kort, false annars
	 */

	public boolean moreCards() {
		return current > 0;

	}

	/**
	 * Drar det översta kortet i leken. Fungerar bara om moreCards är true.
	 * 
	 * @return det översta kortet i leken
	 */

	public Card getCard() {
		current--;
		return cards[current];

	}

}
