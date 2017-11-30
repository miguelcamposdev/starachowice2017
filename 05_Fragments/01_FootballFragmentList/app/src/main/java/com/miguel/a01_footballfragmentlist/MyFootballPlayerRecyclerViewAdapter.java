package com.miguel.a01_footballfragmentlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MyFootballPlayerRecyclerViewAdapter extends RecyclerView.Adapter<MyFootballPlayerRecyclerViewAdapter.ViewHolder> {

    private final List<FootballPlayerItem> mValues;
    Context ctx;

    public MyFootballPlayerRecyclerViewAdapter(Context context, List<FootballPlayerItem> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_footballplayer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewName.setText(holder.mItem.getName());
        holder.textViewTeam.setText(holder.mItem.getTeam());
        holder.textViewGoals.setText(holder.mItem.getGoals()+" goals");

        Picasso.with(ctx)
                .load(holder.mItem.getPhoto())
                .into(holder.imageViewPhoto);

        Picasso.with(ctx)
                .load(holder.mItem.getLogoTeam())
                .resize(30,30)
                .centerInside()
                .into(holder.imageViewTeam);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewName;
        public final TextView textViewTeam;
        public final TextView textViewGoals;
        public final ImageView imageViewPhoto;
        public final ImageView imageViewTeam;
        public FootballPlayerItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewName = view.findViewById(R.id.textViewName);
            textViewTeam = view.findViewById(R.id.textViewTeam);
            textViewGoals = view.findViewById(R.id.textViewGoals);
            imageViewPhoto = view.findViewById(R.id.imageViewPhoto);
            imageViewTeam = view.findViewById(R.id.imageViewTeam);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewName.getText() + "'";
        }
    }
}
