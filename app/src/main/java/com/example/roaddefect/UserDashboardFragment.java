package com.example.roaddefect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class UserDashboardFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<ModelClass> mList;
    CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_user_dashboard, container, false);

        recyclerView=v.findViewById(R.id.recyclerViewId);

        customAdapter=new CustomAdapter(mList,getContext());
        recyclerView.setAdapter(customAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mList=new ArrayList<>();
        mList.add(new ModelClass(R.drawable.onboard,"Title"));
        mList.add(new ModelClass(R.drawable.oboard_sec,"Title"));
        mList.add(new ModelClass(R.drawable.onboard_fir,"Title"));
        mList.add(new ModelClass(R.drawable.onboard,"Title"));
        mList.add(new ModelClass(R.drawable.oboard_sec,"Title"));
        mList.add(new ModelClass(R.drawable.onboard_fir,"Title"));
        mList.add(new ModelClass(R.drawable.onboard,"Title"));
        mList.add(new ModelClass(R.drawable.oboard_sec,"Title"));
        mList.add(new ModelClass(R.drawable.onboard_fir,"Title"));
        mList.add(new ModelClass(R.drawable.oboard_sec,"Title"));
        mList.add(new ModelClass(R.drawable.onboard_fir,"Title"));
        mList.add(new ModelClass(R.drawable.onboard,"Title"));
        mList.add(new ModelClass(R.drawable.oboard_sec,"Title"));
        mList.add(new ModelClass(R.drawable.onboard_fir,"Title"));
    }
}