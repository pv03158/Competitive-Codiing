import java.util.*;

public class WordBreakProblem {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        HashMap<String, Boolean> hashmap = new HashMap<>();
        for (int idx = 0; idx < dictionary.length; idx++)
            hashmap.put(dictionary[idx], true);

        isStringCanSegmented(str, hashmap);
    }

    public static String[] dictionary = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream",
            "man", "go", "mango" };

    public static void isStringCanSegmented(String str, HashMap<String, Boolean> hashmap) {
        int lb = 0;
        int ub = 0;
        boolean flag = false;

        for (; ub < str.length(); ub++) {
            if (hashmap.containsKey(str.substring(lb, ub + 1))) {
                flag = true;
                lb = ub + 1;
            } else
                flag = false;
        }

        if (flag)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}