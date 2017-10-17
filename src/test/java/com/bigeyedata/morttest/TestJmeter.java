package com.bigeyedata.morttest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJmeter {

    public static void main(String[] args) {



        String responseStr = "\"id\":\"d03acdf3-946e-4de0-8a14-50dacf9f81d2\",\"codeName\":\"mort0\",\"displayName\":\"Id_C\",\"fieldName\":\"Id_C\"";
        String regEx = "\"id\":\"(.+?)\",\"codeName\":\"(.+?)\",\"displayName\":\"(.+?)\",\"fieldName\":\"(.+?)\"";
        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(responseStr);

        String OrderNo_cars_FieldId="";

        int groupCount = 0;
        while(matcher.find()) {
            groupCount = groupCount + 1;
            switch (matcher.group(4)) {
                case "OrderNo":
                    OrderNo_cars_FieldId = matcher.group(1);
                    break;
            }
        }
        System.out.println("OrderNo_cars_FieldId:" + OrderNo_cars_FieldId);
    }
}
