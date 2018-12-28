package example.domain.model.attendance;

import example.domain.type.time.HourAndMinute;
import example.domain.type.time.Minute;

/**
 * 総労働時間
 */
public class AllWorkTime {

    Minute value;

    public AllWorkTime(Minute value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return HourAndMinute.from(value).toString();
    }

    public Minute minute() {
        return value;
    }
}
