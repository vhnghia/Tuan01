package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText doF,doC;
    private TextView txtkq;
    private Button btF,btC,btClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doF = (EditText)findViewById(R.id.edtF);
        doC = (EditText)findViewById(R.id.edtC);
        txtkq = (TextView)findViewById(R.id.txtKetQua);
        btF = (Button)findViewById(R.id.btnF);
        btC = (Button)findViewById(R.id.btnC);
        btClear = (Button)findViewById(R.id.btnClear);
        btC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float doC1 = Float.parseFloat(doC.getText().toString());
                float doF1 = Float.parseFloat(doF.getText().toString());
                float Swap = (doF1 - 32) * 5/9;
                txtkq.setText("Do F chuyen sang do C: "+Swap);
            }
        });
        btF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float doC1 = Float.parseFloat(doC.getText().toString());
                float doF1 = Float.parseFloat(doF.getText().toString());
                float Swap = (doC1 * 9/5) + 32;
                txtkq.setText("Do F chuyen sang do C: "+Swap);
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doC.setText("");
                doF.setText("");
                txtkq.setText("");
            }
        });
    }
}
