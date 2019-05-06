package com.example.administrator.tongze.Adapter;

import android.view.View;

public interface OnItemClickLitener {
	
	void onItemClick(View view, int position);
	void onItemLongClick(View view, int position);
	void onItemSlectClick(View view, int position,String selectId);
    void onItemSlectNameClick(View view, int position,String selectName);
    void onItemSlectNameIdsClick(View view, int position,String selectName,String ids);

}