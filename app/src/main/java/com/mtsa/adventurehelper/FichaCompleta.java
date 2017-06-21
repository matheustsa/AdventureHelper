package com.mtsa.adventurehelper;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FichaCompleta extends AppCompatActivity {

    //SHARED PREFERENCES
    public final String FICHA = "FichaPersonagem";
    public final String RACA = "Raca_Key";
    public final String NOMEPERSON = "NomePerson_Key";
    public final String CLASSE = "Classe_Key";
    public final String FOR = "Forca_Key";
    public final String DES = "Dest_Key";
    public final String CON = "Const_Key";
    public final String INT = "Intel_Key";
    public final String SAB = "Sabed_Key";
    public final String CAR = "Caris_Key";
    public int modForca, modConstituicao, modDestreza, modSabedoria, CA;
    public String sModForca, sModConstituicao, sModDestreza, sModSabedoria;
    SharedPreferences ShaPrefs;
    TextView txv_nome = null;
    TextView txv_raca = null;
    TextView txv_classe = null;
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

        System.out.println(ShaPrefs.getInt(FOR, 0));
        System.out.println(ShaPrefs.getInt(CON, 0));
        System.out.println(ShaPrefs.getInt(DES, 0));
        System.out.println(ShaPrefs.getInt(SAB, 0));

        //Modificador = (habilidade/2)-5
//        sModForca = ShaPrefs.getString(FOR, "");
//        sModDestreza = ShaPrefs.getString(DES, "");
//        sModConstituicao = ShaPrefs.getString(CON, "");
//        sModSabedoria = ShaPrefs.getString(SAB, "");

        modForca = (ShaPrefs.getInt(FOR, 0)/2)-5;
        modConstituicao = (ShaPrefs.getInt(CON, 0)/2)-5;
        modDestreza = (ShaPrefs.getInt(DES, 0)/2)-5;
        modSabedoria = (ShaPrefs.getInt(SAB, 0)/2)-5;

        txv_nome = (TextView) findViewById(R.id.txv_ficha_nomePersonagem);
        txv_raca = (TextView) findViewById(R.id.txv_ficha_racaPersonagem);
        txv_classe = (TextView) findViewById(R.id.txv_ficha_classePersonagem);
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

        txv_nome.setText(ShaPrefs.getString(NOMEPERSON, "(Nenhum personagem salvo)"));
        txv_raca.setText(ShaPrefs.getString(RACA, ""));
        txv_classe.setText(ShaPrefs.getString(CLASSE, ""));
        CA += modDestreza;
        txv_ca.setText(String.valueOf(CA));

        txv_forca.setText(String.valueOf(ShaPrefs.getInt(FOR, 0)));
        txv_dest.setText(String.valueOf(ShaPrefs.getInt(DES, 0)));
        txv_const.setText(String.valueOf(ShaPrefs.getInt(CON, 0)));
        txv_intel.setText(String.valueOf(ShaPrefs.getInt(INT, 0)));
        txv_caris.setText(String.valueOf(ShaPrefs.getInt(CAR, 0)));
        txv_sabed.setText(String.valueOf(ShaPrefs.getInt(SAB, 0)));

        txv_fortitude.setText(String.valueOf(modConstituicao));
        txv_reflexos.setText(String.valueOf(modDestreza));
        txv_vontade.setText(String.valueOf(modSabedoria));

    }
}
