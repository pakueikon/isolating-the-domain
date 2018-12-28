package example.domain.model.attendance;

import example.domain.type.time.HourAndMinute;
import example.domain.type.time.Minute;

/**
 * 総時間外労働時間
 */
public class AllOverWorkTime {

    Minute value;

    public AllOverWorkTime(Minute value) {
        this.value = value;
    }

    public Minute minute() {
        return value;
    }

    @Override
    public String toString() {
        return HourAndMinute.from(value).toString();
    }
}
