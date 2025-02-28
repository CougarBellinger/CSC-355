import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      SelfPayKiosk kiosk = new SelfPayKiosk();

      // Test basic operations
      System.out.print("Input item price: ");
      double userPrice = scanner.nextDouble();

      kiosk.scanItem(userPrice);
      kiosk.checkOut();

      System.out.printf("Amount due: %.2f\n", kiosk.getAmountDue());
      System.out.print("Input payment amount: ");
      double userPayment = scanner.nextDouble();

      kiosk.makePayment(userPayment);

      System.out.println("Number of customers: " + kiosk.getNumCustomers());
      System.out.printf("Total Sales: %.2f\n\n", kiosk.getTotalSales());

      // Add statements as methods are completed to support development mode testing

      // Test simulateSales()
      kiosk.resetKiosk();

      System.out.println("Input for simulating sales");

      System.out.print("numSales: ");
      int inputNumSales = scanner.nextInt();

      System.out.print("initialPrice: ");
      double inputInitPrice = scanner.nextDouble();

      System.out.print("incrPrice: ");
      double inputIncrPrice = scanner.nextDouble();

      kiosk.simulateSales(inputNumSales, inputInitPrice, inputIncrPrice);

      System.out.println("Number of customers: " + kiosk.getNumCustomers());
      System.out.printf("Amount due: %.2f\n", kiosk.getAmountDue());
      System.out.printf("Total Sales: %.2f\n", kiosk.getTotalSales());

      scanner.close();
   }
}
