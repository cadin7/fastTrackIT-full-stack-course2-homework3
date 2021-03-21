package ro.fasttrackit.homework3.app;

import ro.fasttrackit.homework3.app.gym.Gym;
import ro.fasttrackit.homework3.app.gym.GymMember;
import ro.fasttrackit.homework3.app.gym.GymSubscription;
import ro.fasttrackit.homework3.app.report.FromMemoryGymReportReader;
import ro.fasttrackit.homework3.app.report.GymReportGenerator;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class GymMain {

    public static void main(String[] args) throws IOException {
        Gym gym = new Gym(List.of(
                new GymSubscription(
                        new GymMember("Pelo", LocalDate.of(1995, 11, 3)),
                        Duration.ofHours(5)),
                new GymSubscription(
                        new GymMember("Bozsi", LocalDate.of(1931, 3, 3)),
                        Duration.ofHours(2)),
                new GymSubscription(
                        new GymMember("Hablo", LocalDate.of(1990, 4, 30)),
                        Duration.ofHours(35)),
                new GymSubscription(
                        new GymMember("Lorenzo", LocalDate.of(2005, 1, 23)),
                        Duration.ofHours(55)),
                new GymSubscription(
                        new GymMember("Fabio", LocalDate.of(1971, 12, 1)),
                        Duration.ofHours(22)),
                new GymSubscription(
                        new GymMember("Antonio", LocalDate.of(1991, 8, 5)),
                        Duration.ofHours(62))

        ));

        printExercises(gym);
        generateReportForGym(gym);
    }

    private static void generateReportForGym(Gym gym) throws IOException {
        new GymReportGenerator(new FromMemoryGymReportReader(gym)).generateSubscriptionReportByTimeLeft();
    }

    private static void printExercises(Gym gym) {
        System.out.println("Average member age: " + String.format("%.2f", gym.getAverageMemberYear()));
        System.out.println("Oldest member age: " + gym.getOldestMemberYear());
        System.out.println("Youngest member age: " + gym.getYoungestMemberYear());
        System.out.println("Remaining time for all members: " + gym.getRemainingTimeFromAllMembers() + "h");

        System.out.println(gym.getMemberDetails("Lorenzo"));
        gym.addTimeToMember("Lorenzo", Duration.ofHours(12));
        gym.spentTimeByMember("Lorenzo", Duration.ofHours(3));
        System.out.println(gym.getMemberDetails("Lorenzo"));
        System.out.println("Remaining time for all members: " + gym.getRemainingTimeFromAllMembers() + "h");
    }
}
