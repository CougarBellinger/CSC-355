public class SelfPayKiosk {
   private int numCustomers;
   private double totalSales;
   private double amountDue;

   private boolean hasCheckedOut;

   private final double SALES_TAX = 0.07;

   // Constructor
   public SelfPayKiosk() {
      numCustomers = 0;
      totalSales = 0;
      amountDue = 0;
      hasCheckedOut = false;
   }

   // Return total daily sales
   public double getTotalSales() {
      return totalSales;
   }

   // Return current amount due
   public double getAmountDue() {
      return amountDue;
   }

   // Return number of customers served
   public int getNumCustomers() {
      return numCustomers;
   }

   // Scan one item
   public void scanItem(double price) {
      amountDue += price;
   }

   // Apply sales tax to current purchases
   public void checkOut() {
      amountDue += (amountDue * SALES_TAX);
      hasCheckedOut = true;
   }

   // Cancel current purchases
   public void cancelTransaction() {
      if (!hasCheckedOut) {
         amountDue = 0;
      }
   }

   // Reset register for the day
   public void resetKiosk() {
      amountDue = 0;
      numCustomers = 0;
      totalSales = 0;
      hasCheckedOut = false;
   }

   // Apply payment to amount due
   public void makePayment(double payment) {
      if (hasCheckedOut) {

         if (payment >= amountDue) {
            totalSales += amountDue;
            amountDue = 0;
            numCustomers++;
            hasCheckedOut = false;
         } else if (payment >= 0) {
            totalSales += payment;
            amountDue -= payment;
            hasCheckedOut = false;
         }

      }
   }

   // Simulate multiple transactions
   public void simulateSales(int numSales, double initialPrice, double incrPrice) {
      for (int i = 0; i < numSales; i++) {
         scanItem(initialPrice);
         checkOut();
         makePayment((initialPrice * (1 + SALES_TAX) + 1.0));

         initialPrice += incrPrice;
      }
   }
}