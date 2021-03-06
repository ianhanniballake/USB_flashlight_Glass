package org.thinkcreate.usb_flashlight_glass;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardBuilder;

/**
 * Created by seer on 11/6/2014.
 */
public class AlertActivity extends Activity {
    private CardBuilder mAlertCard;
    private AudioManager mAudio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAudio = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

        mAlertCard =  new CardBuilder(this, CardBuilder.Layout.ALERT);
        mAlertCard.setIcon(R.drawable.ic_warning_150);
        mAlertCard.setText(R.string.device_not_found);
        mAlertCard.setFootnote(R.string.device_not_found_foot_note);
        View card_view=mAlertCard.getView ();

        mAudio.playSoundEffect(Sounds.ERROR);

        setContentView(card_view);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            mAudio.playSoundEffect(Sounds.DISALLOWED);
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }


}
