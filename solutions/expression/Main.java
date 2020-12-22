package expression;

public class Main {
    public static void main(String[] args) {
        System.out.print(
                new Add(new Variable("x"), new Variable("x")).toString().equals("(x + x)")
        );
    }
}
