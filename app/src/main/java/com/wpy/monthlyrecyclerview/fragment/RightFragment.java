package com.wpy.monthlyrecyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wpy.monthlyrecyclerview.R;
import com.wpy.monthlyrecyclerview.adapter.RightAdapter;
import com.wpy.monthlyrecyclerview.bean.Bean;

import java.util.List;

/**
 * Created by dell on 2017/3/4.
 */

public class RightFragment extends Fragment {

    private RecyclerView rigthRecy;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rigthfragment, container, false);
        rigthRecy = (RecyclerView) view.findViewById(R.id.rigthRecy);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //进行接值
        Bundle arguments = getArguments();
        int index = arguments.getInt("index");
        Bean bean = (Bean) arguments.get("bean");
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        rigthRecy.setLayoutManager(manager);
        List<Bean.RsBeanHeadline.ChildrenBeanHeadlineX> children =
                bean.getRs().get(index).getChildren();
        RightAdapter rightAdapter = new RightAdapter(getContext(),children);
        rigthRecy.setAdapter(rightAdapter);
    }

    public static RightFragment newFrag(Bean bean, int position) {
        RightFragment fragment = new RightFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bean", bean);
        bundle.putInt("index", position);
        fragment.setArguments(bundle);
        return fragment;
    }
}
