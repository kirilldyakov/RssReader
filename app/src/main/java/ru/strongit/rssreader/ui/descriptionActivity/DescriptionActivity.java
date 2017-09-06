package ru.strongit.rssreader.ui.descriptionActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.strongit.rssreader.R;

public class DescriptionActivity extends AppCompatActivity {
    DescriptionActivityPresenter presenter;

    TextView tvFullText;
    Button btnLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        tvFullText = (TextView) findViewById(R.id.tvFullText);

        btnLink = (Button) findViewById(R.id.btnLink);
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.www();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter = new DescriptionActivityPresenter();
        presenter.attachView(this);
        presenter.init();
    }
}
