package tables;

public class Groop {
    private String id;
    private String name;
    private String id_curator;

    public Groop(String id,String name,String id_curator) {
        this.id = id;
        this.name = name;
        this.id_curator = id_curator;

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String fio){
        this.name = name;
    }

    public String getId_curator(){
        return id_curator;
    }

    public void setId_curator(String id_curator){
        this.id_curator = id_curator;
    }
}
