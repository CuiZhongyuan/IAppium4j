package com.iappium.utils;

import org.testng.annotations.Test;

import java.util.Map;

public class Json2MapUtil {
    @Test
    private void getGang(){
        String text  = "controllerModel: \"33\"\n" +
                "controllerProdUnitId: \"e197ebb9e9584e50ba67ed3ff3264f90\"\n" +
                "driveColdMode: 0\n" +
                "driveType: 1\n" +
                "maxElectricity: 22\n" +
                "maxOutputTorque: 123\n" +
                "validPower: 44";

        pritMap(text);

    }

    void pritMap(String paramsStr){

        //Deprecated
        for (String item:paramsStr.split("\n"))
            System.out.println("map.put(\""+item.split(": ")[0]+"\",\""+item.split(": ")[1].replace("\"","")+"\");");
    }
}
