package com.example.bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtmHoTen, edtmSoLuong, edtmSoKH, edtmLoai, edtmDoanhThu;
    private CheckBox chkmLoai;
    private TextView txtmTongTien;
    private Button btnmTinhTT, btnmTiep, btnmThongKe, btnmThoat;
    private dsCustomer dsCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Customer customer = new Customer("Nghia",20000,"VIP");
        dsCustomer = new dsCustomer();
        edtmHoTen = (EditText)findViewById(R.id.edtName);
        edtmSoLuong = (EditText)findViewById(R.id.edtSoLuong);
        edtmDoanhThu = (EditText)findViewById(R.id.edtDoanhThu);
        edtmLoai = (EditText)findViewById(R.id.edtKHVIP);
        edtmSoKH = (EditText)findViewById(R.id.edtTongKH);
        chkmLoai = (CheckBox)findViewById(R.id.chkLoai);
        btnmTinhTT = (Button)findViewById(R.id.btnTinhTien);
        btnmTiep = (Button)findViewById(R.id.btnTIep);
        btnmThongKe = (Button)findViewById(R.id.btnThongKe);
        txtmTongTien = (TextView)findViewById(R.id.txtThanhTien);
        btnmThoat = (Button)findViewById(R.id.btnThoat);
        btnmTinhTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuong = Integer.parseInt(edtmSoLuong.getText().toString());
                float Tong=0;
                if(soLuong<0){
                    Toast.makeText(MainActivity.this,"So luong phai > 0",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(chkmLoai.isChecked()){
                        Tong = (soLuong*20000) - (soLuong*20000)/10;
                        txtmTongTien.setText(Tong+"");
                    }
                    else
                    {
                        Tong = (soLuong*20000);
                        txtmTongTien.setText(Tong+"");
                    }
                }
            }
        });
        btnmTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String HoTen = edtmHoTen.getText().toString();
                float  TongTien = Float.parseFloat(txtmTongTien.getText().toString());
                String LoaiKh ="";
                if(chkmLoai.isChecked())
                    LoaiKh="VIP";
                else
                    LoaiKh="Thuong";
                Customer customer = new Customer(HoTen,TongTien,LoaiKh);
                dsCustomer.them(customer);
                dsCustomer.ds();
                edtmHoTen.requestFocus();
                Toast.makeText(MainActivity.this,"Luu Thanh Cong",Toast.LENGTH_LONG).show();
            }
        });
        btnmThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dsCustomer.ds().size()==0){
                    Toast.makeText(MainActivity.this,"Ban chua luu thong tin",Toast.LENGTH_LONG).show();
                }else
                {
                    int tongkh=0;
                    float tongtien=0;
                    int khachvip=0;
                    for(int i=0;i<dsCustomer.ds().size(); i++){
                        System.out.println(dsCustomer.ds().size());
                        tongkh++;
                        tongtien = tongtien + dsCustomer.ds().get(i).getTongTien();
                        if(dsCustomer.ds().get(i).getLoaiKH().equalsIgnoreCase("VIP")){
                            khachvip++;
                        }
                    }
                    edtmSoKH.setText(tongkh+"");
                    edtmDoanhThu.setText(tongtien+"");
                    edtmLoai.setText(khachvip+"");
                }

            }
        });
        btnmThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
