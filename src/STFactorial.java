import java.math.BigInteger;

public class STFactorial {
    // Method complexity O(n)
    // this method runs n times

    public static BigInteger factorial(BigInteger n)
    {
//        if(n.equals(BigInteger.ONE))
//            return BigInteger.ONE;
//
//        return n.multiply(factorial(n.subtract(BigInteger.ONE)));

        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;

    }

    public static void main(String[] args)
    {

        BigInteger number = BigInteger.valueOf(1000000);

        // start time
        long startTime = System.nanoTime();

        BigInteger result = STFactorial.factorial(number);



        // end time
        long stopTime = System.nanoTime();

        // elapsed time
        long elapsedTime = stopTime - startTime;
        System.out.println("Elapsed:" + elapsedTime);
        System.out.println("Result:" + result);
    }
}
