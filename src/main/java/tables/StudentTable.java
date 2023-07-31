package tables;

import db.MySqlConnector;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentTable extends AbsTable {
    private final static String TABLE_NAME = "Student";
    public static Map<String, String> userColumns = new LinkedHashMap<>(){{
        put("id","varchar(10)");
        put("fio","varchar(100)");
        put("sex","varchar(10)");
        put("id_group","varchar(10)");
    }};



    public StudentTable(){
        super(TABLE_NAME, userColumns);
    }

    @Override
    public String toString() {
        return ("Успешно создана таблица " + TABLE_NAME);
    }

    public void insert(Student student){
        String sqlRequest_s1 = String.format("INSERT INTO student(id,fio,sex,id_group) VALUES ('%s','%s','%s','%s')",
                student.getId(),student.getFio(),student.getSex(),student.getId_group());
        System.out.println(sqlRequest_s1);
        db = new MySqlConnector();
        db.executeRequest(sqlRequest_s1);
    }
}
