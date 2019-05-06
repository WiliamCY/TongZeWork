package com.example.administrator.tongze.application;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;


import com.example.administrator.tongze.Entiy.LoginUser;
import com.example.administrator.tongze.GeTui.MyLifecycleHandler;
import com.example.administrator.tongze.GeTui.PushService;
import com.example.administrator.tongze.Retrofit.RetrofitUtil;
import com.example.administrator.tongze.Utils.fileDisplay.ExceptionHandler;
import com.igexin.sdk.PushManager;
import com.tencent.smtt.sdk.QbSdk;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * Created by admin on 2017/11/7.
 */

public class MyApplication extends Application {

    public static String phoneType = "Android";
    private static Context mContext;
    public static LoginUser loginUser;
    public static String Cid;
//    private static UploadManager uploadManager;
//
//    public static UploadManager getUploadManager() {
//        return uploadManager;
//    }

    @Override
    public void onCreate() {
        super.onCreate();
           try {
               RetrofitUtil.init(this);
           }catch (IOException e){
               e.printStackTrace();
           }
        QbSdk.initX5Environment(this, null);
        ExceptionHandler.getInstance().initConfig(this);
//        mContext = getApplicationContext();
//        loginUser = SPHelper.getUserMsg();
//        try {
//            RetrofitUtil.init(this);
//            //七牛服务器文件上传
//            Recorder recorder = null;
//            try {
//                recorder = new FileRecorder(this.getFilesDir().getAbsolutePath());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            KeyGenerator keyGenerator = new KeyGenerator() {
//                @Override
//                public String gen(String key, File file) {
//                    return UUID.randomUUID().toString();
//                }
//            };
//            //默认重试5次失败
//            Configuration config = new Configuration.Builder()
//                    .connectTimeout(10)
//                    .responseTimeout(60)
//                    .recorder(recorder, keyGenerator)
//                    .zone(Zone.zone0)
//                    .build();
//
//            uploadManager = new UploadManager(config);
//
//            //UIL 配置 图片加载
//            ImageLoaderConfiguration loaderConfigurationconfig = new ImageLoaderConfiguration.Builder(this)
//                    .threadPriority(Thread.NORM_PRIORITY - 2)
//                    .denyCacheImageMultipleSizesInMemory()
//                    .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
//                    .memoryCacheSize(2 * 1024 * 1024)
//                    .memoryCacheSizePercentage(13)
//                    // default
//                    .diskCacheFileNameGenerator(new Md5FileNameGenerator())
//                    .diskCacheSize(50 * 1024 * 1024)
//                    // 50 Mb
//                    .tasksProcessingOrder(QueueProcessingType.LIFO)
//                    // .writeDebugLogs() // Remove for release app
//                    .build();
//            com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(loaderConfigurationconfig);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(mContext, "服务器未响应", Toast.LENGTH_SHORT);
//        }
        mContext = getApplicationContext();
        registerActivityLifecycleCallbacks(new MyLifecycleHandler());
        PushManager.getInstance().initialize(this.getApplicationContext(), PushService.class);
        try {
            RetrofitUtil.init(this);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "服务器未响应", Toast.LENGTH_SHORT);
        }
    }

    public static Context getmContext() {
        return mContext;
    }
}