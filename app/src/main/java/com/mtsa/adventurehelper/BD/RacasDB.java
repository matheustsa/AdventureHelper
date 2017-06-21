package com.mtsa.adventurehelper.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathe on 16/06/2017.
 */

public class RacasDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AdvHelpRacas";
    private static final int DATABASE_VERSION = 2;

    private static final String TABELA_RACA = "racas";
    private static final String ID_RACA = "idRaca";
    private static final String NOME = "nome";
    private static final String DESCRICAO = "descricao";
    private static final String TAMANHO = "tamanho";
    private static final String DESLOCAMENTO = "deslocamento";

    public RacasDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable());
        addRacaDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL(dropTable());
        // Create tables again
        onCreate(db);
    }

    public String createTable(){
        String query = "CREATE TABLE " + TABELA_RACA + "("
                + ID_RACA + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOME + " TEXT,"
                + DESCRICAO + " TEXT,"
                + TAMANHO + " TEXT,"
                + DESLOCAMENTO + " TEXT)";
        return query;
    }

    public String dropTable(){
        String query ="DROP TABLE IF EXISTS " + TABELA_RACA;
        return query;
    }

    public String getNOME(String[] nomeRaca){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+NOME+" FROM "+TABELA_RACA+" WHERE "+NOME+" = ?", nomeRaca);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    public List<String> getLISTA_NOMES(){

        SQLiteDatabase db = this.getReadableDatabase();
        List<String> listaRacas = new ArrayList<String>();
        // Monta Query SQL
        String selectQuery = "SELECT * FROM " + TABELA_RACA;
        Cursor cursor = db.rawQuery(selectQuery, null); //String, selectedArguments
        // Move o cursor pra primeira posição e inicia um laço até adicionar todos os valores à lista
        if (cursor.moveToFirst()) {
            do {
                listaRacas.add(cursor.getString(1)); //Pega informação da segunda coluna (nome)
            } while (cursor.moveToNext());
        }
        // Fecha conexão
        cursor.close();
        db.close();
        // Retorna a lista
        return listaRacas;
    }

    public String getDESCRICAO(String[] nomeRaca){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+DESCRICAO+" FROM "+TABELA_RACA+" WHERE "+NOME+" = ?", nomeRaca);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    public String getTAMANHO(String[] nomeRaca){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+TAMANHO+" FROM "+TABELA_RACA+" WHERE "+NOME+" = ?", nomeRaca);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    public String getDESLOCAMENTO(String[] nomeRaca){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+DESLOCAMENTO+" FROM "+TABELA_RACA+" WHERE "+NOME+" = ?", nomeRaca);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    private void addRacaDB(SQLiteDatabase db){

        ContentValues values = new ContentValues();
        //Anão
        values.put(NOME, "Anão");//column name, column value
        values.put(DESCRICAO, "Os anões são famosos por sua eficiência militar, sua habilidade para resistir a castigos físicos e mágicos, seu conhecimento sobre os segredos da terra, seu trabalho árduo e sua capacidade de beber cerveja. Seus reinos misteriosos, escavados no interior das montanhas, são famosos pelos tesouros maravilhosos que a raça produz como presentes ou para o comércio.");
        values.put(TAMANHO, "Tamanho Médio: Como criaturas Médias, os anões não sofrem nenhuma penalidade ou recebem qualquer bônus em relação ao tamanho.");
        values.put(DESLOCAMENTO, "O deslocamento básico dos anões equivale a 6 metros. No entanto, os anões são capazes de percorrer seu deslocamento básico, sem penalidades, mesmo quando utilizam armaduras médias ou pesadas ou transportam uma carga média ou pesada, ao contrário das outras raças, que sofrem uma redução no deslocamento em situações similares.");
        db.insert(TABELA_RACA, null, values);//tableName, nullColumnHack, CotentValues
        //Elfo
        values.put(NOME, "Elfo");
        values.put(DESCRICAO, "Os elfos caminham livremente nas terras dos humanos. Eles sempre são bem vindos, mas nunca se sentem realmente em casa. A raça é famosa pela poesia, dança, música, cultura e artes mágicas. Os elfos valorizam as coisas naturais e a beleza simples. No entanto, quando existem ameaças contra seus lares nas florestas, eles revelam um aspecto militarizado, demonstrando uma eficácia incrível com espadas, arcos e estratégias de batalha.");
        values.put(TAMANHO, "Tamanho Médio: Como criaturas Médias, os elfos não sofrem nenhuma penalidade ou recebem qualquer bônus em relação ao tamanho.");
        values.put(DESLOCAMENTO, "O deslocamento básico dos elfos equivale a 9 metros.");
        db.insert(TABELA_RACA, null, values);
        //Gnomo
        values.put(NOME, "Gnomo");
        values.put(DESCRICAO,"Os gnomos são bem vindos em todos os lugares como técnicos, alquimistas e inventores. Apesar da demanda po suas habilidades, a maioria prefere viver entre a própria raça, em confortáveis buracos sob as colinas, em meio à natureza e os animais.");
        values.put(TAMANHO, "Tamanho Pequeno: Como criaturas Pequenas, os gnomos recebem +1 de bônus de tamanho na Classe de Armadura, +1 de bônus de tamanho nas jogadas de ataque e +4 de bônus de tamanho nos testes de Esconder-se, mas precisam usar armas menores que os humanos e sua capacidade de levantar e carregar peso equivale a três quartos da carga máxima das criaturas Médias.");
        values.put(DESLOCAMENTO, "O deslocamento básico dos gnomos equivale a 6 metros.");
        db.insert(TABELA_RACA, null, values);
        //Halflin
        values.put(NOME, "Halfling");
        values.put(DESCRICAO,"Os Halflings são espertos, competentes e oportunistas. Os indivíduos e os clãs desta raça encontram seu espaço em qualquer lugar. Muitas vezes, eles são viajantes e peregrinos, e os nativos os observam com desconfiança ou curiosidade. De acordo com o clã, os Halflins podem ser cidadãos honestos e trabalhadores ou ladrões à espera de uma oportunidade para realizar um grande golpe e desaparecer na escuridão da noite. De qualquer forma, eles são sobreviventes astutos e engenhosos.");
        values.put(TAMANHO, "Tamanho Pequeno: Como criaturas Pequenas, os Halflins recebem +1 de bônus de tamanho na Classe de Armadura, +1 de bônus de tamanho nas jogadas de ataque e +4 de bônus de tamanho nos testes de Esconder-se, mas precisam usar armas menores que os humanos e sua capacidade de levantar e carregar peso equivale a três quartos da carga máxima das criaturas Médias.");
        values.put(DESLOCAMENTO, "O deslocamento básico dos Halflins equivale a 6 metros.");
        db.insert(TABELA_RACA, null, values);
        //Humano
        values.put(NOME, "Humano");
        values.put(DESCRICAO,"A maioria dos humanos descende de pioneiros, conquistadores, mercadores, refugiados e outras pessoas que viajam com freqüência. Desse modo, os territórios dos humanos são uma mistura de povos – com diferenças físicas, culturais, religiosas e políticas. Simples ou refinados, de pele clara ou escura, extrovertidos ou austeros, primitivos ou civilizados, devotos ou impiedosos, os humanos se espalham pelo mundo.");
        values.put(TAMANHO, "Tamanho Médio: Como criaturas Médias, os humanos não sofrem nenhuma penalidade ou recebem qualquer bônus em relação ao tamanho.");
        values.put(DESLOCAMENTO, "O deslocamento básico dos humanos equivale a 9 metros.");
        db.insert(TABELA_RACA, null, values);
        //Meio-Elfo
        values.put(NOME, "Meio-Elfo");
        values.put(DESCRICAO,"Algumas vezes, os humanos e os elfos se casam. Um elfo é atraído pela energia humana e o humano pela graciosidade élfica. Esses casamentos acabam depressa, na opinião dos elfos, porque a vida de um humano é muito curta, mas deixam um legado duradouro – os filhos meio-elfos. A vida de um meio-elfo pode ser árdua. Caso seja criado entre os parentes elfos, crescerá numa velocidade estonteante, atingindo a maturidade em duas décadas. O meio-elfo se tornará adulto muito antes que possa compreender a intricada arte e cultura élficas ou mesmo sua gramática. Ele ultrapassará rapidamente seus amigos de infância, adquirindo um corpo adulto, embora seja culturalmente uma criança segundo os padrões élficos. Em geral, ele abandona sua casa élfica, que não é mais um lar, e procura abrigo entre os humanos. Por outro lado, caso seja criado entre os humanos, ele será diferente de seus semelhantes: mais reservado, mais sensível, menos ambicioso e com amadurecimento mais lento. Alguns meio-elfos tentam se adaptar à sociedade humana, enquanto outros descobrem suas identidades exatamente nessa diferença. A maioria encontra seu lugar nas terras dos humanos, mas alguns continuam deslocados a vida inteira.");
        values.put(TAMANHO, "Tamanho Médio: Como criaturas Médias, os meio-elfos não sofrem nenhuma penalidade ou recebem qualquer bônus em relação ao tamanho.");
        values.put(DESLOCAMENTO, "O deslocamento básico dos meio-elfos equivale a 9 metros.");
        db.insert(TABELA_RACA, null, values);
        //Meio-Orc
        values.put(NOME, "Meio-Orc");
        values.put(DESCRICAO,"As tribos bárbaras de humanos e orcs vivem em um equilíbrio instável nas regiões selvagens, aniquilando-se durante as épocas de guerra e negociando em tempos de paz. Os meio-orcs nascidos nessas áreas podem viver com seus pais humanos ou orcs; contudo, eles serão expostos às duas culturas. Por diversas razões, muitos abandonam sua terra natal e viajam para as terras civilizadas, levando consigo a tenacidade, a coragem e a habilidade de combate desenvolvidas nas regiões agrestes do mundo.");
        values.put(TAMANHO, "Tamanho Médio: Como criaturas Médias, os meio-orcs não sofrem nenhuma penalidade ou recebem qualquer bônus em relação ao tamanho.");
        values.put(DESLOCAMENTO, "O deslocamento básico dos meio-orcs equivale a 9 metros.");
        db.insert(TABELA_RACA, null, values);

    }

}
