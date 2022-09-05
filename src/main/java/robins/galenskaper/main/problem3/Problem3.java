package robins.galenskaper.main.problem3;

import static robins.galenskaper.main.DoMath.doMath;

public class Problem3 {

    public static double calculator(String input){
        if(!StringChecker.regexValidator(input)){
            System.out.println("Please enter a valid string");
            return 0;
        }

        double num1 = 0;
        double num2;
        String operator = "";

        StringBuilder buffer = new StringBuilder("0");

        //Problem 3 only has 1 operator, so it doesn't take a lot of extra logic
        //Two numbers, one operator, that's it
        for (char c : input.toCharArray()) {

            //If the character is a number, we can add it to the string builder used to build the numbers
            if(Character.isDigit(c)){
                buffer.append(c);
            }
            //IF there is whitespace, we'll simply skip it and go to the next character in the string
            else if(Character.isWhitespace(c)){
                continue;
            }
            //Since regex has already been used to filter out everything other than whitespaces
            //We KNOW that the only remaining possibilities are /*-+
            else{
                //Parsing the buffer to a double and assigning it to the first num variable
                //Since we only get to this point when there is an operator, we assign the operator with current char
                num1 = Double.parseDouble(buffer.toString());
                operator = Character.toString(c);

                //Resetting the buffer so that the next number isn't an amalgamation of both
                buffer.setLength(0);
            }
        }
        //Out of the loop? Great, then we know the last number has finished
        //Send that right into the other num variable
        num2 = Double.parseDouble(buffer.toString());
        //Now all that's left is to do the math, and to print the result
        double result = doMath(operator, num1, num2);
        System.out.println("The result is: " + result);

        return result;
    }
}
