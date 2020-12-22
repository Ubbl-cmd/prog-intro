package expression;

public class Const implements CommunicantInterface {
    int i;
    public Const(int i) {
        this.i = i;
    }
    @Override
    public int evaluate(int x) {
        return this.i;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return this.i;
    }

    public String toString() {
        return Integer.toString(this.i);
    }


    public boolean equals(Object checkOperand) {
        if (checkOperand == null || checkOperand.getClass() != Const.class) {
            return false;
        }
        return this.toString().equals(checkOperand.toString());
    }

    @Override
    public int hashCode() {
        return this.i;
    }
}
