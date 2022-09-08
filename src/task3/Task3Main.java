package task3;

import java.util.*;

public class Task3Main {
    public static void main(String[] args) {
        // ??????????? ??????? ????????? ??????
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
    }

    public static boolean fuzzySearch(String stringToFind, String text) {
        int i = 0;
        char[] textChars = text.toCharArray();
        char[] pattern = stringToFind.toCharArray();

        for (int j = i; j < textChars.length; j++) {
            if (textChars[j] == (pattern[i])) {
                i++;
                if (pattern.length == i) {
                    break;
                }
            }
        }
        if (i == pattern.length) {
            return true;
        } else {
            return false;
        }
    }
}
