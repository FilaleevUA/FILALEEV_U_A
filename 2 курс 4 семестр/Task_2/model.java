public class model {
    private String[] strings;
    private int anInt;

    public model(String line) {
        this.strings = line.split(" ");
        this.anInt = 0;
    }

    public double calculate() {
        double first = multiply();
        while (anInt < strings.length) {
            String operator = strings[anInt];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                anInt++;
            }
            double second = multiply();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    private double multiply() {
        double first = factor();
        while (anInt < strings.length) {
            String operator = strings[anInt];
            if (!operator.equals("*") && !operator.equals("/") && !operator.equals("//") && !operator.equals("^") && !operator.equals("**")) {
                break;
            } else {
                anInt++;
            }
            double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else if (operator.equals("/")) {
                first /= second;
            } else if (operator.equals("//")) {
                first %= second;
            } else if (operator.equals("^") || operator.equals("**")) {
                first = Math.pow(first, second);
            }
        }
        return first;
    }

    private double factor() {
        String next = strings[anInt];
        if (next.equals("(")) {
            anInt++;
            double result = calculate();
            String closingBracket;
            if (anInt < strings.length) {
                closingBracket = strings[anInt];
            } else {
                throw new IllegalArgumentException("Error");
            }
            if (closingBracket.equals(")")) {
                anInt++;
                return result;
            }
            throw new IllegalArgumentException("')' Error");
        } else if (next.equals("log")) {
            anInt++;
            double argument = factor();
            return Math.log(argument)/Math.log(2);
        } else if (next.equals("exp")) {
            anInt++;
            double argument = factor();
            return Math.exp(argument);
        } else if (next.equals("!")) {
            anInt++;
            double argument = factor();
            return factorial((int) argument);
        } else {
            anInt++;
            return Double.parseDouble(next);
        }
    }

    private double factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative argument");
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
