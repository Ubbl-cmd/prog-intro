package expression;

public class Add extends AbstractExpression{
    public Add(CommunicantInterface exp1, CommunicantInterface exp2) {
        super(exp1, exp2, "+");
    }

    public int calculateExpression(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
