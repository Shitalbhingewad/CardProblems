package DeckCard.cardproblems;
import java.util.Random;
public class DeckOfCardsExtended {

	
		MyQueue<Player> playerQueue;	
		int[][] cardsArray;	
		public static void main(String[] args) {
			
			DeckOfCardsExtended extended = new DeckOfCardsExtended();	
			extended.start();	
			extended.dequeuePlayers();	
		}
		
		
		void start() {
			playerQueue = new MyQueue<Player>();
			cardsArray = new int[4][13];
			for(int i = 0; i < 4; i++) {
				addPlayers();
			}
		}
		
	
		void addPlayers() {
			Player player = new Player();		
			for (int i = 0; i < 9; i++) {
				allotCard(player);
			}
			player.enqueueCards();	//	sorts the allotted cards
			playerQueue.enqueue(player);	//	enqueues the player
		}
		
		
		void allotCard(Player player) {
			Random random = new Random();	//	random object
			int suit = random.nextInt(4);
			int rank = random.nextInt(13);
			if(cardsArray[suit][rank] == 0) {	//	checks if the card is already allotted
				player.addCard(suit, rank);	// adds card to player
				cardsArray[suit][rank] = 1;	//	marks card as allotted
			}
			else {	//	card is already allotted. generates new card 
				allotCard(player);
			}
		}
		
		
		void dequeuePlayers() {
			for(int i = 0; i < 4; i++) {
				Player player = playerQueue.dequeue();
				System.out.println("Player " + (i+1) + "'s cards:");
				printPlayerCards(player);
				System.out.println();
			}
		}
		
	
		void printPlayerCards(Player player) {
			for (int i = 0; i < 9; i++) {
				Card card = player.getCard();
				System.out.print(card.getSuit() + " " + card.getRank() + "\t");
			}
			System.out.println();
		}
	}

