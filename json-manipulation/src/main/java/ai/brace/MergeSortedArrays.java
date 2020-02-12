package ai.brace;

import ai.brace.TextData;
import ai.brace.ConvertJson;

/*
* Class merges the two sorted textarrays into one sorted array with all the elements.
* */

public class MergeSortedArrays
{
    public static TextData[] merge(TextData[] a1, TextData[] a2) {
        int idx1 = 0; //Will run through first textarray
        int idx2 = 0;// Will run through second textarray
        TextData[] combined = new TextData[a1.length + a2.length];
        while (idx1 < a1.length || idx2 < a2.length) {
            // if checks if either array is already fully input into new array in which case input is made from other array
            // also checks that for which element at current checked idx in the arrays is smaller, and inserts that into new array first
            if (idx1 >= a1.length || (idx2 < a2.length && a2[idx2].id < a1[idx1].id)) {
                combined[idx1 + idx2] = a2[idx2];
                idx2++;
            } else {
                combined[idx1 + idx2] = a1[idx1];
                idx1++;
            }
        }
        return combined;
    }
}