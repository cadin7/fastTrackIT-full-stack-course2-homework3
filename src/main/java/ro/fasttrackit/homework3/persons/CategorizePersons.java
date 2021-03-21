package ro.fasttrackit.homework3.persons;

public class CategorizePersons {
    private final String ageRange;
    private final Person person;

    public CategorizePersons(Person person) {
        this.person = person;
        this.ageRange = getAgeRange(person.getAge());
    }

    public static String getFullName(CategorizePersons categorizePersons) {
        return categorizePersons.getPerson().getFirstName() + " " + categorizePersons.getPerson().getLastName();
    }

    public Person getPerson() {
        return person;
    }

    public String getAgeRange() {
        return ageRange;
    }

    private String getAgeRange(int age) {
        return String.valueOf(
                AgeStages.of(age)
                        .getAgeRange());
    }
}
