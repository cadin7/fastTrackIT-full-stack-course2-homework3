package ro.fasttrackit.homework3.app.gym;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Gym {
    private final List<GymSubscription> gymSubscriptions;

    public Gym(List<GymSubscription> gymSubscriptionList) {
        this.gymSubscriptions = new ArrayList<>(gymSubscriptionList);
    }

    public List<GymSubscription> getSubscriptions() {
        return Collections.unmodifiableList(gymSubscriptions);
    }

    public int getYoungestMemberYear() {
        return calculateMemberYears().getMin();
    }

    public int getOldestMemberYear() {
        return calculateMemberYears().getMax();
    }

    public double getAverageMemberYear() {
        return calculateMemberYears().getAverage();
    }

    private IntSummaryStatistics calculateMemberYears() {
        return gymSubscriptions.stream()
                .mapToInt(value ->
                        Period.between(value.getGymMember().getBirthdate(),
                                LocalDate.now()).getYears())
                .summaryStatistics();
    }

    public long getRemainingTimeFromAllMembers() {
        return gymSubscriptions.stream()
                .mapToLong(value ->
                        value.getTimeLeft()
                                .toHours())
                .sum();
    }

    public void addTimeToMember(String name, Duration time) {
        GymSubscription gymMember = findGymMemberByName(name);
        gymMember.setTimeLeft(
                gymMember.getTimeLeft()
                        .plus(time));
    }

    private GymSubscription findGymMemberByName(String name) {
        return gymSubscriptions.stream()
                .filter(gymMember ->
                        gymMember.getGymMember()
                                .getName()
                                .equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow();
    }

    public String getMemberDetails(String name) {
        return findGymMemberByName(name).toString();
    }

    public void spentTimeByMember(String name, Duration time) {
        GymSubscription gymMember = findGymMemberByName(name);
        gymMember.setTimeLeft(
                gymMember.getTimeLeft()
                        .minus(time));
        gymMember.setTimeSpent(
                gymMember.getTimeSpent()
                        .plus(time));
    }

}
