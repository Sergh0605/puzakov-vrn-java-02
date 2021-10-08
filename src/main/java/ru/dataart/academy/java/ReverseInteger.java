package ru.dataart.academy.java;

public class ReverseInteger {
    /**
     * @param inputNumber - any integer value
     * @return - inputNumber in reversed order
     * Example: 1234 -> 4321
     * -23 -> -32
     * 120 -> 12
     * -2,147,483,648 -> exception, error message
     */

    public int reverse(int inputNumber) {
        boolean negative = false;
        // Special cases check
        if (inputNumber < 10 && inputNumber > -10) return inputNumber;

        // main calculations
        if (inputNumber < 0) {
            negative = true;
            inputNumber *= -1;
        }
        char[] charsOfInputNumber = String.valueOf(inputNumber).toCharArray();
        for (int i = 0; i <= charsOfInputNumber.length - 1 - i; i++) {
            char tmp;
            tmp = charsOfInputNumber[i];
            charsOfInputNumber[i] = charsOfInputNumber[charsOfInputNumber.length - 1 - i];
            charsOfInputNumber[charsOfInputNumber.length - 1 - i] = tmp;
        }
        int outputValue = Integer.parseInt(String.valueOf(charsOfInputNumber));
        if (negative) return outputValue *= -1;
        else return outputValue;
    }
}
