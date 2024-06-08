package unsync;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) {
        try {
            while (accounts[from] < amount) {
                wait();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.printf(" %10.2f from %d to %d, res = %s", amount, from, to, accounts[to]);
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a: accounts) {
            sum += a;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
