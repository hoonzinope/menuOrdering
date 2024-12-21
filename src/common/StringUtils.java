package common;

import java.util.Random;

public class StringUtils {

    public static String getRandomString(int strLength) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        // a = 97 / A = 65;
        for(int i = 0; i < strLength; i++){
            int UL = random.nextInt(3);
            if(UL == 1) UL = 97;
            else if(UL == 2)UL = 65;
            else UL = 0;

            int r = random.nextInt(26);
            int n = random.nextInt(10);
            if(UL == 0)
                stringBuilder.append(UL+n);
            else
                stringBuilder.append((char)(UL+r));
        }
        return stringBuilder.toString();
    }

    public static boolean isNumeric(String strNum) {
        try {
            int num = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
