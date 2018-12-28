package example.domain.model.attendance.worktimerecord;

import example.domain.type.time.ClockTime;

/**
 * 業務終了時刻
 */
public class WorkEndTime {

    ClockTime value;

    @Deprecated
    WorkEndTime() {
    }

    public WorkEndTime(ClockTime value) {
        this.value = value;
    }

    public WorkEndTime(String value) {
        this(new ClockTime(value));
    }

    ClockTime normalizedHourTime() {
        return value.quarterRoundDown();
    }

    public ClockTime clockTime() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
