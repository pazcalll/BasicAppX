package org.aplas.basicappx;

public class Distance {
    private double meter;

    public Distance() {
        this.meter = 0;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public void setInch(double inch){
        this.meter = inch/39.3701;
    }

    public void setMile(double mile){
        this.meter = mile/0.000621371;
    }

    public void  setFoot(double foot){
        this.meter = foot/3.28084;
    }

    public double getMeter() {
        return meter;
    }

    public double getInch(){
        return this.meter * 39.3701;
    }

    public double getMile(){
        return this.meter * 0.000621371;
    }

    public double getFoot(){
        return this.meter * 3.28084;
    }

    public double convert(String oriUnit, String convUnit, double oriValue){
        if (oriUnit.equalsIgnoreCase("mtr")){
            setMeter(oriValue);
            if (convUnit.equalsIgnoreCase("mtr")){
                oriValue = getMeter();
            }
            else if (convUnit.equalsIgnoreCase("inc")){
                oriValue = getInch();
            }
            else if(convUnit.equalsIgnoreCase("mil")){
                oriValue = getMile();
            }
            else if(convUnit.equalsIgnoreCase("ft")){
                oriValue = getFoot();
            }
        }
        else if (oriUnit.equalsIgnoreCase("inc")){
            setInch(oriValue);
            if (convUnit.equalsIgnoreCase("mtr")){
                oriValue = getMeter();
            }
            else if (convUnit.equalsIgnoreCase("inc")){
                oriValue = getInch();
            }
            else if(convUnit.equalsIgnoreCase("mil")){
                oriValue = getMile();
            }
            else if(convUnit.equalsIgnoreCase("ft")){
                oriValue = getFoot();
            }
        }
        else if (oriUnit.equalsIgnoreCase("mil")){
            setMile(oriValue);
            if (convUnit.equalsIgnoreCase("mtr")){
                oriValue = getMeter();
            }
            else if (convUnit.equalsIgnoreCase("inc")){
                oriValue = getInch();
            }
            else if(convUnit.equalsIgnoreCase("mil")){
                oriValue = getMile();
            }
            else if(convUnit.equalsIgnoreCase("ft")){
                oriValue = getFoot();
            }
        }
        else if (oriUnit.equalsIgnoreCase("ft")){
            setFoot(oriValue);
            if (convUnit.equalsIgnoreCase("mtr")){
                oriValue = getMeter();
            }
            else if (convUnit.equalsIgnoreCase("inc")){
                oriValue = getInch();
            }
            else if(convUnit.equalsIgnoreCase("mil")){
                oriValue = getMile();
            }
            else if(convUnit.equalsIgnoreCase("ft")){
                oriValue = getFoot();
            }
        }
        return oriValue;
    }

}
