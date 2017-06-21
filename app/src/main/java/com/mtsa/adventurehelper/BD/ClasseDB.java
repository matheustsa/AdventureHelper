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

public class ClasseDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AdvHelpClasses";
    private static final int DATABASE_VERSION = 4;

    private static final String TABELA_CLASSE = "classes";
    private static final String ID_CLASSE = "idClasse";
    private static final String NOME = "nome";
    private static final String DESCRICAO = "descricao";
    private static final String HABILIDADES = "habilidades";  // atributos chaves da classe
    private static final String DDV = "ddv";  // ddv = dados de vida
    private static final String ARMADURA = "armadura";
    private static final String ARMAS = "armas";
    private static final String EQUIPAMENTOS = "equipamentos";
    private static final String DINHEIRO = "dinheiro";


    public ClasseDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable());
        addClasseDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL(dropTable());
        // Create tables again
        onCreate(db);
    }

    public String createTable(){
        String query = "CREATE TABLE " + TABELA_CLASSE + "("
                + ID_CLASSE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOME + " TEXT,"
                + DESCRICAO + " TEXT,"
                + HABILIDADES + " TEXT,"
                + DDV + " TEXT,"
                + ARMADURA + " TEXT,"
                + ARMAS + " TEXT,"
                + EQUIPAMENTOS + " TEXT,"
                + DINHEIRO + " TEXT)";
        return query;
    }

    public String dropTable(){
        String query ="DROP TABLE IF EXISTS " + TABELA_CLASSE;
        return query;
    }

    public String getNOME(String[] nomeClasse){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+NOME+" FROM "+ TABELA_CLASSE +" WHERE "+NOME+" = ?", nomeClasse);
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
        String selectQuery = "SELECT * FROM " + TABELA_CLASSE;
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

    public String getDESCRICAO(String[] nomeClasse){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+DESCRICAO+" FROM "+ TABELA_CLASSE +" WHERE "+NOME+" = ?", nomeClasse);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    public String getHABILIDADES(String[] nomeClasse){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+HABILIDADES+" FROM "+ TABELA_CLASSE +" WHERE "+NOME+" = ?", nomeClasse);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    public String getDDV(String[] nomeClasse){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+DDV+" FROM "+ TABELA_CLASSE +" WHERE "+NOME+" = ?", nomeClasse);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    public String getARMADURA(String[] nomeClasse){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+ARMADURA+" FROM "+ TABELA_CLASSE +" WHERE "+NOME+" = ?", nomeClasse);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    public String getARMAS(String[] nomeClasse){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+ARMAS+" FROM "+ TABELA_CLASSE +" WHERE "+NOME+" = ?", nomeClasse);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    public String getEQUIPAMENTOS(String[] nomeClasse){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+EQUIPAMENTOS+" FROM "+ TABELA_CLASSE +" WHERE "+NOME+" = ?", nomeClasse);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    public String getDINHEIRO(String[] nomeClasse){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+DINHEIRO+" FROM "+ TABELA_CLASSE +" WHERE "+NOME+" = ?", nomeClasse);
        cursor.moveToFirst();
        String resultado = cursor.getString(0);
        cursor.close();
        db.close();
        return resultado;
    }

    private void addClasseDB(SQLiteDatabase db) {

        ContentValues values = new ContentValues();
        //Barbaro
        values.put(NOME, "Bárbaro");
        values.put(DESCRICAO, "Esses guerreiros temerários e inconsequentes são criaturas provenientes das vastidões geladas do norte e das selvas infernais do sul. As pessoas civilizadas os chamam de bárbaros ou amoques e afirmam que são cruéis e impiedosos, arautos da destruição e da atrocidade. No entanto, esses “bárbaros” já provaram sua coragem e seu valor junto aos povos que se tornaram aliados de suas tribos. Aos inimigos que os subestimam, eles já provaram sua astúcia, sabedoria, persistência e impiedade.");
        values.put(HABILIDADES, "FORÇA: é essencial para um bárbaro, devido a sua importância em combate. Além disso, muitas perícias da classe são baseadas nessa habilidade.\nDESTREZA: tem uma utilidade equivalente, em especial para os bárbaros que usam armaduras leves.\nSABEDORIA: é importante para diversas perícias da classe.\nUm valor elevado de CONSTITUIÇÃO permite que um bárbaro utilize sua fúria durante mais tempo (e viva mais tempo, pois lhe concede mais pontos de vida).");
        values.put(DDV, "d12");
        values.put(ARMADURA, "Corselete de couro batido (+3 CA, -1 de penalidade de armadura, 12 m de deslocamento, 10 kg).");
        values.put(ARMAS, "Machado grande (1dl2, dec. x3, 6 kg, duas mãos, cortante). Arco curto (ld6, dec. x3, alcance 18 m, 1 kg, perfurante). Adaga (ld4, dec. 19-20/x2, alcance 3 m, 0,5 kg, leve, perfurante).");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, sacola, pederneira e isqueiro. Aljava com 20 flechas.");
        values.put(DINHEIRO, "2d4 PO (Peças de Ouro)");
        db.insert(TABELA_CLASSE, null, values);
        //Bardo
        values.put(NOME, "Bardo");
        values.put(DESCRICAO, "Todos sabem que a música possui uma magia especial e o bardo prova que isso é verdade. Viajar pelo mundo, acumular conhecimento, contar histórias, retirar mágica da sua música e sobreviver da gratidão de sua audiência – essa é a vida de um bardo. Quando a sorte ou a oportunidade os atrai para um conflito, os bardos servem como diplomatas, negociadores, mensageiros, batedores e espiões. A magia do bardo provém de seu coração. Quando esse coração é bom, o bardo carrega esperança e coragem para os abandonados e utiliza seus truques, sua música e sua magia para frustrar os planos das forças do mal. Se os nobres da região são corruptos, um bardo bondoso será um inimigo do estado, evitando a captura com perspicácia e elevando a moral dos oprimidos. Mas a música também pode florescer em um coração maligno. Os bardos malignos preferem a manipulação como substituta da violência, dominando as mentes e os corações do povo e deleitando-se com os presentes que a audiência oferece de “boa vontade”.");
        values.put(HABILIDADES, "CARISMA: determina a magia mais poderosa que um bardo é capaz de conjurar, a quantidade de magias disponíveis a cada dia e a dificuldade para resistir às suas magias. Para conjurar magias, um bardo deve ter uma pontuação em CARISMA igual ou superior a 10 + o nível da magia. Além disso, essa habilidade determina a quantidade de magias adicionais que o bardo adquire. A Classe de Dificuldade de um teste de resistência contra essas magias equivale a 10 + nível da magia + modificador de CARISMA. O CARISMA, a DESTREZA e a INTELIGÊNCIA são importantes para muitas perícias da classe");
        values.put(DDV, "d6");
        values.put(ARMADURA, "Corselete de couro batido (+3 CA, -1 de penalidade de armadura, sem chance de falha de magia arcana, 6 m de deslocamento, 5 kg).");
        values.put(ARMAS, "Espada longa (1d6, dec. 19-20/x2,1 kg, uma mão, cortante). Besta leve (1d6, dec. 19-20/x2, alcance 24 m, 1 kg, perfurante).");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, saco, pederneira e isqueiro. Três tochas. Caixa com 10 virotes de besta. Alaúde (comum). Bolsa de componentes de magia.");
        values.put(DINHEIRO, "2d4 PO (Peças de Ouro)");
        //Magias Conhecidas: Nível 0: detectar magia, som fantasma, luz e ler magias.
        db.insert(TABELA_CLASSE, null, values);
        //Clerigo
        values.put(NOME, "Clérigo");
        values.put(DESCRICAO, "As obras divinas estão em toda parte: nos lugares de beleza natural, nas cruzadas importantes, nos imensos templos e no coração de seus seguidores. Similares às pessoas, os deuses variam entre a benevolência e a malícia, a introspecção e a curiosidade, a simplicidade e a complexidade. Os deuses, no entanto, quase sempre atuam por meio de intermediários – os clérigos. Os clérigos Bons curam, protegem e vingam. Os clérigos malignos saqueiam, destroem e sabotam. Um clérigo manifesta a vontade divina canalizando o poder de seu patrono. As religiões também esperam que os sacerdotes utilizem o poder da sua divindade para melhorar a própria situação.");
        values.put(HABILIDADES, "SABEDORIA: determina a magia mais poderosa que um clérigo é capaz de conjurar, a quantidade de magias disponíveis a cada dia e a dificuldade para resistir às suas magias (veja Magias, a seguir).\nUm valor elevado de CONSTITUIÇÃO aumentaria os pontos de vida do clérigo e um CARISMA elevado aprimora sua capacidade de expulsar mortos-vivos.");
        values.put(DDV, "d8");
        values.put(ARMADURA, "Brunea (+4 CA, –4 de penalidade de armadura, 6 m de deslocamento, 15 kg). Escudo grande de madeira (+2 CA, -2 de penalidade de armadura, 5 kg).");
        values.put(ARMAS, "Maça pesada (ld8, dec.x 2,4 kg, uma mão, concussão). Besta leve (1d8, dec. 19-20 x 2, 24 m, 2 kg, perfurante).");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, saco, pederneira e isqueiro. Caixa com 10 virotes de besta. Símbolo sagrado de madeira (disco solar de Pelor). Três tochas.");
        values.put(DINHEIRO, "1d4 PO (Peças de Ouro)");
        db.insert(TABELA_CLASSE, null, values);
        //Druida
        values.put(NOME, "Druida");
        values.put(DESCRICAO, "A fúria de uma tempestade, a força suave do sol matinal, a astúcia da raposa, o poder do urso – tudo isso está sob controle do druida. Entretanto, ele não se considera um mestre da natureza. Segundo eles, essa afirmação não passa de uma simples bobagem dos habitantes das cidades. O druida não adquire seu poder controlando a natureza, mas se tornando uno com ela. Para os profanadores dos bosques sagrados dos druidas, e para os que sentem sua fúria, a distinção não é muito clara.");
        values.put(HABILIDADES, "SABEDORIA: determina a magia mais poderosa que um druida é capaz de conjurar, a quantidade de magias disponíveis a cada dia e a dificuldade para resistir às suas magias (veja Magias, a seguir). Para conjurar magias, um druida deve ter uma pontuação em SABEDORIA igual ou superior a 10 + o nível da magia. Além disso, essa habilidade determina a quantidade de magias adicionais que o druida adquire. A Classe de Dificuldade de um teste de resistência contra essas magias equivale a 10 + nível da magia + modificador de SABEDORIA.\nComo um druida utiliza somente armaduras leves ou médias, uma DESTREZA elevada aprimora sua capacidade defensiva.");
        values.put(DDV, "d8");
        values.put(ARMADURA, "Gibão de peles (+3 CA, -3 de penalidade de armadura, 6 m de deslocamento, 12,5 kg). Escudo grande de madeira (+2 CA, -2 de penalidade de armadura, 5 kg).");
        values.put(ARMAS, "Cimitarra (1d6, dec. 18-20/x2, 2 kg, uma mão, cortante). Clava (bastão de carvalho) (1d6, 3 m, dec.x 2,1,5 kg, uma mão, concussão). Funda (1d4, dec.x 2,15 m, Médio, concussão).");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, saco, pederneira e isqueiro. Bolsa com 10 balas de funda. Azevinho e visco. Três tochas.");
        values.put(DINHEIRO, "1d6 PO (Peças de Ouro)");
        //Companheiro Animal: Lobo (veja o Livro dos Monstros)
        db.insert(TABELA_CLASSE, null, values);
        //Feiticeiro
        values.put(NOME, "Feiticeiro");
        values.put(DESCRICAO, "Os feiticeiros criam a magia da mesma forma que os poetas criam as poesias, com um talento inato aperfeiçoado com a prática. Eles não possuem livros, mentores, nem teorias – apenas um poder bruto que canalizam através da sua vontade. Alguns feiticeiros afirmam que o sangue dos dragões corre em suas veias. Isso pode até ser verdade – é de conhecimento comum que alguns dragões poderosos assumem a forma humana e escolhem amantes humanóides, portanto é difícil provar que um certo feiticeiro não tenha um ancestral dracônico. É verdade que os feiticeiros geralmente ostentam uma aparência notável, quase sempre com algum aspecto exótico que demonstre sua linhagem incomum. Para outros, aceitar que os feiticeiros são, em parte, dragões pode ser um exagero infundado ou até um boato invejoso criado pelos conjuradores que não possuem esse dom.");
        values.put(HABILIDADES, "CARISMA: determina a magia mais poderosa que um feiticeiro é capaz de conjurar, a quantidade de magias disponíveis a cada dia e a dificuldade para resistir às suas magias (consulte Magias, a seguir).\nSemelhante aos magos, um feiticeiro se beneficia de valores elevados de DESTREZA e CONSTITUIÇÃO.");
        values.put(DDV, "d4");
        values.put(ARMADURA, "Vestes simples  (9 m de deslocamento).");
        values.put(ARMAS, "Lança curta (1d6, dec.x2,6 m, 1,5 kg, uma mão, perfurante). Besta Leve (1d8, dec. 19-20/ x 2, 24 m, 2 kg, perfurante).");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, saco, pederneira e isqueiro, lanterna coberta, 500 ml de óleo. Bolsa de componentes de magia. Caixa com 10 virotes.");
        values.put(DINHEIRO, "3d4 PO (Peças de Ouro)");
        /*
        Magias Conhecidas: Magias de nível 0 – detectar magia, som fantasma, luz, ler magias.
        Magias de 1° nível: mísseis mágicos, sono.
         */
        db.insert(TABELA_CLASSE, null, values);
        //Guerreiro
        values.put(NOME, "Guerreiro");
        values.put(DESCRICAO, "O cavaleiro errante, o conquistador, o campeão do rei, o soldado de elite, o mercenário experiente e o líder dos bandidos pertencem a esta classe. Os guerreiros podem ser defensores leais dos oprimidos, bandoleiros cruéis ou aventureiros corajosos. Alguns são as maiores almas da terra, determinados a enfrentar a morte para um bem maior. Outros estão entre as piores, sem escrúpulos para matar em benefício próprio ou mesmo por esporte. Os guerreiros que não se aventuram podem ser soldados, sentinelas, guarda-costas, campeões ou mantenedores da lei. Um guerreiro viajante pode ser um gladiador, mercenário, criminoso ou simplesmente um aventureiro.");
        values.put(HABILIDADES, "FORÇA: é muito importante para um guerreiro, porque aumenta sua capacidade de combate corporal e o dano de seus ataques.\nCONSTITUIÇÃO: também é essencial, pois fornece mais pontos de vida, necessários para suas diversas batalhas.\nDESTREZA: será bastante útil para os guerreiros que desejam ser arqueiros ou para selecionar talentos relacionados com essa habilidade, embora as armaduras pesadas normalmente utilizadas pelos guerreiros reduzam o benefício de uma DESTREZA elevada.");
        values.put(DDV, "d10");
        values.put(ARMADURA, "Brunea (+4 CA, -4 de penalidade de armadura, 6 m de deslocamento, 15 kg).");
        values.put(ARMAS, "Espada larga (2d6, dec. 19-20/x2,4 kg, duas mãos, cortante).");
        /*
        Anão Guerreiro
        values.put(ARMADURA, "Brunea (+4 CA, -4 de penalidade de armadura, 6 m de deslocamento, 15 kg). Escudo grande de madeira (+2 CA, -2 de penalidade de armadura)");
        values.put(ARMAS, "Machado de guerra anão (1d10, dec.x 3, 4 kg, uma mão, cortante). Arco Curto (1d6, dec.x 3,18 m, 1 kg, perfurante)");
        */
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, saco, pederneira e isqueiro. Aljava com 20 flechas.");
        values.put(DINHEIRO, "4d4 PO (Peças de Ouro)");
        db.insert(TABELA_CLASSE, null, values);
        //Ladino
        values.put(NOME, "Ladino");
        values.put(DESCRICAO, "Os ladinos têm pouco em comum entre si. Alguns são ladrões silenciosos. Outros são charlatões habilidosos. Outros são batedores, infiltradores, espiões, diplomatas e criminosos. A única coisa em comum é sua versatilidade, adaptabilidade e quantidade de recursos. Em geral, os ladinos são capazes de realizar exatamente as tarefas que seus alvos menos desejam: invadir uma sala de tesouro secreta, superar uma armadilha letal em segurança, obter planos de combate sigilosos, adquirir a confiança de um guarda ou retirar o dinheiro do bolso de alguém.");
        values.put(HABILIDADES, "DESTREZA: fornece proteção adicional para os ladinos que utilizam armaduras leves. A DESTREZA, a INTELIGÊNCIA e a SABEDORIA são importantes para a maioria das perícias do ladino. Um valor elevado de INTELIGÊNCIA também fornece pontos de perícia adicionais, sempre úteis para expandir seu repertório.");
        values.put(DDV, "d6");
        values.put(ARMADURA, "Corselete de couro (+2 CA, 6 m de deslocamento, 3 kg).");
        values.put(ARMAS, "Espada curta (1d4, dec. 19-20/ x 2,0,5 kg, leve, perfurante). Besta leve (1d8, dec. 19-20/ x 2, 24 m, 1 kg, perfurante). Adaga (1d3, dec. 19-20/ x 2, 3 m, 250 g, leve, perfurante).");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, saco, pederneira e isqueiro, instrumentos de ladrão, lanterna coberta e 300 ml de óleo. Caixa com 10 virotes.");
        values.put(DINHEIRO, "4d4 PO (Peças de Ouro)");
        db.insert(TABELA_CLASSE, null, values);
        //Mago
        values.put(NOME, "Mago");
        values.put(DESCRICAO, "Algumas palavras ininteligíveis e um gesto rápido são mais poderosos que um machado de guerra quando proferidas e executadas por um mago. Esses atos simples fazem a magia parecer fácil, mas não demonstram o tempo gasto pelo mago sobre seu grimório, preparando cada magia a ser conjurada, ou os anos que ele passou aprendendo as artes arcanas. Os magos dependem de estudo intensivo para conjurar suas magias, examinando tomos antigos, debatendo teorias mágicas com seus colegas e praticando pequenas magias sempre que possível. Para um mago, a magia não é um talento, é uma arte complexa, embora gratificante.");
        values.put(HABILIDADES, "INTELIGÊNCIA: determina a magia mais poderosa que um mago é capaz de conjurar, a quantidade de magias disponíveis a cada dia e a dificuldade para resistir às suas magias (consulte Magias, a seguir).\nUm valor elevado de DESTREZA será útil, pois fornecerá um bônus maior na Classe de Armadura, já que os magos não costumam usar armaduras.\nUm valor elevado de CONSTITUIÇÃO concede mais pontos de vida ao personagem, recurso que a classe não possui.");
        values.put(DDV, "d4");
        values.put(ARMADURA, "Vestes simples  (9 m de deslocamento).");
        values.put(ARMAS, "Bordão (1d6/1d6, dec.x 2, 2 kg, duas mãos, concussão). Besta Leve (1d8, dec. 19-20/ x 2, 24 m, 2 kg, perfurante).");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, saco, pederneira e isqueiro. Dez velas, porta-mapas, três páginas de pergaminho, tinta, caneta tinteiro. Bolsa de componentes de magia, grimório. Caixa com 10 virotes para besta.");
        values.put(DINHEIRO, "3d6 PO (Peças de Ouro)");
        /*
        Grimório: Todas as magias de nível 0; enfeitiçar pessoas, invocar criaturas I e
        sono; escolha mais uma dessas magias para cada ponto de bônus de INTELIGÊNCIA (se
        houver): causar medo, leque cromático, mísseis mágicos e imagem silenciosa.
         */
        db.insert(TABELA_CLASSE, null, values);
        //Monge
        values.put(NOME, "Monge");
        values.put(DESCRICAO, "Os monastérios estão espalhados em todo o mundo – pequenos mosteiros fechados, habitados por monges que buscam alcançar a própria perfeição através da ação e da contemplação. Eles treinam para serem guerreiros versáteis, capazes de lutar sem armas ou armaduras. Os habitantes dos monastérios comandados por mestres bondosos servem como protetores da população local. Preparados para o combate, mesmo descalços e trajando roupas simples, os monges são capazes de viajar incógnitos entre a população, capturando bandidos, líderes guerreiros e nobres corruptos de surpresa. Por outro lado, os monastérios liderados por mestres malignos controlam os arredores através do medo, como o império de um governante maligno. Os monges malignos são ideais como espiões, infiltradores e assassinos. É improvável que um determinado monge se preocupe em proteger os camponeses ou acumular riquezas. Ele se preocupa essencialmente em aperfeiçoar sua arte e, através disso, alcançar a perfeição pessoal. Seu objetivo é atingir um estado superior ao reino dos mortais.");
        values.put(HABILIDADES, "SABEDORIA: aprimora as capacidades ofensivas e defensivas do monge.\nDESTREZA: oferece uma defesa melhor e bônus em algumas perícias de classe para um monge sem armadura. A Força aprimora sua habilidade de combate desarmado.");
        values.put(DDV, "d8");
        values.put(ARMADURA, "Vestes simples  (9 m de deslocamento). (9 m de deslocamento).");
        values.put(ARMAS, "Bordão (1d6/1d6, dec.x 2, 2 kg, duas mãos, concussão). Funda (1d4, dec.x 2,15 m, concussão).");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, saco, pederneira e isqueiro. Três tochas. Bolsa com 10 balas de funda.");
        values.put(DINHEIRO, "2d4 PO (Peças de Ouro)");
        db.insert(TABELA_CLASSE, null, values);
        //Paladino
        values.put(NOME, "Paladino");
        values.put(DESCRICAO, "A compaixão na busca pelo bem, a vontade de defender a lei e o poder de derrotar o mal – essas são as três armas do paladino. Poucos indivíduos têm a pureza e a devoção necessária para seguir o caminho dos paladinos, mas esses são recompensados com o poder para proteger, curar e destruir o mal. Em um mundo cheio de magos conspiradores, sacerdotes profanos, dragões sanguinários e demônios infernais, o paladino é a última esperança, que não pode ser extinta.");
        values.put(HABILIDADES, "CARISMA: aumenta o poder de cura de um paladino, sua capacidade de se proteger e sua habilidade de expulsar mortos-vivos.\nFORÇA: é importante para um paladino, devido a sua relevância em combate.\nÉ necessário um valor igual ou superior a 14 em SABEDORIA para adquirir acesso às magias mais poderosas da classe e um valor mínimo de 11 é essencial para conjurar qualquer magia de paladino.");
        values.put(DDV, "d10");
        values.put(ARMADURA, "Brunea (+4 CA, -6 de penalidade de armadura, 6 m de deslocamento, 15 kg). Escudo grande de madeira (+2 CA, -2 de penalidade de armadura, 5 kg).");
        values.put(ARMAS, "Espada longa (1d8, dec. 19-20/x 2, 2 kg, uma mão, cortante). Arco Curto (1d6, dec.x 3,18 m, 1 kg, perfurante)");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, saco, pederneira e isqueiro. Lanterna coberta, 300 ml de óleo. Aljava com 20 flechas. Símbolo sagrado de madeira (punho de Heironeous, deus do heroísmo).");
        values.put(DINHEIRO, "6d4 PO (Peças de Ouro)");
        db.insert(TABELA_CLASSE, null, values);
        //Ranger
        values.put(NOME, "Ranger");
        values.put(DESCRICAO, "As florestas e as colinas abrigam criaturas poderosas e astutas, como os sanguinários ursos-coruja e as maliciosas panteras deslocadoras. O ranger é ainda mais poderoso e perspicaz que essas criaturas e um caçador habilidoso. Ele conhece a floresta como se ela fosse sua casa (e na verdade ela é) e cada detalhe de sua presa.");
        values.put(HABILIDADES, "DESTREZA: é essencial para um ranger, para compensar a utilização de armaduras leves e em função das perícias da classe que são baseadas nessa habilidade.\nFORÇA: é importante, pois os rangers costumam se envolver em combates com frequência.\nMuitas perícias da classe são baseadas em SABEDORIA, inclusive sua habilidade principal – rastrear seus oponentes. É necessário um valor igual ou superior a 14 em SABEDORIA para adquirir acesso às magias mais poderosas da classe e um valor mínimo de 11 é essencial para conjurar qualquer magia de ranger.");
        values.put(DDV, "d8");
        values.put(ARMADURA, "Corselete de couro batido (+3 CA, -1 de penalidade de armadura, 9 m de deslocamento, 10 kg).");
        values.put(ARMAS, "Espada longa (1d8, dec. 19-20/ x 2,1 kg, uma mão, cortante) Espada curta, mão inábil (1d6, dec. 19-20/ x 2,1 kg, leve, perfurante); Arco longo (1d8, dec.x 3, 30 m, 1,5 kg, perfurante).");
        values.put(EQUIPAMENTOS, "Mochila com cantil, um dia de rações de viagem, saco de dormir, pederneira e isqueiro. Três tochas. Aljava com 20 flechas.");
        values.put(DINHEIRO, "2d4 PO (Peças de Ouro)");
        db.insert(TABELA_CLASSE, null, values);
    }

}
