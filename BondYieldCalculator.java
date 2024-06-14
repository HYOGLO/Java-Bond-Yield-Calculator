import java.util.Scanner;

public class BondYieldCalculator {
    
    public static double calculateYTM(double price, double couponRate, double faceValue, int yearsToMaturity) {
        double couponPayment = couponRate * faceValue;
        double interestRateGuess = couponRate;
        double tolerance = 0.0001; // tolerance for accuracy
        double ytm = 0.0;
        
        // Using iterative approach to find YTM using trial and error
        while (true) {
            double presentValue = 0.0;
            for (int i = 1; i <= yearsToMaturity; i++) {
                presentValue += couponPayment / Math.pow(1 + interestRateGuess, i);
            }
            presentValue += faceValue / Math.pow(1 + interestRateGuess, yearsToMaturity);
            
            if (price - presentValue < tolerance) {
                ytm = interestRateGuess;
                break;
            } else {
                interestRateGuess += 0.0001; // Increment the interest rate guess
            }
        }
        
        return ytm;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter bond price:");
        double price = scanner.nextDouble();
        
        System.out.println("Enter coupon rate:");
        double couponRate = scanner.nextDouble();
        
        System.out.println("Enter face value:");
        double faceValue = scanner.nextDouble();
        
        System.out.println("Enter years to maturity:");
        int yearsToMaturity = scanner.nextInt();
        
        double ytm = calculateYTM(price, couponRate, faceValue, yearsToMaturity);
        System.out.println("Yield to Maturity (YTM): " + ytm);
        
        scanner.close();
    }
}
