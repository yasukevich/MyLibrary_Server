package model;

import java.net.URL;

public class PrintedMatirial  extends Resource {
    private int pages;

    public PrintedMatirial(Library instance){super(instance);}
    public PrintedMatirial(String author, String name, int year, URL source, int pages, StorageType storage, Library instance){
        super(author,name,year,source,storage,instance);
        this.pages=pages;
    }
    public PrintedMatirial(PrintedMatirial ob){
        super(ob);
        pages=ob.pages;
    }

    public void setPages(int pages) {this.pages=pages;}

    public int getPages(){ return pages;}

    @Override
    public String toString() {
        return super.toString() +pages+"-(PrintedMatirial).\n";
    }
    @Override
    public int hashCode() {
        return super.hashCode() + 9*pages;
    }
    @Override
    public boolean equals (Object ob) {
        if(!super.equals(ob)) return false;
        PrintedMatirial other=(PrintedMatirial) ob;
        return (pages==other.pages);
    }

    @Override
    public void reproduce() {

    }
}
