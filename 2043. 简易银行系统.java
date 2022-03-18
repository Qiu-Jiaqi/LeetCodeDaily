package LeetCodeDaily;

/*
思路：过于简单，注意判断就好
*/
class Bank {

    private long[] balance;
    private int len;

    public Bank(long[] balance) {
        this.balance = balance;
        this.len = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 1 || account2 < 1 || account1 > len || account2 > len || balance[account1 - 1] < money) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account < 1 || account > len) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account < 1 || account > len || balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}
