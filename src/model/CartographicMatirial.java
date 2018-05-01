package model;

import java.net.URL;

public class CartographicMatirial  extends Resource{

    private String scale;

    public CartographicMatirial(Library instance){super(instance);}
    public CartographicMatirial(String author, String name, int year, URL source, String scale, StorageType storage, Library instance){
        super(author,name,year,source,storage,instance);
        this.scale=scale;
    }
    public CartographicMatirial(CartographicMatirial ob){
        super(ob);
        scale=ob.scale;
    }

    public void setScale(String scale) {this.scale=scale;}

    public String getScale(){ return scale;}

    //оверайды Object
    @Override
    public String toString() {
        return super.toString() +scale+".-(CartographicMatirial).\n";
    }
    @Override
    public int hashCode() {
        return super.hashCode() + 3*scale.hashCode();
    }
    @Override
    public boolean equals (Object ob) {
        if(!super.equals(ob)) return false;
        CartographicMatirial other=(CartographicMatirial) ob;
        return (scale.equals(other.scale));
    }

    @Override
    public void reproduce() {

    }
}
