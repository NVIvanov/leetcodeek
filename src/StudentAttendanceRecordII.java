import java.math.BigInteger;

public class StudentAttendanceRecordII {

    public static BigInteger mod = BigInteger.valueOf(1_000_000_007);

    private static final int MOD = 1000000007;

    public static int checkRecord(int n) {
        if (n == 0) return 1;
        if (n == 1) return 3;

        // f(n) array to store results for sequences without 'A'
        long[] f = new long[n + 1];
        f[0] = 1; // Empty sequence
        f[1] = 2; // "P", "L"
        if (n > 1) f[2] = 4; // "PP", "PL", "LP", "LL"

        // Fill f array for sequences without 'A'
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % MOD;
        }

        // Calculate total sequences
        long result = f[n]; // Sequences without 'A'

        // Add sequences with one 'A'
        for (int i = 1; i <= n; i++) {
            result = (result + (f[i - 1] * f[n - i]) % MOD) % MOD;
        }

        return (int) result;
    }

    public static BigInteger countAbsenceSeq(int n) {
        if (n <= 0) {
            return BigInteger.ZERO;
        }
        return BigInteger.valueOf(n - 1).modPow(BigInteger.TWO.pow(n), mod);
    }

    public static BigInteger binomialCoefficient(int N, int k) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            result = result.multiply(BigInteger.valueOf(N - (i - 1)))
                    .divide(BigInteger.valueOf(i));
        }
        return result;
    }

    // Method to calculate the number of valid sequences
    public static BigInteger countSequencesWithL(int N) {
        BigInteger totalSequences = BigInteger.ZERO;
        for (int k = 3; k <= N; k++) {
            BigInteger binomCoeff = binomialCoefficient(N, k);
            BigInteger remainingCombinations = BigInteger.valueOf(2).pow(N - k);
            totalSequences = totalSequences.add(binomCoeff.multiply(remainingCombinations));
        }
        return totalSequences.mod(mod).subtract(countAbsenceSeq(N - 3));
    }



    public static void main(String[] args) {
        System.out.println(checkRecord(10101));
    }
}
