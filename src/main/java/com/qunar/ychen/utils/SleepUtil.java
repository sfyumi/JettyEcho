/*
* Copyright (c) 2016 Jiulvxing.com. All Rights Reserved.
*/
package com.qunar.ychen.utils;

/**
 * ychen  Date: 11/7/16 Time: 3:22 PM
 */
public class SleepUtil {
    public static String sleep(String sleep) {
        try {
            Long sleepMillis = 1000l;
            try {
                sleepMillis = Long.parseLong(sleep);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            System.out.println("sleep ".concat(sleep));
            Thread.sleep(sleepMillis);
            return String.valueOf(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "0";
        }
    }
}
