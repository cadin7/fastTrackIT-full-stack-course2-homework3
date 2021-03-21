package ro.fasttrackit.homework3.app.gym;

import java.time.Duration;

public class CategorizedGymSubscriptions {

    private final GymSubscription gymSubscription;
    private final String gymTimeLeftToColorEnum;

    public CategorizedGymSubscriptions(GymSubscription gymSubscription) {
        this.gymSubscription = gymSubscription;
        this.gymTimeLeftToColorEnum = setColourByTimeLeft(gymSubscription.getTimeLeft());
    }

    public GymSubscription getGymSubscription() {
        return gymSubscription;
    }

    public String getGymTimeLeftToColorEnum() {
        return gymTimeLeftToColorEnum;
    }

    private String setColourByTimeLeft(Duration timeLeft) {
        return String.valueOf(
                GymTimeLeftToColor.of(
                        timeLeft.toHours()));
    }

}
