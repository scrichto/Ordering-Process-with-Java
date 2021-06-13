/* MIS350 M3
   Stephen Crichton
   12/3/2020
   Final code for Fastenal Company online store ordering
*/

import java.util.Scanner;


public class FastenalStore {
   //main method
	public static void main( String[] args ) {
		Scanner input = new Scanner(System.in);
		
		int [] prodNumber = {1, 2, 3, 4, 5, 6};
		String [] prodName = {"Axe", "Drill", "Hammer", "Toolbox", "Batteries", "Ladder"};
		int [] prodPrice = {10, 40, 7, 100, 3, 30};
		
		//Display welcome message and table of products 
		System.out.print("Hello, welcome to Fastenal Company!\n");
		System.out.println("----------------------------------------------------");
		System.out.println("|\tProduct ID\t|\tProduct Name\t|\tProduct Price\t|");
		System.out.println("----------------------------------------------------");
		// Print the table.
		for (int i = 0; i < prodNumber.length; i++) {
			System.out.printf("|\t%-8s\t\t|\t%-9s\t\t|\t$%-9s\t\t|\n", prodNumber[i], prodName[i], prodPrice[i]);
		}
		System.out.println("----------------------------------------------------");
		
		int total = 0;
		
		//Call Order method
		total = processOrder(prodNumber, prodName, prodPrice, total);
		System.out.printf("Your order total is: $%d", total);	
		System.out.println();
		
		//Call Payment method
		payment();
		System.out.println();
      
		//Call Fulfillment method
      fillOrder();
      System.out.println();
      
		//Display thank you message
		
	}
	
	// Payment Method
	public static void payment() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like to pay with a card now? (Enter 1 for yes, 0 for no)");
		int payNow = input.nextInt();
		
		if (payNow == 1) {
			System.out.println("Please enter your card number.");
			int cardNum = input.nextInt();
			System.out.printf("You entered card number: %d", cardNum);
			System.out.println();
			System.out.println("Your payment information has been confirmed!");
		}
		else if (payNow == 0) {
			System.out.println("Thanks, you will pay upon pickup of your order!");
			System.out.println("Your payment information will be confirmed upon pickup.");
		}
		
	}
   
   //Fulfillment methods
      public static void fillOrder() {
         Scanner input = new Scanner(System.in); 
         
         System.out.println("Would you like your order delivered or pickup in store? 30 = delivery, 1 = in store"); 
         int shipMethod = input.nextInt(); 
         
         if (shipMethod == 0) {
            System.out.println("Please select one of our delivery partners.\n1.)UPS\n2.)FedEx\n3.)USPS");
            int carrier = input.nextInt(); 
            
            if (carrier > 0 && carrier <= 3) {
               System.out.println("Your order is complete. Thank you for using Fastenal Company!"); 
            }
            else {
               System.out.println("Invalid input. Please enter a valid carrier.");
            } 
         } 
         else if (shipMethod == 1) {
            System.out.print("Your have selected to pick up your order in store, see you then!\nThank you for choosing Fastenal Company!");
         }
         else {
            System.out.println("Invalid fulfillment method, please select a valid option.");
         } 
      }

	
	// Order Method
	public static int processOrder(int [] prodNums, String [] prodNames, int [] prodPrices, int currentTotal) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the ID of the product you would like to purchase.");
		int prodID = input.nextInt();
		System.out.println("Plase enter the quantity you would like.");
		int qty = input.nextInt();
		currentTotal += (prodPrices[prodID - 1] * qty);
		System.out.print("\nCurrent Total: $");
		System.out.println(currentTotal);
      
      int cont = 1;
		
		while(cont != 0) {
			System.out.println("\nWould you like to continue shopping? (Enter 1 for yes, 0 for no)");
			cont = input.nextInt();
			if (cont != 0) {
				System.out.println("Please enter the ID of the product you would like to purchase.");
				prodID = input.nextInt();
				System.out.println("Plase enter the quanity you would like.");
				qty = input.nextInt();
				currentTotal += (prodPrices[prodID - 1] * qty);
				System.out.print("\nCurrent Total: $");
				System.out.print(currentTotal);
			}
		} 
		return currentTotal;
	}
} 
     
           