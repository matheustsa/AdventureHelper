package com.mtsa.adventurehelper.desenvolvimento;

/**
 * Created by mathe on 05/04/2017.
 */

public class CelulaLista {
    int idImagem;
    String nomePerson;
    String lvlPerson;
    String classePerson;

    CelulaLista(int imagem, String nome, String classe, String lvl){
        idImagem    = imagem;
        nomePerson  = nome;
        classePerson = classe;
        lvlPerson = lvl;

    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public String getNomePerson() {
        return nomePerson;
    }

    public void setNomePerson(String nomePerson) {
        this.nomePerson = nomePerson;
    }

    public String getLvlPerson() {
        return lvlPerson;
    }

    public void setLvlPerson(String lvlPerson) {
        this.lvlPerson = lvlPerson;
    }

    public String getClassePerson() {
        return classePerson;
    }

    public void setClassePerson(String classePerson) {
        this.classePerson = classePerson;
    }
}
