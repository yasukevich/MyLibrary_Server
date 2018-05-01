package net;

import model.Library;

import java.io.Serializable;

public class Responce implements Serializable {
    Library lib;
    int choise;

    Responce(){ lib=new Library();}
    Responce(Library lib,int choise){ this.lib=lib; this.choise=choise;}

    public Library getLib(){
        return lib;
    }
    public int getChoise(){
        return choise;
    }
}
