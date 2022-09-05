package robins.galenskaper.main.problem5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static robins.galenskaper.main.DoMath.doMath;

public class Problem5 {

    public static double calculator(String input){
        //If the string does not match the regex, returns immediately
        if(!StringChecker.regexValidator(input)){
            System.out.println("Please enter a valid string");
            return 0;
        }

        //Getting the input as two separate lists
        List<List<String>> convertedLists = convertToLists(input);

        //Getting and further converting the two lists into more specific ones
        List<String> op = convertedLists.get(0);
        List<Double> num = convertToIntList(convertedLists.get(1));

        double result = calculate(op, num);
        System.out.println("Result is: " + result);
        return result;
    }

    private static List<List<String>> convertToLists(String input){

        //Creating lists of all operators and operands
        List<String> operators = new ArrayList<>(Arrays.asList(input.split("[0-9]+"))) ;
        List<String> operands = new ArrayList<>(Arrays.asList(input.split("[-+*/]")));

        //For some reason, empty spaces has a tendency to appear in the lists
        //Since I don't know why and don't have time to fix it for now, this is my best solution
        operators.removeAll(Arrays.asList("", null));
        operands.removeAll(Arrays.asList("", null));

        if(operands.size() == operators.size()){
            //Because of how I split everything, if the first operand is ex -100, it'll get split to the different lists
            //To combat this I'll simply check if the lists are the same size (which they shouldn't be)
            //Remove first from operators, and replacing the first operand with the operator appended
            String toReplace = operators.get(0) + operands.get(0);
            operators.remove(0);
            operands.set(0, toReplace);
        }

        //Trimming away any potential spaces next to operators
        for (int i = 0; i < operators.size(); i++) {
            operators.set(i, operators.get(i).trim());
        }

        //In case someone wants to calculate ex 123+-123, we currently have 123, 123 in one list, and +- in the other
        //To fix this, I'll check if operator elements are larger than 1, if that's the case
        //Remove the second part from operator, and append it to the front of the upcoming operand
        for (int i = 0; i < operators.size(); i++) {
            if(operators.get(i).length() > 1){
                String toAppend = operators.get(i).substring(1);

                operands.set(i+1, toAppend + operands.get(i+1));
                operators.set(i, operators.get(i).substring(0,1));
            }
        }

        //Just making the nested list and adding the lists to the list of lists, so we can return the list of lists with the lists
        List<List<String>> listOfLists = new ArrayList<>();
        listOfLists.add(operators);
        listOfLists.add(operands);

        return listOfLists;
    }

    private static List<Double> convertToIntList(List<String> stringList){
        return stringList.stream()
                //Trimming away any potential spaces next to operands
                .map(String::trim)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    private static double calculate (List<String> op, List<Double> num){
        int opIndex;

        int size = op.size();
        //For every operator in the operator list, one calculation should happen
        for (int i = 0; i < size; i++){
            //Get the largest operator
            String largest = findLargestOperator(op);


            //Get the index of the largest operator, if there are multiple, it does not matter which one
            opIndex = op.indexOf(largest);

            //Get the numbers neighbouring the operator
            double num1 = num.get(opIndex);
            double num2 = num.get(opIndex + 1);

            //Do the math between the operands and operator
            double result = doMath(largest, num1, num2);

            //Remove operator, operand after operator, and replace the operand before the operator
            //Effectively removing the 3 lil things and replacing it with the result
            num.remove(opIndex + 1);
            num.set(opIndex, result);
            op.remove(opIndex);
        }
        //Return the only remaining operand
        return num.get(0);
    }

    private static String findLargestOperator(List<String> op){
        // Division and multiplication is valued the same by pamudas, so in an equation it simply goes from left to right
        //Therefore I try and find the one with the lowest index
        if(op.contains("/") || op.contains("*")){
            int indexDiv;
            int indexMult;
            indexDiv = op.indexOf("/");
            indexMult = op.indexOf("*");

            //In case it doesn't exist in the list, the indexof Automatically becomes -1, so we return the other
            if(indexDiv == -1){
                return "*";
            }
            if(indexMult == -1){
                return "/";
            }

            //If none is -1, we just return the one with the lowest index
            if(indexDiv < indexMult){
                return "/";
            }
            return "*";
        }
        //Refer to comments above
        else{
            int indexSub;
            int indexAdd;
            indexSub = op.indexOf("-");
            indexAdd = op.indexOf("+");

            if(indexSub == -1){
                return "+";
            }
            if(indexAdd == -1){
                return "-";
            }

            if(indexSub < indexAdd){
                return "-";
            }
            return "+";
        }
    }

}
