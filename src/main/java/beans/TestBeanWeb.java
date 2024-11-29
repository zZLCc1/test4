package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;


@Named(value = "testBean")
@RequestScoped
public class TestBeanWeb
{
private String farheneitTemperature;
private String celciusTemperature;
private String testInput;

    public String getTestInput() {
        return testInput;
    }

    public void setTestInput(String testInput) {
        System.out.println("setTestInput setter called");
        this.testInput = testInput;
    }


private String miles;

    public String getMiles()
    {
        return miles;
    }

    public void setMiles(String miles)
    {
        System.out.println("miles: " + miles);
        this.miles = miles;
    }
    
    public String milesToKilometers()
    {
        if  ( this.miles == null )
            return null;
        double miles = Double.parseDouble( this.miles );
        double km = miles * 1.65;
        return String.valueOf(km);      
    }


    public String getFarheneitTemperature(){return farheneitTemperature;}

    public void setFarheneitTemperature(String farheneitTemperature)
    {
        this.farheneitTemperature = farheneitTemperature;
        System.out.println("setter: " + this.farheneitTemperature);
        this.celciusTemperature = convertFtoC();
    }
    public String getCelciusTemperature(){return celciusTemperature;}  
    private String convertFtoC()
    {
        double f = Double.parseDouble( this.farheneitTemperature );
        double c = (f - 32) * ( 5.0 / 9.0);
        System.out.println("far: " + this.farheneitTemperature);
        System.out.println("convert " + c);
        celciusTemperature = String.valueOf(c);
        return celciusTemperature;
    }

  
    
}
