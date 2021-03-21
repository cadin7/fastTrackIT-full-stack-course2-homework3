package ro.fasttrackit.homework3.app.gym;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

public class GymSubscription {
    private final GymMember gymMember;
    private final LocalDate registerDate;
    private Duration timeLeft;
    private Duration timeSpent;

    public GymSubscription(GymMember gymMember, Duration timeLeft) {
        this.gymMember = gymMember;
        this.registerDate = LocalDate.now();
        this.timeLeft = timeLeft;
        this.timeSpent = Duration.ZERO;
    }

    public GymMember getGymMember() {
        return gymMember;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public Duration getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Duration timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Duration getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Duration timeSpent) {
        this.timeSpent = timeSpent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymSubscription that = (GymSubscription) o;
        return Objects.equals(gymMember, that.gymMember) &&
                Objects.equals(registerDate, that.registerDate) &&
                Objects.equals(timeLeft, that.timeLeft) &&
                Objects.equals(timeSpent, that.timeSpent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gymMember, registerDate, timeLeft, timeSpent);
    }

    @Override
    public String toString() {
        return "GymSubscription{" +
                "gymMember=" + gymMember +
                ", registerDate=" + registerDate +
                ", timeLeft=" + timeLeft.toHours() +
                ", timeSpent=" + timeSpent.toHours() +
                '}';
    }
}
