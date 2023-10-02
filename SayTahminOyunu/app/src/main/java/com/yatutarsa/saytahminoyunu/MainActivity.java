package com.yatutarsa.saytahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnTahminiYap,btnTekrarOyna;

    private TextView txtKalanHak;
    private TextView txtView;
    private EditText editTxtSayiGir;
    private String gelenDeger;
    private int kalanHak,randomNumber;
    private Random rndNumber;
    private TextView txtSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTahminiYap=findViewById(R.id.btnTahminEt);
        btnTekrarOyna=findViewById(R.id.btnTekrarOyna);
        txtKalanHak=findViewById(R.id.txtViewKalanHak);
        txtView=findViewById(R.id.txtViewSonuc);
        editTxtSayiGir=findViewById(R.id.editTextSayiGirin);
        txtSonuc=findViewById(R.id.txtViewSonuc);
        rndNumber=new Random();
        randomNumber=rndNumber.nextInt(5);
        System.out.println("Random Sayısı: "+randomNumber);
        kalanHak=3;
        btnTekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber = rndNumber.nextInt(5);
                System.out.println("Random Sayısı: " + randomNumber);
                kalanHak = 3;
                editTxtSayiGir.setEnabled(true);
                editTxtSayiGir.setText("");
                txtSonuc.setText("");
                txtKalanHak.setText("Kalan Hak: " + kalanHak);
            }
        });




    }



    public void btnTahminEt(View v){
        gelenDeger=editTxtSayiGir.getText().toString();
        if(!TextUtils.isEmpty(gelenDeger)){
            if(kalanHak>0) {
                if(gelenDeger.equals(String.valueOf(randomNumber))){
                    sonucGoster("Tebrikler! Doğru bildiniz");

                }
                else{
                    kalanHak--;
                }
                txtKalanHak.setText("Kalan Hak: "+kalanHak);
            }
            else if(kalanHak==0){
                sonucGoster("Tahmin hakkınız bitti");
            }
            else{
                txtSonuc.setText("Oyun Bitti");
            }
        }
        else{
            System.out.println("Lütfen Sayı girin");
        }

    }

    private void sonucGoster(String metin) {
        editTxtSayiGir.setEnabled(false);
        txtSonuc.setText(metin);
    }

    public Button getBtnTahminiYap() {
        return btnTahminiYap;
    }

    public void setBtnTahminiYap(Button btnTahminiYap) {
        this.btnTahminiYap = btnTahminiYap;
    }

    public TextView getTxtKalanHak() {
        return txtKalanHak;
    }

    public void setTxtKalanHak(TextView txtKalanHak) {
        this.txtKalanHak = txtKalanHak;
    }

    public TextView getTxtView() {
        return txtView;
    }

    public void setTxtView(TextView txtView) {
        this.txtView = txtView;
    }

    public EditText getTxtSayiGir() {
        return editTxtSayiGir;
    }

    public void setTxtSayiGir(EditText txtSayiGir) {
        this.editTxtSayiGir = txtSayiGir;
    }


}