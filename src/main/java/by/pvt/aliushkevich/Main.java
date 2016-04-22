package by.pvt.aliushkevich;

import by.pvt.aliushkevich.dao.StudentDAO;
import by.pvt.aliushkevich.exceptions.DaoException;
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

  public static void main(String[] args) throws DaoException {
    util = HibernateUtil.getHibernateUtil();

    Student student = new Student();
    Student student1 = null;

    student.setFirstName("Igor3");
    student.setLastName("Aliushk3");
    student.setLogin("Student3");
    student.setPassword("333");
    student.setLearningCourseId(1);

    getStudentDAO().saveOrUpdate(student);

    try {
      student1 = getStudentDAO().get(1);
      System.out.print(student1);
    } catch (DaoException e) {
      e.printStackTrace();
    } catch (NullPointerException e) {
      log.error("Unable find person:", e);
    }

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

}
