package com.mtsa.adventurehelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class CriarPersonagem_Atributos extends AppCompatActivity implements View.OnClickListener {

    //SHARED PREFERENCES
    public final String FICHA = "FichaPersonagem";
    public final String RACA = "Raca_Key";
    public final String NOMEPERSON = "NomePerson_Key";
    public final String BONUS_FOR = "Bonus_For_Key";
    public final String BONUS_DES = "Bonus_Des_key";
    public final String BONUS_INT = "Bonus_Int_key";
    public final String BONUS_CON = "Bonus_Con_key";
    public final String BONUS_CAR = "Bonus_Car_key";

    public final String FOR = "Forca_Key";
    public final String DES = "Dest_Key";
    public final String CON = "Const_Key";
    public final String INT = "Intel_Key";
    public final String SAB = "Sabed_Key";
    public final String CAR = "Caris_Key";

    String raca;
    int forca, destreza, inteligencia, constituicao, carisma, sabedoria;
    int FORCA;
    int DESTREZA;
    int INTELIGENCIA;
    int CONSTITUICAO;
    int SABEDORIA;
    int CARISMA;
    SharedPreferences sp;

    EditText edtx_nomePerson = null;
    EditText edtx_forca = null;
    EditText edtx_destreza = null;
    EditText edtx_inteligencia = null;
    EditText edtx_constituicao = null;
    EditText edtx_sabedoria = null;
    EditText edtx_carisma = null;

    TextView txv_bonus_for = null;
    TextView txv_bonus_des = null;
    TextView txv_bonus_con = null;
    TextView txv_bonus_int = null;
    TextView txv_bonus_sab = null;
    TextView txv_bonus_car = null;

    TextView txv_resultado_dados;
    TextView txv_total_dados;

    Button bt_finalizaFicha;
    ImageButton bt_d6;
    ImageButton bt_d20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_criar_personagem_atributos);

        sp = getSharedPreferences(FICHA, Context.MODE_PRIVATE);
        bt_finalizaFicha = (Button) findViewById(R.id.bt_finalizaFicha);
        bt_finalizaFicha.setOnClickListener(this);
        bt_d6 = (ImageButton) findViewById(R.id.imgbt_d6);
        bt_d6.setOnClickListener(this);
        bt_d20 = (ImageButton) findViewById(R.id.imgbt_d20);
        bt_d20.setOnClickListener(this);

        forca = sp.getInt(BONUS_FOR, 0);
        destreza = sp.getInt(BONUS_DES, 0);
        inteligencia = sp.getInt(BONUS_INT, 0);
        constituicao = sp.getInt(BONUS_CON, 0);
        sabedoria = 0;
        carisma = sp.getInt(BONUS_CAR, 0);

        edtx_nomePerson = (EditText) findViewById(R.id.edtx_nomePersonagem);
        edtx_forca = (EditText) findViewById(R.id.edtx_forca);
        edtx_destreza = (EditText) findViewById(R.id.edtx_destreza);
        edtx_inteligencia = (EditText) findViewById(R.id.edtx_inteligencia);
        edtx_constituicao = (EditText) findViewById(R.id.edtx_constituicao);
        edtx_sabedoria = (EditText) findViewById(R.id.edtx_sabedoria);
        edtx_carisma = (EditText) findViewById(R.id.edtx_carisma);

        txv_bonus_for = (TextView) findViewById(R.id.txv_bonus_for);
        txv_bonus_des = (TextView) findViewById(R.id.txv_bonus_des);
        txv_bonus_con = (TextView) findViewById(R.id.txv_bonus_con);
        txv_bonus_int = (TextView) findViewById(R.id.txv_bonus_int);
        txv_bonus_car = (TextView) findViewById(R.id.txv_bonus_car);
        txv_bonus_sab = (TextView) findViewById(R.id.txv_bonus_sab);

        txv_resultado_dados = (TextView) findViewById(R.id.txv_resultados_dados);
        txv_total_dados = (TextView) findViewById(R.id.txv_total_dados);

        txv_bonus_for.setText(String.valueOf(forca));
        txv_bonus_des.setText(String.valueOf(destreza));
        txv_bonus_int.setText(String.valueOf(inteligencia));
        txv_bonus_con.setText(String.valueOf(constituicao));
        txv_bonus_sab.setText(String.valueOf(sabedoria));
        txv_bonus_car.setText(String.valueOf(carisma));
        colorBonus();

    }

    @Override
    public void onClick(View v) {
        final Random random =  new Random();
        int maior = 0, menor;
        int total = 0;
        int roll;

        switch (v.getId()){
            case R.id.imgbt_d6:
                txv_resultado_dados.setText("");
                txv_total_dados.setText("");
                menor = 6;
                for(int i = 0; i < 6; i++){
                    roll = random.nextInt(4)+1;
                    if(roll > maior)
                        maior = roll;
                    if (roll<menor)
                        menor = roll;

                    txv_resultado_dados.append(String.valueOf(roll));
                    total += roll;
                    if (i<5)
                        txv_resultado_dados.append("+");
                }//for
                total -= menor;
                txv_total_dados.setText(String.valueOf(total));
                break;
            case R.id.imgbt_d20:
                txv_resultado_dados.setText("");
                txv_total_dados.setText("");
                for(int i = 0; i < 3; i++){
                    roll = random.nextInt(20)+1;
                    if(roll > maior)
                        maior = roll;

                    txv_resultado_dados.append(String.valueOf(roll));
                    total += roll;
                    if (i<2)
                        txv_resultado_dados.append("+");
                }//for
                txv_total_dados.setText(String.valueOf(maior));
                break;

            case R.id.bt_finalizaFicha:
                FORCA = Integer.parseInt(edtx_forca.getText().toString());
                DESTREZA = Integer.parseInt(edtx_destreza.getText().toString());
                INTELIGENCIA = Integer.parseInt(edtx_inteligencia.getText().toString());
                CONSTITUICAO = Integer.parseInt(edtx_constituicao.getText().toString());
                SABEDORIA = Integer.parseInt(edtx_sabedoria.getText().toString());
                CARISMA = Integer.parseInt(edtx_carisma.getText().toString());

                SharedPreferences.Editor spe = sp.edit();
                spe.putString(NOMEPERSON, edtx_nomePerson.getText().toString());
                spe.putInt(FOR, FORCA + forca);
                spe.putInt(DES, DESTREZA + destreza);
                spe.putInt(INT, INTELIGENCIA + inteligencia);
                spe.putInt(CON, CONSTITUICAO + constituicao);
                spe.putInt(SAB, SABEDORIA + sabedoria);
                spe.putInt(CAR, CARISMA + carisma);
                spe.apply();

                Intent intent = new Intent(this, TelaPrincipal.class);
                startActivity(intent);
        }
    }

    public void colorBonus(){
        // FORÇA
        if (forca==0)
            txv_bonus_for.setEnabled(false);
        if (forca>0)
            txv_bonus_for.setTextColor(Color.GREEN);
        if (forca<0)
            txv_bonus_for.setTextColor(Color.RED);


        // DESTREZA
        if (destreza==0)
            txv_bonus_des.setEnabled(false);
        if (destreza>0)
            txv_bonus_des.setTextColor(Color.GREEN);
        if (destreza<0)
            txv_bonus_for.setTextColor(Color.RED);


        // INTELIGÊNCIA
        if (inteligencia==0)
            txv_bonus_int.setEnabled(false);
        if (inteligencia>0)
            txv_bonus_int.setTextColor(Color.GREEN);
        if (inteligencia<0)
            txv_bonus_int.setTextColor(Color.RED);


        // CONSTITUIÇÃO
        if (constituicao==0)
            txv_bonus_con.setEnabled(false);
        if (constituicao>0)
            txv_bonus_con.setTextColor(Color.GREEN);
        if (constituicao<0)
            txv_bonus_con.setTextColor(Color.RED);

        // SABEDORIA
        if (sabedoria==0)
            txv_bonus_sab.setEnabled(false);
        if (sabedoria>0)
            txv_bonus_sab.setTextColor(Color.GREEN);
        if (sabedoria<0)
            txv_bonus_sab.setTextColor(Color.RED);

        // CARISMA
        if (carisma==0)
            txv_bonus_car.setEnabled(false);
        if (carisma>0)
            txv_bonus_car.setTextColor(Color.GREEN);
        if (carisma<0)
            txv_bonus_car.setTextColor(Color.RED);
    }
}
