package ai.brace;

import ai.brace.TextData;
import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;
import java.lang.Character;

//NOTE: did not get to using regex

public class WordFreqCounter
{
    public static void getCounts(TextData[] textArr) {
        final Map<String, Integer> counts = new HashMap<>(); //map to hold counts
        for (TextData textData : textArr) {
            String text = textData.textdata;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                if (!Character.isWhitespace(text.charAt(i))) {
                    //if char is not whitespace continue to add to string builder
                    str.append(text.charAt(i));
                } else if (str.length() > 0) {
                    //if char is whitespace, word has been found
                    String word = str.toString().toLowerCase();
                    counts.put(word, counts.getOrDefault(word, 0) + 1); //map updated
                    str = new StringBuilder(); //stringbuilder reset
                }
            }
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue()); // map entries printed
        }
    }
}