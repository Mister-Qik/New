package com.Test;

import cn.hutool.http.HttpUtil;

public class GetBaidu {
    public static void main(String[] args) {
        String str = HttpUtil.get("https://www.baidu.com");
        System.out.println(str);

    }

}
