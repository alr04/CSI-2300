public class Converter {

    double value;
    String unit; 

    Converter(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }


    public static Converter ConvertedOutput(Converter aConverter) {
        
        switch (aConverter.unit.toLowerCase().strip()) {
            case "g": 
            aConverter.unit = "oz";
            aConverter.value = aConverter.value * 0.035;
            return aConverter;

            case "kg": 
            aConverter.unit = "lb";
            aConverter.value = aConverter.value * 2.2;
            return aConverter;
            
            case "mm": 
            aConverter.unit = "in";
            aConverter.value = aConverter.value * 0.04;
            return aConverter;
            
            case "km": aConverter.unit = "mi";
            aConverter.value = aConverter.value * 0.62;
            return aConverter;

        }

        return aConverter;

    }

    
}
