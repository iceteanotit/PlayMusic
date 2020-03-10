package com.example.playmusic;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.example.basemodule.base.BaseAdapter;
import com.example.basemodule.models.BaseModels;

public class AppAdapter<T extends BaseModels> extends BaseAdapter<T> {

    public AppAdapter(LayoutInflater inflater, int resLayout) {
        super(inflater, resLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.HolderBase holder, int position) {
        T t = getData().get(position);
        holder.binding.setVariable(BR.item, t);
        if (listener != null) {
            holder.binding.setVariable(BR.listener, listener);
        }
        holder.binding.executePendingBindings();
    }
}