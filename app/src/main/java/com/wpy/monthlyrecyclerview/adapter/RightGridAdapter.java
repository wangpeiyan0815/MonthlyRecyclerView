package com.wpy.monthlyrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.wpy.monthlyrecyclerview.R;
import com.wpy.monthlyrecyclerview.bean.Bean;

import java.util.List;

/**
 * Created by dell on 2017/3/4.
 */

public class RightGridAdapter extends BaseAdapter {
    private Context context;
    List<Bean.RsBeanHeadline.ChildrenBeanHeadlineX.ChildrenBeanHeadline> children;

    public RightGridAdapter(Context context, List<Bean.RsBeanHeadline
            .ChildrenBeanHeadlineX.ChildrenBeanHeadline> children) {
        this.context = context;
        this.children = children;
    }

    @Override
    public int getCount() {
        return children.size();
    }

    @Override
    public Object getItem(int position) {
        return children.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
            v = new ViewHolder();
            v.textView = (TextView) convertView.findViewById(R.id.grid_textView);
            v.imageView = (ImageView) convertView.findViewById(R.id.grid_imageView);
            convertView.setTag(v);
        }else{
            v = (ViewHolder) convertView.getTag();
        }
        v.textView.setText(children.get(position).getDirName());
        BitmapUtils bitmapUtils = new BitmapUtils(context);
        bitmapUtils.display(v.imageView,children.get(position).getImgApp());
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
