package ai.brace;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class EmployeeProcessor
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

    public static void main(String[] args)
    {
        final Map<String, Integer> duplicateCount = new HashMap<>(); //duplicate count key is now ssn
        final Map<String, Employee> socialToEmployee = new HashMap<>(); //map needed to relate ssn to employee

        try (Stream<String> stream = Files.lines(getPathForResource("employees.csv")))
        {
            stream.forEach(line -> {
                final String[] elements = line.split(",");
                final Employee emp = new Employee(elements[0], elements[1], elements[2], elements[3]);
                duplicateCount.put(emp.socialSecurityNumber, duplicateCount.getOrDefault(emp.socialSecurityNumber, 0) + 1); //ssn used as key
                socialToEmployee.putIfAbsent(emp.socialSecurityNumber, emp); //ssn map to employee updated as needed
            });
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }

        for (Map.Entry<String, Integer> entry : duplicateCount.entrySet())
        {
            final Employee emp = socialToEmployee.get(entry.getKey()); //employee retrieved from socialToEmployee map
            System.out.println(emp.firstName + " " + emp.middleInitial + " " + emp.lastName + ": " + entry.getValue());
        }
    }
}
