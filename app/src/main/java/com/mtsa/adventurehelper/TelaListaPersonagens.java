package com.mtsa.adventurehelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TelaListaPersonagens extends AppCompatActivity {


    ArrayList<CelulaLista> vetorDados = new ArrayList<CelulaLista>();
    ListView lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_personagens);

        vetorDados.add(new CelulaLista(R.mipmap.ret_jax, "Jax", "Guerreiro", "5"));
        vetorDados.add(new CelulaLista(R.mipmap.ret_kat, "Katarina", "Assassina", "3"));
        vetorDados.add(new CelulaLista(R.mipmap.ret_lux, "Lux", "Mago", "2"));

        Adaptador adapt = new Adaptador(this, vetorDados);

        lista = (ListView) findViewById(R.id.listView_listaPersonagens);
        lista.setAdapter(adapt);

    }
}

class Adaptador extends ArrayAdapter<CelulaLista> // implements ListView.OnClickListener{
{
    Adaptador(Context activity, ArrayList<CelulaLista> vetor){
        super(activity, 0, vetor);
    }

    //MÉTODO QUE CRIA AS CÉLULAS NA LISTA
    public View getView(int posicao, View reciclada, ViewGroup layoutPai){

        //OBJETO DE DADOS DO VETOR
        CelulaLista celula = getItem(posicao);

        if (reciclada == null){
            //OBJETO CONTENDO A CÉLULA EM XML
            reciclada = LayoutInflater.from(getContext()).inflate(R.layout.layout_celula, layoutPai, false);
        }

        ImageView imagem = (ImageView) reciclada.findViewById(R.id.imageView_retPerson);
        TextView nomePerson = (TextView) reciclada.findViewById(R.id.textView_nomePerson);
        TextView classePerson = (TextView) reciclada.findViewById(R.id.textView_classePerson);
        TextView lvlPerson = (TextView) reciclada.findViewById(R.id.textView_lvlPerson);

        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), celula.idImagem);
        imagem.setImageBitmap(bitmap);
        nomePerson.setText(celula.nomePerson);
        classePerson.setText(celula.classePerson);
        lvlPerson.setText(celula.lvlPerson);

        return reciclada;
    }
/*
    public void onClick(View celula){
        Log.i("INFO","Lista clicada");
    }
    */
}
