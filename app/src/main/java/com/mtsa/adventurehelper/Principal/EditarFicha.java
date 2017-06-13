package com.mtsa.adventurehelper.Principal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mtsa.adventurehelper.R;

public class EditarFicha extends AppCompatActivity {

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

    EditText edtx_nome = null;
    EditText edtx_raca = null;
    EditText edtx_classe = null;
    EditText edtx_for = null;
    EditText edtx_des = null;
    EditText edtx_con = null;
    EditText edtx_int = null;
    EditText edtx_sab = null;
    EditText edtx_car = null;
    EditText edtx_pv = null;
    EditText edtx_lvl = null;
    
    Button bt_salvar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_editar_ficha);

        ShaPrefs = getSharedPreferences(FICHA, Context.MODE_PRIVATE);
        
        edtx_nome = (EditText) findViewById(R.id.editText_nomePersonagem);
        edtx_raca = (EditText) findViewById(R.id.editText_racaPersonagem);
        edtx_classe = (EditText) findViewById(R.id.editText_classePersonagem);
        edtx_for = (EditText) findViewById(R.id.editText_forca);
        edtx_des = (EditText) findViewById(R.id.editText_destreza);
        edtx_con = (EditText) findViewById(R.id.editText_constituicao);
        edtx_int = (EditText) findViewById(R.id.editText_inteligencia);
        edtx_sab = (EditText) findViewById(R.id.editText_sabedoria);
        edtx_car = (EditText) findViewById(R.id.editText_carisma);
        edtx_pv = (EditText) findViewById(R.id.editText_pontosdevida);
        edtx_lvl = (EditText) findViewById(R.id.editText_lvl);

        edtx_nome.setText(ShaPrefs.getString(NOME, "")); //Pega o valor em NOME, senão o default, nesse caso "";
        edtx_raca.setText(ShaPrefs.getString(RACA, ""));
        edtx_classe.setText(ShaPrefs.getString(CLASSE, ""));
        edtx_pv.setText(ShaPrefs.getString(PV, ""));
        edtx_lvl.setText(ShaPrefs.getString(LVL, ""));
        edtx_for.setText(ShaPrefs.getString(FOR, ""));
        edtx_des.setText(ShaPrefs.getString(DES, ""));
        edtx_con.setText(ShaPrefs.getString(CON, ""));
        edtx_int.setText(ShaPrefs.getString(INT, ""));
        edtx_sab.setText(ShaPrefs.getString(SAB, ""));
        edtx_car.setText(ShaPrefs.getString(CAR, ""));

        bt_salvar = (Button) findViewById(R.id.bt_editarFicha_salvar);

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor ShaPrefsEditor = ShaPrefs.edit();
                String nome = edtx_nome.getText().toString();
                String raca = edtx_raca.getText().toString();
                String classe = edtx_classe.getText().toString();
                String pv = edtx_pv.getText().toString();
                String lvl = edtx_lvl.getText().toString();
                String forc = edtx_for.getText().toString();
                String des = edtx_des.getText().toString();
                String con = edtx_con.getText().toString();
                String inte = edtx_int.getText().toString();
                String sab = edtx_sab.getText().toString();
                String car = edtx_car.getText().toString();

                ShaPrefsEditor.putString(NOME, nome);
                ShaPrefsEditor.putString(RACA, raca);
                ShaPrefsEditor.putString(CLASSE, classe);
                ShaPrefsEditor.putString(PV, pv);
                ShaPrefsEditor.putString(LVL, lvl);
                ShaPrefsEditor.putString(FOR, forc);
                ShaPrefsEditor.putString(DES, des);
                ShaPrefsEditor.putString(CON, con);
                ShaPrefsEditor.putString(INT, inte);
                ShaPrefsEditor.putString(SAB, sab);
                ShaPrefsEditor.putString(CAR, car);

                ShaPrefsEditor.apply();

                onBackPressed();
            }
        });
    }
}
