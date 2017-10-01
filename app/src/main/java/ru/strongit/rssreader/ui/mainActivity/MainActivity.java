package ru.strongit.rssreader.ui.mainActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.strongit.rssreader.ItemAdapter;
import ru.strongit.rssreader.R;
import ru.strongit.rssreader.common.RecyclerViewEmptySupport;
import ru.strongit.rssreader.dataBase.model.Item;
import ru.strongit.rssreader.service.RssLoaderService;

import static ru.strongit.rssreader.RssReaderApp.getAppContext;

public class MainActivity extends AppCompatActivity implements IMainActivity, SwipeRefreshLayout.OnRefreshListener {

    private IMainActivityPresenter presenter;

    RecyclerViewEmptySupport recNews;

    SwipeRefreshLayout swipeRefreshLayout;

    TextView tvDescription;

    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (presenter == null) {

            presenter = new MainActivityPresenter(this);

            presenter.init();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        recNews = (RecyclerViewEmptySupport) findViewById(R.id.recNews);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getAppContext());

        recNews.setLayoutManager(mLayoutManager);

        recNews.setEmptyView(findViewById(R.id.list_empty));

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    protected void onPostResume() {

        super.onPostResume();

        //presenter.defineOrientation(getResources().getConfiguration().orientation);

    }

    @Override
    public void setNewsTitle(String title) {
        setTitle(title);
    }

    @Override
    public void setNewsText(String description) {

        tvDescription = (TextView) findViewById(R.id.tv_full_text_small);

        tvDescription.setText(description);

    }

    @Override
    public void showProgress() {

        this.swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {

        this.swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onRefresh() {
        presenter.startNewsLoading();
    }

    @Override
    public void bindData(List<Item> items, ItemAdapter.OnItemClickListener listener) {

        try {

            ItemAdapter adapter = new ItemAdapter(getAppContext(), items, listener);

            recNews.setAdapter(adapter);

            recNews.setItemAnimator(new DefaultItemAnimator());

            recNews.setAdapter(adapter);

            adapter.notifyDataSetChanged();


        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @Override
    public void startLoadService() {

        Intent intent = new Intent(getAppContext(), RssLoaderService.class);

        startService(intent);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("TAG", "onConfigurationChanged: 167"+newConfig.toString());
    }
}
