package ai.brace;
import ai.brace.TextData;

/*
* This class is the object which the a1 and a2 JSON files will be converted to. It contains all the same
* fields as the JSON files
* */

public class AllText
{
    public String version;
    public String uuid;
    public int lastModified;
    public String title;
    public String author;
    public String translator;
    public String releaseDate;
    public String language;
    public TextData[] textArray;
}