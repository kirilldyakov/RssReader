package ru.strongit.rssreader.ui.descriptionActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.strongit.rssreader.R;

public class DescriptionActivity extends AppCompatActivity {
    DescriptionActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter = new DescriptionActivityPresenter();
        presenter.attachView(this);
        presenter.init();
    }
}
