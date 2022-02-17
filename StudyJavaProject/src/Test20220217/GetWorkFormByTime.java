package Test20220217;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetWorkFormByTime {
    public static final int YEAR = 2022;
    public static final int MONTH = 1;
    public static final int DAYS = 13;
    public static final int MILLI_SECOND_IN_ONE_DAY = 1000 * 3600 * 24;
    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        String workForm = getWorkForm();
        System.out.println(workForm);
    }
    public static String getWorkForm(){
        String returnStr;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, YEAR);
        calendar.set(Calendar.MONTH, MONTH);
        calendar.set(Calendar.DATE, DAYS);
        int intervalDays = daysBetween(calendar.getTime(), new Date());
        System.out.println("相隔的天数是：" + intervalDays);
        switch (intervalDays % 7){
            case 1:
                returnStr = "第一工作日";
                break;
            case 2:
                returnStr = "第二工作日";
                break;
            case 3:
                returnStr = "第三工作日";
                break;
            case 4:
                returnStr = "第四工作日";
                break;
            case 5:
                returnStr = "第五工作日, 昨儿晚上23点开始上夜班，今早8点下班 今天算第一个工作日";
                break;
            default:
                returnStr = "休息日";//case 6.7
                break;
        }
        //System.out.println(sdf.format(calendar.getTime()));
        return returnStr;
    }

    public static int daysBetween(Date startDate, Date endDate) {
        long between_days= 0;
        try {
            startDate=sdf.parse(sdf.format(startDate));
            endDate=sdf.parse(sdf.format(endDate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(endDate);
            long time2 = cal.getTimeInMillis();
            between_days = (time2-time1)/ MILLI_SECOND_IN_ONE_DAY;
        } catch (ParseException e) {
            System.out.println("转换时间格式错误！");
        }

        return Integer.parseInt(String.valueOf(between_days));
    }
}
