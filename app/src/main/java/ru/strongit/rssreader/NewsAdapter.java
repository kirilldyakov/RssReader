package ru.strongit.rssreader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;


import java.util.List;

import ru.strongit.rssreader.realm.model.Item;

import static ru.strongit.rssreader.RssReaderApp.getAppContext;

/**
 * Created by user on 03.07.17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    private String TAG = "LOG_TAG";

    private Context mContext;
    private List<Item> itemList;
    private final OnItemClickListener listener;




    public NewsAdapter(Context mContext, List<Item> itemList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.itemList = itemList;
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, count;
        ImageView thumbnail, arrow;
        RelativeLayout rlPostRow;

        ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.post_title);
            //count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.post_thumbnail);
            //arrow = (ImageView) view.findViewById(R.id.ic_arrow_right);
            rlPostRow = (RelativeLayout) view.findViewById(R.id.rl_post_row);

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
        final Item item = itemList.get(position);

        //holder.title.setText(item.getAttributes().getTranslations().get(0).getTitle());

        String logo_url = "";
        try {
          //  logo_url = item.getAttributes().getLogo().getMiniThumb().getUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (logo_url!=null) {

            if (logo_url.substring(0, 1).equals("/"))
                logo_url = logo_url.substring(1, logo_url.length());

           // logo_url = BASE_URL + logo_url;

            Picasso.with(getAppContext())
                    .load(logo_url)
                    .into(holder.thumbnail);


        }
        holder.bind(item, listener );

    }





//    private void showPopupMenu(View view) {
//        // inflate menu
//        PopupMenu popup = new PopupMenu(mContext, view);
//        MenuInflater inflater = popup.getMenuInflater();
//        inflater.inflate(R.menu.menu_album, popup.getMenu());
//        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
//        popup.show();
//    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


}
