package com.example.akshar.jsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<DataModel> arrayList;
    Context context;

    public MyAdapter(Context context,ArrayList<DataModel> arrayList ) {
        this.arrayList = arrayList;
        this.context = context;
    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.item_list,null);
        TextView txtName,txtLat, txtLong;
        RelativeLayout relativeLayout;
        ImageView imageView;

        txtName=(TextView) convertView.findViewById(R.id.txt_name);
        txtLat=(TextView) convertView.findViewById(R.id.txt_lat);
        txtLong=(TextView) convertView.findViewById(R.id.txt_long);
        imageView=(ImageView) convertView.findViewById(R.id.imageView);
        relativeLayout=(RelativeLayout) convertView.findViewById(R.id.itemView);

        txtLat.setText(arrayList.get(position).getLat());
        txtLong.setText(arrayList.get(position).getLng());
        txtName.setText(arrayList.get(position).getName());
        Picasso.with(context).load(arrayList.get(position).getIconUrl()).into(imageView);

        return convertView;
    }
}