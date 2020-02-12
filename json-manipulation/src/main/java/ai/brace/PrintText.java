package ai.brace;

import ai.brace.TextData;

public class PrintText
{
    /*
    * Prints text from TextData elements in order
    * */
    public static void print(TextData[] text) {
        for (TextData data : text) {
            System.out.println(data.textdata);
        }
    }
}