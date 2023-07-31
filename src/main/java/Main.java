import db.IDBConnector;
import db.MySqlConnector;
import tables.*;

import java.util.List;

public class Main {
    static IDBConnector db;

   public static List<Student> students = List.of(
        //тут все студенты
         new Student("1","Иванов","m","1"),
           new Student("2","Петров","m","2"),
           new Student("3","Сидоров","m","3"),
           new Student("4","Макаров","m","1"),
           new Student("5","Первый","m","2"),
           new Student("6","Второй","m","3"),
           new Student("7","Пятая","ж","1"),
           new Student("8","Белая","ж","2"),
           new Student("9","Черная","ж","3"),
           new Student("10","Красная","ж","1"),
           new Student("11","Оршова","m","2"),
           new Student("12","Егоров","m","3"),
           new Student("13","Сурова","ж","1"),
           new Student("14","Ухова","ж","2"),
           new Student("15","Носова","ж","3")
   );

   public static List<Groop> groops = List.of(
           new Groop("1","математика","1"),
           new Groop("2","русский","2"),
           new Groop("3","физика","3")

   );

   public static List<Curator> curators = List.of(
           new Curator("1","Тащи"),
           new Curator("2","тарасов"),
           new Curator("3","Алексеев"),
           new Curator("4","Рыбаков")
   );

    public static void main(String[] args) {
        /// создание обьектов
        StudentTable studentTable = new StudentTable();
        GroopTable groupTable = new GroopTable();
        CuratorTable curatorTable = new CuratorTable();

        // обьектам присваеваем метод создания таблиц
        studentTable.create();
        groupTable.create();
        curatorTable.create();


        System.out.println(studentTable);
        for (Student student: students) {
            studentTable.insert(student);
        }
        System.out.println("Все данные из таблицы studentTable");
        studentTable.selectAll();


        System.out.println(groupTable);
        for (Groop groop: groops) {
            groupTable.insert(groop);
        }
        System.out.println("Все данные из таблицы groupTable");
        groupTable.selectAll();


        System.out.println(curatorTable);
        for (Curator curator:curators) {
            curatorTable.insert(curator);
        }
        System.out.println("Все данные из таблицы curatorTable");
        curatorTable.selectAll();

        System.out.println("Задание№5/Информация о всех студентах включая название группы и имя куратора");
        studentTable.selectStudentTable();
        System.out.println("Задание№6/Вывести на экран количество студентов");
        studentTable.selectCountStudent();
        System.out.println("Задание№7/Вывести студенток");
        studentTable.selectStudentWoman();
        System.out.println("Задание№8/Обновить данные по группе сменив куратора");
        String StringsqlRequest_s1 = ("UPDATE curator SET fio = (case when id = 1 then 'Один' " +
                                                                      "when id = 2 then 'Два' " +
                                                                      "when id = 3 then 'три' " +
                                                                      "when id = 4 then 'четыре' " +
                                                                                           "end ) " +
                                                          "where id  in ('1','2','3','4') ");
        db = new MySqlConnector();
        db.executeRequest(StringsqlRequest_s1);
        System.out.println("Обновленные данные по таблицы Curator");
        curatorTable.selectAll();
        System.out.println("Задание№9/Вывести список групп с их кураторами");
        studentTable.selectStudentCurator();
        System.out.println("Задание№10/Вывести на экран студентов из определенной группы(поиск по имени группы)");
        studentTable.selectStudentGroop();
    }

}
