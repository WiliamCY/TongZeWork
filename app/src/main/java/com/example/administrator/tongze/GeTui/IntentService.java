package com.example.administrator.tongze.GeTui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.example.administrator.tongze.Activity.LoginActivity;
import com.example.administrator.tongze.List.TouchuanList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.application.MyApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;

/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData 处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */
public class IntentService extends GTIntentService {
    private View view;
    private WindowManager wm;
    private boolean showWm =true;//默认是应该显示悬浮通知栏
    private WindowManager.LayoutParams params;
    private static final int PUSH_NOTIFICATION_ID = (0x001);
    private static final String PUSH_CHANNEL_ID = "PUSH_NOTIFY_ID";
    private static final String PUSH_CHANNEL_NAME = "PUSH_NOTIFY_NAME";
    /**
     * 为了观察透传数据变化.
     */
    private static int cnt;
    public IntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    @Override
    public void onReceiveMessageData(final Context context, GTTransmitMessage msg) {
        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String cid = msg.getClientId();
        // 第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
        boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
        Log.d(TAG, "call sendFeedbackMessage = " + (result ? "success" : "failed"));

        Log.d(TAG, "onReceiveMessageData -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nmessageid = " + messageid + "\npkg = " + pkg
                + "\ncid = " + cid);

        if (payload == null) {
            Log.e(TAG, "receiver payload = null"+payload);
        } else {
         String data = new String(payload);
            Log.d(TAG, "receiver" + data);
            final String content = data;
            final  String type = "标题";
             TouchuanList touchuanList = new Gson().fromJson(content,new TypeToken<TouchuanList>(){}.getType());
             final String userNmae = touchuanList.getUserName();
            if(MyLifecycleHandler.isApplicationVisible()){
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    Intent intent = new Intent("com.tongze.GETUI");
                        intent.putExtra("data","2");
                    sendOrderedBroadcast(intent,null);
                    }
                });
                Log.d(TAG,content);
            }else {
//                NotificationHelper.createNotification(TwoActivity.class,userNmae,type);
                showNotification(userNmae);
            }


        }

        Log.d(TAG, "----------------------------------------------------------------------------------------------");


    }
    private void showNotification(String userNmae) {
        NotificationManager notificationManager = (NotificationManager)
                this.getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(PUSH_CHANNEL_ID,
                    PUSH_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,null);
        Intent notificationIntent = new Intent(this, LoginActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        builder.setContentTitle("通知")//设置通知栏标题
                .setContentIntent(pendingIntent) //设置通知栏点击意图
                .setContentText(userNmae)
                .setTicker("通知") //通知首次出现在通知栏，带上升动画效果的
                .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                .setSmallIcon(R.mipmap.ic_launcher)//设置通知小ICON
                .setChannelId(PUSH_CHANNEL_ID)
                .setDefaults(Notification.DEFAULT_ALL)
                .getNotification();

        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        if (notificationManager != null) {
            notificationManager.notify(PUSH_NOTIFICATION_ID, notification);
        }
    }

    @Override
    public void onReceiveClientId(Context context, String s) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + s);
        MyApplication.Cid = s;
        Log.e("sssss", s);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {

    }


    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage msg) {
    }

    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage msg) {
    }
}
