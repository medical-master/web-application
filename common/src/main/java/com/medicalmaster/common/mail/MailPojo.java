package com.medicalmaster.common.mail;

public class MailPojo
{

    public static String MAIL_ADDRESSEE = "FSHITD31@aegon-cnooc.com,FSHITD11@aegon-cnooc.com,LiAijun@aegon-cnooc.com"; // simonshen@aegon-cnooc.com,bobli@aegon-cnooc.com,
    public static String MAIL_CC        = "";

    public static String getMailContent(String mailContent)
    {
        StringBuffer buffer = new StringBuffer ();
        buffer.append ("<div class=Section1 style='layout-grid:15.6pt'><p class=MsoNormal style='layout-grid-mode:char'><font size=1 face=Arial>");
        buffer.append ("<span lang=EN-US style='font-size:9.0pt;font-family:Arial;'>Dear </span></font>");
        buffer.append ("<font size=1 face=宋体><span style='font-size:9.0pt;font-family:宋体;'>：");
        buffer.append ("<span lang=EN-US><o:p></o:p></span></span></font></p>");
        buffer.append ("<p class=MsoNormal style='text-indent:18.0pt;layout-grid-mode:char'><font size=1 face=宋体>");
        buffer.append ("<span style='font-size:9.0pt;font-family:宋体;'>");
        buffer.append (mailContent);
        buffer.append ("</span></font>");
        buffer.append ("<span lang=EN-US style='background:silver'><o:p></o:p></span></p>");
        buffer.append ("<p class=MsoNormal style='layout-grid-mode:char'><font size=1 color=navy face=宋体>");
        buffer.append ("<span lang=EN-US style='font-size:9.0pt;font-family:宋体;color:navy'><o:p>&nbsp;</o:p></span></font></p>");
        buffer.append ("<p class=MsoNormal style='layout-grid-mode:char'><font size=1 color=navy face=宋体>");
        buffer.append ("<span lang=EN-US style='font-size:9.0pt;font-family:宋体;color:navy'>");
        buffer.append ("<p class=MsoNormal style='layout-grid-mode:char'><font size=1 color='#0079c1' face=黑体>");
        buffer.append ("<span style='font-size:9.0pt;font-family:黑体;color:#0079C1'>海康人寿保险有限公司</span></font>");
        buffer.append ("<font size=1 color='#0079c1' face=Arial><span lang=EN-US style='font-size:9.0pt;font-family:Arial;color:#0079C1'>");
        buffer.append ("<o:p></o:p></span></font></p>");
        buffer.append ("<p class=MsoNormal style='layout-grid-mode:char'><font size=1 color='#717074' face=黑体>");
        buffer.append ("<span style='font-size:9.0pt;font-family:黑体;color:#717074'>全国统一服务热线</span></font>");
        buffer.append ("<font size=1 color='#717074' face=Arial><span lang=EN-US style='font-size:9.0pt;font-family:Arial;color:#717074'>");
        buffer.append (": 95105768&nbsp;&nbsp; www.aegon-cnooc.com<o:p></o:p></span></font></p>");
        buffer.append ("<p class=MsoNormal style='layout-grid-mode:char'><font size=1 color='#717074'face=黑体>");
        buffer.append ("<span style='font-size:9.0pt;font-family:黑体;color:#717074'>由荷兰全球人寿和中国海油合资组建</span></font>");
        buffer.append ("<span lang=EN-US><o:p></o:p></span></p><p class=MsoNormal><font size=1 face=Arial><span lang=EN-US style='font-size:9.0pt;font-family:Arial'>");
        buffer.append ("<o:p>&nbsp;</o:p></span></font></p></div>");
        return buffer.toString ();
    }

    public static String getMailSubject(int mailType)
    {
        String mail_subject = null;
        switch (mailType)
        {
            case 1:
                mail_subject = "XXXXXXX系统";
                break;
            case 2:
                mail_subject = "XXXXXXX系统";
                break;
        }
        return mail_subject;
    }
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  create
 */