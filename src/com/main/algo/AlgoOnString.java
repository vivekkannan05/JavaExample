package com.main.algo;

import org.junit.platform.commons.util.StringUtils;

public class AlgoOnString {
    public static void main(String[] args) {

        System.out.println(""" 
            =====================================================================================================================
                    Is the input String Uppeeercasee. Example for All match or None match
            #####################################################################################################################
            """);

        System.out.println("HI".chars().allMatch(Character::isUpperCase));
        System.out.println("hi".chars().allMatch(Character::isLowerCase));

        System.out.println(""" 
            =====================================================================================================================
                  Validate A String with complex or multiple validation  
            #############################®########################################################################################
            """);

        String str = "Hello2U";
        System.out.println(str.chars().anyMatch(Character::isUpperCase)
            && str.chars().anyMatch(Character::isLowerCase)
            && str.chars().anyMatch((Character::isDigit)));

        System.out.println(""" 
            =====================================================================================================================
                    Custom Parsing to search
            #####################################################################################################################
            """);
            str="Hello";
            boolean resultB = false;
            if(str==null)
                resultB=false;
            else {
                for (int i = 0; i < str.length()/2 +1; i = i + 2) {
                if(str.charAt(i) == 'L') {
                    resultB = true;
                    break;
                }
                }
                System.out.println(resultB);

            }






    }

    /**
     * Check is thee string is Uppercase
     * @param str
     * @return boolean
     */
    static boolean isUpperCase(String str){

        return str.chars().allMatch(Character::isUpperCase);
    }

    /**
     * Check is thee string is Uppercase
     * @param str
     * @return boolean
     */
    static boolean isLowerCase(String str){

        //return str.chars().allMatch(Character::isLowerCase);
        return str.chars().noneMatch(Character::isUpperCase);

    }


    static boolean isPasswordComplex(String str){
        return str.chars().anyMatch(Character::isUpperCase)
                && str.chars().anyMatch(Character::isLowerCase)
                && str.chars().anyMatch((Character::isDigit));
    }

}
