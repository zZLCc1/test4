package utilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author asdv5
 */
public class Utilities
{
    public static String simpleDateFormat( Date date)
    {
    if ( date == null )
        return null;
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  hh:mm");
     String s = sdf.format( date);   
     return s;
    }

    public static void addMessage(FacesMessage.Severity severity, String summary, String detail)
    {
        FacesMessage msg = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void clearAllMessages()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Iterator<FacesMessage> it = context.getMessages();
        while (it.hasNext())
        {
            it.next();
            it.remove();
        }
    }

}
