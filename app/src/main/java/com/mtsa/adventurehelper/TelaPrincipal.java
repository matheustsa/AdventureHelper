package com.mtsa.adventurehelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity implements View.OnClickListener{

    Button bt_NovoPerson = null;
    Button bt_FichaCompleta = null;
    Button bt_RolarDados = null;
    Button bt_Mochila = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal2);

        bt_NovoPerson = (Button) findViewById(R.id.bt_novo_person);
        bt_FichaCompleta = (Button) findViewById(R.id.bt_ficha_completa);
        bt_RolarDados = (Button) findViewById(R.id.bt_rolar_dados);
        bt_Mochila = (Button) findViewById(R.id.bt_mochila);

        bt_NovoPerson.setOnClickListener(this);
        bt_FichaCompleta.setOnClickListener(this);
        bt_RolarDados.setOnClickListener(this);
        bt_Mochila.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_novo_person:
                startActivity(new Intent(TelaPrincipal.this, EditarFicha.class));
                break;

            case R.id.bt_ficha_completa:
                startActivity(new Intent(TelaPrincipal.this, FichaCompleta.class));
                break;

            case R.id.bt_rolar_dados:
                startActivity(new Intent(TelaPrincipal.this, TelaDados.class));
                break;

            case R.id.bt_mochila:
                Toast.makeText(getApplicationContext(), "Implementação Futura!", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(TelaPrincipal.this, TelaMochila.class));
                break;
        }
    }
}
