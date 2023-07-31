package tables;

public class Student {
    private String id;
    private String fio;
    private String sex;
    private String id_group;

   public Student (String id,String fio,String sex,String id_group){
       this.id = id;
       this.fio = fio;
       this.sex = sex;
       this.id_group = id_group;
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

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getId_group(){
        return id_group;
    }

    public void setId_group(String id_group){
        this.id_group = id_group;
    }


}

