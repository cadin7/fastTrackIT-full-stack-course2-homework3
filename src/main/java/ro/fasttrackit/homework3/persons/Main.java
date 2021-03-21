package ro.fasttrackit.homework3.persons;

import ro.fasttrackit.homework3.persons.composition.FilePersonReader;
import ro.fasttrackit.homework3.persons.composition.FromMemoryPersonReader;
import ro.fasttrackit.homework3.persons.composition.PersonReportGenerator;
import ro.fasttrackit.homework3.persons.inheritance.FilePersonReportGenerator;
import ro.fasttrackit.homework3.persons.inheritance.FromMemoryPersonReportGenerator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var compFileGenerator = new FilePersonReader("src/main/resources/people.txt");
        new PersonReportGenerator(compFileGenerator, "comp_file.txt").generatePersonReportByAge();

        var compMemoryGenerator = new FromMemoryPersonReader();
        new PersonReportGenerator(compMemoryGenerator, "comp_memory.txt").generatePersonReportByAge();


        var inhFileGenerator = new FilePersonReportGenerator("src/main/resources/people.txt");
        inhFileGenerator.generatePersonReportByAge("inh_file.txt");

        new FromMemoryPersonReportGenerator().generatePersonReportByAge("inh_memory.txt");
    }
}
