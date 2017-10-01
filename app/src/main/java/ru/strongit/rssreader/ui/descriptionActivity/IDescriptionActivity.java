package ru.strongit.rssreader.ui.descriptionActivity;

import android.content.Intent;
import android.text.Spanned;

/**
 * Created by user on 01.10.17.
 */

interface IDescriptionActivity {

    void startWWW(Intent intent);

    Intent getIntent();

    void fillTitle(String title);

    void fillFullText(Spanned spanned);
}
