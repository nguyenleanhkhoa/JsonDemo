package com.example.admin.demoviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by ADMIN on 11/01/17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    public Context context;
    public int[] arr;
    public ViewPagerAdapter(Context context,int[] arr){
        this.context=context;
        this.arr=arr;
    }
    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater LayoutInflater.from(this.context);
        View view=layoutInflater.inflate(R.layout.viewpager_item,container,falseo)

    }
}
