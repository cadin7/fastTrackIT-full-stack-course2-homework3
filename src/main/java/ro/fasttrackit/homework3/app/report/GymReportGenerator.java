package ro.fasttrackit.homework3.app.report;

import ro.fasttrackit.homework3.app.gym.CategorizedGymSubscriptions;

import java.io.IOException;
import java.time.LocalDate;

import static java.util.stream.Collectors.*;

public class GymReportGenerator {
    private final SubscriptionProvider subscriptionProvider;
    private final GymReportWriter reportWriter = new GymReportWriter();

    public GymReportGenerator(SubscriptionProvider subscriptionProvider) {
        this.subscriptionProvider = subscriptionProvider;
    }

    public void generateSubscriptionReportByTimeLeft() throws IOException {
        reportWriter.writeReport(
                subscriptionProvider.readSubscriptions()
                        .stream()
                        .map(CategorizedGymSubscriptions::new)
                        .collect(toList())
                        .stream()
                        .collect(groupingBy(
                                CategorizedGymSubscriptions::getGymTimeLeftToColorEnum,
                                mapping(subscriptions ->
                                                subscriptions.getGymSubscription()
                                                        .getGymMember()
                                                        .getName(),
                                        toList()))),
                getRemainingTimeFileName());
    }

    private String getRemainingTimeFileName() {
        return "remaining-time-report-" + LocalDate.now() + ".txt";
    }

}
