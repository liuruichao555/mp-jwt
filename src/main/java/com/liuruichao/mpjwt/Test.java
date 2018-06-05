package com.liuruichao.mpjwt;

import java.util.Date;

/**
 * Test
 *
 * @author liuruichao
 * Created on 2018/6/5 18:17
 */
public class Test {
    public static void main(String[] args) {
        Long timestamp = 1311281970L;
        Date date = new Date(timestamp);
        System.out.println(date.toString());
    }
}
