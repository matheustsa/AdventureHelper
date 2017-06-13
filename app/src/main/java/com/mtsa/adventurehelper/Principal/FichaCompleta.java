package com.mtsa.adventurehelper.Principal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mtsa.adventurehelper.R;

public class FichaCompleta extends AppCompatActivity {

    //SHARED PREFERENCES
    public final String FICHA = "FichaPersonagem";
    public final String NOME = "Nome_Key";
    public final String RACA = "Raca_Key";
    public final String CLASSE = "Classe_Key";
    public final String PV = "PV_Key";
    public final String LVL = "LVL_Key";
    public final String FOR = "Forca_Key";
    public final String DES = "Dest_Key";
    public final String CON = "Const_Key";
    public final String INT = "Intel_Key";
    public final String SAB = "Sabed_Key";
    public final String CAR = "Caris_Key";
    SharedPreferences ShaPrefs;

    TextView txv_nome = null;
    TextView txv_raca = null;
    TextView txv_classe = null;
    TextView txv_pv = null;
    TextView txv_lvl = null;
    TextView txv_ca = null;

    TextView txv_forca = null;
    TextView txv_dest = null;
    TextView txv_const = null;
    TextView txv_intel = null;
    TextView txv_caris = null;
    TextView txv_sabed = null;

    TextView txv_fortitude = null;
    TextView txv_reflexos = null;
    TextView txv_vontade = null;

    public int modForca, modConstituicao, modDestreza, modSabedoria, CA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ficha_completa);

        //SHARED PREFERENCES
        ShaPrefs = getSharedPreferences(FICHA, Context.MODE_PRIVATE);

        modForca = 0;
        modConstituicao = 0;
        modDestreza = 0;
        modSabedoria = 0;
        CA = 10;

        //Modificador = (habilidade/2)-5
        modForca = (Integer.parseInt(ShaPrefs.getString(FOR, ""))/2)-5;
        modConstituicao = (Integer.parseInt(ShaPrefs.getString(CON, ""))/2)-5;
        modDestreza = (Integer.parseInt(ShaPrefs.getString(DES, ""))/2)-5;
        modSabedoria = (Integer.parseInt(ShaPrefs.getString(SAB, ""))/2)-5;

        txv_nome = (TextView) findViewById(R.id.txv_ficha_nomePersonagem);
        txv_raca = (TextView) findViewById(R.id.txv_ficha_racaPersonagem);
        txv_classe = (TextView) findViewById(R.id.txv_ficha_classePersonagem);
        txv_pv = (TextView) findViewById(R.id.txv_ficha_pvPersonagem);
        txv_lvl = (TextView) findViewById(R.id.txv_ficha_lvlPersonagem);
        txv_ca = (TextView) findViewById(R.id.txv_ficha_caPersonagem);

        txv_forca = (TextView) findViewById(R.id.txv_ficha_forcaPersonagem);
        txv_dest = (TextView) findViewById(R.id.txv_ficha_destrezaPersonagem);
        txv_const = (TextView) findViewById(R.id.txv_ficha_constituicaoPersonagem);
        txv_intel = (TextView) findViewById(R.id.txv_ficha_inteligenciaPersonagem);
        txv_caris = (TextView) findViewById(R.id.txv_ficha_carismaPersonagem);
        txv_sabed = (TextView) findViewById(R.id.txv_ficha_sabedoriaPersonagem);
        txv_fortitude = (TextView) findViewById(R.id.txv_ficha_fortitudePersonagem);
        txv_reflexos = (TextView) findViewById(R.id.txv_ficha_reflexosPersonagem);
        txv_vontade = (TextView) findViewById(R.id.txv_ficha_vontadePersonagem);
        txv_ca = (TextView) findViewById(R.id.txv_ficha_caPersonagem);

        txv_nome.setText(ShaPrefs.getString(NOME, "(Nenhum personagem salvo)"));
        txv_raca.setText(ShaPrefs.getString(RACA, ""));
        txv_classe.setText(ShaPrefs.getString(CLASSE, ""));
        txv_pv.setText(ShaPrefs.getString(PV, ""));
        txv_lvl.setText(ShaPrefs.getString(LVL, ""));
        CA += modDestreza;
        txv_ca.setText(String.valueOf(CA));

        txv_forca.setText(ShaPrefs.getString(FOR, ""));
        txv_dest.setText(ShaPrefs.getString(DES, ""));
        txv_const.setText(ShaPrefs.getString(CON, ""));
        txv_intel.setText(ShaPrefs.getString(INT, ""));
        txv_caris.setText(ShaPrefs.getString(SAB, ""));
        txv_sabed.setText(ShaPrefs.getString(CAR, ""));

        txv_fortitude.setText(String.valueOf(modForca+modConstituicao));
        txv_reflexos.setText(String.valueOf(modDestreza));
        txv_vontade.setText(String.valueOf(modSabedoria));

    }
}
