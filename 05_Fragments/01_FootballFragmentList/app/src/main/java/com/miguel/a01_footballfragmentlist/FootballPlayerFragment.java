package com.miguel.a01_footballfragmentlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;


public class FootballPlayerFragment extends Fragment {

    private int mColumnCount = 1;
    List<FootballPlayerItem> footballPlayerItemList;


    public FootballPlayerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        footballPlayerItemList = new ArrayList<>();
        footballPlayerItemList.add(new FootballPlayerItem(
                "Cristiano Ronaldo",
                "Real Madrid",
                325,
                "http://www.soccerblog.com/wp-content/uploads/2016/11/cron.jpg",
                "https://ssl.gstatic.com/onebox/media/sports/logos/Th4fAVAZeCJWRcKoLW7koA_96x96.png"
        ));
        footballPlayerItemList.add(new FootballPlayerItem(
            "Leo Messi",
            "Barcelona FC",
            0,
            "https://as00.epimg.net/futbol/imagenes/2016/11/08/primera/1478588829_895112_1478588972_noticia_normal.jpg",
                "https://ssl.gstatic.com/onebox/media/sports/logos/paYnEE8hcrP96neHRNofhQ_96x96.png"

        ));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_footballplayer_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyFootballPlayerRecyclerViewAdapter(getActivity(),footballPlayerItemList));
        }
        return view;
    }


}
