package Common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonMethods {
    public static String getSomeDaysAfter(int i){
        DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, i);

        Date currentDatePlusThree = c.getTime();
        return dateFormat.format(currentDatePlusThree);
    }
}
