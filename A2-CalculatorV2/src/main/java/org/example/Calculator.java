package org.example;

import java.io.InputStream;
import java.util.Scanner;

public class Calculator {
    Scanner scanner;
    public boolean calculating = false;

    public Calculator(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public float multiply(float a, float b){
        return a*b;
    }

    public float add(float a, float b){return a+b;}

    public float subtract(float a, float b){return a-b;}

    public float divide(float a, float b){return a/b;}

    public float cube(float a){
        return a*a*a;
    }

    public float square(float a){
        return a*a;
    }

    public float sqrt(float a){
        return (float) Math.sqrt(a);
    }

    public float GetOperation(){
        float output = 0f;
        int numOfDigits;
        System.out.println("How many numbers would you like to compute?\nEnter 1 or 2...\n");

        numOfDigits = scanner.nextInt();
        while(numOfDigits != 1 && numOfDigits != 2){
            System.out.println("Sorry! That isn't a valid entry. Please enter 1 or 2.\n");
            numOfDigits = scanner.nextInt();
        }

        int selection;
        if(numOfDigits == 1){
            System.out.println("Here are the options for one number entry:");
            System.out.println("1: Square\n2: Cube\n3: Square Root");
            selection = scanner.nextInt();

            while(selection < 1 || selection > 3) {
                System.out.println("Sorry! That isn't a valid entry. Please enter 1, 2 or 3");
                selection = scanner.nextInt();
            }

            float inputA;

            switch(selection) {
                case 1:
                    System.out.println("Please enter a number to square: ");
                    inputA = TakeOneInput();
                    output = square(inputA);
                    PrintResult(output);
                    break;
                case 2:
                    System.out.println("Please enter a number to cube: ");
                    inputA = TakeOneInput();
                    output = cube(inputA);
                    PrintResult(output);
                    break;
                case 3:
                    System.out.println("Please enter a number to square root: ");
                    inputA = TakeOneInput();
                    output = sqrt(inputA);
                    PrintResult(output);
                    break;
                default:
                    break;
            }
        }else{
            System.out.println("Here are the options for two number entry:");
            System.out.println("1: Addition\n2: Subtraction\n3: Multiplication\n4: Division");
            selection = scanner.nextInt();

            while(selection < 1 || selection > 4){
                System.out.println("Sorry! That isn't a valid entry. Please enter 1, 2, 3 or 4");
                selection = scanner.nextInt();
            }

            System.out.println("Please enter the first number for your operation:");
            float inputs[] = TakeTwoInputs();
            float inputA = inputs[0];
            float inputB = inputs[1];

            switch(selection) {
                case 1:
                    output = add(inputA, inputB);
                    PrintResult(output);
                    break;
                case 2:
                    output = subtract(inputA, inputB);
                    PrintResult(output);
                    break;
                case 3:
                    output = multiply(inputA, inputB);
                    PrintResult(output);
                    break;
                case 4:
                    output = divide(inputA, inputB);
                    PrintResult(output);
                default:
                    break;
            }
        }
        return output;
    }

    public float TakeOneInput(){
        float inputA;
        do {
            inputA = scanner.nextFloat();
        } while(shouldAskAgain(inputA));
        return inputA;
    }

    public float[] TakeTwoInputs(){

        float inputA;
        do {
            inputA = scanner.nextFloat();
        } while(shouldAskAgain(inputA));
        System.out.println("Please enter the second number:");
        float inputB;
        do {
            inputB = scanner.nextFloat();
        } while(shouldAskAgain(inputB));
        float[] inputs = {inputA, inputB};
        return inputs;
    }

    public boolean shouldAskAgain(Float num) {
        System.out.println("You entered: " + num.toString() + ", would you like to enter a new number? (y/N)");
        String res = scanner.next();
        return res.toLowerCase().contains("y");
    }

    public int RunCalculator(){
        int option;
        System.out.println("Please enter selection:\n1: Get Operation List\n2: Quit");
        option = scanner.nextInt();

        while(option != 2 && option != 1){
            System.out.println("Sorry you have entered an invalid option. Please select 1 or 2.");
            System.out.println(option);
            option = scanner.nextInt();
        }

        if(option == 1){
            GetOperation();
            return 1;
        }else{
            calculating = false;
            return 0;
        }
    }

    public void doCalculations() {
        calculating = true;
        do {
            RunCalculator();
        } while(calculating);
    }

    public static void PrintResult(float output){
        System.out.println("The result is " + output + "\n\n");
    }

    public static void main(String args[]){
        Calculator calculator = new Calculator(System.in);
        calculator.doCalculations();
        System.out.println("Thanks for using this calculator!...");
        System.out.println("Bye.");
    }
}
