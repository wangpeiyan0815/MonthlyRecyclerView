package com.wpy.monthlyrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.wpy.monthlyrecyclerview.R;
import com.wpy.monthlyrecyclerview.bean.Bean;

import java.util.List;

/**
 *  右侧  adapter
 */

public class RightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Bean.RsBeanHeadline.ChildrenBeanHeadlineX> children;

    public RightAdapter(Context context, List<Bean.RsBeanHeadline.ChildrenBeanHeadlineX> children) {
        this.context = context;
        this.children = children;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item,parent,false);
        ViewHolder viewHolder1 = new ViewHolder(view);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).textView.setText(children.get(position).getDirName());
        //进行适配

        RightGridAdapter rightAdapter = new RightGridAdapter(context,children.get(position).getChildren());
        ((ViewHolder)holder).gridView.setAdapter(rightAdapter);
        ((ViewHolder)holder).gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return children.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        GridView gridView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.right_name);
            gridView = (GridView) itemView.findViewById(R.id.rigth_grid);
        }
    }
}
