package com.radio.search_fm.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.radio.search_fm.R;
import com.radio.search_fm.databinding.AdapterArtistEntryBinding;
import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.presenter.PresenterArtistList;
import com.radio.search_fm.views.ViewArtistAdapter;

public class AdapterArtistItem extends RecyclerView.Adapter {
    private PresenterArtistList mPresenter;

    public AdapterArtistItem(PresenterArtistList presenter) {
        this.mPresenter = presenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterArtistEntryBinding itemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_artist_entry, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemBinding.getRoot());
        viewHolder.setBinding(itemBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        mPresenter.bindViewHolder((ViewArtistAdapter) holder, position);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements ViewArtistAdapter {
        AdapterArtistEntryBinding mBinding;
        ImageView mImage;

        public void setBinding(AdapterArtistEntryBinding mBinding) {
            this.mBinding = mBinding;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.artistImage);
        }

        @Override
        public void bindItem(Artist artist) {
            if(mBinding != null) mBinding.setArtist(artist);

            if(artist.getImage() == null) return;

            Glide.with(itemView.getContext())
                    .load(artist.getImage().get(0).getUrl()).into(mImage);
        }
    }

}
