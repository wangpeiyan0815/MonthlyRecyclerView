package com.wpy.monthlyrecyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wpy.monthlyrecyclerview.App;
import com.wpy.monthlyrecyclerview.R;
import com.wpy.monthlyrecyclerview.bean.Bean;

import java.util.List;

/**
 * Created by dell on 2017/3/4.
 */

public class LeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context context;
    List<Bean.RsBeanHeadline> rs;
    private LeftCheckClick leftCheckClick;
    private RecyclerView recyclerView;
    public void setOnLeftCheckClick(LeftCheckClick leftCheckClick) {
        this.leftCheckClick = leftCheckClick;
    }

    public LeftAdapter(Context context, List<Bean.RsBeanHeadline> rs) {
        this.context = context;
        this.rs = rs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_iten,parent,false);
        view.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder)holder;
        if(App.flag == position){
            viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#F2F2F2"));
            viewHolder.textView.setTextColor(Color.parseColor("#F2E2C8"));
        }else{
            viewHolder.linearLayout.setBackgroundColor(Color.WHITE);
            viewHolder.textView.setTextColor(Color.BLACK);
        }
        //进行赋值
        Log.i("TAG", "onBindViewHolder: ="+rs.size());
        viewHolder.textView.setText(rs.get(position).getDirName());
    }

    @Override
    public int getItemCount() {
        return rs.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }
    //解绑
    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }
    @Override
    public void onClick(View v) {
        if(leftCheckClick != null && rs.size()>0){
            int position = recyclerView.getChildAdapterPosition(v);
            leftCheckClick.leftItem(position);
        }
    }
    ;
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.left_textView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.left_linear);
        }
    }
    /**
     *   创建接口
     */
   public interface LeftCheckClick{
        void leftItem(int position);
    }
}
