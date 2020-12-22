package expression;

import java.util.List;

public abstract class AbstractExpression implements CommunicantInterface {
    private final CommunicantInterface firstOperand, secondOperand;
    String operator;


    public AbstractExpression(CommunicantInterface firstOperand, CommunicantInterface secondOperand, String operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    abstract protected int calculateExpression(int a, int b);
    @Override
    public int evaluate(int x, int y, int z) {
        return calculateExpression(firstOperand.evaluate(x, y, z), secondOperand.evaluate(x, y, z));
    }

    @Override
    public int evaluate(int x) {
        return calculateExpression(firstOperand.evaluate(x), secondOperand.evaluate(x));
    }

    public String toString() {
        return "(" + firstOperand.toString() + " " + operator + " " + secondOperand.toString() + ")";
    }

    public boolean equals(Object checkOperand) {
        if (checkOperand == null || checkOperand.getClass() != this.getClass()) {
            return false;
        }
        AbstractExpression abstractExpression = (AbstractExpression) checkOperand;
        return this.firstOperand.equals(abstractExpression.firstOperand)
                && this.secondOperand.equals(abstractExpression.secondOperand);
    }

    @Override
    public int hashCode() {
        return ((31 * this.firstOperand.hashCode() + this.secondOperand.hashCode()) * 31 + getClass().hashCode()) * 31;
    }
}
