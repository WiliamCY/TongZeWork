package com.example.administrator.tongze.Utils;

import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class util {
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches() + "---");
        return m.matches();
    }

    public static void showMyToast(final Toast toast, final int cnt) {
        final Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        },0,500);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt );
    }
    public static String getErrorMesg(int event){
        switch (event) {
            case 200:
                return "操作成功";
            case 400:
                return "服务器访问错误";
            case 401:
                return "用户认证错误";
            case 402:
                return "手机号码错误或验证码错误，短信验证失败";
            case 403:
                return "芝麻信用访问出错，请检查身份信息";
            case 601:
                return "手机服务密码输入错误";
            case 602:
                return "手机号码格式不正确";
            case 603:
                return "服务密码错误次数超过上限";
            case 604:
                return "身份证信息有误";
            case 605:
                return "客服密码输入错误";
            case 606:
                return "客服密码错误或其他错误";
            case 607:
                return "请求错误";
            default:
                return "未知错误";
        }
    }


}
