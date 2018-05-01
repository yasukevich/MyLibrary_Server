package model;

import interfaces.Reproducible;

import java.io.Serializable;
import java.net.URL;

public abstract class Resource implements Reproducible,Comparable<Resource>, Serializable {

    protected static int count=-1;
    protected String author;
    protected String name;
    protected int year;
    protected URL source;
    protected id resId;
    protected StorageType storage;

    class id implements Serializable {
        String libId;
        int contryId;
        int itemId;

        id(Library instance){
            libId=instance.getLibId();
            contryId=instance.getContryId();
            itemId=count;
        }
        id(id ob){
            this.libId=ob.libId;
            this.contryId=ob.contryId;
            this.itemId=ob.itemId;
        }

        @Override
        public String toString(){
            return (libId+"-"+contryId+"-"+itemId+".");
        }
        @Override
        public boolean equals(Object ob) {
            if(this==ob) return true;
            if(ob==null) return false;
            if(getClass()!=ob.getClass()) return false;
            id other=(id) ob;
            return (itemId==other.itemId);
        }
    }
    protected Resource(Library instance){
        count++;
        this.resId=new id(instance);

    }
    protected Resource(Resource ob){
        if(ob==null) throw new IllegalArgumentException("Transmitted object not found");
        count++;
        author=ob.author;
        name=ob.name;
        year=ob.year;
        source=ob.source;
        storage=ob.storage;
        count++;
        this.resId=new id(ob.resId);
    }
    protected Resource(String author, String name, int year,URL source,StorageType storage,Library instance){
        count++;
        this.author=author;
        this.name=name;
        this.year=year;
        this.source=source;
        this.storage=storage;
        this.resId=new id(instance);
    }

    public void setAuthor(String author) {this.author=author;}
    public void setName(String name) {this.name=name;}
    public void setYear(int year) {this.year=year;}
    public void setSource(URL source) {this.source=source;}
    public void setStorage(StorageType storage) {this.storage=storage;}

    public String getAuthor(){ return author;}
    public String getName(){ return name;}
    public int getYear(){ return year;}
    public URL getSource(){ return source;}
    public StorageType getStorage() {return storage;}
    public id getID() {return resId;}

    @Override
    public String toString() {
        return author+".-"+name+".-" + year +".- "+source+".- "+resId+"- ";
    }
    @Override
    public int hashCode() {
        return 10 * name.hashCode() +
                5 * author.hashCode() +
                10*year;
    }
    @Override
    public boolean equals (Object ob) {
        if(this==ob) return true;
        if(ob==null) return false;
        if(getClass()!=ob.getClass()) return false;
        Resource other=(Resource) ob;
        return (author.equals(other.author) & name.equals(other.name) &year==other.year);
    }
    @Override
    public int compareTo(Resource o) {
        if(author.compareTo(o.getAuthor())!=0) return author.compareTo(o.getAuthor());
        return name.compareTo(o.getName());
    }
}
