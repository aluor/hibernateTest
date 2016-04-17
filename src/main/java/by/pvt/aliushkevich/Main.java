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

    student.setFirstName("FirstName");
    student.setLastName("LastName");
    student.setLogin("Student1");
    student.setPassword("111");

    getStudentDAO().saveOrUpdate(student);

  }

  public static StudentDAO getStudentDAO() {
    if (studentDAO == null) {
      studentDAO = new StudentDAO();
    }
    return studentDAO;
  }

}
