package example.domain.model.attendance.worktimerecord;

import example.domain.type.time.ClockTime;

/**
 * 業務開始時刻
 */
public class WorkStartTime {

    ClockTime value;

    @Deprecated
    WorkStartTime(){
    }

    public WorkStartTime(ClockTime value) {
        this.value = value;
    }

    public WorkStartTime(String value) {
        this(new ClockTime(value));
    }

    ClockTime normalizedHourTime() {
        return value.quarterRoundDown();
    }

    public boolean isAfter(WorkEndTime workEndTime) {
        return value.isAfter(workEndTime.value);
    }

    public ClockTime clockTime() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
