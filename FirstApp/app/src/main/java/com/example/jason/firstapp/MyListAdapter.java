package com.example.jason.firstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jason on 9/6/2014.
 */
public class MyListAdapter extends BaseAdapter{

    private final String PREFS_KEY = "SHARED_PREFERENCES";
    private final String SELECTED_KEY_PREFIX = "selected";

    private ArrayList<MyListItem>myListCategory;
    private Context myContext;

    public MyListAdapter(Context context, ArrayList<MyListItem>listCategory){
        myListCategory=listCategory;
        myContext=context;
    }

    @Override
    public int getCount() {
        return myListCategory.size();
    }

    @Override
    public MyListItem getItem(int position) {
        return myListCategory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ListViewHolder rowView;

        if(convertView==null){
            LayoutInflater inflater =(LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_view, parent, false);

            rowView = new ListViewHolder();
            rowView.title=(TextView) convertView.findViewById(R.id.list_item_title);
            //rowView.selected=(CheckBox) convertView.findViewById(R.id.list_item_selected);
            convertView.setTag(rowView);
        }
        else
            rowView = (ListViewHolder) convertView.getTag();

        rowView.title.setText(getItem(position).myTitle);
        convertView.setBackgroundDrawable(getItem(position).myBackground);

        /* FOR CHECKBOX d
        final SharedPreferences prefs = myContext.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);
        rowView.selected.setSelected(prefs.getBoolean(SELECTED_KEY_PREFIX + position, false));
        rowView.selected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prefs.edit().putBoolean(SELECTED_KEY_PREFIX + position, isChecked).commit();
            }
        });
        */

        return convertView;
    }


}
