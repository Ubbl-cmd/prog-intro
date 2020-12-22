package expression;

import java.util.List;

public class Divide extends AbstractExpression{
    public Divide(CommunicantInterface exp1, CommunicantInterface exp2) {
        super(exp1, exp2, "/");
    }

    public int calculateExpression(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}


