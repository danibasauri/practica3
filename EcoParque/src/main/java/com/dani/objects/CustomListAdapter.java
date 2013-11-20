package com.dani.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dani.ecoparque.R;

import java.util.ArrayList;

/**
 * Created by dcandelas on 20/11/13.
 */
public class CustomListAdapter extends BaseAdapter {

    private ArrayList listData;

    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, ArrayList listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
@Override
public View getView(int position, View convertView, ViewGroup parent) {
   /* ViewHolder holder;
    if (convertView == null) {
        convertView = layoutInflater.inflate(R.layout.fila, null);
        holder = new ViewHolder();
        holder.nameView = (TextView) convertView.findViewById(R.id.title);
        holder.imageView = (ImageView) convertView.findViewById(R.id.thumbImage);
        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    Item item = (Item) listData.get(position);
    holder.nameView.setText(item.getName());
    if (holder.imageView != null) {
        new ImageDownoloaderTask(holder.imageView).execute(item.getUrl());
    }

    return convertView;*/
    View theView;

    if (convertView == null) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        theView = inflater.inflate(R.layout.fila, parent, false);
    } else {
        theView = convertView;
    }
    Item item = (Item) getItem(position);
    TextView textView = (TextView) theView.findViewById(R.id.title);
    ImageView imageView = (ImageView) theView.findViewById(R.id.thumbImage);
    textView.setText(textView.getText().toString());

    if (imageView != null) {
        new ImageDownoloaderTask(imageView).execute(item.getUrl());
    }
    return theView;

}

    static class ViewHolder {
        TextView nameView;
        ImageView imageView;
    }


}
