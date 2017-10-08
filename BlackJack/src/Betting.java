import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Betting {

	private ArrayList <Integer> playerBet = new ArrayList<>();
	private int playerChips = 0;
	private Scanner scan = new Scanner(System.in);

	int[] tempHand = {5,2};
	
	public ArrayList<Integer> getPlayerBet() {
		return playerBet;
	}

	public void setPlayerBet(ArrayList<Integer> playerBet) {
		this.playerBet = playerBet;
	}

	public int getPlayerChips() {
		return playerChips;
	}

	public void setPlayerChips(int playerChips) {
		this.playerChips = playerChips;
	}





	/**Har man inga pengar kan man inte betta - skriv ut att man inte kan betta mer. 
	 * har man pengar räknar man första handen playerBet[0]
	 * finns det fler händer fortsätter man 
	 * 
	 * Om man har 7-11 kan man dubbla
	 * Om man inte har pengar får man istället upp att man kan satsa sina sista slantar
	 * Om man inte har några pengar kvar får man upp att man inte kan dubbla 
	 * Har man fler än en hand så ska handens nummer redovisar, typ Din hand 1 har 11 - vill du dubbla?
	 * 
	 * 
	 * Om man satsat sin sista slant och förlorat så åker man ut. 
	 * 
	 * @param betIn
	 * @param chipsIn
	 */
	
	//vinst ger 1x pengar. Alltså 10 man satsade + 10
	//Har man 21 och vinner får man 1.5x peng. Alltså 10 man satsade + 15
	//Har dealer och playern lika mellan 17-21 får man tillbka instatsen.  
	//Har spelaren 7-11 på grundgiven kan spelaren dubbla insatsen. 
	//felmeddelande om man bettar med för mycket pengar. 
	//är pengarna slut ska spelet sluta auto. ett felmeddelande att pengarna är slut. 
	
	  public int bettingLoop() 
	  {
		   boolean bettingAgain=false;
		   int bettingIn=0;
	   do{
	     if (getPlayerChips()>0)
	      {
			  System.out.println("Du har $"+getPlayerChips()+". Hur mycket vill du satsa?");
			  
			  bettingIn = bettingScanEvaluator();

			  if (bettingIn<=getPlayerChips())
			  {
				  setPlayerChips(getPlayerChips()-bettingIn); 
				  System.out.println("Du satsar $" + bettingIn);
				  System.out.println("Du har $"+getPlayerChips()+" kvar.");
				  bettingAgain=false;
			  }else {
				  System.out.println("Du kan inte satsa så mycket.");
				  bettingAgain=true;
			  }
			  
	      }else{
		      bettingAgain=false;
		      System.out.println("Du har inga pengar kvar att satsa med.");
	      }
	     }while(bettingAgain==true);
	   
	   return bettingIn;

	  }

	  

	  public void doubleUp(int[] handIn)

	  {

	    //if handIn = 7-11 AND length =2;

	    //fråga om spelaren vill dubbla. 

	  }
	  
	  int bettingScanEvaluator ()
	  {
		  Scanner scannerAnswer = new Scanner(System.in);
		  int bettingIn;
		  do {
		      while (!scannerAnswer.hasNextInt()) {
		    	  	System.out.println("Felaktig inmatning. Försök igen.");
		          scannerAnswer.next(); 
		      }
		      bettingIn = scannerAnswer.nextInt();
		  } while (bettingIn <= 0);

		  return bettingIn;
	  }
	  
}