package ru.strongit.rssreader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.realm.RealmChangeListener;
import ru.strongit.rssreader.dataBase.model.Item;

import static ru.strongit.rssreader.dataBase.DataBase.getItemsCount;


/**
 * Created by user on 03.07.17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> implements RealmChangeListener {

    @Override
    public void onChange(Object o) {

        Log.d("TAG", "onChange: "+getItemsCount());

    }

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    private Context mContext;

    private List<Item> ItemsList;

    private final OnItemClickListener listener;


    public ItemAdapter(Context mContext, List<Item> items, OnItemClickListener listener) {
        this.mContext = mContext;
        this.ItemsList = items;
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvTitle, tvStatus, tvName, tvAddress;

        ImageView imgLogo;

        LinearLayout llItemRow;

        ViewHolder(View view) {
            super(view);

            imgLogo = (ImageView) view.findViewById(R.id.img_logo);

            tvTitle = (TextView) view.findViewById(R.id.tv_title);

//            tvStatus = (TextView) view.findViewById(R.id.tv_calls_item_status);
//
//            tvName = (TextView) view.findViewById(R.id.tv_calls_item_name);
//
//            tvAddress = (TextView) view.findViewById(R.id.tv_calls_item_address);
//
//            llItemRow = (LinearLayout) view.findViewById(R.id.llRowItem);

            //rlCallRow = (RelativeLayout) view.findViewById(R.id.rl_call_row);


        }

        public void bind(final Item item, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }

            });
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater
                .from(parent
                        .getContext())
                .inflate(R.layout.row_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Item item = ItemsList.get(position);


        holder.tvTitle.setText(item.getTitle());

        String imgUrl = absoluteImgUrl(item.getEnclosure().getUrl());

        Picasso.with(mContext)
                .load(imgUrl)
                .into(holder.imgLogo);


//        holder.llItemRow.setBackgroundColor(getItemBackgroundColor(item));

        holder.bind(item, listener);
    }

    private String absoluteImgUrl(String url) {

        return url;
    }


    @Override
    public int getItemCount() {

        return this.ItemsList.size();

    }


}
