package com.example.gvendekal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class bilgiler extends AppCompatActivity {
    private String alan_kod[];
    private String il[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgiler);
        alan_kod=new String[1000];
        alan_kod[0]="Alan Kodu";
        for (int i=1;i<1000;i++){
            alan_kod[i]="+"+i;
        }
        Spinner s = (Spinner) findViewById(R.id.alan);
        ArrayAdapter adapter = new ArrayAdapter(this,
        android.R.layout.simple_spinner_item, alan_kod);
        s.setAdapter(adapter);



    }
}