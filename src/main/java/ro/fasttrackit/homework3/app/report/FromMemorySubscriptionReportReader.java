package ro.fasttrackit.homework3.app.report;

import ro.fasttrackit.homework3.app.gym.Gym;
import ro.fasttrackit.homework3.app.gym.GymSubscription;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class FromMemorySubscriptionReportReader implements SubscriptionProvider {

    private final Gym gym;

    public FromMemorySubscriptionReportReader(Gym gym) {
        this.gym = gym;
    }

    @Override
    public List<GymSubscription> readSubscriptions() {
        return unmodifiableList(gym.getSubscriptions());
    }
}
