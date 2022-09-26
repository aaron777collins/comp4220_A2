package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private InputStream inputStream;
    private Scanner scanner;

    public boolean calculating = true;

    public Calculator(InputStream inputStream) {
        this.inputStream = inputStream;
        this.scanner = new Scanner(inputStream);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator(System.in);
        calc.doCalculations();

    }

    // Asks the user for the input operation and then runs the proper functions and prints a result. It will keep running until they exit.
    public void doCalculations() {

        while(calculating) {
            System.out.println("Please enter an input operation from one of the following options or 'e' to exit:");
            System.out.println("'a' - Add");
            System.out.println("'s' - Subtract");
            System.out.println("'m' - Multiply");
            System.out.println("'d' - Divide");
            System.out.println("'sqrt' - Square Root");
            System.out.println("'sq' - Square");
            System.out.println("'c' - Cube");

            String res = scanner.next();

            try {
                String lowerRes = res.toLowerCase();
                if(lowerRes.equals("a")) {
                    Float[] inputs = get2Floats();
                    Float result = add(inputs[0], inputs[1]);
                    System.out.println(inputs[0].toString() + " + " + inputs[1] + " = " + result.toString());
                } else if (lowerRes.equals("s")) {
                    Float[] inputs = get2Floats();
                    Float result = subtract(inputs[0], inputs[1]);
                    System.out.println(inputs[0].toString() + " - " + inputs[1] + " = " + result.toString());
                } else if (lowerRes.equals("m")) {
                    Float[] inputs = get2Floats();
                    Float result = multiply(inputs[0], inputs[1]);
                    System.out.println(inputs[0].toString() + " * " + inputs[1] + " = " + result.toString());
                } else if (lowerRes.equals("d")) {
                    Float[] inputs = get2Floats();
                    Float result = divide(inputs[0], inputs[1]);
                    System.out.println(inputs[0].toString() + " / " + inputs[1] + " = " + result.toString());
                } else if (lowerRes.equals("sqrt")) {
                    Float input = get1FloatUndoable("");
                    Float result = sqrt(input);
                    System.out.println("sqrt(" + input.toString() + ") = " + result.toString());
                } else if (lowerRes.equals("sq")) {
                    Float input = get1FloatUndoable("");
                    Float result = square(input);
                    System.out.println("sq(" + input.toString() + ") = " + result.toString());
                } else if (lowerRes.equals("c")) {
                    Float input = get1FloatUndoable("");
                    Float result = cube(input);
                    System.out.println("cube(" + input.toString() + ") = " + result.toString());
                } else if (lowerRes.equals("e")) {
                    calculating = false;
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input! Going back to the main menu..");
            }

        }

    }

    public boolean shouldTryAgain(Float num) {
        System.out.println("You entered: " + num.toString() + ", would you like to try again? (y/N)");
        String res = scanner.next();
        return res.toLowerCase().contains("y");
    }

    // Returns an array of 2 floats from the user.
    // Scanner is a Scanner with the input stream
    public Float[] get2Floats() {
        Float[] result = new Float[2];

        result[0] = get1FloatUndoable("first");
        result[1] = get1FloatUndoable("second");

        return result;
    }

    // Gets a float but also asks if it's the right number.
    // Scanner is a Scanner with the input stream
    // numOrder is used in the prompt to specify the order of number. Ex. 'first'
    // when numOrder == "", no number order is used.
    public float get1FloatUndoable(String numOrder) {
        float res = -1;
        do {
            res = getFloat(numOrder);
        } while(shouldTryAgain(res));

        return res;
    }

    // Returns a float from the user
    // Takes the scanner and the numbers order. Ex. 'first'
    // when numOrder == "", no number order is used.
    public float getFloat(String numOrder) {
        if (numOrder.equals("")) {
            System.out.println("Please enter the number (float): ");
        } else {
            System.out.println("Please enter the " + numOrder + " number (float): ");
        }
        return scanner.nextFloat();
    }

    public float add(float a, float b) { return a+b; }
    public float subtract(float a, float b) { return a-b; }
    public float multiply(float a, float b) {
        return a*b;
    }
    public float divide(float a, float b) { return a/b; }
    public float sqrt(float a) { return (float)Math.sqrt(a); }
    public float square(float a) { return a*a; }
    public float cube(float a) { return a*a*a; }

}