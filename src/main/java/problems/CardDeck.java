package problems;

import java.util.Random;

public class CardDeck 
{
	public Card[] Shuffle(Card[] deck)
	{
		Random random = new Random();
		
		for (int i = 0; i < deck.length; i++)
		{
			int randomIndex = random.nextInt(deck.length-1) + 1;
			Card tmp = deck[randomIndex];
			deck[randomIndex] = deck[i];
			deck[i] = tmp;
		}
		
		return deck;
	}
	
	public static void main(String[] args)
	{
		int deckCount = 52;
		Card[] deck = new Card[deckCount];
		
		for(int i = 0; i < deckCount; i++)
		{
			deck[i] = new Card(i);
		}
		
		CardDeck cd = new CardDeck();
		
		Card[] result = cd.Shuffle(deck);
		
		for(int i = 0; i < deck.length; i++)
			System.out.println(deck[i].Value);
	}
}
