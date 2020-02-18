package me.teenyda.nCoV.base.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    private final static String datePattern1 = "yyyyMMdd";
    private final static String datePattern2 = "yyyy-MM-dd";
    private final static String datePattern3 = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取年-月-日
     * @return
     */
    public static String getYTD() {
        DateFormat dateFormat = new SimpleDateFormat(datePattern2);
        Calendar calendar = Calendar.getInstance();
        String formatDate = dateFormat.format(calendar.getTimeInMillis());
        return formatDate;
    }

    /**
     * 获取年-月-日
     * @param date
     * @return
     */
    public static String getYTD(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(datePattern2);
        String formatDate = dateFormat.format(date);
        return formatDate;
    }

    public static String getYTD(Calendar calendar) {
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        return year + "-" + month + "-" + day;
        DateFormat dateFormat = new SimpleDateFormat(datePattern2);
        String date = dateFormat.format(calendar.getTimeInMillis());
        return date;
    }
}
