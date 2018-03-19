package com.mds.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 本类是日期工具类，包括日期转换、日期求值函数，功能是实现日期转换与日期日期求值.
 * 
 * @author liu
 */
public class DateUtil {
	public static String getWeekNum(int num){
		String temp = "";
		switch (num) {
		case 1:
			temp = "一";
			break;
		case 2:
			temp = "二";
			break;
		case 3:
			temp = "三";
			break;
		case 4:
			temp = "四";
			break;
		case 5:
			temp = "五";
			break;
		case 6:
			temp = "六";
			break;
		case 0:
			temp = "日";
			break;
		default:
			break;
		}
		return temp;
	}
	/**
	 * 根据预告日期得出预告的周
	 * @param date
	 * @return
	 */
	public static String getWeekByDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE",Locale.CHINA); 
		String week = "";
		if (null != date && !"".equals(date)) {
			try {
				Date tempDate = dateFormat.parse(date);
				week = weekFormat.format(tempDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return week;
	}
    /**
     * 格式化日期 (格式:yyyy-MM-dd HH:mm:ss)
     * 
     * @param inDate
     *                要格式化的日期
     * @return 格式化后的日期
     */
    public final static String formatDate2Str(Date inDate) {
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	return sf.format(inDate);
    }
    /**
     * 根据指定都日期格式格式化日期
     * 格式化日期 (格式:yyyy-MM-dd HH:mm:ss)
     * 
     * @param inDate
     *                要格式化的日期
     * @return 格式化后的日期
     */
    public final static String formatDate2Str(Date inDate,String format) {
	SimpleDateFormat sf = new SimpleDateFormat(format);
	return sf.format(inDate);
    }

    /**
     * 格式化日期 (格式:format)
     * 
     * @param inDate
     *                要格式化的日期
     * @param format
     *                格式化的格式
     * @return 格式化后的日期
     * @throws ParseException
     */
    public final static String formatString2String(String inDate, String format)
	    throws ParseException {
	String strDate = "";
	Date date = string2UtilDate(inDate);
	SimpleDateFormat sf = new SimpleDateFormat(format);
	strDate = sf.format(date);
	return strDate;
    }

    /**
     * 得到当前日期
     * 
     * @return String型日期
     */
    public final static String getDayStr() {
	Date date = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	return sf.format(date);
    }
    /**
	 * 比较时间
	 * 
	 * @return String型日期
	 */
	public final static boolean CompareTwoDate(Date datestart, Date dateend) {
		boolean flag = false;
		Date date = new Date();
		SimpleDateFormat sfdate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sftime = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dates = sfdate.format(date);

		String nextdate = sfdate.format(new Date(date.getTime()
				+ (1000 * 60 * 60 * 24)));

		String datestarttime = sftime.format(datestart);
		String dateendtime = sftime.format(dateend);

		try {

		
			if (datestart.after(dateend)) {
				//结束时间加一天
				dateend = sf.parse(nextdate + " " + dateendtime);
			} else {
				dateend = sf.parse(dates + " " + dateendtime);
			}
			datestart = sf.parse(dates + " " + datestarttime);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         if(date.after(datestart) && date.before(dateend)){
        	 flag= true;
         }
		
		return flag;
	}
    /**
     * 得到当前日期
     * 
     * @return String型日期
     */
    public  static String getDateStr() {
	Date date = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return sf.format(date);
    }
    
    public  static String getDateStrEvery() {
    	Date date = new Date();
    	SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
    	return sf.format(date);
        }

    /**
     * 得到当前日期
     * 
     * @return Date型日期
     * @throws ParseException
     */
    public final static Date getDay() throws ParseException {
	Date date = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	String strDate = sf.format(date);
	return sf.parse(strDate);
    }

	/**
	 * 获得当前时间
	 * @return
	 * @throws ParseException
	 */
	public final static Date getCurrentDateTime() throws ParseException {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = sf.format(date);
		return sf.parse(strDate);
	}

    /**
     * Calendar转化为Date
     * 
     * @return Date型日期
     */
    public final static Date calendar2Date() {
	Calendar cal = Calendar.getInstance();
	Date date = cal.getTime();
	return date;
    }

    /**
     * Date转化为Calendar
     * 
     * @return Calendar型日期
     */
    public final static Calendar date2Calendar() {
	Date date = new Date();
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	return cal;
    }

    /**
     * UtilDate转化为SqlDate
     * 
     * @return SqlDate型日期
     */
    public final static java.sql.Date UtilDate2SqlDate(Date date) {
	return new java.sql.Date(date.getTime());
    }

    /**
     * 将字符串类型的日期转换为一个Date（java.sql.Date）
     * 
     * @param dateString
     *                需要转换为Date的字符串
     * @return dataTime Date
     */
    public final static java.sql.Date string2SqlDate(String dateString)
	    throws Exception {
	DateFormat dateFormat;
	dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	dateFormat.setLenient(false);
	Date timeDate = dateFormat.parse(dateString);// util类型
	java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());// sql类型
	return dateTime;
    }

    /**
     * 将字符串类型的日期转换为一个Date（java.util.Date）
     * 
     * @param dateString
     *                需要转换为Date的字符串
     * @return dataTime Date
     */
    public final static Date string2UtilDate(String dateString){
	DateFormat dateFormat;
	dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
		Locale.ENGLISH);
	dateFormat.setLenient(false);
	Date timeDate=null;
	try {
		timeDate = dateFormat.parse(dateString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}// util类型
	return timeDate;
    }

    /**
     * 将字符串类型的日期转换为一个Date（java.util.Date）
     * 
     * @param dateString
     *                需要转换为Date的字符串
     * @param format
     *                格式化的格式
     * @return dataTime Date
     * @throws ParseException
     */
    public final static Date string2UtilDate(String dateString,
	    String format) throws ParseException {
	DateFormat dateFormat;
	dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
	dateFormat.setLenient(false);
	Date timeDate = dateFormat.parse(dateString);// util类型
	return timeDate;
    }

    /**
     * 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     * 
     * @param dateString
     *                需要转换为timestamp的字符串
     * @return dataTime timestamp
     */
    public final static java.sql.Timestamp string2Time(String dateString)
	    throws ParseException {
	DateFormat dateFormat;
	dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS",
		Locale.ENGLISH);// 设定格式
	dateFormat.setLenient(false);
	Date timeDate = dateFormat.parse(dateString);// util类型
	java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
	return dateTime;
    }

    /**
     * 计算两个任意时间中间的间隔天数（这个比较常用）
     * 
     * @param startday
     *                Calendar型起始日期
     * @param endday
     *                Calendar型终止日期
     * @return int 天数
     */
    public final static int getIntervalDays(Calendar startday, Calendar endday) {
	if (startday.after(endday)) {
	    Calendar cal = startday;
	    startday = endday;
	    endday = cal;
	}
	long sl = startday.getTimeInMillis();
	long el = endday.getTimeInMillis();

	long ei = el - sl;
	return (int) (ei / (1000 * 60 * 60 * 24));
    }

    /**
     * 计算两个任意时间中间的间隔天数（这个比较常用）
     * 
     * @param startday
     *                Date型起始日期
     * @param endday
     *                Date型终止日期
     * @return int 天数
     */
    public final static int getIntervalDays(Date startday, Date endday) {
	if (startday.after(endday)) {
	    Date cal = startday;
	    startday = endday;
	    endday = cal;
	}
	long sl = startday.getTime();
	long el = endday.getTime();
	long ei = el - sl;
	return (int) (ei / (1000 * 60 * 60 * 24));
    }

    /**
     * 计算两个任意时间中间的间隔天数 改进精确计算相隔天数的方法
     * 
     * @param d1
     *                Calendar型日期
     * @param d2
     *                Calendar型日期
     * @return int 天数
     */
    public final static int getDaysBetween(Calendar d1, Calendar d2) {
	if (d1.after(d2)) {
	    Calendar swap = d1;
	    d1 = d2;
	    d2 = swap;
	}
	int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
	int y2 = d2.get(Calendar.YEAR);
	if (d1.get(Calendar.YEAR) != y2) {
	    d1 = (Calendar) d1.clone();
	    do {
		days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
		d1.add(Calendar.YEAR, 1);
	    } while (d1.get(Calendar.YEAR) != y2);
	}
	return days;
    }

    /**
     * 计算两个任意时间中间的间隔 （根据type返回天数、小时数、分钟数、秒数与毫秒数）
     * 
     * @param startday
     *                Date型起始日期
     * @param endday
     *                Date型终止日期
     * @param type
     *                类型
     * @return int 天数、小时数、分钟数、秒数与毫秒数
     */
    public final static int getIntervalNo(Date startday, Date endday,
	    String type) {
	if (startday.after(endday)) {
	    Date cal = startday;
	    startday = endday;
	    endday = cal;
	}
	int no = 0;
	long sl = startday.getTime();
	long el = endday.getTime();
	long ei = el - sl;
	// 返回天数
	if ("day".equals(type)) {
	    no = (int) (ei / (1000 * 60 * 60 * 24));
	}
	// 返回小时数
	else if ("hour".equals(type)) {
	    no = (int) (ei / (1000 * 60 * 60));
	}
	// 返回分钟数
	else if ("minute".equals(type)) {
	    no = (int) (ei / (1000 * 60));
	}
	// 返回秒数
	else if ("second".equals(type)) {
	    no = (int) (ei / (1000));
	}
	// 返回毫秒数
	else {
	    no = (int) ei;
	}

	return no;
    }

    /**
     * 计算一当前时间前与现在的间隔
     * 
     * @param dateString
     *                String型日期
     * @return String 天数、小时数、分钟数、秒数与毫秒数
     */
    public final static String getIntervalNow(String dateString) {
	String strback = "";
	Date now = new Date();
	try {
	    Date date = string2UtilDate(dateString);
	    int no = 0;
	    if (date.after(now)) {
		strback = "所传时间在当前时间之前，所传时间不正确。";
	    } else {
		// 判断天数
		no = getIntervalNo(date, now, "day");
		if (no != 0) {
		    strback = no + "天前";
		} else {
		    // 判断小时数
		    no = getIntervalNo(date, now, "hour");
		    if (no != 0) {
			strback = no + "小时前";
		    } else {
			// 判断分钟数
			no = getIntervalNo(date, now, "minute");
			if (no != 0) {
			    strback = no + "分钟前";
			} else {
			    // 判断秒数
			    no = getIntervalNo(date, now, "second");
			    strback = no + "秒";
			}
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return strback;
    }
    
    /**
     * 将字符串类型的日期转换为一个Date（java.util.Date）
     * 
     * @param dateString
     *                需要转换为Date的字符串
     * @param format
     *                格式化的格式
     * @return dataTime Date
     * @throws ParseException
     */
    public final static Date string2UtilDateByCatch(String dateString){
	DateFormat dateFormat;
	Date timeDate = null;
	dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
	dateFormat.setLenient(false);
	try {
		timeDate = dateFormat.parse(dateString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}// util类型
	return timeDate;
    }
    
    /**
	 * 获取当前日期第几季度
	 * @author zhangdandan
	 * @date 2016年12月27日 下午12:09:20
	 * @description
	 * @param date
	 * @return
	 */
	public static int getSeason(Date date) {  
		  
        int season = 0;  
  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int month = c.get(Calendar.MONTH);  
        switch (month) {  
        case Calendar.JANUARY:  
        case Calendar.FEBRUARY:  
        case Calendar.MARCH:  
            season = 1;  
            break;  
        case Calendar.APRIL:  
        case Calendar.MAY:  
        case Calendar.JUNE:  
            season = 2;  
            break;  
        case Calendar.JULY:  
        case Calendar.AUGUST:  
        case Calendar.SEPTEMBER:  
            season = 3;  
            break;  
        case Calendar.OCTOBER:  
        case Calendar.NOVEMBER:  
        case Calendar.DECEMBER:  
            season = 4;  
            break;  
        default:  
            break;  
        }  
        return season;  
    }  
	/**
	 * 获取上半年，下半年
	 * @author zhangdandan
	 * @date 2016年12月27日 下午12:14:30
	 * @description
	 * @param date
	 * @return
	 */
	public static int getHalfYear(Date date) {  
		  
        int season = 0;  
  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int month = c.get(Calendar.MONTH);  
        switch (month) {  
        case Calendar.JANUARY:  
        case Calendar.FEBRUARY:  
        case Calendar.MARCH:  
        case Calendar.APRIL:  
        case Calendar.MAY:  
        case Calendar.JUNE:  
            season = 1;  
            break;  
        case Calendar.JULY:  
        case Calendar.AUGUST:  
        case Calendar.SEPTEMBER:  
        case Calendar.OCTOBER:  
        case Calendar.NOVEMBER:  
        case Calendar.DECEMBER:  
        	season = 2;  
        	break;  
        default:  
            break;  
        }  
        return season;  
    } 
	/**
	 * 获取俩月
	 * @author zhangdandan
	 * @date 2016年12月27日 下午12:14:58
	 * @description
	 * @param date
	 * @return
	 */
	public static int getTwoMonth(Date date) {  
		  
        int season = 0;  
  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int month = c.get(Calendar.MONTH);  
        switch (month) {  
        case Calendar.JANUARY:  
        case Calendar.FEBRUARY:  
        	season = 1;  
        	break;  
        case Calendar.MARCH:  
        case Calendar.APRIL:  
        	season = 2;  
        	break;  
        case Calendar.MAY:  
        case Calendar.JUNE:  
        	season = 3;  
        	break;  
        case Calendar.JULY:  
        case Calendar.AUGUST:  
        	season = 4;  
        	break;  
        case Calendar.SEPTEMBER:  
        case Calendar.OCTOBER:  
        	season = 5;  
        	break;  
        case Calendar.NOVEMBER:  
        case Calendar.DECEMBER:  
        	season = 6;  
        	break;  
        default:  
            break;  
        }  
        return season;  
    } 

	
	/**
	 * 根据年月返回的文件夹名称
	 * @author lxy
	 * @return
	 */
	public static String dirName() {  
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		String strDate = sf.format(date);
        return strDate;  
    } 
}
