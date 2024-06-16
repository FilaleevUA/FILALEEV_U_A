public class model {
    private String[] strings;
    private int pos;

    public model(String line) {
        this.strings = line.split(" ");
        this.pos = 0;
    }

    public double calculate() {
        double first = multiply();
        while (pos < strings.length) {
            String s = strings[pos];
            if (!s.equals("+") && !s.equals("-")) {
                break;
            } else {
                pos++;
            }
            double second = multiply();
            if (s.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    private double multiply() {
        double first = factor();
        while (pos < strings.length) {
            String s = strings[pos];
            if (!s.equals("*") && !s.equals("/") && !s.equals("//") && !s.equals("^")) {
                break;
            } else {
                pos++;
            }
            double second = factor();
            if (s.equals("*")) {
                first *= second;
            } else if (s.equals("/")) {
                first /= second;
            } else if (s.equals("//")) {
                first %= second;
            } else if (s.equals("^")) {
                first = Math.pow(first, second);
            }
        }
        return first;
    }

    private double factor() {
        String next = strings[pos];
        if (next.equals("(")) {
            pos++;
            double result = calculate();
            String closingBracket;
            if (pos < strings.length) {
                closingBracket = strings[pos];
            } else {
                throw new IllegalArgumentException("Error");
            }
            if (closingBracket.equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalArgumentException("')' Error");
        } else  {
            pos++;
            return Double.parseDouble(next);
        }
    }
}
