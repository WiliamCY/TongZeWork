package com.example.administrator.tongze.Activity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.tongze.Utils.DialogHelp;
import com.example.administrator.tongze.Utils.PermissionsChecker;
import com.example.administrator.tongze.broadcast.GetuiBroadcast;

import java.util.HashMap;
import java.util.Map;


public class BaseTemplateActivity extends AppCompatActivity implements View.OnClickListener {
    //对话框是否可见
    protected boolean _isVisiable;
    //进度对话框
    private ProgressDialog _waitDialog;
    protected LayoutInflater _infalter;
    protected ActionBar _actionbar;


    private Map<Integer, Runnable> allowablePermissionRunnables = new HashMap<>();
    private Map<Integer, Runnable> disallowablePermissionRunnables = new HashMap<>();
    private GetuiBroadcast getuiBroadcast;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeSetContentLayout();
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        _infalter = getLayoutInflater();
        init(savedInstanceState);
        initView();
        initData();
        getuiBroadcast = new GetuiBroadcast();
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.tongze.GETUI");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(getuiBroadcast,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(getuiBroadcast);
    }


    @Override
    protected void onStart() {
        super.onStart();
        _isVisiable = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        _isVisiable = false;
    }

    /**
     * 设置内容之前设置窗体大小
     */
    protected void onBeforeSetContentLayout() {
        if (fullScreen()) {
            showStatusBar();
        }
    }

    private void hideStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
    }

    private void showStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
    }

    protected void init(Bundle savedInstanceState) {
    }

    public void initView() {

    }

    public void initData() {

    }

    protected int getLayoutId() {
        return 0;
    }

    protected boolean fullScreen() {
        return false;
    }

    protected View inflateView(int resId) {
        return _infalter.inflate(resId, null);
    }

    protected boolean hasBackButton() {
        return false;
    }

    protected String getActionBarTitle() {
        return "";
    }


    public ProgressDialog showWaitDialog(int resid) {
        return showWaitDialog(getString(resid));
    }

    public ProgressDialog showWaitDialog(String message) {
        if (_isVisiable) {
            if (_waitDialog == null) {
                _waitDialog = DialogHelp.getWaitDialog(this, message);
            }
            if (_waitDialog != null) {
                _waitDialog.setMessage(message);
                if (!_waitDialog.isShowing())
                    _waitDialog.show();
            }
            return _waitDialog;
        }
        return null;
    }

    public void changeProgressMsg(String str) {
        if (_isVisiable && _waitDialog != null) {
            try {
                _waitDialog.setMessage(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void hideWaitDialog() {
        if (_isVisiable && _waitDialog != null) {
            try {
                _waitDialog.dismiss();
                _waitDialog = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void showErrToast(Throwable t) {
        String msg = t.getMessage();
        if (!TextUtils.isEmpty(msg)) {
            showToast(msg);
        } else
            showToast(t.getMessage());
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public boolean showToast(int event) {
        if (event == 200) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 是否所有权限都授权了
     *
     * @param grantResults
     * @return
     */
    private boolean hasAllPermissionsGranted(@NonNull int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 请求一组权限
     *
     * @param requestCode
     * @param permissions
     */
    public void requestPermissions(int requestCode, String... permissions) {
        if (PermissionsChecker.lacksPermissions(this, permissions)) {
            ActivityCompat.requestPermissions(this, permissions, requestCode);
        } else {
            allPermissionsAllow(requestCode);
        }
    }


    /**
     * 授权成功时需要调用的方法
     *
     * @param requestCode
     */
    protected void allPermissionsAllow(int requestCode) {

    }

    /**
     * 授权拒绝,根据不同的requestCode进行不同的处理
     *
     * @param requestCode
     */
    protected void permissionDeny(int requestCode) {

    }

    /**
     * 通过URL跳转到activity scheme://activity?params1=xxx&params2=xxx
     *
     * @param urlSchema
     */
    public void startActivity(String urlSchema) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlSchema)));
    }

    public void startActivityForResult(String urlSchema, int requestCode) {
        startActivityForResult(new Intent(Intent.ACTION_VIEW, Uri.parse(urlSchema)), requestCode);
    }

    /**
     * 获取查询参数
     * milk://login?p1=xxxx&p2=xx getParams("p1") return 'xxxx'
     *
     * @param key
     * @return
     */
    public String getQueryParameter(String key) {
        Intent intent = getIntent();
        if (intent != null) {
            Uri data = intent.getData();
            String tmp = data.toString();
            if (key.equals("url")) {
                String url = tmp.substring(tmp.indexOf("&url=") + 5);
                return url;
            }
            if (data != null) {
                return data.getQueryParameter(key);
            }
        }
        return null;
    }

    public String getQueryParameter(Intent intent, String key) {
        if (intent != null) {
            Uri data = intent.getData();
            if (data != null) {
                return data.getQueryParameter(key);
            }
        }
        return null;
    }

    /**
     * milk://login?p1=xx&p2=xx return 'login'
     *
     * @return
     */
    public String getUrlHost() {
        Intent intent = getIntent();
        if (intent != null) {
            Uri data = intent.getData();
            if (data != null) {
                return data.getHost();
            }
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 请求权限
     *
     * @param id                   请求授权的id 唯一标识即可
     * @param permission           请求的权限
     * @param allowableRunnable    同意授权后的操作
     * @param disallowableRunnable 禁止权限后的操作
     */
    public void requestPermission(int id, String permission, Runnable allowableRunnable, Runnable disallowableRunnable) {
        if (allowableRunnable == null) {
            throw new IllegalArgumentException("allowableRunnable == null");
        }

        allowablePermissionRunnables.put(id, allowableRunnable);
        if (disallowableRunnable != null) {
            disallowablePermissionRunnables.put(id, disallowableRunnable);
        }

        //版本判断
        if (Build.VERSION.SDK_INT >= 23) {
            //减少是否拥有权限
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(this.getApplicationContext(), permission);
            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                //弹出对话框接收权限
                ActivityCompat.requestPermissions(this, new String[]{permission}, id);
                return;
            } else {
                allowableRunnable.run();
            }
        } else {
            allowableRunnable.run();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Runnable allowRun = allowablePermissionRunnables.get(requestCode);
            allowRun.run();
        } else {
            Runnable disallowRun = disallowablePermissionRunnables.get(requestCode);
            disallowRun.run();
        }

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                hideKeyboard(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }


    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText))   {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                v.clearFocus();
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 获取InputMethodManager，隐藏软键盘
     *
     * @param token
     */
    private void hideKeyboard(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}

