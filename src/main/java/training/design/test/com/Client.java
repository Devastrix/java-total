package training.design.test.com;

import training.design.test.exception.CustomException;
import training.design.test.exception.InvalidAmountException;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidAmountException {
        for (; ; ) {
            System.out.println("------------Main Menu-------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance inquiry.");
            System.out.println("4. Create an Account");
            System.out.println("5. Transfer funds between two accounts");

            System.out.println("\n\n\nPlease choose an option [1, 2, 3, 4, 5]:");
            Scanner sc = new Scanner(System.in);
            int option;
            try {
                 option = sc.nextInt();
            }catch (Exception e){
                throw new InvalidAmountException("Option should be one of [1, 2, 3, 4, 5] only.");
            }
            if(option>5 || option<1){
                throw new InvalidAmountException("Option should be one of [1, 2, 3, 4, 5] only.");
            }
            int accNo = 0;
            float amt = 0;
            AccountDao opr = new AccountDaoImpl();
            switch (option) {
                case 1:
                    System.out.println("Enter Account No.");
                    accNo = getIntNumber(sc);
                    System.out.println("Enter Amount ");
                    amt = getFloatNumber(sc);

                    try {
                        opr.deposit(accNo, amt);
                    } catch (CustomException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter Account No.");
                    accNo = getIntNumber(sc);
                    System.out.println("Enter Amount ");
                    amt = getFloatNumber(sc);

                    try {
                        opr.withdraw(accNo, amt);
                    } catch (CustomException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter Account No.");
                    accNo = getIntNumber(sc);

                    try {
                        System.out.println("balance is="
                                + opr.balanceEnquiry(accNo));
                    } catch (CustomException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter Account No.");
                    accNo = getIntNumber(sc);

                    System.out.println("Enter Amount ");
                    amt = getFloatNumber(sc);

                    System.out.println("Enter Name ");
                    String name = sc.next();

                    try {
                        opr.createAccount(accNo, amt, name);
                    } catch (CustomException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter Source Account No.");
                    accNo = getIntNumber(sc);

                    System.out.println("Enter Source Account No.");
                    int desAccNo = getIntNumber(sc);

                    System.out.println("Enter Amount ");
                    amt = getFloatNumber(sc);

                    try {
                        opr.fundTransfer(accNo, desAccNo, amt);
                    } catch (CustomException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Enter Valid option");
            }
        }
    }
    private static int getIntNumber(Scanner sc) throws InvalidAmountException {
        int num;
        try {
            num = (int) sc.nextInt();
        }catch (Exception e){
            throw new InvalidAmountException("Input should be an Integer number only.");
        }
        return num;
    }

    private static float getFloatNumber(Scanner sc) throws InvalidAmountException {
        float num;
        try {
            num = sc.nextFloat();
        }catch (Exception e){
            throw new InvalidAmountException("Input should be an Integer number only.");
        }
        return num;
    }
}
