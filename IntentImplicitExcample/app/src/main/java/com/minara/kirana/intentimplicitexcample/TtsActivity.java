package com.minara.kirana.intentimplicitexcample;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

public class TtsActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.editText)
    EditText edtTv;
    @BindView(R.id.btnSpeech)
    Button btnSpeech;

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);

        tts = new TextToSpeech(TtsActivity.this, this);
    }

    @OnClick(R.id.btnSpeech)
    public void onViewClicked(){
        String inputan = edtTv.getText().toString().trim();
        tts.speak(inputan, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS){
            int hasil = tts.setLanguage(Locale.ENGLISH);
            if (hasil == TextToSpeech.LANG_MISSING_DATA || hasil == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this, "Language Not Support", Toast.LENGTH_SHORT).show();
            } else {
                onViewClicked();
                btnSpeech.setEnabled(true);
            }
        } else {
            Toast.makeText(this, "tts Not Supported", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
