package ro.fasttrackit.homework3.app.report;

import ro.fasttrackit.homework3.app.gym.GymSubscription;

import java.util.List;

public interface GymProvider {
    List<GymSubscription> readSubscriptions();
}
