package ro.fasttrackit.homework3.persons.inheritance;

import ro.fasttrackit.homework3.persons.CategorizePersons;
import ro.fasttrackit.homework3.persons.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.*;

abstract class PersonReportGenerator {
    public void generateReport(String outputFile) throws IOException {
        writeReport(readPersons(), outputFile);
    }

    public void generatePersonReportByAge(String outputFile) throws IOException {
        writeReport(
                readPersons().stream()
                        .map(CategorizePersons::new)
                        .collect(toList())
                        .stream()
                        .collect(groupingBy(CategorizePersons::getAgeRange,
                                mapping(CategorizePersons::getFullName, toList())))
                , outputFile);
    }

    private void writeReport(List<Person> persons, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            persons.stream()
                    .map(person -> person.getFirstName() + " " + person.getLastName() + " " + person.getAge())
                    .forEach(person -> writeLine(writer, person));
        }
    }

    private void writeReport(Map<String, List<String>> persons, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            persons.entrySet()
                    .stream()
                    .sorted(comparingByKey())
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
                    .forEach(names -> writeLine(writer, names.replaceAll("[\\[\\]]", "")));
        }
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract List<Person> readPersons();
}
