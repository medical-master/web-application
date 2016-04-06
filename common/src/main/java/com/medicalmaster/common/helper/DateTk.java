package com.medicalmaster.common.helper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTk 
{
	protected static Logger log = LoggerFactory.getLogger(DateTk.class);

	    public final static int MILLISECOND = Calendar.MILLISECOND;
	    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	    private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	    /**
	     * 时间格式化.
	     * @param str
	     */
	    public static void setDateFormat(String str) 
	    {
	    	DATE_FORMAT = str;
	        sdf = new SimpleDateFormat(DATE_FORMAT);
	    }
 
	    /**
	     * 获得系统当前日期
	     * @return
	     */
	    public static String getFormattedCurrentDate() 
	    {
	        long currentTime = System.currentTimeMillis();
	        Timestamp ts = new Timestamp(currentTime);
	        return sdf.format(ts);
	    }
	    
	    /**
	     * 获得系统当天日期
	     * */
	    public static String getDay()
	    {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    	long currentTime = System.currentTimeMillis();
	        Timestamp ts = new Timestamp(currentTime);
	        return sdf.format(ts);
	    }

	    /**
	     * 获得指定格式日期
	     * @param t
	     * @return
	     */
	    public static String getFormattedDateByTime(Date t) 
	    {
	        return sdf.format(t);
	    }
	    
	    /**
	     * 获得日期之前或之后的“日期”上一步。
	     * @param str
	     */
	    public static Timestamp getDate(Date date, int step) 
	    {
	        Calendar cal = getCalendar();
	        Timestamp t = null;
	        if (date != null) 
	        {
	            cal.setTime(date);
	            cal.clear(Calendar.AM_PM);
	            cal.clear(Calendar.HOUR);
	            cal.clear(Calendar.HOUR_OF_DAY);
	            cal.clear(Calendar.MINUTE);
	            cal.clear(Calendar.SECOND);
	            cal.clear(Calendar.MILLISECOND);
	            cal.add(Calendar.DATE, step);
	            t = new Timestamp(cal.getTime().getTime());
	        }
	        return t;
	    }

	    /**
	     * 获得者一天的下一个星期.
	     * @param date
	     * @return
	     */
	    public static Timestamp getBeginOfWeek(Date date) 
	    {
	        Timestamp result = null;
	        Calendar cal = getCalendar();
	        cal.setTime(date);
	        if (cal.get(Calendar.DAY_OF_WEEK) == 1) 
	        {
	            result = getDate(date, -6);
	        }
	        else 
	        {
	            result = getDate(date, 2 - cal.get(Calendar.DAY_OF_WEEK));
	        }
	        return result;
	    }
	    
	    /**
	     * 获得这个星期的最后一天
	     * @param date
	     * @return
	     */
	    public static Timestamp getEndOfWeek(Date date) 
	    {
	        Timestamp result = null;
	        Calendar cal = getCalendar();
	        cal.setTime(date);
	        if (cal.get(Calendar.DAY_OF_WEEK) == 1) 
	        {
	            result = getDate(date, 0);
	        }
	        else 
	        {
	            result = getDate(date, 8 - cal.get(Calendar.DAY_OF_WEEK));
	        }
	        return result;
	    }

	    /**
	     * 获得下周的开始时间
	     * @param date
	     * @return
	     */
	    public static Timestamp getBeginOfNextWeek(Date date) 
	    {
	        Calendar cal = getCalendar();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, 7);
	        return getBeginOfWeek(cal.getTime());
	    }

	    /**
	     * 获得按日期下周的最后日期。
	     * @param date
	     * @return
	     */
	    public static Timestamp getEndOfNextWeek(Date date) 
	    {
	        Calendar cal = getCalendar();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, 7);
	        return getEndOfWeek(cal.getTime());
	    }

	    /**
	     * 获得这个例子的Calendar对象
	     * @return
	     */
	    private static Calendar getCalendar() 
	    {
	        Calendar cal = Calendar.getInstance();
	        cal.clear();
	        cal.setFirstDayOfWeek(Calendar.MONDAY);
	        return cal;
	    }
	    
	    /**
	     * 获得下一月
	     * @return Timestamp
	     * */
	    public static Timestamp getNextMonth(Date date, int step)
	    {
    	 	Calendar cal = getCalendar();
	        Timestamp t = null;
	        if (date != null) 
	        {		        
	            cal.setTime(date);
	            cal.add(GregorianCalendar.MONTH , step);
	            t = new Timestamp(cal.getTime().getTime());
	        }
	        return t;
	    }
	    
	    /**
	     * 获得本月月份
	     * @return String
	     * */
	    public static String getMonth()
	    {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
	    	long currentTime = System.currentTimeMillis();
	        Timestamp ts = new Timestamp(currentTime);
	        return sdf.format(ts);
	    }
	    
	    /**  
	     * 得到本月的第一天
	     * @param strData 指定的某一月
	     * @return  Timestamp
	     */  
	    public static String getMonthFirstDay(String strData,int type) 
	    {   
	        Calendar cal = getCalendar();
	        Timestamp t = null;
	        String newTime = null;
	    	try
	    	{
	    		if(type == 0)
	    		{
			        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
			        Date date = dateFormat.parse(strData);
			        if (date != null) 
			        {
			        	cal.setTime(date);
			        	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
			        	t = new Timestamp(cal.getTime().getTime());
			        }
	    		}
	    		else
	    		{
	    			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
			        Date date = dateFormat.parse(getDay());
			        if (date != null) 
			        {
			        	cal.setTime(date);
			        	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
			        	t = new Timestamp(cal.getTime().getTime());
			        }
	    		}
	    		SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    			newTime = newDateFormat.format(t);
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    		return null;
	    	}
	    	return newTime;
	    }   
	      
	    /**  
	     * 得到本月的最后一天  
	     * @param strData 指定的某一月
	     * @return  Timestamp
	     */  
	    public static String getMonthLastDay(String strData,int type) 
	    {   
	    	Calendar cal = getCalendar();
	        Timestamp t = null;
	        String newTime = null;
	    	try
	    	{
	    		if(type == 0)
	    		{
			        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
			        Date date = dateFormat.parse(strData);
			        if (date != null) 
			        {
			        	cal.setTime(date);
			        	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			        	t = new Timestamp(cal.getTime().getTime());
			        }
	    		}
	    		else
	    		{
	    			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
			        Date date = dateFormat.parse(getDay());
			        if (date != null) 
			        {
			        	cal.setTime(date);
			        	cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			        	t = new Timestamp(cal.getTime().getTime());
			        }
	    		}
		        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		        newTime = newDateFormat.format(t);
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    		return null;
	    	}
	        return newTime;
	    }   


	    public static String format(Date date, String patten) 
	    {
	        String result = "";
	        try 
	        {
	            if (date != null && patten != null) 
	            {
	                SimpleDateFormat sdf = new SimpleDateFormat(patten);
	                result = sdf.format(date);
	            }
	        }
	        catch (Exception ex) 
	        {
	            log.error(ex.getMessage(), ex);
	        }
	        return result;
	    }

	    public static int getDayOfWeek(Date date) 
	    {
	        int result;
	        Calendar cal = getCalendar();
	        cal.setTime(date);
	        if (cal.get(Calendar.DAY_OF_WEEK) == 1) 
	        {
	            result = 6;
	        }
	        else 
	        {
	            result = cal.get(Calendar.DAY_OF_WEEK) - 2;
	        }
	        return result;
	    }

	    public static Timestamp dateToTimestamp(Date date) 
	    {
	        return new Timestamp(date.getTime());
	    }

	    public static Timestamp getOneDayOfWeek(Date date, int dayOfWeek) 
	    {
	        dayOfWeek %= 7;
	        if (dayOfWeek < 0)
	            dayOfWeek += 7;
	        int dow = getDayOfWeek(date);
	        return getDate(date, dayOfWeek - dow);
	    }

	    public static Timestamp clear(int field, Timestamp t) 
	    {
	        Calendar c = getCalendar();
	        c.setTime(t);
	        c.clear(field);
	        return new Timestamp(c.getTime().getTime());
	    }
	    
	    public static String convertFromEpoch(long epoch) 
	    {
	    	return sdf.format(new Date(epoch*1000));
	    }
	    
		public static String getDateFromMillSeconds(long minSeconds) 
		{ 
				Date   date   =   new   Date(); 
				try 
				{ 
					date.setTime(minSeconds); 
				} 
				catch(NumberFormatException nfe) 
				{ 
					log.error( "Input minSeconds: " + minSeconds + " not correct"); 
				}
				return sdf.format(date);
		}
		
		@SuppressWarnings("deprecation")
		public static String[] formatTimeInterval(Date beginTime,Date endTime)
		{
			String[] timeArr=new String[2];
			String y=String.valueOf(beginTime.getYear());
			SimpleDateFormat df=new SimpleDateFormat(y+"MMddHHmmssSSS");
			String beginFormat=df.format(beginTime);
			timeArr[0]=beginFormat;
			String y1=String.valueOf(endTime.getYear());
			SimpleDateFormat df1=new SimpleDateFormat(y1+"MMddHHmmssSSS");
			String endFormat=df1.format(endTime);
			timeArr[1]=endFormat;
			return timeArr;
		}

		public static int getMonthDiff(Calendar beginCal, Calendar endCal)
		{
			int m = (endCal.get(Calendar.MONTH)) - (beginCal.get(Calendar.MONTH));
			int y = (endCal.get(Calendar.YEAR)) - (beginCal.get(Calendar.YEAR));
			return y * 12 + m;
		}
		
		@SuppressWarnings("deprecation")
		public static int getMonthDiff(Date beginDate, Date endDate  )
		{
			int m = (endDate.getMonth() - beginDate.getMonth());
			int y = (endDate.getYear()) - (beginDate.getYear());
			return y * 12 + m;
		}
		
		
		//获得指定天数的前一天
		public static String formatDate(Date date,int step)
		{
			Calendar cal = getCalendar();
	        Timestamp t = null;
	        String formatDate = null;
	        if (date != null) 
	        {
	            cal.setTime(date);
	            cal.clear(Calendar.AM_PM);
	            cal.clear(Calendar.HOUR);
	            cal.clear(Calendar.HOUR_OF_DAY);
	            cal.clear(Calendar.MINUTE);
	            cal.clear(Calendar.SECOND);
	            cal.clear(Calendar.MILLISECOND);
	            cal.add(Calendar.DATE, step);
	            t = new Timestamp(cal.getTime().getTime());
	            formatDate = sdf.format(t).substring(0, 10);
	        }
	        return formatDate;
		}
		
		/**
		 * 将Date按照指定的格式格式化
		 * @param date 时间
		 * @param strFormat 格式化样式
		 * @return strDate
		 */
		public static String getFormatDate(Date date,String strFormat)
		{
		    if(date!=null||strFormat!=null||"".equals(strFormat))
		    {
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat);
	            return simpleDateFormat.format(date);
		    }
		    return null;
		}
		
		public static void main(String[] args) 
		{
			String time = DateTk.getMonthLastDay("",1);
			System.out.println(time);
		}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0           2016-4-04       jiangsong         create
 *  
 */