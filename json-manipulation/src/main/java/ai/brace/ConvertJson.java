package ai.brace;

import java.io.FileReader;
import com.google.gson.Gson;
import java.net.URISyntaxException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import ai.brace.AllText;
import java.util.Arrays;

/*
* Class in charge of converting JSON file data into usable AllText objects and sorting their textarrays
* */

public class ConvertJson
{
    public static Path getPathForResource(final String path)
    {
        try
        {
            return Paths.get(ClassLoader.getSystemResource(path).toURI());
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static AllText convertFromJSON(final String path)
    {
        try {
            FileReader reader = new FileReader(getPathForResource(path).toString());
            Gson gson = new Gson();
            AllText allText = gson.fromJson(reader, AllText.class); //Convert JSON to AllText
            reader.close();
            Arrays.sort(allText.textArray, (a, b) -> a.id - b.id); //Sort textarray on Alltext object
            return allText;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}