package ru.strongit.rssreader.ui.mainActivity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.OrientationEventListener;
import android.widget.Button;
import android.widget.TextView;

import ru.strongit.rssreader.R;

import static ru.strongit.rssreader.RssReaderApp.getAppContext;

public class MainActivity extends AppCompatActivity {
    private String TAG = "TAG";

    private MainActivityPresenter presenter;

    protected RecyclerView recItems;

    protected SwipeRefreshLayout swipeRefreshLayout;

    protected TextView tvDescription;


    private OrientationEventListener orientationListener;

    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();
    }


    private void initViews() {

        tvDescription = (TextView) findViewById(R.id.tvFullTextSmall);

        recItems = (RecyclerView) findViewById(R.id.recNews);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getAppContext());

        recItems.setLayoutManager(mLayoutManager);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                presenter.startRefreshing();

            }
        });

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        presenter.defineOrientation(getResources().getConfiguration().orientation);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(presenter== null) {presenter = new MainActivityPresenter();

            presenter.attachView(this);

            presenter.init();
        }
    }

//не работает.
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        presenter.redrawScreen(newConfig);
//    }



    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

}
