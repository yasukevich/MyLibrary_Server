package net;

import model.Library;
import model.User;

import java.io.Serializable;

public class Request implements Serializable {
    Library lib;
    int choise;
    User user;

    Request(){ lib=new Library();}
    Request(Library lib, int choise){ this.lib=lib; this.choise=choise;}
    Request(User user, int choise){ this.user=user; this.choise=choise;}

    public Library getLib(){
        return lib;
    }
    public int getChoise(){
        return choise;
    }
    public User getUser(){
        return user;
    }
}
