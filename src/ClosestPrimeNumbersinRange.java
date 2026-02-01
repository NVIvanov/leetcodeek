import java.util.Arrays;

public class ClosestPrimeNumbersinRange {

    static class Solution {
        public int[] closestPrimes(int left, int right) {
            int[] primes = new int[]{-1, -1};
            int minDiff = Integer.MAX_VALUE;
            int prevPrime = -1;

            // Sieve of Eratosthenes to find all primes in the range [left, right]
            boolean[] isPrimeArr = new boolean[right + 1];
            Arrays.fill(isPrimeArr, true);
            isPrimeArr[0] = isPrimeArr[1] = false;
            for (int p = 2; p * p <= right; p++) {
                if (isPrimeArr[p]) {
                    for (int i = p * p; i <= right; i += p) {
                        isPrimeArr[i] = false;
                    }
                }
            }

            // Iterate through the range and find the closest prime numbers
            for (int i = left; i <= right; i++) {
                if (isPrimeArr[i]) {
                    if (prevPrime != -1) {
                        int diff = i - prevPrime;
                            if (diff < minDiff) {
                                minDiff = diff;
                            primes[0] = prevPrime;
                            primes[1] = i;
                            }
                        }
                    prevPrime = i;
                }
            }

            return primes;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world");    
    }
}
