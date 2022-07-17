package com.knubisoft.base.string;

public class Test extends StringTasksImpl {
//    public static void main(String[] args) {
//
//        Test test = new Test();
//        System.out.println(test.insertStringInMiddle("Wakanim", "Test"));
////        String str = "My name is Gustavo";
////        System.out.println(str);
////        char charToRemove = 'a';
////
////        System.out.println();
////
////        StringBuilder sb = new StringBuilder(str);
////        sb.deleteCharAt(charToRemove);
////        System.out.println(sb);
//
//
//    }

    static String convert(String s)
    {

        // to count spaces
        int cnt= 0;
        int n = s.length();
        char ch[] = s.toCharArray();
        int res_ind = 0;

        for (int i = 0; i < n; i++)
        {

            // check for spaces in the sentence
            if (ch[i] == ' ')
            {
                cnt++;
                // conversion into upper case
                ch[i + 1] = Character.toUpperCase(ch[i + 1]);
                continue;
            }

            // If not space, copy character
            else
                ch[res_ind++] = ch[i];
        }

        // new string will be reduced by the
        // size of spaces in the original string
        return String.valueOf(ch, 0, n - cnt);
    }

    // Driver code
    public static void main(String args[])
    {
        String str = "I_get_intern_at_geeksforgeeks";
        System.out.println(convert(str));
    }
}
