package robins.galenskaper.main.problem4;

import java.util.ArrayList;
import java.util.List;

import static robins.galenskaper.main.DoMath.doMath;

public class Problem4 {

    public static double calculator(String input){
        if(!StringChecker.regexValidator(input)){
            System.out.println("Please enter a valid string");
            return 0;
        }

        List<Double> nums = new ArrayList<>();
        String operator = null;
        boolean moreThanOneOperator = false;

        double result = 0;
        StringBuilder buffer = new StringBuilder("0");

        //In problem 4 there is no need to check for which operators take priority over the others
        //So it's possible to just do the math as we are reading the string, just with some added logic
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
                //Parsing the buffer to a double and adding it to a list
                double tempNum = Double.parseDouble(buffer.toString());
                nums.add(tempNum);

                //Resetting the buffer so that the next number isn't an amalgamation of both
                buffer.setLength(0);

                //If there has already been a calculation, this bool will be true, this is to prevent operation skips
                if(moreThanOneOperator){
                    result = doMath(operator, result, nums.get(0));
                    nums.remove(0);
                }
                //At this point the above bool is false, so we wait until we have 2 numbers in the list
                if(nums.size() == 2){
                    //Setting the bool to true for future reference
                    moreThanOneOperator = true;

                    //Just calling the math method and inputting the correct arguments
                    result += doMath(operator, nums.get(0), nums.get(1));

                    //Clearing the list of nums so that we don't accidentally reuse nums
                    nums.remove(0);
                    nums.remove(0);
                }

                //This happens last so that the incorrect operator is not used.
                //Because of logic defined above, this will have triggered once before any calculations happen
                operator = Character.toString(c);
            }
        }

        //Since the for loop breaks when we run out of characters, no more math will be done inside the loop
        //Therefore to have the last number be calculated into the final sum, some more logic is here
        //The buffer.isempty check is so that this doesn't happen when there was just one operand in the original string
        if(!moreThanOneOperator){
            double tempNum = Double.parseDouble(buffer.toString());
            nums.add(tempNum);
            result += doMath(operator, nums.get(0), nums.get(1));

            buffer.setLength(0);
        }
        if(!buffer.isEmpty()){
            double tempNum = Double.parseDouble(buffer.toString());
            result = doMath(operator, result, tempNum);
        }
        
        System.out.println(result);
        return result;
    }

}
