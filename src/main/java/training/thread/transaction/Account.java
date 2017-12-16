package training.thread.transaction;


public class Account {
    private int balance;

    /**
     * @param balance
     */
    public Account(int balance) {
        this.balance = balance;
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    private void setBalance(int balance) {

        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    /**
     * @param name
     * @param amt
     */
    public void deposit(String name, int amt) {

        System.out.println(name + " trying to deposit :" + amt);
        synchronized (this) {
            int bal = getBalance();
            System.out.println(name + " getting balance as " + bal);
            bal += amt;
            System.out.println(name + " setting balance to :" + bal);
            setBalance(bal);
        }
        System.out.println(name + " completes deposit");
    }

    /**
     * @param name
     * @param amt
     */
    public void withdraw(String name, int amt) {

        System.out.println(name + " trying to withdraw :" + amt);
        synchronized (this) {
            int bal = getBalance();
            System.out.println(name + " getting balance as " + bal);
            bal -= amt;
            System.out.println(name + " setting balance to :" + bal);
            setBalance(bal);
        }
        System.out.println(name + " completes withdraw");
    }
}


