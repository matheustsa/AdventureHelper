package com.mtsa.adventurehelper.Principal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mtsa.adventurehelper.R;

import org.w3c.dom.Text;

import java.util.Random;

public class TelaDados extends AppCompatActivity {

    //SHARED PREFERENCES
    public final String PREFERENCES = "AHPrefs";
    public final String D4 = "D4_Key";
    public final String D6 = "D6_Key";
    public final String D8 = "D8_Key";
    public final String D10 = "D10_Key";
    public final String D12 = "D12_Key";
    public final String D20 = "D20_Key";
    SharedPreferences ShaPrefs;

    //REFERÊNCIAS PARA OS OBJETOS VISUAIS
    //BOTÕES
    ImageButton bt_d4 = null;
    ImageButton bt_d6 = null;
    ImageButton bt_d8 = null;
    ImageButton bt_d10 = null;
    ImageButton bt_d12 = null;
    ImageButton bt_d20 = null;
    //TEXTVIEWS
    TextView text_somaD4 = null;
    TextView text_somaD6 = null;
    TextView text_somaD8 = null;
    TextView text_somaD10 = null;
    TextView text_somaD12 = null;
    TextView text_somaD20 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dados_resp);

        //SHARED PREFERENCES
        ShaPrefs = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);

        //Buscando referências para objetos da classe R
        //Botões
        bt_d4 = (ImageButton) findViewById(R.id.imgButton_d4);
        bt_d6 = (ImageButton) findViewById(R.id.imgButton_d6);
        bt_d8 = (ImageButton) findViewById(R.id.imgButton_d8);
        bt_d10 = (ImageButton) findViewById(R.id.imgButton_d10);
        bt_d12 = (ImageButton) findViewById(R.id.imgButton_d12);
        bt_d20 = (ImageButton) findViewById(R.id.imgButton_d20);
        //TextViews
        text_somaD4 = (TextView) findViewById(R.id.textView_somaD4);
        text_somaD6 = (TextView) findViewById(R.id.textView_somaD6);
        text_somaD8 = (TextView) findViewById(R.id.textView_somaD8);
        text_somaD10 = (TextView) findViewById(R.id.textView_somaD10);
        text_somaD12 = (TextView) findViewById(R.id.textView_somaD12);
        text_somaD20 = (TextView) findViewById(R.id.textView_somaD20);

        //Buscando valores guardados nas SharedPreferences
        //.getString(Valor chave, "valor_padrão_caso_não_encontre_nada")
        text_somaD4.setText(ShaPrefs.getString(D4, ""));
        text_somaD6.setText(ShaPrefs.getString(D6, ""));
        text_somaD8.setText(ShaPrefs.getString(D8, ""));
        text_somaD10.setText(ShaPrefs.getString(D10, ""));
        text_somaD12.setText(ShaPrefs.getString(D12, ""));
        text_somaD20.setText(ShaPrefs.getString(D20, ""));

        //------- BOTÃO D4 -------
        bt_d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Random random =  new Random();
                int roll;

                //for (int i=0; i<6 ;i++){
                    roll = random.nextInt(4)+1;
                    text_somaD4.setText(String.valueOf(roll));
                //}
            }
        });//---------------------

        //------- BOTÃO D6 -------
        bt_d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Random random =  new Random();
                int roll;

                //for (int i=0; i<6 ;i++){
                    roll = random.nextInt(6)+1;
                    text_somaD6.setText(String.valueOf(roll));
                //}
            }
        });//---------------------

        //------- BOTÃO D8 -------
        bt_d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Random random =  new Random();
                int roll;

                //for (int i=0; i<6 ;i++){
                    roll = random.nextInt(8)+1;
                    text_somaD8.setText(String.valueOf(roll));
                //}
            }
        });//---------------------

        //------- BOTÃO D10 -------
        bt_d10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Random random =  new Random();
                int roll;

                //for (int i=0; i<6 ;i++){
                    roll = random.nextInt(10)+1;
                    text_somaD10.setText(String.valueOf(roll));
                //}
            }
        });//---------------------

        //------- BOTÃO D12 -------
        bt_d12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Random random =  new Random();
                int roll;

                //for (int i=0; i<6 ;i++){
                    roll = random.nextInt(12)+1;
                    text_somaD12.setText(String.valueOf(roll));
                //}
            }
        });//---------------------

        //------- BOTÃO D20 -------
        bt_d20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Random random =  new Random();
                int roll;

                //for (int i=0; i<6 ;i++){
                    roll = random.nextInt(20)+1;
                    text_somaD20.setText(String.valueOf(roll));
                //}
            }
        });//---------------------
    }


    public void onBackPressed(){
        SharedPreferences.Editor ShaPrefsEditor = ShaPrefs.edit();

        String d4 = text_somaD4.getText().toString();
        String d6 = text_somaD6.getText().toString();
        String d8 = text_somaD8.getText().toString();
        String d10 = text_somaD10.getText().toString();
        String d12 = text_somaD12.getText().toString();
        String d20 = text_somaD20.getText().toString();

        ShaPrefsEditor.putString(D4, d4);
        ShaPrefsEditor.putString(D6, d6);
        ShaPrefsEditor.putString(D8, d8);
        ShaPrefsEditor.putString(D10, d10);
        ShaPrefsEditor.putString(D12, d12);
        ShaPrefsEditor.putString(D20, d20);
        ShaPrefsEditor.apply();

        //Para ainda manter a funcionalidade do onBackPressed(), deve-se utilizar o super ou finish()
        //finish();
        super.onBackPressed();
    }
}
