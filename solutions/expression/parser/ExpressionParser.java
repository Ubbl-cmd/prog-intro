package expression.parser;

import expression.*;
import expression.parser.BaseParser;
import expression.parser.CharSource;
import expression.parser.StringSource;


public class ExpressionParser {
    public static TripleExpression parse(final String source) {
        return parse(new StringSource(source));
    }

    public static TripleExpression parse(CharSource source) {
        return new ExpressionsParser(source).parseExpression();
    }

    private static class ExpressionsParser extends BaseParser {
        public ExpressionsParser(final CharSource source) {
            super(source);
            nextChar();
        }
        public TripleExpression parseExpression() {
            final TripleExpression result = parseOperation();
            if (eof()) {
                return result;
            }
            throw error("End of expression expected");
        }
private String operator;
        private CommunicantInterface parseOperation() {
            CommunicantInterface fin = parseValue();
            while (!operator.equals("\0")) {
                if (operator.equals("+")) {
                    fin = new Add(fin, parseValue());
                } else if (operator.equals("-")) {
                    fin = new Subtract(fin, parseValue());
                } else if (operator.equals("/")) {
                    fin = new Divide(fin, parseValue());
                }
                skipWhitespace();
                if (ch == ')') {
                    return fin;
                }
            }

            return fin;
        }

        private String parseOperator() {
            final String operator = String.valueOf(ch);
            nextChar();
            return operator;
        }

        public CommunicantInterface Pearse() {
            if (ch == '-' || Character.isDigit(ch)) {
                return parseConst();
            }
            return parseVariable();
        }

        CommunicantInterface temp;
        private CommunicantInterface parseValue() {

            skipWhitespace();
            boolean bracket = false;
            CommunicantInterface firstResult;
            if (ch == '(') {
                nextChar();
                skipWhitespace();
                firstResult = parseOperation();
                skipWhitespace();
                nextChar();
            } else {
                skipWhitespace();
                firstResult = Pearse();
                skipWhitespace();
            }
            if (ch == ')') {
                operator = "";
                skipWhitespace();
                return firstResult;
            }
            skipWhitespace();
            operator = parseOperator();
            skipWhitespace();
            if (operator.equals("\0")) {
                return firstResult;
            }
            skipWhitespace();
            if (operator.equals("*")) {
                return new Multiply(firstResult, parseValue());
            } else if (operator.equals("/")) {
                return new Divide(firstResult, parseValue());
            }
            skipWhitespace();
            return firstResult;
        }
        private Const parseConst() {
            final StringBuilder sb = new StringBuilder();
            skipWhitespace();
            if (test('-')) {
                sb.append('-');
            }
            skipWhitespace();
            while (between('0', '9')) {
                sb.append(ch);
                nextChar();
            }
            skipWhitespace();
            return new Const(Integer.parseInt(sb.toString()));
        }

        private Variable parseVariable() {
            final StringBuilder sb = new StringBuilder();
            skipWhitespace();
            do {
                sb.append(ch);
                nextChar();
            } while(Character.isAlphabetic(ch));
            skipWhitespace();
            return new Variable(sb.toString());
        }

        private void skipWhitespace() {
            while (test(' ') || test('\r') || test('\n') || test('\t')) {
                // skip
            }
        }
    }
}
// new Divide(new Divide(new Var(x), new Var(y)), new Var(z))