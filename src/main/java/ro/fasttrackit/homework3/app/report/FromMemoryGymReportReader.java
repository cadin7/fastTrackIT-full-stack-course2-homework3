package ro.fasttrackit.homework3.app.report;

import ro.fasttrackit.homework3.app.gym.Gym;
import ro.fasttrackit.homework3.app.gym.GymSubscription;

import java.util.Collections;
import java.util.List;

public class FromMemoryGymReportReader implements GymProvider {

    private final Gym gym;

    public FromMemoryGymReportReader(Gym gym) {
        this.gym = gym;
    }

    @Override
    public List<GymSubscription> readSubscriptions() {
        return Collections.unmodifiableList(gym.getSubscriptions());
    }
}
