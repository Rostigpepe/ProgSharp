package robins.galenskaper.main;

public class DoMath {

    public static double doMath(String operator, double num1, double num2){
        switch (operator){
            case "/" -> {
                return num1 / num2;
            }
            case "*" ->{
                return num1 * num2;
            }
            case "-" ->{
                return num1 - num2;
            }
            case "+" ->{
                return num1 + num2;
            }
            default -> {
                System.out.println("Something broke :')");
                return 0;
            }
        }
    }

}
