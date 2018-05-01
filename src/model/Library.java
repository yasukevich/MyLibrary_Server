package model;

import java.io.Serializable;
import java.util.TreeSet;

public class Library  implements Serializable {

    private String name;
    private String libId;
    private int contryId;
    protected TreeSet<Resource> resourceList;

    public Library(){
        resourceList=new TreeSet<>();
    }
    public Library(String name,String libId,int contryId){
        this.name=name;
        this.libId=libId;
        this.contryId=contryId;
        resourceList=new TreeSet<>();
    }
    public Library(String name,String libId,int contryId,TreeSet<Resource> resourceList){
        this.name=name;
        this.libId=libId;
        this.contryId=contryId;
        this.resourceList=resourceList;
    }

    public void setName(String name) {this.name=name;}
    public void setLibId(String libId) {this.libId=libId;}
    public void setContryId(int contryId) {this.contryId=contryId;}

    public String getName() { return name;}
    public String getLibId() { return libId;}
    public int getContryId() { return contryId;}


    @Override
    public String toString() {
        if(resourceList.isEmpty()) return "Library: " + name + ". Library ID: " + libId + " contryId=" + contryId +".\n";
        else {
            StringBuilder str= null;
            for(Resource i:resourceList) {
                if(str==null) str = new StringBuilder(i.toString());
                else str.append(i.toString());
            }
            return "Library: " + name + ". Library ID: " + libId + " contryId=" + contryId +".\n"+str;
        }
    }

    public void addResource(Resource item){
        resourceList.add(item);
    }
    public void deleteResource(){

    }
    public Resource loadResource(int id){

        Resource temp=null;
        int y=0;
        for(Resource i:resourceList) {
            if(y==id) {
                temp=i;
                break;
            }
            y++;
        }
        return temp;
    }
}
