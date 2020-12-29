package com.example.gvendekal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Kayit extends AppCompatActivity {
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        EditText username=findViewById(R.id.username);
        EditText password=findViewById(R.id.password);
        EditText repasword=findViewById(R.id.repassword);
        Button register=findViewById(R.id.register);

        db=new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String kul_ad=username.getText().toString();
                String kul_sif=password.getText().toString();
                String kul_siff=repasword.getText().toString();

                if (kul_ad.equals("")||kul_sif.equals("")||kul_siff.equals(""))
                {
                    Toast.makeText(Kayit.this,"Lütfen bütün bilgileri eksiksiz giriniz.",Toast.LENGTH_LONG).show();

                }
                else
                {
                    if (kul_sif.equals(kul_siff))
                    {
                        boolean checkuser =db.checkusername(kul_ad);
                        if (checkuser==false)
                        {
                            boolean insert =db.insertData(kul_ad,kul_sif);
                            if (insert==true)
                            {
                                Toast.makeText(Kayit.this,"Kayıt başarılı Ana Sayfaya yönlendiriliyorsunuz.",Toast.LENGTH_LONG).show();
                                Intent go = new Intent(getApplicationContext(),Harita.class);
                                startActivity(go);
                            }
                            else Toast.makeText(Kayit.this, "Kayıt yapılamadı Lütfen tekrar deneyiniz.", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(Kayit.this, "Denediğiniz Kullanıcı adı kullanılıyor lütfen başka deneyiniz.", Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(Kayit.this, "Şifreler uyuşmuyor lütfen tekrar deneyiniz.", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }
}