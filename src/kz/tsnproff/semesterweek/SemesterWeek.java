package kz.tsnproff.semesterweek;

import java.util.Calendar;
import java.util.Date;

public class SemesterWeek {

    int displacementWeekSemester;
    boolean invertNumerator;
    String info;
    SettingsSemesterWeek settingsSemesterWeek;

    public SemesterWeek() {
        settingsSemesterWeek = new SettingsSemesterWeek(this);
    }

    public int getDisplacementWeekSemester() {
        return displacementWeekSemester;
    }

    public boolean isInvertNumerator() {
        return invertNumerator;
    }

    public String getInfo() {
        return info;
    }

    public void setSettings(int displacement, boolean invert, String inf) {
        displacementWeekSemester = displacement;
        invertNumerator = invert;
        info = inf;
    }

    public DataSemesterWeek getData(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int semesterWeek = calendar.get(Calendar.WEEK_OF_YEAR) - displacementWeekSemester;
        boolean numerator = (semesterWeek & 1) == 0;
        numerator = invertNumerator ? !numerator : numerator;
        return new DataSemesterWeek(date, semesterWeek, numerator);
    }

}
