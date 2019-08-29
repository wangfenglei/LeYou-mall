package com.leyou.common.utils;


/**
 * @author wfl
 * @description
 */
public class Md5UtilsTest {

    public static void main(String[] args){
        //String generate = Md5Utils.generate();
        //System.out.println("generate = " + generate);

        String str = "11ec27e24c5c4c3c76a8e47a2391b31f";
        //String s = Md5Utils.encryptPassword("123456", generate);

        String s = Md5Utils.encryptPassword("123456", "9760348891585893");

        System.out.println("s = " + s);

    }

}