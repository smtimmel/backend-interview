package ai.brace;

import ai.brace.AllText;
import ai.brace.TextData;
import java.lang.reflect.Field;
import java.util.UUID;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

// NOTE: did not get to lastModified updates

public class AdditiveMerge
{
    public static void merge(AllText older, AllText newer, TextData[] mergedTextArray) {
        Class allTextClass = newer.getClass();
        Field[] fields = allTextClass.getDeclaredFields(); //Gather all fields which need editing
        for (Field field : fields) {
            try {
                if (field.get(newer) == null) continue; //If newer JSON does not have the field, use field from older JSON
                field.set(older, field.get(newer));
            } catch (Exception e) {
                continue;
            }
        }
        older.textArray = mergedTextArray; //set the textarray of the object to contain the elements from both files arrays
        older.uuid = UUID.randomUUID().toString(); //generate a random UUID for the file
        Gson gson = new Gson();
        String json = gson.toJson(older, AllText.class);
        try {
            FileWriter writer = new FileWriter("output.json"); //Create and write to the new file
            writer.write(json);
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}