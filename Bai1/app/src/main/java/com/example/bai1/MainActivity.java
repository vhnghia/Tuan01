package com.example.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText soA, soB;
    private TextView ketqua;
    private Button tong,hieu,tich,thuong,usc,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soA = (EditText)findViewById(R.id.edtSoA);
        soB = (EditText)findViewById(R.id.edtSoB);
        ketqua = (TextView)findViewById(R.id.txtKetQua);
        tong = (Button)findViewById(R.id.btTong);
        hieu = (Button)findViewById(R.id.btHieu);
        tich = (Button)findViewById(R.id.btTich);
        usc = (Button)findViewById(R.id.btUSC);
        thuong = (Button)findViewById(R.id.btThuong);
        exit = (Button)findViewById(R.id.btExit);
        tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float tong = Float.parseFloat(soA.getText().toString())+Float.parseFloat(soB.getText().toString());
                ketqua.setText(tong+"");
            }
        });
        hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float hieu = Float.parseFloat(soA.getText().toString())-Float.parseFloat(soB.getText().toString());
                ketqua.setText(hieu+"");
            }
        });
        tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float tich = Float.parseFloat(soA.getText().toString())*Float.parseFloat(soB.getText().toString());
                ketqua.setText(tich+"");
            }
        });
        thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Float.parseFloat(soB.getText().toString())==0){
                    ketqua.setText("He So B phai # 0");
                    return;
                }
                float thuong = Float.parseFloat(soA.getText().toString())/Float.parseFloat(soB.getText().toString());
                ketqua.setText(thuong+"");
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        usc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(soA.getText().toString());
                float b = Float.parseFloat(soB.getText().toString());
                if(Float.parseFloat(soA.getText().toString())==0 && Float.parseFloat(soB.getText().toString())==0){
                    ketqua.setText("Khong co uoc so chung lon nhat");
                }
                else {
                    while (a != b){
                        if (a > b){
                            a -= b; // a = a - b
                        }else{
                            b -= a;
                        }
                    }
                ketqua.setText("Uoc So Chung lon nhat la:" +a);
                }
            }
        });
    }
}
