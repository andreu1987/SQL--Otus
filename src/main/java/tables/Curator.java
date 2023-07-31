package tables;

public class Curator {
    private String id;
    private String fio;

    public Curator(String id,String fio){
        this.id = id;
        this.fio = fio;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getFio(){
        return fio;
    }

    public void setFio(String fio){
        this.fio = fio;
    }
}
