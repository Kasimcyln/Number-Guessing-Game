package com.kasimkartal866.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtKalanHak, txtSonuc;
    private EditText editTxtSayi;
    private String gelenDeger;
    private int kalanHak = 3, randomSayi;
    private Random rndNumber;
    private boolean tahminDogrumu = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKalanHak = findViewById(R.id.txtViewKalanHak);
        txtSonuc = findViewById(R.id.txtViewSonuc);
        editTxtSayi = findViewById(R.id.editTxtSayi);
        rndNumber = new Random();
        randomSayi = rndNumber.nextInt(5);
        System.out.println("Random Sayi: " + randomSayi);

    }

    public void btnTahminEt(View view) {
        gelenDeger = editTxtSayi.getText().toString();
        if (!TextUtils.isEmpty(gelenDeger))
        {
            if (kalanHak > 0 && tahminDogrumu == false) {
                if (gelenDeger.equals(String.valueOf(randomSayi))) {
                    sonucGoster("Tebrikler Dogru Tahminde Bulundunuz. ");
                    tahminDogrumu = true;

                }
                else {
                    txtSonuc.setText("Yanlis Tahminde bulundunuz. ");
                    editTxtSayi.setText("");
                }
                kalanHak--;
                txtKalanHak.setText("Kalan Hak: " + kalanHak);

                if (kalanHak == 0 && tahminDogrumu ==false) {
                    sonucGoster("Tahmin Hakkiniz Bitti. ");
                    editTxtSayi.setText(" ");
                }
            }
            else
                txtSonuc.setText("Oyun bitti. ");
        }
        else
        txtSonuc.setText("Girilen Deger Bos Olamaz. ");
    }

    private void sonucGoster(String mesaj) {
        editTxtSayi.setEnabled(false);
        txtSonuc.setText(mesaj);
    }
}