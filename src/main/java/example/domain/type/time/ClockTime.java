package example.domain.type.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 時刻を時分単位で表す
 */
public class ClockTime {

    String value;

    @Deprecated
    ClockTime() {
    }

    public ClockTime(LocalTime value) {
        // TODO 廃止
        this(value.format(DateTimeFormatter.ofPattern("H:mm")));
    }

    public ClockTime(String value) {
        if (!value.matches("\\d{1,2}:\\d{2}(:\\d{2})?")) throw new IllegalArgumentException(value);
        String[] split = value.split(":");
        this.value = String.format("%d:%02d", Integer.valueOf(split[0]), Integer.valueOf(split[1]));
    }

    public ClockTime(Integer hour, Integer minute) {
        this.value = String.format("%d:%02d", hour, minute);
    }

    public ClockTime(Hour hour, Minute minute) {
        this(hour.value, minute.value);
    }

    public LocalTime value() {
        // TODO 廃止
        return LocalTime.parse(value, DateTimeFormatter.ofPattern("H:mm"));
    }

    @Override
    public String toString() {
        return value;
    }

    public Minute until(ClockTime other) {
        return new ClockTimeRange(this, other).between();
    }

    public ClockTime quarterRoundDown() {
        Minute minute = minute().quarterHourRoundDown();
        return new ClockTime(hour(), minute);
    }

    public boolean isAfter(ClockTime other) {
        Minute thisMinute = hour().toMinute().add(minute());
        Minute otherMinute = other.hour().toMinute().add(other.minute());
        return otherMinute.lessThan(thisMinute);
    }

    public boolean isBefore(ClockTime other) {
        Minute thisMinute = hour().toMinute().add(minute());
        Minute otherMinute = other.hour().toMinute().add(other.minute());
        return thisMinute.lessThan(otherMinute);
    }

    public Hour hour() {
        return new Hour(Integer.valueOf(value.split(":")[0]));
    }

    public Minute minute() {
        return new Minute(Integer.valueOf(value.split(":")[1]));
    }

    public Minute betweenMinute(ClockTime other) {
        Minute thisMinute = hour().toMinute().add(minute());
        Minute otherMinute = other.hour().toMinute().add(other.minute());

        if (thisMinute.lessThan(otherMinute)) {
            return otherMinute.subtract(thisMinute);
        }
        return thisMinute.subtract(otherMinute);
    }
}
