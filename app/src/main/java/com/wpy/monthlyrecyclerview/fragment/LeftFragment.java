package com.wpy.monthlyrecyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.wpy.monthlyrecyclerview.App;
import com.wpy.monthlyrecyclerview.R;
import com.wpy.monthlyrecyclerview.adapter.LeftAdapter;
import com.wpy.monthlyrecyclerview.bean.Bean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by dell on 2017/3/4.
 */

public class LeftFragment extends Fragment{

    private RecyclerView leftRecy;
    private Bean bean;
    private FragmentManager fragmentManager;
    private LeftAdapter leftAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.leftfragment, container, false);
        leftRecy = (RecyclerView) view.findViewById(R.id.leftRecy);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();

    }
    /**
     * 进行数据的获取
     */
    private void getData() {
        String url = "http://mock.eoapi.cn/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {



                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("TAG", "onResponse:ppp " + response);
                        Gson gson = new Gson();
                        bean = gson.fromJson(response, Bean.class);
                        List<Bean.RsBeanHeadline> rs = bean.getRs();
                        //进行适配
                        leftAdapter = new LeftAdapter(getActivity(), rs);
                        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
                        leftRecy.setLayoutManager(manager);
                        //MyDecoration myDecoration = new MyDecoration(getActivity(), LinearLayoutManager.VERTICAL);
                        leftRecy.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
                        leftRecy.setAdapter(leftAdapter);
                        fragmentManager = getActivity().getSupportFragmentManager();
                        //初试化一个
                        RightFragment fragment = RightFragment.newFrag(bean, 0);
                        fragmentManager.beginTransaction()
                                .add(R.id.rightFrame, fragment).commit();

                        leftAdapter.setOnLeftCheckClick(new LeftAdapter.LeftCheckClick() {
                            @Override
                            public void leftItem(int position) {
                                App.flag = position;
                                leftAdapter.notifyDataSetChanged();

                                RightFragment fragment = RightFragment.newFrag(bean, position);
                                fragmentManager.beginTransaction().replace(R.id.rightFrame, fragment).commit();
                            }
                        });
                        //对于替换Fragment  不能  new LeftFragment()  不在一个频道
//                        leftAdapter.setOnLeftCheckClick(new LeftFragment());
//                        leftAdapter.setOnLeftCheckClick(this);
//                        leftAdapter.setOnLeftCheckClick(getActivity());
                    }

                });
    }
    /*@Override
    public void leftItem(int position) {
        Log.i("TAG", "leftItem: +++" + position);
        RightFragment fragment = RightFragment.newFrag(bean, position);
        fragmentManager.beginTransaction().replace(R.id.rightFrame, fragment).commit();
    }*/
}
