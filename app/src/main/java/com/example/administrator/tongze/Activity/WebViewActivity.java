package com.example.administrator.tongze.Activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Utils.fileDisplay.LoadFileModel;
import com.example.administrator.tongze.Utils.fileDisplay.Md5Tool;
import com.example.administrator.tongze.Utils.fileDisplay.SuperFileView2;
import com.jaeger.library.StatusBarUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebViewActivity extends AppCompatActivity {
    @BindView(R.id.bat_back)
    ImageView batBack;
    @BindView(R.id.bar_name)
    TextView barName;
    private String TAG = "WebViewActivity";
    String filePath;
    @BindView(R.id.mSuperFileView)
    SuperFileView2 mSuperFileView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        ButterKnife.bind(this);
        mSuperFileView.setOnGetFilePathListener(new SuperFileView2.OnGetFilePathListener() {
            @Override
            public void onGetFilePath(SuperFileView2 mSuperFileView2) {
                getFilePathAndShowFile(mSuperFileView2);
            }
        });
        String path = getIntent().getStringExtra("uri");
        String name = getIntent().getStringExtra("name");
        barName.setText(name);
        if (!TextUtils.isEmpty(path)) {
            setFilePath(path);
        }
        mSuperFileView.show();


    }

    public void setFilePath(String fileUrl) {
        Log.i(TAG, "setFilePath" + fileUrl);
        this.filePath = fileUrl;
    }

    private String getFilePath() {
        return filePath;
    }

    private void getFilePathAndShowFile(SuperFileView2 mSuperFileView2) {


        if (getFilePath().contains("http")) {//网络地址要先下载

            downLoadFromNet(getFilePath(), mSuperFileView2);

        } else {
            mSuperFileView2.displayFile(new File(getFilePath()));
        }
    }


    private void downLoadFromNet(final String url, final SuperFileView2 mSuperFileView2) {

        //1.网络下载、存储路径、
        File cacheFile = getCacheFile(url);
        if (cacheFile.exists()) {
            if (cacheFile.length() <= 0) {

                cacheFile.delete();
                return;
            }
        }


        LoadFileModel.loadPdfFile(url, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                boolean flag;
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    ResponseBody responseBody = response.body();
                    is = responseBody.byteStream();
                    long total = responseBody.contentLength();

                    File file1 = getCacheDir(url);
                    if (!file1.exists()) {
                        file1.mkdirs();

                    }


                    //fileN : /storage/emulated/0/pdf/kauibao20170821040512.pdf
                    File fileN = getCacheFile(url);//new File(getCacheDir(url), getFileName(url))


                    if (!fileN.exists()) {
                        boolean mkdir = fileN.createNewFile();
                    }
                    fos = new FileOutputStream(fileN);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);

                    }
                    fos.flush();

                    //2.ACache记录文件的有效期
                    mSuperFileView2.displayFile(fileN);
                } catch (Exception e) {

                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                File file = getCacheFile(url);
                if (!file.exists()) {

                    file.delete();
                }
            }
        });


    }

    /***
     * 获取缓存目录
     *
     * @param url
     * @return
     */
    private File getCacheDir(String url) {

        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/006/");

    }

    /***
     * 绝对路径获取缓存文件
     *
     * @param url
     * @return
     */
    private File getCacheFile(String url) {
        File cacheFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/006/"
                + getFileName(url));

        return cacheFile;
    }

    /***
     * 根据链接获取文件名（带类型的），具有唯一性
     *
     * @param url
     * @return
     */
    private String getFileName(String url) {
        String fileName = Md5Tool.hashKey(url) + "." + getFileType(url);
        return fileName;
    }

    /***
     * 获取文件类型
     *
     * @param paramString
     * @return
     */
    private String getFileType(String paramString) {
        String str = "";

        if (TextUtils.isEmpty(paramString)) {

            return str;
        }

        int i = paramString.lastIndexOf('.');
        if (i <= -1) {

            return str;
        }


        str = paramString.substring(i + 1);

        return str;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mSuperFileView != null) {
            mSuperFileView.onStopDisplay();
        }
    }

    @OnClick({R.id.bat_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bat_back:
                finish();
                break;

        }
    }
}