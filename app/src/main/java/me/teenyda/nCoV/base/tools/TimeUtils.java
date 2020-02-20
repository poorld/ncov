package me.teenyda.nCoV.base.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    public final static String datePattern1 = "yyyyMMdd";
    public final static String datePattern2 = "yyyy-MM-dd";
    public final static String datePattern3 = "yyyy-MM-dd HH:mm:ss";
    public final static String datePattern4 = "MM-dd HH:mm";

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

    public static Calendar getCalendar(String date, String pattern) {
        Date date1 = getDate(date, pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        return calendar;
    }

    public static Date getDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date date1 = sdf.parse(date);
            return date1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTD(long timestamp, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String formatDate = sdf.format(timestamp);
        return formatDate;
    }
}
