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

import com.mtsa.adventurehelper.BD.RacasDB;

import java.util.List;

public class CriarPersonagem_Raca extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    //SHARED PREFERENCES
    public final String FICHA = "FichaPersonagem";
    public final String RACA = "Raca_Key";
    public final String BONUS_FOR = "Bonus_For_Key";
    public final String BONUS_DES = "Bonus_Des_key";
    public final String BONUS_INT = "Bonus_Int_key";
    public final String BONUS_CON = "Bonus_Con_key";
    public final String BONUS_CAR = "Bonus_Car_key";
    String raca;
    int forca, destreza, inteligencia, constituicao, carisma;
    SharedPreferences ShaPrefs;

    Spinner spin_raca;
    Button bt_avancar;
    private ImageView img_raca;
    private TextSwitcher txtsw_desc_raca;
    private TextView txv_bonusRacialPosit;
    private TextView txv_bonusRacialNegat;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cria_personagem_raca);

        ShaPrefs = getSharedPreferences(FICHA, Context.MODE_PRIVATE);


        bt_avancar = (Button) findViewById(R.id.bt_prox_criaPerson_raca);
        bt_avancar.setOnClickListener(this);

        img_raca = (ImageView) findViewById(R.id.img_raca);
        txv_bonusRacialPosit = (TextView) findViewById(R.id.txv_bonus_racial_positivo);
        txv_bonusRacialNegat = (TextView) findViewById(R.id.txv_bonus_racial_negativo);

        //-------------------- TEXT SWITCHER --------------------
        txtsw_desc_raca = (TextSwitcher) findViewById(R.id.txtsw_descricao_classe);
        txtsw_desc_raca.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView txv_desc_raca = new TextView(CriarPersonagem_Raca.this);
                txv_desc_raca.setTextSize(18);
                txv_desc_raca.setPadding(45,25,45,15); //left, top, right, bottom
                txv_desc_raca.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                return txv_desc_raca;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        txtsw_desc_raca.setInAnimation(in);
        txtsw_desc_raca.setOutAnimation(out);


        spin_raca = (Spinner) findViewById(R.id.spinner_raca);
        loadSpinnerData_Raca();
        spin_raca.setOnItemSelectedListener(this);

    }

    private void loadSpinnerData_Raca() {
        RacasDB raca = new RacasDB(getApplicationContext());
        List<String> labels = raca.getLISTA_NOMES();
        // Creating adapter for spin_raca
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spin_raca
        spin_raca.setAdapter(dataAdapter);
    }

    //Eventos dos botões
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_prox_criaPerson_raca:
                SharedPreferences.Editor SPEditor = ShaPrefs.edit();
                SPEditor.putString(RACA, raca);
                SPEditor.putInt(BONUS_FOR, forca);
                SPEditor.putInt(BONUS_DES, destreza);
                SPEditor.putInt(BONUS_CON, constituicao);
                SPEditor.putInt(BONUS_INT, inteligencia);
                SPEditor.putInt(BONUS_CAR, carisma);
                SPEditor.apply();
                /*
                System.out.println("\n\n-----------------------\n"
                        +"\nRACA "+sp.getString(RACA,"")
                        +"\nFOR "+sp.getInt(BONUS_FOR, 0)
                        +"\nDES "+sp.getInt(BONUS_DES, 0)
                        +"\nCON "+sp.getInt(BONUS_CON, 0)
                        +"\nINT "+sp.getInt(BONUS_INT, 0)
                        +"\nCAR "+sp.getInt(BONUS_CAR, 0)
                        +"\n-------------------------------\n\n");
                */
                startActivity(new Intent(this, CriarPersonagem_Classe.class));
                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        RacasDB racasDB = new RacasDB(getApplicationContext());
        //Para não acontecer o bug da área de descrição não reduzir com o texto
        txtsw_desc_raca.setText("");

        forca = destreza = constituicao = inteligencia = carisma = 0;
        raca = "";

        switch (parent.getSelectedItem().toString()){
            case "Anão":
                //Shared Preferences
                //Atributos individuais da raca
                raca = "Anão";
                constituicao = 2;
                carisma = -2;
                //-----------------------------
                img_raca.setImageResource(R.drawable.anao);
                txtsw_desc_raca.setText(racasDB.getDESCRICAO(new String[]{"Anão"}));
                txv_bonusRacialPosit.setText("+2 de Constituição");
                txv_bonusRacialNegat.setText("-2 de Carisma");
                break;
            case "Elfo":
                //Shared Preferences
                // Atributos individuais da raca
                raca = "Elfo";
                destreza = 2;
                constituicao = -2;
                //-----------------------------
                img_raca.setImageResource(R.drawable.elfo);
                txtsw_desc_raca.setText(racasDB.getDESCRICAO(new String[]{"Elfo"}));
                txv_bonusRacialPosit.setText("+2 de Destreza");
                txv_bonusRacialNegat.setText("-2 de Constituição");
                break;
            case "Gnomo":
                //Shared Preferences
                // Atributos individuais da raca
                raca = "Gnomo";
                constituicao = 2;
                forca = -2;
                //-----------------------------
                img_raca.setImageResource(R.drawable.gnomo);
                txtsw_desc_raca.setText(racasDB.getDESCRICAO(new String[]{"Gnomo"}));
                txv_bonusRacialPosit.setText("+2 de Constituição");
                txv_bonusRacialNegat.setText("-2 de Força");
                break;
            case "Halfling":
                //Shared Preferences
                // Atributos individuais da raca
                raca = "Halfling";
                constituicao = 2;
                forca = -2;
                //-----------------------------
                img_raca.setImageResource(R.drawable.halfling);
                txtsw_desc_raca.setText(racasDB.getDESCRICAO(new String[]{"Halfling"}));
                txv_bonusRacialPosit.setText("+2 de Constituição");
                txv_bonusRacialNegat.setText("-2 de Força");
                break;
            case "Humano":
                //Shared Preferences
                // Atributos individuais da raca
                raca = "Humano";
                //-----------------------------
                img_raca.setImageResource(R.drawable.human);
                txtsw_desc_raca.setText(racasDB.getDESCRICAO(new String[]{"Humano"}));
                txv_bonusRacialPosit.setText("(nenhum)");
                txv_bonusRacialNegat.setText("(nenhum)");
                break;
            case "Meio-Elfo":
                //Shared Preferences
                // Atributos individuais da raca
                raca = "Meio-Elfo";
                //-----------------------------
                img_raca.setImageResource(R.drawable.meioelfo);
                txtsw_desc_raca.setText(racasDB.getDESCRICAO(new String[]{"Meio-Elfo"}));
                txv_bonusRacialPosit.setText("(nenhum)");
                txv_bonusRacialNegat.setText("(nenhum)");
                break;
            case "Meio-Orc":
                //Shared Preferences
                // Atributos individuais da raca
                raca = "Meio-Orc";
                forca = 2;
                inteligencia = -2;
                carisma = -2;
                //-----------------------------
                img_raca.setImageResource(R.drawable.meioorc);
                txtsw_desc_raca.setText(racasDB.getDESCRICAO(new String[]{"Meio-Orc"}));
                txv_bonusRacialPosit.setText("+2 de Força");
                txv_bonusRacialNegat.setText("-2 de Inteligência, -2 de Carisma");
                break;
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
