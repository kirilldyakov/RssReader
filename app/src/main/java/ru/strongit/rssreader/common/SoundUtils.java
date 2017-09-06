package ru.strongit.rssreader.common;

import android.media.AudioManager;
import android.media.ToneGenerator;

/**
 * Created by user on 02.08.17.
 */

public class SoundUtils {

    public static void beep() {
        ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
        toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
    }
}
