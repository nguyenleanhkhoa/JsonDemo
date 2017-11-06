package com.example.admin.expandlelist;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by ADMIN on 8/30/2017.
 */

public class expandleAdapter extends BaseExpandableListAdapter {
    String[] groupname={"Sport","Computer","Food","Car","TV"};
    String[][] Childname={{"boxing","Kick Boxing","Judo"},
            {"Desktop computer","Laptop Computer","Smartphone Computer"},
            {"Ice Scream","Banana"},
            {"Mezcedez Benz"},
            {"Samsung tv","LG Tv"}};

    Context context;
    public expandleAdapter(Context context){
            this.context=context;
    }
    @Override
    public int getGroupCount() {
        return groupname.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return Childname[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return groupname[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return Childname[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i ;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        TextView txtgroup=new TextView(context);
        txtgroup.setText(groupname[i]);
        txtgroup.setPadding(100,0,0,0);
        txtgroup.setTextColor(Color.GREEN);
        txtgroup.setTextSize(30);
        return txtgroup;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        TextView txtchild=new TextView(context);
        txtchild.setText(Childname[i][i1]);
        txtchild.setPadding(100,0,0,0);
        txtchild.setTextColor(Color.RED );
        txtchild.setTextSize(30);
        return txtchild;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
