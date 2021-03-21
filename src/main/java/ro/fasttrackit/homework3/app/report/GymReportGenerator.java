package ro.fasttrackit.homework3.app.report;

import ro.fasttrackit.homework3.app.gym.CategorizedGymSubscriptions;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class GymReportGenerator {
    private final GymProvider gymProvider;
    private final GymReportWriter reportWriter = new GymReportWriter();

    public GymReportGenerator(GymProvider gymProvider) {
        this.gymProvider = gymProvider;
    }

    public void generateSubscriptionReportByTimeLeft() throws IOException {
        reportWriter.writeReport(
                gymProvider.readSubscriptions()
                        .stream()
                        .map(CategorizedGymSubscriptions::new)
                        .collect(Collectors.toList())
                        .stream()
                        .collect(Collectors.groupingBy(CategorizedGymSubscriptions::getGymTimeLeftToColorEnum,
                                Collectors.mapping(subscriptions ->
                                                subscriptions.getGymSubscription()
                                                        .getGymMember()
                                                        .getName(),
                                        Collectors.toList()))),
                getRemainingTimeFileName());
    }

    private String getRemainingTimeFileName() {
        return "remaining-time-report-" + LocalDate.now() + ".txt";
    }

}
