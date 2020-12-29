package org.aplas.basicappx;

public class Temperature {
    private double celcius;

    public Temperature() {
        celcius = 0;
    }

    public void setCelcius(double celsius){
        this.celcius = celsius;
    }

    public void setFahrenheit(double fahrenheit){
        this.celcius = (fahrenheit - 32) / 9*5;
    }

    public void setKelvins(double kelvin){
        this.celcius = kelvin - 273.15;
    }

    public double getCelcius(){
        return this.celcius;
    }

    public double getFahrenheit(){
        return this.celcius * 9/5 + 32;
    }

    public double getKelvins(){
        return this.celcius +273.15;
    }

    public double convert(String oriUnit, String convUnit, double oriValue){
        if (oriUnit.equalsIgnoreCase("°C")){

            setCelcius(oriValue);

            if (convUnit.equalsIgnoreCase("°C")){
                oriValue = getCelcius();
            }
            else if (convUnit.equalsIgnoreCase("°F")){
                oriValue = getFahrenheit();
            }
            else if (convUnit.equalsIgnoreCase("K")){
                oriValue =  getKelvins();
            }
        }
        else if (oriUnit.equalsIgnoreCase("°F")){
            setFahrenheit(oriValue);
            if (convUnit.equalsIgnoreCase("°C")){
                oriValue = getCelcius();
            }
            else if(convUnit.equalsIgnoreCase("°F")){
                oriValue = getFahrenheit();
            }
            else if(convUnit.equalsIgnoreCase("K")){
                oriValue = getKelvins();
            }
        }
        else if(oriUnit.equalsIgnoreCase("K")){
            setKelvins(oriValue);
            if (convUnit.equalsIgnoreCase("°C")){
                oriValue = getCelcius();
            }
            else if(convUnit.equalsIgnoreCase("°F")){
                oriValue = getFahrenheit();
            }
            else if(convUnit.equalsIgnoreCase("K")){
                oriValue = getKelvins();
            }
        }
        return oriValue;
    }
}
