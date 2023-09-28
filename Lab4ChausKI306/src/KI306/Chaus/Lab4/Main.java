package KI306.Chaus.Lab4;

class CalcException extends ArithmeticException {
    public CalcException() {}  // Constructor without a cause message
    public CalcException(String cause) {
        super(cause);  // Constructor with a cause message
    }
}

class NegativeNumberException extends Exception {
    public NegativeNumberException() {
        super("Exception reason: Negative number");
    }
}

class Equations {
    public double calculate(int x) throws CalcException, NegativeNumberException {
        if (x < 0) {
            throw new NegativeNumberException();
        }

        double y, rad;
        rad = x * Math.PI / 180.0;

        try {
            double denominator = x - Math.cos(2 * rad);
            if (denominator == 0) {
                throw new ArithmeticException();
            }

            y = Math.sin(rad - 9) / denominator;
            if (Double.isNaN(y) || Double.isInfinite(y)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            if (x == 0) {
                throw new CalcException("Exception reason: X = 0");
            } else {
                throw new CalcException("Exception reason: Division by zero");
            }
        }

        return y;
    }
}
