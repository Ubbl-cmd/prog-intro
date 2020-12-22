package expression;

import java.util.List;

public class Multiply extends AbstractExpression {
    public Multiply(CommunicantInterface exp1, CommunicantInterface exp2) {
        super(exp1, exp2, "*");
    }

    public int calculateExpression(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
