package com.Test;

import cn.hutool.crypto.digest.DigestUtil;
import com.sun.mail.smtp.DigestMD5;

public class MD5 {
    public static void main(String[] args) {
        String pwd = "123456";
        String str = DigestUtil.md5Hex(pwd);
        System.out.println(str);
    }
}
