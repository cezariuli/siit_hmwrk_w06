package org.example;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    //create a Map between the metric unit (key) and a power of 10 (value) that will be used for conversion between units
    private Map<String, Integer> unitsMapping = new HashMap<String, Integer>();

    public Calculator() {
        unitsMapping.put("mm", 0);
        unitsMapping.put("cm", 1);
        unitsMapping.put("dm", 2);
        unitsMapping.put("m", 3);
        unitsMapping.put("km", 6);
    }

    public String calculate (String ex, String unit) {
        String retMessage = "";
        Double tmp = 0.0;

        //first thing test if expression contains only valid operands
        if ( (ex.contains("+") || ex.contains("-")) &&
                !( ex.contains("*") || ex.contains("/") || ex.contains("%")))
        {
            //split the input expression into an array of sub-strings by using space " " as a delimeter
            //i.e. string "10 cm + 2 mm" will result into an array of substrings {"10", "cm", "+", "2", "mm"}
            String[] s = ex.split(" ");

            tmp = convertUnit(Double.parseDouble(s[0]), s[1], unit);
            for (int i = 2; i < s.length; i++) {
                if ( s[i].equals("+")) {
                    tmp += convertUnit(Double.parseDouble(s[i+1]), s[i+2], unit);
                } else
                    if (s[i].equals("-")){
                        tmp -= convertUnit(Double.parseDouble(s[i+1]), s[i+2], unit);
                    }
            }

            System.out.println(retMessage.concat(String.valueOf(tmp) + unit));
        } else {
            retMessage = "Given expression contains invalid operands.";
        }
        return retMessage;
    }

    private Double convertUnit(Double number, String fromUnit, String toUnit) {

            return number * Math.pow(10, (double)(unitsMapping.get(fromUnit) - unitsMapping.get(toUnit)));
        }

}
