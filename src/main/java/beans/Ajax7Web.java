package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Named;
import utilities.Utilities;


@Named(value = "ajax7")
@RequestScoped
public class Ajax7Web
{
private String farheneitTemperature;
private String celciusTemperature;
private String miles;
private String km;

    public String getMiles()
    {
        return miles;
    }

    public void setMiles(String miles)
    {
        this.miles = miles;
        this.km = milesToKilometers();
        Utilities.addMessage(FacesMessage.SEVERITY_INFO, "miles=" + miles, "kilometers=" + km);
    }
    
    public String milesToKilometers()
    {
        if  ( this.miles == null || "".equals(miles) )
            return null;
        double miles = Double.parseDouble( this.miles );
        double km = miles * 1.65;
        this.km = String.valueOf(km);
        return this.km;      
    }

    public String getFarheneitTemperature(){return farheneitTemperature;}

    public void setFarheneitTemperature(String farheneitTemperature)
    {
        this.farheneitTemperature = farheneitTemperature;
        this.celciusTemperature = convertFtoC();
        Utilities.addMessage(FacesMessage.SEVERITY_INFO, "farheneit=" + farheneitTemperature, "celcius=" + celciusTemperature);
    }
    public String getCelciusTemperature(){
        return celciusTemperature;
    }  
   
    private String convertFtoC()
    {
        if ( "".equals(this.farheneitTemperature ) ||farheneitTemperature == null )
            return "";
        double f = Double.parseDouble( this.farheneitTemperature );
        double c = (f - 32) * ( 5.0 / 9.0);
        celciusTemperature = String.valueOf(c);
        return celciusTemperature;
    }
}