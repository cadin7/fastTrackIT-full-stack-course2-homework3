package ro.fasttrackit.homework3.persons.composition;

import ro.fasttrackit.homework3.persons.CategorizePersons;

import java.io.IOException;

import static java.util.stream.Collectors.*;

public class PersonReportGenerator {
    private final PersonProvider personProvider;
    private final String outputFile;
    private final PersonReportWriter personReportWriter = new PersonReportWriter();

    public PersonReportGenerator(PersonProvider personProvider, String outputFile) {
        this.personProvider = personProvider;
        this.outputFile = outputFile;
    }

    public void generateSimpleReport() throws IOException {
        personReportWriter.writeReport(personProvider.readPersons(), outputFile);
    }

    public void generatePersonReportByAge() throws IOException {
        personReportWriter.writeReport(
                personProvider.readPersons()
                        .stream()
                        .map(CategorizePersons::new)
                        .collect(toList())
                        .stream()
                        .collect(groupingBy(CategorizePersons::getAgeRange,
                                mapping(CategorizePersons::getFullName, toList())))
                , outputFile);
    }
}