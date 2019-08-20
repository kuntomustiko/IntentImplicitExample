package com.minara.kirana.intentimplicitexcample;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WifiActivity extends AppCompatActivity {

    @BindView(R.id.switch1)
    Switch aSwitch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        ButterKnife.bind(this);
        aSwitch1.setChecked(status());
        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wifiStatus(isChecked);
            }
        });
    }

    //method cek status
    private void wifiStatus(boolean isChecked){
        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        if ((isChecked==true && !manager.isWifiEnabled())){
            Toast.makeText(this, "wifi aktif", Toast.LENGTH_SHORT).show();
            manager.setWifiEnabled(true);
        } else {
            Toast.makeText(this, "Wifi tidak aktif", Toast.LENGTH_SHORT).show();
            manager.setWifiEnabled(false);
        }
    }

    private boolean status(){
        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        return manager.isWifiEnabled();
    }
}
