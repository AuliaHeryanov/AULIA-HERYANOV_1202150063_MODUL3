package com.example.auliaheryanov.auliaheryanov_1202150063_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Aulia Heryanov on 24/02/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private GradientDrawable mGradient;
    private ArrayList<Model> mData;
    private Context mContext;

    Adapter(Context context, ArrayList<Model> Data){
        this.mData = Data;
        this.mContext = context;

        mGradient = new GradientDrawable();
        mGradient.setColor(Color.GRAY);

        Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.ades);
        if (drawable!=null){
            mGradient.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.itemlist, parent, false), mGradient);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        Model currentModel = mData.get(position);

        holder.bindTo(currentModel);
        Glide.with(mContext).load(currentModel.getImage()).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mImage;
        private TextView mTitle;
        private TextView mInfo;
        private Context mContext;
        private Model mCurrentModel;
        private GradientDrawable mGradient;

        ViewHolder(Context context, View itemView, GradientDrawable gradientDrawable){
            super(itemView);

            mImage = (ImageView) itemView.findViewById(R.id.imageList);
            mTitle = (TextView) itemView.findViewById(R.id.titleList);
            mInfo = (TextView) itemView.findViewById(R.id.descList);

            mContext = context;
            mGradient = gradientDrawable;

            itemView.setOnClickListener(this);

        }

        void bindTo(Model currentModel){
            mTitle.setText(currentModel.getTitle());
            mInfo.setText(currentModel.getInfo());

            mCurrentModel = currentModel;

            Glide.with(mContext).load(currentModel.getImage()).placeholder(mGradient).into(mImage);
        }

        @Override
        public void onClick(View view) {
            Intent detail = Model.starter(mContext, mCurrentModel.getTitle(), mCurrentModel.getImage());
            mContext.startActivity(detail);
        }
    }
}

