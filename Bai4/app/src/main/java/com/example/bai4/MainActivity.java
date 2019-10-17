package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtmHoTen, edtmCMND,edtmBoSung;
    private RadioButton rdmTrungCap, rdmCaoDang, rdmDaiHoc;
    private CheckBox chkmDocBao, chkmDocSach, chkmDocCode;
    private Button btnmSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtmHoTen = (EditText)findViewById(R.id.edtFullName);
        edtmCMND = (EditText)findViewById(R.id.edtCMND);
        edtmBoSung = (EditText)findViewById(R.id.edtBoSung);
        rdmDaiHoc = (RadioButton)findViewById(R.id.rdDaiHoc);
        chkmDocBao = (CheckBox)findViewById(R.id.chkDocBao);
        chkmDocSach = (CheckBox)findViewById(R.id.chkDocSach);
        chkmDocCode = (CheckBox)findViewById(R.id.chkDocCode);
        btnmSubmit = (Button)findViewById(R.id.btnSubmit);
        btnmSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(KiemTra()==false){
                    Toast.makeText(MainActivity.this,"Vui Long Kiem Tra Lai Thong Tin",Toast.LENGTH_LONG).show();
                    return;
                }
                else
                    Toast.makeText(MainActivity.this,"Submit thanh cong",Toast.LENGTH_LONG).show();
            }
        });

    }

    public Boolean KiemTra (){
        String HoTen = edtmHoTen.getText().toString();
        String cmnd = edtmCMND.getText().toString();
        if(!HoTen.matches("^[A-Za-z]{3,}$"))
            return  Boolean.FALSE;
        else if(!cmnd.matches("^\\d{9}$"))
            return Boolean.FALSE;
        else if(!rdmDaiHoc.isChecked())
            return Boolean.FALSE;
        else if(!chkmDocBao.isChecked() && !chkmDocSach.isChecked() && !chkmDocCode.isChecked())
            return Boolean.FALSE;
        return Boolean.TRUE;
    }

}
