package com.minara.kirana.intentimplicitexcample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SmsActivity extends AppCompatActivity {

    @BindView(R.id.btn_sms_intent)
    Button btn_call;
    @BindView(R.id.btn_tampil_call)
    Button btn_tampil_call;
    @BindView(R.id.btn_list_contact)
    Button btn_list_contact;
    @BindView(R.id.edt_no)
    EditText editTextNo;

    String noHp, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_sms_intent, R.id.btn_tampil_call, R.id.btn_list_contact})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sms_intent:
                smsIntent();
                break;
        }
    }

    private void smsIntent(){
        if (TextUtils.isEmpty(noHp) || (TextUtils.isEmpty(message))){
            Toast.makeText(this,"Harus di isi", Toast.LENGTH_SHORT).show();
        } else {
            Intent sms = new Intent(Intent.ACTION_VIEW);
            sms.putExtra("address", noHp);
            sms.putExtra("message", message);
            sms.setType("vnd.android-dir/mms-sms");
            startActivity(sms);
        }
    }
}
