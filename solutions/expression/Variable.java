package expression;

public class Variable implements CommunicantInterface {
    String s;
    public Variable(String s) {
        this.s = s;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (this.s.equals("x")) {
            return x;
        }
        if (this.s.equals("y")) {
            return y;
        }
        return z;
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    public String toString() {
        return s;
    }


    @Override
    public boolean equals(Object checkOperand) {
        if (checkOperand == null || checkOperand.getClass() != Variable.class) {
            return false;
        }
        return this.s.equals(checkOperand.toString());
    }

    public int hashCode() {
        return this.s.hashCode();
    }
}
