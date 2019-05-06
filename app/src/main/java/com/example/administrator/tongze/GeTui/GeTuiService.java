package com.example.administrator.tongze.GeTui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.administrator.tongze.Activity.LoginActivity;
import com.example.administrator.tongze.Utils.DialogHelp;

public class GeTuiService extends BroadcastReceiver {


    @Override
    public void onReceive(final Context context, final Intent intent) {
        if(intent.getAction().equals("com.tongze.GETUI")){
            final String content = intent.getStringExtra("data");
            System.out.print(content);
            DialogHelp.getConfirmDialog(context, content, "确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent1 = new Intent(context,LoginActivity.class);
                    context.startActivity(intent1);
                }
            }).setCancelable(false).create().show();
        }


    }
}