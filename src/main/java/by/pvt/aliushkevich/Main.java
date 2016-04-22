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

    Student student = new Student();
    Student student1;

    student.setFirstName("Fedor");
    student.setLastName("Pipkin");
    student.setLogin("Student1");
    student.setPassword("111");

    getStudentDAO().saveOrUpdate(student);

    try {
      student1 = getStudentDAO().get(1);
      System.out.print(student1);
    } catch (DaoException e) {
      e.printStackTrace();
    } catch (NullPointerException e) {
      log.error("Unable find person:", e);
    }

    Lecturer lecturer = new Lecturer();

    lecturer.setFirstName("Roman");
    lecturer.setLastName("Pupkin");
    lecturer.setLogin("Lecturer1");
    lecturer.setPassword("111");

    getLecturerDAO().saveOrUpdate(lecturer);


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
