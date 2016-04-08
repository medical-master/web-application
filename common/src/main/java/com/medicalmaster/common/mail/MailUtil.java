package com.medicalmaster.common.mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MailUtil
{

    public static String    smtp = "SHASXM01";
    public static String    from = "保代通系统<brokeragechannel@aegon-cnooc.com>";

    // public static StringBuffer m_temp_str = new StringBuffer();

    protected static Logger log = LoggerFactory.getLogger(MailUtil.class);

    public MailUtil()
    {
    }

    public static boolean sent(String p_smtp,String p_from,String p_to,String p_cc,String p_bcc,String p_subject,String p_content,String[] p_filepath,String[] p_filename,String p_contenttype,String encode) throws Exception
    {
        return sent (p_smtp, p_from, p_to, p_cc, p_bcc, p_subject, p_content, p_filepath, p_filename, p_contenttype, false, encode);
    }

    /**
     * Send Message
     * 
     * @param smtp The value of smtp server address
     * @param from The value of message from
     * @param to The value of message to
     * @param cc The value of message cc
     * @param bcc The value of message bcc
     * @param subject The value of message subject
     * @param content The value of message content
     * @param filepath The value of attach information
     * @param filename The value of attach filename
     * @param contenttype content type "1": text/plain; "2": text/html
     * @return boolean
     */
    public static boolean sent(String smtp,String from,String to,String cc,String bcc,String subject,String content,String[] filepath,String[] filename,String contenttype,boolean p_auth,String encode) throws Exception
    {
        try
        {
            String _filename = ""; // attach file name
            String _filepath = ""; // attach file path

            Properties props = new Properties ();
            Session sendMailSession;
            Store store;
            Transport transport;

            InitialContext ctx = new javax.naming.InitialContext ();

            try
            {
                sendMailSession = (Session) ctx.lookup ("AegonMail");

                // for test start
                // Properties pro = sendMailSession.getProperties();
                // Iterator it = pro.entrySet().iterator();
                // m_temp_str = new StringBuffer();
                // while (it.hasNext())
                // {
                // Map.Entry entry = (Map.Entry) it.next();
                // Object key = entry.getKey();
                // Object value = entry.getValue();
                // m_temp_str.append("key:" + key + " value:" + value + "<br>\n");
                // System.out.println(key + ":" + value);
                // }
                // for test end

            }
            catch (NamingException ex)
            {

                // if (p_auth)
                // {
                // sendMailSession = Session.getInstance(props, new Authenticator()
                // {
                // protected PasswordAuthentication getPasswordAuthentication()
                // {
                // return new PasswordAuthentication(MailUtil.m_authname, MailUtil.m_authpwd);
                // }
                // });
                // props.put("mail.smtp.auth", "true");
                // }
                // else
                // {
                sendMailSession = Session.getInstance (props, null);
                // }
                props.put ("mail.smtp.host", smtp);

                log.error ("Error:Send Email" + ex.getMessage ());
            }

            MimeMessage newMessage = new MimeMessage (sendMailSession);

            Message[] msgs = new Message[1];

            int istart = from.indexOf ("<");
            int iend = from.indexOf (">");
            if (istart != -1 && iend != -1)
            {
                newMessage.setFrom (new InternetAddress (from.substring (istart + 1, iend),MimeUtility.encodeText (from.substring (0, istart), encode, null)));
            }
            else
            {
                newMessage.setFrom (new InternetAddress (from));
            }

            if (to != null && to.indexOf ("@") != -1)
            {
                to = to.replaceAll (",", ";");
                String[] astr = to.split (";");
                String[] astr_name = to.split (";");
                InternetAddress[] addrTo = new InternetAddress[astr.length];
                istart = -1;
                iend = -1;
                for ( int i = 0 ; i < addrTo.length ; i++ )
                {
                    istart = astr[i].indexOf ("<");
                    iend = astr[i].indexOf (">");
                    if (istart != -1 && iend != -1)
                    {
                        astr_name[i] = MimeUtility.encodeText (astr_name[i].substring (0, istart), "gbk", null);
                        astr[i] = astr[i].substring (istart + 1, iend);
                        addrTo[i] = new InternetAddress (astr[i],astr_name[i]);
                    }
                    else
                    {
                        addrTo[i] = new InternetAddress (astr[i]);
                    }
                }
                newMessage.setRecipients (Message.RecipientType.TO, addrTo);
            }
            if (cc != null && cc.indexOf ("@") != -1)
            {
                cc = cc.replaceAll (",", ";");
                String[] astr = cc.split (";");
                String[] astr_name = cc.split (";");
                InternetAddress[] addrCc = new InternetAddress[astr.length];
                istart = -1;
                iend = -1;
                for ( int i = 0 ; i < addrCc.length ; i++ )
                {
                    istart = astr[i].indexOf ("<");
                    iend = astr[i].indexOf (">");
                    if (istart != -1 && iend != -1)
                    {
                        astr_name[i] = MimeUtility.encodeText (astr_name[i].substring (0, istart), "gbk", null);
                        astr[i] = astr[i].substring (istart + 1, iend);
                        addrCc[i] = new InternetAddress (astr[i],astr_name[i]);
                    }
                    else
                    {
                        addrCc[i] = new InternetAddress (astr[i]);
                    }
                }
                newMessage.setRecipients (Message.RecipientType.CC, addrCc);
            }

            if (bcc != null && bcc.indexOf ("@") != -1)
            {
                bcc = bcc.replaceAll (",", ";");
                String[] astr = bcc.split (";");
                String[] astr_name = bcc.split (";");
                InternetAddress[] addrBcc = new InternetAddress[astr.length];
                istart = -1;
                iend = -1;
                for ( int i = 0 ; i < addrBcc.length ; i++ )
                {
                    istart = astr[i].indexOf ("<");
                    iend = astr[i].indexOf (">");
                    if (istart != -1 && iend != -1)
                    {
                        astr_name[i] = MimeUtility.encodeText (astr_name[i].substring (0, istart), encode, null);
                        astr[i] = astr[i].substring (istart + 1, iend);
                        addrBcc[i] = new InternetAddress (astr[i],astr_name[i]);
                    }
                    else
                    {
                        addrBcc[i] = new InternetAddress (astr[i]);
                    }
                }
                newMessage.setRecipients (Message.RecipientType.BCC, addrBcc);
            }

            newMessage.setSubject (MimeUtility.encodeText (subject, encode, null));
            newMessage.setSentDate (new Date ());
            transport = sendMailSession.getTransport ("smtp");

            // Create the message part
            MimeBodyPart messageBodyPart = new MimeBodyPart ();

            // Fill the message
            messageBodyPart.setText (content, encode);
            messageBodyPart.removeHeader ("Content-Type");
            messageBodyPart.removeHeader ("Content-Transfer-Encoding");

            if (contenttype.equalsIgnoreCase ("2"))
            {
                messageBodyPart.addHeader ("Content-Type", "text/html; charset=" + encode);
            }
            else
            {
                messageBodyPart.addHeader ("Content-Type", "text/plain; charset=" + encode);
            }

            messageBodyPart.addHeader ("Content-Transfer-Encoding", "base64");

            Multipart multipart = new MimeMultipart ();
            multipart.addBodyPart (messageBodyPart);

            // Part two is attachment
            FileDataSource source = null;
            int isize = 0;
            if (filepath != null)
            {
                isize = filepath.length;
            }
            for ( int i = 0 ; i < isize ; i++ )
            {
                messageBodyPart = new MimeBodyPart ();
                _filepath = filepath[i]; // get attach file info from vector file
                _filename = filename[i];

                source = new FileDataSource (_filepath); // get attatch data source
                messageBodyPart.setDataHandler (new DataHandler (source));
                messageBodyPart.setFileName (MimeUtility.encodeText (_filename, encode, null));
                messageBodyPart.removeHeader ("Content-Type");
                messageBodyPart.removeHeader ("Content-Transfer-Encoding");
                messageBodyPart.addHeader ("Content-Type", source.getContentType ());
                messageBodyPart.addHeader ("Content-Transfer-Encoding", "base64");

                multipart.addBodyPart (messageBodyPart);
            }
            // Put parts in message
            newMessage.setContent (multipart);
            newMessage.saveChanges ();

            transport.send (newMessage); // Send Message

            return true;

        }
        catch (Exception e)
        {
            e.printStackTrace ();
            throw e;
        }
    }

    // -- +V1.1 start
    public List receiveMail(String p_username,String p_pwd) throws Exception
    {
        try
        {
            Store _store = null;
            Folder _folder = null;
            String _mailContent = null;
            List _mailbox = new ArrayList ();
            // Session session = Session.getInstance(new Properties());
            Properties _props = new Properties ();
            Session _mailSession = null;
            InitialContext ctx = new javax.naming.InitialContext ();
            String _mailServer = null;

            try
            {
                _mailSession = (Session) ctx.lookup ("AegonMail");
                _mailServer = _mailSession.getProperty ("mail.smtp.host");
            }
            catch (NamingException ex)
            {
                _mailSession = Session.getInstance (_props, null);
                _mailServer = this.smtp;
            }

            _store = _mailSession.getStore ("pop3");
            _store.connect (_mailServer, p_username, p_pwd);
            _folder = _store.getDefaultFolder ();

            if (_folder == null) { throw new Exception ("No default folder"); }
            _folder = _folder.getFolder ("INBOX");
            if (_folder == null) { throw new Exception ("No POP3 INBOX"); }
            _folder.open (Folder.READ_WRITE);
            Message[] _msgs = _folder.getMessages ();
            for ( int i = 0 ; i < _msgs.length ; i++ )
            {
                // if (!_msgs[i].getFlags().contains(Flags.Flag.SEEN))
                if (!_msgs[i].isSet (Flags.Flag.SEEN))
                {
                    HashMap _mail = new HashMap ();

                    java.util.Date _sent_time = _msgs[i].getSentDate ();
                    if (_sent_time != null)
                    {
                        _mail.put ("SEND_TIME", new java.text.SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format (_sent_time));
                    }
                    else
                    {
                        _mail.put ("SEND_TIME", "");
                    }

                    java.util.Date _rev_time = _msgs[i].getReceivedDate ();
                    if (_rev_time != null)
                    {
                        _mail.put ("REV_TIME", new java.text.SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format (_rev_time));
                    }
                    else
                    {
                        _mail.put ("REV_TIME", "");
                    }

                    Address[] _to = _msgs[i].getRecipients (Message.RecipientType.TO);
                    StringBuffer _to_str = new StringBuffer ();
                    for ( int k = 0 ; k < _to.length ; k++ )
                    {
                        _to_str.append (_to[k].toString () + ";");
                    }

                    Address[] _cc = _msgs[i].getRecipients (Message.RecipientType.CC);
                    StringBuffer _cc_str = new StringBuffer ();
                    for ( int j = 0 ; j < _cc.length ; j++ )
                    {
                        _cc_str.append (_cc[j].toString () + ";");
                    }

                    _mail.put ("MAIL_FROM", _msgs[i].getFrom ());
                    _mail.put ("MAIL_TO", _to_str.toString ());
                    _mail.put ("MAIL_CC", _cc_str.toString ());
                    _mail.put ("SUBJECT", _msgs[i].getSubject ());

                    // 郑健添加保存附件 start
                    // 此处保存邮件内容及附件
                    // 郑健添加保存附件 end

                    _mailbox.add (_mail);
                    _msgs[i].setFlag (Flags.Flag.DELETED, true);

                }
            }

            // 关闭folder
            if (_folder != null && _folder.isOpen ())
            {
                _folder.close (true);
            }
            // 关闭Store
            if (_store != null && _store.isConnected ())
            {
                _store.close ();
                _store = null;
            }
            return _mailbox;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static void main(String[] args) throws Exception
    {
        /*
         * MailUtil _mail = new MailUtil();
         * 
         * BufferedReader _reader = null; String _tempString = null; StringBuffer _content = new StringBuffer(); File _file = new File("D:\\Project\\邮件平台\\test.html"); if (_file.exists()) { _reader =
         * new BufferedReader(new FileReader(_file)); while ((_tempString = _reader.readLine()) != null) { _content.append(_tempString); } _reader.close(); } System.out.println(_content.toString());
         * System.out.println(new Date());
         */

        // 带附件的邮件
        /*
         * try { for(int i = 0; i < 1000; i++) { System.out.println("第 " + i + "封邮件"); MailUtil.sent(MailUtil.smtp, MailUtil.from, "bobli@aegon-cnooc.com", null, null, "test", "test", null, null,
         * "2",true,"gb2312"); } } catch(Exception e) { e.printStackTrace(); } _mail.receiveMail("fshiti06@aegon-cnooc.com", "Savo$123"); String[] file = new String[2]; file[0] = "c:\\temp\\03.log";
         * file[1] = "c:\\temp\\timer.txt"; String[] filename = new String[]{"1.txt", "2.txt"}; MailUtil.sent(MailUtil.smtp, MailUtil.from, "EricLi@aegon-cnooc.com", null, null, "测试邮件", "正文内容", file,
         * filename, "2");
         */

        MailUtil.sent (MailUtil.smtp, MailUtil.from, "FSHITD31@aegon-cnooc.com", null, null, "test", "test", null, null, "2", "gb2312");
        System.out.println (new Date ());
    }
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  create
 */