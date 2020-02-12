package ai.brace;

import ai.brace.ConvertJson;
import ai.brace.MergeSortedArrays;
import ai.brace.WordFreqCounter;
import ai.brace.AdditiveMerge;
import ai.brace.PrintText;
import ai.brace.AllText;
import ai.brace.TextData;

public class Main
{
    public static void main(String[] args)
    {
        AllText a1 = ConvertJson.convertFromJSON("a1.json");
        PrintText.print(a1.textArray);
        System.out.println();

        AllText a2 = ConvertJson.convertFromJSON("a2.json");
        TextData[] mergedData = MergeSortedArrays.merge(a1.textArray, a2.textArray);
        PrintText.print(mergedData);
        System.out.println();

        WordFreqCounter.getCounts(mergedData);
        System.out.println();

        boolean a1Older = a1.lastModified < a2.lastModified;
        AdditiveMerge.merge(a1Older ? a1 : a2, a1Older ? a2 : a1, mergedData);
    }
}
