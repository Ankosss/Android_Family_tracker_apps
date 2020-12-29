package com.example.gvendekal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn;
    CheckBox see;
    EditText ad,sif;
    TextView kayit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        ad=findViewById(R.id.ad);
        sif=findViewById(R.id.sif);
        see=findViewById(R.id.see);
        kayit=findViewById(R.id.kayit);
        DBHelper db=new DBHelper(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String kul_ad=ad.getText().toString();
                String kul_sif=sif.getText().toString();
                if (kul_ad.equals("")||kul_sif.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Lütfen alanları doldurunuz.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean checkuserpass=db.checkusernamepassword(kul_ad,kul_sif);
                    if (checkuserpass==true)
                    {
                        //Toast.makeText(MainActivity.this, "Kullanıcı girişi başarılı Ana sayfaya yönlendiriliyorsunuz.", Toast.LENGTH_SHORT).show();
                        Intent go = new Intent(MainActivity.this,Harita.class);
                        startActivity(go);
                    }
                    else Toast.makeText(MainActivity.this, "Bilgileri Tekrar girip deneyiniz.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (see.isChecked())
                {
                    sif.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    sif.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }


            }
        });
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent go=new Intent(MainActivity.this,Kayit.class);
                startActivity(go);
            }
        });

    }

}