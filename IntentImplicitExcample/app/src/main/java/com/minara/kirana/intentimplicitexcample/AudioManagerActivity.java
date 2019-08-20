package com.minara.kirana.intentimplicitexcample;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AudioManagerActivity extends AppCompatActivity {

    @BindView(R.id.btnring)
    Button btnring;
    @BindView(R.id.btnvibrate)
    Button btnvibrate;
    @BindView(R.id.btnsilent)
    Button btnsilent;

    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_manager);
        ButterKnife.bind(this);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    @OnClick({R.id.btnring, R.id.btnvibrate, R.id.btnsilent})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.btnring:
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(this, "aktif mode ring", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnvibrate:
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(this, "aktif mode vibrate", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnsilent:
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(this, "aktif mode silent", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
