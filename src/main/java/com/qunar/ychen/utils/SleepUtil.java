/*
* Copyright (c) 2016 Jiulvxing.com. All Rights Reserved.
*/
package com.qunar.ychen.utils;

/**
 * ychen  Date: 11/7/16 Time: 3:22 PM
 */
public class SleepUtil {
    public static void sleep(String sleep) {
        try {
            Thread.sleep(Long.parseLong(sleep));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
