package com.mtsa.adventurehelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.mtsa.adventurehelper.BD.ClasseDB;

import java.util.List;

public class CriarPersonagem_Classe extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    //SHARED PREFERENCES
    public final String FICHA = "FichaPersonagem";
    public final String CLASSE = "Classe_Key";
    public String classe = "";
    SharedPreferences ShaPrefs;

    Spinner spinner_classe;
    Button bt_avancar;
    private ImageView img_classe;
    private TextSwitcher txtsw_desc_classe;
    private TextView txv_info_classe;
    private TextView txv_habilidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cria_personagem_classe);

        ShaPrefs = getSharedPreferences(FICHA, Context.MODE_PRIVATE);

        bt_avancar = (Button) findViewById(R.id.bt_prox_criaPerson_classe);
        bt_avancar.setOnClickListener(this);

        img_classe = (ImageView) findViewById(R.id.img_classe);
        txv_info_classe = (TextView) findViewById(R.id.txv_info_classe);
        txv_habilidades = (TextView) findViewById(R.id.txv_habilidades);

        //-------------------- TEXT SWITCHER --------------------
        txtsw_desc_classe = (TextSwitcher) findViewById(R.id.txtsw_descricao_classe);
        txtsw_desc_classe.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView txv_desc_classe = new TextView(CriarPersonagem_Classe.this);
                txv_desc_classe.setTextSize(18);
                txv_desc_classe.setPadding(45,25,45,15); //left, top, right, bottom
                txv_desc_classe.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                return txv_desc_classe;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        txtsw_desc_classe.setInAnimation(in);
        txtsw_desc_classe.setOutAnimation(out);


        spinner_classe = (Spinner) findViewById(R.id.spinner_classe);
        loadSpinnerData_Raca();
        spinner_classe.setOnItemSelectedListener(this);

    }

    private void loadSpinnerData_Raca() {
        ClasseDB classe = new ClasseDB(getApplicationContext());
        List<String> labels = classe.getLISTA_NOMES();
        // Creating adapter for spinner_classe
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner_classe
        spinner_classe.setAdapter(dataAdapter);
    }

    //Eventos dos botões
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_prox_criaPerson_classe:
                SharedPreferences.Editor SPEditor = ShaPrefs.edit();
                SPEditor.putString(CLASSE, classe);
                SPEditor.apply();
                startActivity(new Intent(this, CriarPersonagem_Equipamentos.class));
                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ClasseDB classeDB = new ClasseDB(getApplicationContext());
        //Para não acontecer o bug da área de descrição não reduzir com o texto
        txtsw_desc_classe.setText("");

        classe = "";

        switch (parent.getSelectedItem().toString()){
            case "Bárbaro":
                classe = "Bárbaro";
                img_classe.setImageResource(R.drawable.barbaro);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Bárbaro"}));
                txv_info_classe.setText("Bárbaros devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Bárbaro"}));
                break;
            case "Bardo":
                classe = "Bardo";
                img_classe.setImageResource(R.drawable.bardo);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Bardo"}));
                txv_info_classe.setText("Bardos devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Bardo"}));
                break;
            case "Clérigo":
                classe = "Clérigo";
                img_classe.setImageResource(R.drawable.clerigo);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Clérigo"}));
                txv_info_classe.setText("Clérigos devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Clérigo"}));
                break;
            case "Druida":
                classe = "Druida";
                img_classe.setImageResource(R.drawable.druida);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Druida"}));
                txv_info_classe.setText("Druidas devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Druida"}));
                break;
            case "Feiticeiro":
                classe = "Feiticeiro";
                img_classe.setImageResource(R.drawable.feiticeiro);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Feiticeiro"}));
                txv_info_classe.setText("Feiticeiros devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Feiticeiro"}));
                break;
            case "Guerreiro":
                classe = "Guerreiro";
                img_classe.setImageResource(R.drawable.guerreiro);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Guerreiro"}));
                txv_info_classe.setText("Guerreiros devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Guerreiro"}));
                break;
            case "Ladino":
                classe = "Ladino";
                img_classe.setImageResource(R.drawable.ladino);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Ladino"}));
                txv_info_classe.setText("Ladinos devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Ladino"}));
                break;
            case "Mago":
                classe = "Mago";
                img_classe.setImageResource(R.drawable.mago);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Mago"}));
                txv_info_classe.setText("Magos devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Mago"}));
                break;
            case "Monge":
                classe = "Monge";
                img_classe.setImageResource(R.drawable.monge);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Monge"}));
                txv_info_classe.setText("Monges devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Monge"}));
                break;
            case "Paladino":
                classe = "Paladino";
                img_classe.setImageResource(R.drawable.paladino);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Paladino"}));
                txv_info_classe.setText("Paladinos devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Paladino"}));
                break;
            case "Ranger":
                classe = "Ranger";
                img_classe.setImageResource(R.drawable.ranger);
                txtsw_desc_classe.setText(classeDB.getDESCRICAO(new String[]{"Ranger"}));
                txv_info_classe.setText("Rangers devem focar em");
                txv_habilidades.setText(classeDB.getHABILIDADES(new String[]{"Ranger"}));
                break;
        }


    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
