package com.example.headlinenews.fragment.home.recommend.adapter;

import android.widget.FrameLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.headlinenews.R;
import com.example.headlinenews.http.bean.entify.NewsData;
import com.example.headlinenews.http.bean.response.NewsResponse;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ComAdapter extends BaseQuickAdapter<NewsData, BaseViewHolder> {

    public ComAdapter( @Nullable List<NewsData> data) {
        super(R.layout.item_com_layout, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NewsData newsData) {
        baseViewHolder.setText(R.id.itemTv,newsData.content);
    }
}
