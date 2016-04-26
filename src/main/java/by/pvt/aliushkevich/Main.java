package by.pvt.aliushkevich;

import by.pvt.aliushkevich.dao.LecturerDAO;
import by.pvt.aliushkevich.dao.StudentDAO;
import by.pvt.aliushkevich.exceptions.DaoException;
import by.pvt.aliushkevich.pojos.Lecturer;
import by.pvt.aliushkevich.pojos.Relation;
import by.pvt.aliushkevich.pojos.Student;
import by.pvt.aliushkevich.util.HibernateUtil;
import org.apache.log4j.Logger;

/**
 * Created by Rabotnik on 17.04.2016.
 */
public class Main {
  private static Logger log = Logger.getLogger(Main.class);
  public static HibernateUtil util = null;
  private static StudentDAO studentDAO = null;
  private static LecturerDAO lecturerDAO = null;

  public static void main(String[] args) throws DaoException {
    util = HibernateUtil.getHibernateUtil();

    Student student1 = new Student();
    student1.setFirstName("StudName1");
    student1.setLastName("StudSurname1");
    student1.setLogin("Student1");
    student1.setPassword("111");

    Student student2 = new Student();
    student2.setFirstName("StudName2");
    student2.setLastName("StudSurname2");
    student2.setLogin("Student2");
    student2.setPassword("222");

    Lecturer lecturer1 = new Lecturer();
    lecturer1.setFirstName("LectName1");
    lecturer1.setLastName("LectSurname1");
    lecturer1.setLogin("Lecturer1");
    lecturer1.setPassword("111");

    getStudentDAO().saveOrUpdate(student1);
    getStudentDAO().saveOrUpdate(student2);


    Relation relation1 = new Relation();
    relation1.setStudent(student1);
    relation1.setLecturer(lecturer1);
    relation1.setMark(2);
    lecturer1.getRelations().add(relation1);

    Relation relation2 = new Relation();
    relation2.setStudent(student2);
    relation2.setLecturer(lecturer1);
    relation2.setMark(5);
    lecturer1.getRelations().add(relation2);

    getLecturerDAO().saveOrUpdate(lecturer1);
lecturer1.getRelations().remove(relation1);

    getLecturerDAO().saveOrUpdate(lecturer1);



    try {
      Student student02 = getStudentDAO().get(2);
      System.out.println(student02);
      Lecturer lecturer01 = getLecturerDAO().get(1);
      System.out.println(lecturer01);
    } catch (DaoException e) {
      e.printStackTrace();
    } catch (NullPointerException e) {
      log.error("Unable find person:", e);
    }


//    Student student3 = new Student();
//    student1.setFirstName("StudName3");
//    student1.setLastName("StudSurname3");
//    student1.setLogin("Student3");
//    student1.setPassword("333");
//    getStudentDAO().saveOrUpdate(student3);


//    getStudentDAO().delete(student1);

    util.closeSession();

    try {
      Student student02 = getStudentDAO().get(2);
      System.out.println(student02);
      Lecturer lecturer01 = getLecturerDAO().get(1);
      System.out.println(lecturer01);
    } catch (DaoException e) {
      e.printStackTrace();
    } catch (NullPointerException e) {
      log.error("Unable find person:", e);
    }


    System.exit(0);
  }

  public static StudentDAO getStudentDAO() {
    if (studentDAO == null) {
      studentDAO = new StudentDAO();
    }
    return studentDAO;
  }

  public static LecturerDAO getLecturerDAO() {
    if (lecturerDAO == null) {
      lecturerDAO = new LecturerDAO();
    }
    return lecturerDAO;

  }
}
