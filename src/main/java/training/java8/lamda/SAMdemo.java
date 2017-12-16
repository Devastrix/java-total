package training.java8.lamda;

@FunctionalInterface
public interface SAMdemo {

    void print();

    default void somePrint(){
        System.out.println("somePrint working");
    }
}
