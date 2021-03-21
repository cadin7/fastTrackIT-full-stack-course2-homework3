package ro.fasttrackit.homework3.app.gym;

import java.util.stream.Stream;

public enum GymTimeLeftToColor {

    RED(10),
    YELLOW(30),
    GREEN(Long.MAX_VALUE);

    private final long timeLeft;

    GymTimeLeftToColor(long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public static GymTimeLeftToColor of(long timeLeft) {
        return Stream.of(values())
                .filter(gymTimeLeftToColor ->
                        gymTimeLeftToColor.getTimeLeft() > timeLeft)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid time!"));
    }

    public long getTimeLeft() {
        return timeLeft;
    }


}
