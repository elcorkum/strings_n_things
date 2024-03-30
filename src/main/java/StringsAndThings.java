import java.util.ArrayList;
import java.util.Arrays;

public class StringsAndThings {
    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public static Integer countYZ(String input){
        int countOfYZ = 0;
        String str = input.toLowerCase();
        for (int i = 0; i < str.length(); i++ ) {
            if(str.charAt(i) == 'y' || str.charAt(i) == 'z') {
                if(!Character.isLetter(str.charAt(i+1))) {
                    countOfYZ++;
                }
            }
        }
        return countOfYZ;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public static String removeString(String base, String remove){
        return base.replace(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public static boolean containsEqualNumberOfIsAndNot(String input){
        int countIs = 0;
        int countNot = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'i') {
                if (i + 1 < input.length() && input.charAt(i + 1) == 's') {
                    countIs++;
                }
                i++;
            } else if (input.charAt(i) == 'n') {
                if (i + 1 < input.length() && input.charAt(i+1) == 'o') {
                    if(i + 2 < input.length() && input.charAt(i + 2) == 't') {
                        countNot++;
                        i++;


                    }
                    i++;
                }
            }
        }
    return countIs == countNot;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public static boolean gIsHappy(String input){

        boolean gIsHappy = true;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'g'){
                if ((i+1 < input.length() && input.charAt(i+1) == 'g') || input.charAt(i-1) == 'g') {
                    gIsHappy = true;
                } else {gIsHappy = false;}
            }
        }
        return gIsHappy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public static int countTriple(String input){
        int countOfTriples = 0;
        for (int i = 1; i < input.length(); i++) {
            if(input.charAt(i) == input.charAt(i-1) && (i+1 < input.length() && input.charAt(i) == input.charAt(i+1))) {
                countOfTriples++;
            }

        }
        return countOfTriples;
    }


    public static void main(String[] args) {
        String randomString = "My day was going fyzzz buzz hurray!";
        String toRemove = "zz";

        int countOfYZ = countYZ(randomString);
        System.out.println(countOfYZ);

        String removedString = removeString(randomString, toRemove);
        System.out.println(removedString);

        System.out.println(containsEqualNumberOfIsAndNot("This is notnot"));
        System.out.println(containsEqualNumberOfIsAndNot("This is not"));
        System.out.println(containsEqualNumberOfIsAndNot("noisxxnotyynotxisi"));

        System.out.println(gIsHappy("xxggxx"));
        System.out.println(gIsHappy("xxggxxgg"));
        System.out.println(gIsHappy("xxggyygxx"));


        System.out.println(countTriple("abcXXXabc"));
        System.out.println(countTriple("xxxabyyyycd"));
        System.out.println(countTriple("a"));



    }
}

