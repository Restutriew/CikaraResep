package com.cikarastudio.cikararesep.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cikarastudio.cikararesep.Model.ModelDataKategori;
import com.cikarastudio.cikararesep.R;

import java.util.ArrayList;

public class DataKategoriAdapter extends RecyclerView.Adapter<DataKategoriAdapter.DataViewHolder> {

    private Context mContext;
    private ArrayList<ModelDataKategori> mModelDataKategoriList;
    private DataAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(DataAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(ModelDataKategori data);
    }

    public DataKategoriAdapter(Context context, ArrayList<ModelDataKategori> bumilList) {
        mContext = context;
        mModelDataKategoriList = bumilList;
    }

    public DataKategoriAdapter(Context mContext, ArrayList<ModelDataKategori> mModelDataKategoriList, DataAdapter.OnItemClickCallback onItemClickCallback) {
        this.mContext = mContext;
        this.mModelDataKategoriList = mModelDataKategoriList;
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public DataKategoriAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_data_kategori, parent, false);
        return new DataKategoriAdapter.DataViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final DataKategoriAdapter.DataViewHolder holder, int position) {
        ModelDataKategori currentItem = mModelDataKategoriList.get(position);

        String id = currentItem.getId();
        String nama = currentItem.getNama();
        String icon = currentItem.getIcon();


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemClickCallback.onItemClicked(mModelDataKategoriList.get(holder.getAdapterPosition()));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView nama;
        public ImageView icon;
        public DataViewHolder(@NonNull View itemView) {

            super(itemView);
            nama = itemView.findViewById(R.id.tv_kategori);
            icon = itemView.findViewById(R.id.img_kategori);


        }
    }
}
