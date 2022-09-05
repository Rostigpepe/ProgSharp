package robins.galenskaper.main.problem5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringChecker {

    protected static boolean regexValidator(String string){
        //Regex to confirm that a string is valid to be calculator input
        //        1. Can start with +-, but doesn't have to
        //        2. Must be numbers, 1 to infinite

        //        3. Has to be /*-+
        //        4. Can be +- again
        //        5. Must be numbers, 1 to infinite
        //        6. Repeat 3, 4, 5 until the string ends

        final String regex = "^\\s*([-+]?)(\\d+)(?:\\s*([-+*/])\\s*((?:\\s*[-+])?\\d+)\\s*)+$";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }

}
