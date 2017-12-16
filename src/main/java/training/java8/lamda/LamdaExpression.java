package training.java8.lamda;

import java.util.Comparator;

public class LamdaExpression {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello World");

        Comparator t = (Object a, Object b) -> {System.out.println("Have fun in java8"); return 1;};


        SAMdemo s = new SAMdemo() {
            @Override
            public void print() {

            }
        };
        s.print();
        s.somePrint();

        carryOutWork(new SAMdemo() {
            @Override
            public void print() {
                System.out.println("from the traditional stuff");
            }
        });
        carryOutWork(() -> System.out.println("the lamda way"));

    }

    public static void carryOutWork(SAMdemo s){
        s.print();
        s.somePrint();
    }
}
