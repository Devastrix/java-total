package training.design.test.com;

import training.design.test.exception.AccountTransactionException;
import training.design.test.exception.CustomException;
import training.design.test.exception.InsufficientBalanceException;
import training.design.test.exception.InvalidAmountException;

public class AccountDaoImpl implements AccountDao {
    static int size=10;
    static float totalAmount[][] = new float[size][2];
    static {
        for(int i=0;i<size;i++){
            for(int j=0;j<2;j++) {
                totalAmount[i][j]=0;
            }
        }
    }
    public void deposit(int accNo, float amt) throws CustomException {

        if (amt <= 0)
            throw new InvalidAmountException("Depositing amount should be greater than Zero");
        int accNumber;
        for (accNumber = 0; accNumber < size; accNumber++) {
            if (totalAmount[accNumber][0] == accNo) {
                totalAmount[accNumber][1] += amt;
            } else if (totalAmount[accNumber][0] == 0) {
                System.out.println("No account found, please create one acc with acc number: " + accNo);
//                totalAmount[accNumber][1] = amt;
//                totalAmount[accNumber][0] = accNo;
                return;
            }
        }
        System.out.println("amount saved for " + accNo);

    }

    public float withdraw(int accNo, float amt) throws CustomException {
        if (amt <= 0)
            throw new InvalidAmountException("Withdrawing amount should be greater than Zero");

        for (int accNumber= 0; accNumber< size; accNumber++) {
            if (totalAmount[accNumber][0] == accNo) {
                if (totalAmount[accNumber][1] <= 0)
                    throw new InsufficientBalanceException("Insufficient Balance to Withdraw");
                else if (totalAmount[accNumber][1] <= amt)
                    throw new InsufficientBalanceException("Insufficient Balance to Withdraw");
                else
                    totalAmount[accNumber][1] -= amt;
            }
        }
        System.out.println(amt + " amount withdrawn from acount No :" + accNo);
        return amt;
    }

    public float balanceEnquiry(int accNo) throws CustomException {
        float result = 0;
        for (int accNumber= 0; accNumber< size; accNumber++) {
            if (totalAmount[accNumber][0] == accNo) {
                result = totalAmount[accNumber][1];
                return result;
            }
        }
        System.out.println("No such account exists");
        return 0;
    }

    public void createAccount(int accNo, float amt, String name) {
        for (int accNumber= 0; accNumber< size; accNumber++) {
            if (totalAmount[accNumber][0] == 0) {
                totalAmount[accNumber][0] = accNo;
                totalAmount[accNumber][1] = amt;
                System.out.println("account created successfully");
            }
        }
        System.out.println("Bank system is full, no more accounts can be added. Apologies!");

    }

    public void fundTransfer(int fromAccNo, int toAccNo, float amt) throws AccountTransactionException {
        for (int accNumber= 0; accNumber< size; accNumber++) {
            if (totalAmount[accNumber][0] == fromAccNo) {
                for (int j = 0; j < size; j++) {
                    if (totalAmount[j][0] == toAccNo) {
                        if (amt <= 0)
                            throw new AccountTransactionException("Transfer Amount should be greater than Zero");
                        else if (totalAmount[accNumber][1] <= 0)
                            throw new AccountTransactionException("Insufficient Balance to Withdraw from Source Account No.");
                        else {
                            totalAmount[accNumber][1] -= amt;
                            totalAmount[j][1] += amt;
                            System.out.println("Successfully transferred");
                            return;
                        }
                    }
                }
                System.out.println("No account " + toAccNo+ " is found");
            }
        }
        System.out.println("Something is wrong.. please try again.");
    }
}
