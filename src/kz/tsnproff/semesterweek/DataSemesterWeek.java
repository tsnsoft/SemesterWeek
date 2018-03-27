package kz.tsnproff.semesterweek;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TSN
 */
public class DataSemesterWeek {
    
    Date date;
    int numberSemesterWeeks;
    boolean numerator;

    public DataSemesterWeek(Date date, int semesterWeek, boolean numerator) {
        this.date = date;
        this.numberSemesterWeeks = semesterWeek;
        this.numerator = numerator;
    }

    @Override
    public String toString() {
        String formatDate = "dd MMMM yyyy, EEEE";
        SimpleDateFormat df = new SimpleDateFormat(formatDate);
        return "Выбрано: " + df.format(date) + "\nНеделя семестра: " + numberSemesterWeeks + "\nВ семестре это: " + (numerator ? "Числитель" : "Знаменатель");
    }
    
}
