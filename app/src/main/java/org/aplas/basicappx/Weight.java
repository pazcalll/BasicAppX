package org.aplas.basicappx;

public class Weight {
    private double gram;

    public Weight() {
        this.gram = 0;
    }

    public void setGram(double gram) {
        this.gram = gram;
    }

    public void setOunce(double ounce){
        this.gram = ounce/0.03527396195;
    }

    public void setPound(double pound){
        this.gram = pound/0.00220462262185;
    }

    public double getGram(){
        return this.gram;
    }

    public double getOunce(){
        return this.gram*0.03527396195;
    }

    public double getPound(){
        return this.gram*0.00220462262185;
    }

    public double convert(String oriUnit, String convUnit, double oriValue){
        if (oriUnit.equalsIgnoreCase("grm")){

            setGram(oriValue);

            if (convUnit.equalsIgnoreCase("grm")){
                oriValue = getGram();
            }
            else if (convUnit.equalsIgnoreCase("onc")){
                oriValue = getOunce();
            }
            else if (convUnit.equalsIgnoreCase("pnd")){
                oriValue =  getPound();
            }
        }
        else if (oriUnit.equalsIgnoreCase("onc")){

            setOunce(oriValue);

            if (convUnit.equalsIgnoreCase("grm")){
                oriValue = getGram();
            }
            else if (convUnit.equalsIgnoreCase("onc")){
                oriValue = getOunce();
            }
            else if (convUnit.equalsIgnoreCase("pnd")){
                oriValue =  getPound();
            }
        }
        else if (oriUnit.equalsIgnoreCase("pnd")){

            setPound(oriValue);

            if (convUnit.equalsIgnoreCase("grm")){
                oriValue = getGram();
            }
            else if (convUnit.equalsIgnoreCase("onc")){
                oriValue = getOunce();
            }
            else if (convUnit.equalsIgnoreCase("pnd")){
                oriValue =  getPound();
            }
        }
        return oriValue;
    }
}
