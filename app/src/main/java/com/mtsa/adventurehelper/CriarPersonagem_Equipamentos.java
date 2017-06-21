package com.mtsa.adventurehelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mtsa.adventurehelper.BD.ClasseDB;
import com.mtsa.adventurehelper.BD.RacasDB;

public class CriarPersonagem_Equipamentos extends AppCompatActivity implements View.OnClickListener {

    //SHARED PREFERENCES
    public final String FICHA = "FichaPersonagem";
    public final String CLASSE = "Classe_Key";
    public final String RACA = "Raca_Key";
    public String classe = "";
    public String raca = "";
    SharedPreferences ShaPrefs;
    Button bt_avancar;
    private TextView txv_tamanho;
    private TextView txv_deslocamento;
    private TextView txv_escolha_classeRaca;
    private TextView txv_ddv;
    private TextView txv_armadura;
    private TextView txv_armas;
    private TextView txv_equipamentos;
    private TextView txv_dinheiro;
    private TextView txv_magoFeiticeiro;
    private TextView txv_itens_magoFeiticeiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cria_personagem_equipamentos);

        ShaPrefs = getSharedPreferences(FICHA, Context.MODE_PRIVATE);
        classe = ShaPrefs.getString(CLASSE, "");
        raca = ShaPrefs.getString(RACA, "");
        System.out.println("\n\n"+raca+" "+classe+"\n\n");

        bt_avancar = (Button) findViewById(R.id.bt_prox_criaPerson_equip);
        bt_avancar.setOnClickListener(this);

        txv_tamanho = (TextView) findViewById(R.id.txv_tamanho);
        txv_deslocamento = (TextView) findViewById(R.id.txv_deslocamento);
        txv_escolha_classeRaca = (TextView) findViewById(R.id.txv_escolha_classeRaca);
        txv_ddv = (TextView) findViewById(R.id.txv_ddv);
        txv_armadura = (TextView) findViewById(R.id.txv_armadura);
        txv_armas = (TextView) findViewById(R.id.txv_armas);
        txv_equipamentos = (TextView) findViewById(R.id.txv_equipamentos);
        txv_dinheiro = (TextView) findViewById(R.id.txv_dinheiro);
        txv_magoFeiticeiro = (TextView) findViewById(R.id.txv_magoFeiticeiro);
        txv_itens_magoFeiticeiro = (TextView) findViewById(R.id.txv_itens_magoFeiticeiro);

        // Montando os componentes da tela
        txv_escolha_classeRaca.setText("Então você decidiu ser um " + raca + " " + classe + "? LEGAL!");

        // Características da Raça
        RacasDB racasDB = new RacasDB(getApplicationContext());
        txv_tamanho.setText(racasDB.getTAMANHO(new String[]{raca}));
        txv_deslocamento.setText(racasDB.getDESLOCAMENTO(new String[]{raca}));

        // Características da Classe
        ClasseDB classeDB = new ClasseDB(getApplicationContext());
        txv_ddv.setText("Você usará um " + classeDB.getDDV(new String[]{classe.toString()}) + " para calcular seus pontos de vida totais.");

        switch (raca) {
            case "Anão":
                txv_armadura.setText("Brunea (+4 CA, -4 de penalidade de armadura, 6 m de deslocamento, 15 kg). Escudo grande de madeira (+2 CA, -2 de penalidade de armadura)");
                txv_armas.setText("Machado de guerra anão (1d10, dec.x 3, 4 kg, uma mão, cortante). Arco Curto (1d6, dec.x 3,18 m, 1 kg, perfurante)\"");
                break;
            default:
                txv_armadura.setText(classeDB.getARMADURA(new String[]{classe}));
                txv_armas.setText(classeDB.getARMAS(new String[]{classe}));
        } // ANÃO OU HUMANO
        txv_equipamentos.setText(classeDB.getEQUIPAMENTOS(new String[]{classe}));
        switch (classe) {
            case "Feiticeiro":
                txv_magoFeiticeiro.setVisibility(View.VISIBLE);
                txv_magoFeiticeiro.setText("Magias Conhecidas");
                txv_itens_magoFeiticeiro.setVisibility(View.VISIBLE);
                txv_itens_magoFeiticeiro.setText("Magias de nível 0 – detectar magia, som fantasma, luz, ler magias.\nMagias de 1° nível: mísseis mágicos, sono.");
                break;
            case "Mago":
                txv_magoFeiticeiro.setVisibility(View.VISIBLE);
                txv_magoFeiticeiro.setText("Grimório");
                txv_itens_magoFeiticeiro.setVisibility(View.VISIBLE);
                txv_itens_magoFeiticeiro.setText("Todas as magias de nível 0;\nEnfeitiçar pessoas, invocar criaturas I e sono.\nEscolha mais uma dessas magias para cada ponto de bônus de Inteligência (se houver): causar medo, leque cromático, mísseis mágicos e imagem silenciosa.");
                break;
        } // FEITICEIRO OU MAGO
        txv_dinheiro.setText(classeDB.getDINHEIRO(new String[]{classe}));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_prox_criaPerson_equip:
                startActivity(new Intent(this, CriarPersonagem_Atributos.class));
                break;
        } // Switch
    } // OnClick()
} // main()
