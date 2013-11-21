package com.ecoparque.objects;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dani.ecoparque.R;
import com.ecoparque.asyncTasks.ImageLoaderTask;

import java.util.ArrayList;

/**
 * Created by dcandelas on 20/11/13.
 */
public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Item> data;
    private static LayoutInflater inflater = null;
    //public ImageLoader imageLoader;
    public ImageLoaderTask imageLoaderTask;

    public LazyAdapter(Activity a, ArrayList d) {
        activity = a;
        data = d;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return data.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_listview_item, null);
            holder = new ViewHolder();
            holder.nameView = (TextView) convertView.findViewById(R.id.text);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nameView.setText(data.get(position).getName());
        imageLoaderTask = new ImageLoaderTask(activity.getApplicationContext(), data.get(position).getUrl() ,holder.imageView);
        imageLoaderTask.execute(data.get(position).getUrl());
        return convertView;
    }

    static class ViewHolder {
        TextView nameView;
        ImageView imageView;
    }
}
