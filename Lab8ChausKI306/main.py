import math  # Import the math module for mathematical operations

class CalcException(Exception):
    def __init__(self, cause=None):
        super().__init__(cause)  # Initialize the CalcException with an optional cause message

class Equations:
    def calculate(self, x):
        y = 0  # Initialize variable y

        rad = x * 3.14159 / 180.0  # Convert the angle x to radians

        try:
            denominator = x - math.cos(2 * rad)  # Calculate the denominator of the expression
            if denominator == 0:
                raise ArithmeticError()  # Raise an exception if the denominator is zero

            y = math.sin(rad - 9) / denominator  # Calculate the value of y
            if math.isnan(y) or math.isinf(y):
                raise ArithmeticError()  # Raise an exception if y is NaN (Not a Number) or Infinite

        except ArithmeticError:
            if x == 0:
                raise CalcException("Exception reason: X = 0")  # Raise a CalcException with a specific message for x = 0
            else:
                raise CalcException("Exception reason: Division by zero")  # Raise a CalcException with a specific message for division by zero

        return y  # Return the calculated value of y
