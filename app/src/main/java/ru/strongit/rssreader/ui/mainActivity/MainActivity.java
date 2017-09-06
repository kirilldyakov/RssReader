package ru.strongit.rssreader.ui.mainActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ru.strongit.rssreader.R;

public class MainActivity extends AppCompatActivity {
    private String TAG = "TAG";

    private MainActivityPresenter presenter;

    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(presenter== null) {presenter = new MainActivityPresenter();

        presenter.attachView(this);

        presenter.init();}

        initViews();
    }

    private void initViews() {
        btn1 = (Button) findViewById(R.id.btn1);
        if(btn1!=null){
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.openDescription();

                }
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        presenter.redrawScreen(newConfig);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

}
