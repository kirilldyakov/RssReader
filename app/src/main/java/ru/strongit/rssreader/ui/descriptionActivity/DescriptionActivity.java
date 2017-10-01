package ru.strongit.rssreader.ui.descriptionActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.strongit.rssreader.R;

public class DescriptionActivity extends AppCompatActivity implements IDescriptionActivity, View.OnClickListener {
    DescriptionActivityPresenter presenter;

    TextView tvFullText;
    Button btnLink;
    DescriptionActivity descriptionActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        descriptionActivity =  this;

        tvFullText = (TextView) findViewById(R.id.tvFullText);

        btnLink = (Button) findViewById(R.id.btnLink);
        btnLink.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter = new DescriptionActivityPresenter(this);

        presenter.init();
    }

    @Override
    public void startWWW(Intent intent) {

        startActivity(intent);

    }

    @Override
    public void fillTitle(String title) {

        descriptionActivity.setTitle(title);

    }

    @Override
    public void fillFullText(Spanned spanned) {

        tvFullText.setText(spanned);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnLink:  presenter.openWWWurl();  break;

            default:
                break;
        }
    }
}
