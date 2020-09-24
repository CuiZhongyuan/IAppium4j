package com.iappium.utils;

import org.testng.annotations.Test;

import java.util.HashMap;
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


    @Test
    private void getStr(){
        String text  = "controllerModel: \"33\"\n" +
                "controllerProdUnitId: \"e197ebb9e9584e50ba67ed3ff3264f90\"\n" +
                "driveColdMode: 0\n" +
                "driveType: 1\n" +
                "maxElectricity: 22\n" +
                "maxOutputTorque: 123\n" +
                "maxRotateSpeed: 132\n" +
                "name: \"qddjxh\"\n" +
                "peakPower: 66\n" +
                "peakRotateSpeed: 88\n" +
                "peakTorque: 10\n" +
                "prodUnitId: \"e197ebb9e9584e50ba67ed3ff3264f90\"\n" +
                "ratedPower: 55\n" +
                "ratedRotateSpeed: 77\n" +
                "ratedTorque: 99\n" +
                "ratedVoltage: 11\n" +
                "validPower: 44";
        HashMap<String,String> map = new HashMap<>();
        map = str2map(text);

        String content = "";

        for(String key:map.keySet()){//keySet获取map集合key的集合  然后在遍历key即可
            String value = map.get(key).toString();//
            content = content + "map.put(\""+ key+ "\",\"" + value+"\");\n";
        }
        System.out.println(content);
    }
    public static HashMap<String,String>str2map(String paramsStr){
        HashMap<String,String> map = new HashMap<>();
        String[] tempArray = paramsStr.split("\n");
        for (String item:tempArray){
            String key = item.split(":")[0];
            String value;
            if(key.equals("createTime")){
                value = item.split(":")[1]+":"+item.split(":")[2]+":"+item.split(":")[3];
                value = value.replace("\"","").trim();
            }else{
                value = item.split(":")[1].trim().equals("null")?null:item.split(":")[1].trim().replace("\"","");
            }
            map.put(key,value);
        }
        return map;
    }
}
