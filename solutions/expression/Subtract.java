package expression;

import java.util.List;

public class Subtract extends AbstractExpression{
    public Subtract(CommunicantInterface exp1, CommunicantInterface exp2) {
        super(exp1, exp2, "-");
    }

    public int calculateExpression(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}

