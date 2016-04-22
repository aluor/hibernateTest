package by.pvt.aliushkevich;

import by.pvt.aliushkevich.dao.LecturerDAO;
import by.pvt.aliushkevich.dao.StudentDAO;
import by.pvt.aliushkevich.exceptions.DaoException;
import by.pvt.aliushkevich.pojos.Lecturer;
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
    getStudentDAO().saveOrUpdate(student1);

    Student student2 = new Student();
    student2.setFirstName("StudName2");
    student2.setLastName("StudSurname2");
    student2.setLogin("Student2");
    student2.setPassword("222");
    getStudentDAO().saveOrUpdate(student2);

    try {
      System.out.print(getStudentDAO().get(1));
      System.out.print(getStudentDAO().get(2));
    } catch (DaoException e) {
      e.printStackTrace();
    } catch (NullPointerException e) {
      log.error("Unable find person:", e);
    }

    Lecturer lecturer1 = new Lecturer();
    lecturer1.setFirstName("LectName1");
    lecturer1.setLastName("LectSurname1");
    lecturer1.setLogin("Lecturer1");
    lecturer1.setPassword("111");
    lecturer1.getStudents().add(student1);
    lecturer1.getStudents().add(student2);
    getLecturerDAO().saveOrUpdate(lecturer1);


//    getStudentDAO().delete(student1);
//
//    try {
//      student1 = getStudentDAO().get(1);
//      System.out.print(student1);
//    } catch (DaoException e) {
//      e.printStackTrace();
//    } catch (NullPointerException e) {
//      log.error("Unable find person:", e);
//    }


    util.getSession().close();
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
