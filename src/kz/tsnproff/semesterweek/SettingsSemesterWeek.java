package kz.tsnproff.semesterweek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author TSN
 */
public class SettingsSemesterWeek {

    String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath() + System.getProperty("file.separator");
    String fileName = dir + "semesterweek.prop";
    Properties p = new Properties();
    private final SemesterWeek outer;

    public SettingsSemesterWeek(final SemesterWeek outer) {
        this.outer = outer;
    }

    public void loadSettings() {
        try {
            p.load(new FileInputStream(fileName));
            outer.displacementWeekSemester = Integer.parseInt(p.getProperty("displacementWeekSemester"));
            outer.invertNumerator = Boolean.parseBoolean(p.getProperty("invertNumerator"));
            outer.info = p.getProperty("info");
        } catch (Exception e) {
            outer.displacementWeekSemester = 0;
            outer.invertNumerator = false;
        }
    }

    public void saveSettings() {
        try {
            File f = new File(fileName);
            if (f.exists() == false) {
                f.createNewFile();
            } else {
                p.load(new FileInputStream(fileName));
            }
            p.put("displacementWeekSemester", String.valueOf(outer.displacementWeekSemester));
            p.put("invertNumerator", String.valueOf(outer.invertNumerator));
            p.put("info", outer.info);
            p.store(new FileOutputStream(fileName), "/* properties updated */");
        } catch (Exception e) {
        }
    }

}
