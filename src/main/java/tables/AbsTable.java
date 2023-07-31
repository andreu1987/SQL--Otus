package tables;

import db.IDBConnector;
import db.MySqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbsTable {
    private String tableName;
    private Map<String, String> columns;
    IDBConnector db;

    public AbsTable(String tableName, Map<String, String> columns) {
        this.tableName = tableName;
        this.columns = columns;


    }

    public void create() {
        this.columns = columns;
        String sqlRequest = String.format("CREATE TABLE IF NOT EXISTS %s (%s)", this.tableName, convertMapColumnsToString());
        db = new MySqlConnector();
        db.executeRequest(sqlRequest);
        //db.close();
    }

    private String convertMapColumnsToString() {
        final String result = columns.entrySet().stream()
                .map((Map.Entry entry) -> String.format("%s %s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
        return result;
    }


    public void selectAll() {
        db = new MySqlConnector();
        final String sqlRequest = String.format("SELECT * FROM %s", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        // колличество колонок в результирующем запросе
        try {
            int columnCount = rs.getMetaData().getColumnCount();
            // перебор строк с данными
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //db.close();
        }

    }

    //"Задание№5/Информация о всех студентах включая название группы и имя куратора"
    public void selectStudentTable() {
        db = new MySqlConnector();
        final String sqlRequest = String.format("SELECT s2.id, s2.fio, s2.sex,s2.id_group,g2.name,c2.fio " +
                "FROM student s2 join groop g2 on s2.id_group = g2.id join curator c2 on g2.id_curator = c2.id");
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        // колличество колонок в результирующем запросе
        try {
            int columnCount = rs.getMetaData().getColumnCount();
            // перебор строк с данными
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //db.close();
        }

    }

    //"Задание№6/Вывести на экран количество студентов"
    public void selectCountStudent() {
        db = new MySqlConnector();
        final String sqlRequest = String.format("SELECT count(id) FROM student s2");
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        // колличество колонок в результирующем запросе
        try {
            int columnCount = rs.getMetaData().getColumnCount();
            // перебор строк с данными
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //db.close();
        }

    }

    // "Задание№7/Вывести студенток"
    public void selectStudentWoman() {
        db = new MySqlConnector();
        final String sqlRequest = String.format("SELECT * FROM student s2 WHERE sex in (\"Ж\")");
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        // колличество колонок в результирующем запросе
        try {
            int columnCount = rs.getMetaData().getColumnCount();
            // перебор строк с данными
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //db.close();
        }

    }

    //"Задание№9/Вывести список групп с их кураторами"
    public void selectStudentCurator() {
        db = new MySqlConnector();
        final String sqlRequest = String.format("SELECT g2.id,g2.name,g2.id_curator,c2.fio " +
                "FROM groop g2 JOIN curator c2 on g2.id_curator = c2.id ");
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        // колличество колонок в результирующем запросе
        try {
            int columnCount = rs.getMetaData().getColumnCount();
            // перебор строк с данными
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //db.close();
        }

    }

    // "Задание№10/Вывести на экран студентов из определенной группы(поиск по имени группы)"
    public void selectStudentGroop() {
        db = new MySqlConnector();
        final String sqlRequest = String.format("SELECT s.fio,g.name  FROM student s " +
                "JOIN groop g on s.id_group = g.id WHERE g.name in (\"математика\",\"русский\",\"физика\") ");
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        // колличество колонок в результирующем запросе
        try {
            int columnCount = rs.getMetaData().getColumnCount();
            // перебор строк с данными
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //db.close();
        }

    }


}
