
import java.math.BigInteger;

public class Factorial implements Runnable{

    // higher number
    public long startNumber;

    // lower number
    public long endNumber;

    // end result
    public BigInteger result = BigInteger.ONE;


    // ex: Factorial from 5...1
    public Factorial(long start, long end)
    {
        startNumber = start;
        endNumber = end;
    }

    // Method complexity O(n)
    // this method runs n times
    public BigInteger factorial(long n)
    {
//        if(n == endNumber )
//            return BigInteger.valueOf((endNumber));
//
//        return BigInteger.valueOf(n).multiply(factorial(n - 1));


        BigInteger result = BigInteger.ONE;

        while (n != endNumber - 1) {
            result = result.multiply(new BigInteger(n + ""));
            n = n - 1;
        }

        return result;
    }

    @Override
    public void run() {
        result = factorial(startNumber);
        //result = result.multiply(res);
    }


    public static void main(String [] args) throws InterruptedException
    {
        // assign the number to calculate factorial for
        //Factorial.number = 25;

        long number = 1000000;

        Thread [] threadPool = new Thread[2];
        Factorial [] factPool = new Factorial[threadPool.length];

        BigInteger result = new BigInteger(1 + "");

        // start time
        long startTime = System.nanoTime();


        for(int i = 0; i < threadPool.length; i++)
        {
            factPool[i] = new Factorial(i == threadPool.length - 1 ? number :  ((number / threadPool.length) * (i + 1)), (number / threadPool.length) *  i + 1);
            threadPool[i] = new Thread(factPool[i]);
            threadPool[i].start();
        }

        for(int i =0; i <threadPool.length; i++)
        {
            threadPool[i].join();
        }



        for(int i = 0; i < threadPool.length; i ++)
        {
            result = result.multiply(factPool[i].result);
        }


        // end time
        long stopTime = System.nanoTime();

        // elapsed time
        long elapsedTime = stopTime - startTime;
        System.out.println("Elapsed:" + elapsedTime);
        System.out.println("Result:" + result);


    }
}
