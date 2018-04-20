package test;

import edu.myalimoney.util.MD5Util;

public class Test5 {

    public static void main(String[] args) {
        String pwd = "123456";
        String md5_pwd = MD5Util.string2MD5(pwd);
        System.out.println("MD5后: " + md5_pwd);

        String convert_pwd = MD5Util.convertMD5(MD5Util.convertMD5(md5_pwd));
        System.out.println("解密后：" + convert_pwd);
    }

}
