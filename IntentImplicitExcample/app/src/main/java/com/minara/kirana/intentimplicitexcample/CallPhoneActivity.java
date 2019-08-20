package com.minara.kirana.intentimplicitexcample;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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

public class CallPhoneActivity extends AppCompatActivity {

    @BindView(R.id.btn_call)
    Button btn_call;
    @BindView(R.id.btn_tampil_call)
    Button btn_tampil_call;
    @BindView(R.id.btn_list_contact)
    Button btn_list_contact;
    @BindView(R.id.edt_no)
    EditText editTextNo;

    String noTelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_call, R.id.btn_tampil_call, R.id.btn_list_contact})
    public void onViewClicked(View view) {

        noTelp = editTextNo.getText().toString().trim();

        switch (view.getId()) {
            case R.id.btn_call:
                call();
                break;
            case R.id.btn_tampil_call:
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + noTelp)));
                break;
            case R.id.btn_list_contact:
                listContact();
                break;

        }
    }

    private void call(){

        if (TextUtils.isEmpty(noTelp)){
            editTextNo.requestFocus();
            Toast.makeText(this, "Tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else {
            int checkPermiss = ContextCompat.checkSelfPermission(
                    this, Manifest.permission.CALL_PHONE);

            if (checkPermiss != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(
                        this, new String[] {Manifest.permission.CALL_PHONE},1);
            } else{
                startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel: "+noTelp)));
            }
        }
    }

    //Todo akses database local contacts
    @SuppressLint("IntentReset")
    private void listContact() {
        @SuppressLint("IntentReset") Intent i = new Intent(Intent.ACTION_PICK,
                ContactsContract.Contacts.CONTENT_URI);
        i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(i, 2);
    }

    //todo hasil balik ketika no telfon diklik dan set ke edit text
    @SuppressLint("Recycle")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK) {
            Cursor cursor = null;

            try {
                Uri uri = data.getData();
                cursor = getContentResolver().query(uri, new String[]{
                                ContactsContract.CommonDataKinds.Phone.NUMBER},
                        null, null, null);

                if (cursor != null && cursor.moveToNext()) {
                    String phone = cursor.getString(0);
                    editTextNo.setText(phone);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
