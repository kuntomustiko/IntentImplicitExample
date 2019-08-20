package com.minara.kirana.intentimplicitexcample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BrowserActivity extends AppCompatActivity {

    @BindView(R.id.btnBrowser)
    Button btnBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        ButterKnife.bind(this);
    }

    //ketika button di click maka mengarahkan ke url google
    @OnClick(R.id.btnBrowser)
    public void onViewClicked(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com")));
    }
}
