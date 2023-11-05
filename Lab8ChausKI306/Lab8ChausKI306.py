import os
import math


class CalcException(Exception):
    pass

class Equations:
    def calculate(self, x):
        y = 0
        rad = x * 3.14159 / 180.0

        try:
            denominator = x - math.cos(2 * rad)
            if denominator == 0:
                raise ArithmeticError()

            y = math.sin(rad - 9) / denominator
            if math.isnan(y) or math.isinf(y):
                raise ArithmeticError()

        except ArithmeticError:
            if x == 0:
                raise CalcException("Exception reason: X = 0")
            else:
                raise CalcException("Exception reason: Division by zero")

        return y

def main():
    fName = "Result.txt"
    out_file_bin = "Out_binary.dat"

    try:
        eq = Equations()

        x = int(input("Enter X: "))

        try:
            result = eq.calculate(x)
            print(f"Result: {result}")

            with open(fName, 'w') as fout:
                fout.write(f"Result: {result}\n")

            with open(out_file_bin, 'wb') as fout_bin:
                fout_bin.write(f"Result {result}\n".encode())

        except CalcException as ex:
            print(ex)

    except FileNotFoundError:
        print("Exception reason: File not found")

    # Reading from files
    try:
        with open(fName, 'r') as fin, open(out_file_bin, 'rb') as fin_bin:
            resultText = fin.readline()
            binaryResult = fin_bin.readline().decode()

            print(f"Result from Result.txt: {resultText}", end="")
            print(f"Result from Out_binary.dat: {binaryResult}", end="")

    except FileNotFoundError:
        print("Exception reason: File not found")
    except IOError:
        print("Exception while reading the file")

if __name__ == "__main__":
    main()
