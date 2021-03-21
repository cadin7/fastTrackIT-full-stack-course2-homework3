package ro.fasttrackit.homework3.app.gym;

import java.time.LocalDate;
import java.util.Objects;

public class GymMember {
    private final String name;
    private final LocalDate birthdate;

    public GymMember(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymMember gymMember = (GymMember) o;
        return Objects.equals(name, gymMember.name) &&
                Objects.equals(birthdate, gymMember.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate);
    }
}
