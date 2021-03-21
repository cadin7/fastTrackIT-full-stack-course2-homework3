package ro.fasttrackit.homework3.persons.inheritance;

import ro.fasttrackit.homework3.persons.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilePersonReportGenerator extends PersonReportGenerator {
    private final String sourceFile;

    public FilePersonReportGenerator(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public List<Person> readPersons() {
        try {
            return readPersonsFromFile();
        } catch (IOException e) {
            System.out.println("Could not read from file" + sourceFile);
        }
        return List.of();
    }

    private List<Person> readPersonsFromFile() throws IOException {
        return Files.lines(Path.of(sourceFile))
                .map(this::readPerson)
                .collect(toList());
    }

    private Person readPerson(String line) {
        String[] personInfo = line.split(",");
        return new Person(
                personInfo[0],
                personInfo[1],
                Integer.parseInt(personInfo[2])
        );
    }
}
