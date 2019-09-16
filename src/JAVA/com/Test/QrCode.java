package com.Test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

public class QrCode {
    public static void main(String[] args) {
        QrCodeUtil.generate("user:admin password123456", 300, 300, FileUtil.file("d:/IDEA Project/New/src/main/webapp/img/qrcode.jpg"));
                            //跳转位置                          生成的二维码长宽                    二维码保存位置
    }

}
