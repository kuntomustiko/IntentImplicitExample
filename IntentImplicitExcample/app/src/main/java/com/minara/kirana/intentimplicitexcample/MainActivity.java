package com.minara.kirana.intentimplicitexcample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_browser)
    Button btnBrowser;
    @BindView(R.id.btn_tts)
    Button btnTts;
    @BindView(R.id.btn_call_phone)
    Button btnCallPhone;
    @BindView(R.id.btn_sms)
    Button btnSms;
    @BindView(R.id.btn_wifi)
    Button btnWifi;
    @BindView(R.id.btn_bluetooth)
    Button btnBluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inisial butterknife
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_browser, R.id.btn_tts, R.id.btn_call_phone, R.id.btn_sms,
            R.id.btn_wifi, R.id.btn_bluetooth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_bluetooth:
                startActivity(new Intent(MainActivity.this, BluetoothActivity.class));
                break;
            case R.id.btn_browser:
                startActivity(new Intent(MainActivity.this, BrowserActivity.class));
                break;
            case R.id.btn_tts:
                startActivity(new Intent(MainActivity.this, TtsActivity.class));
                break;
            case R.id.btn_call_phone:
                startActivity(new Intent(MainActivity.this, CallPhoneActivity.class));
                break;
            case R.id.btn_sms:
                startActivity(new Intent(MainActivity.this, SmsActivity.class));
                break;
            case R.id.btn_wifi:
                startActivity(new Intent(MainActivity.this, WifiActivity.class));
                break;

        }
    }
}
