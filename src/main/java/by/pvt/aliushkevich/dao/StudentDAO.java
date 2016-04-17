package by.pvt.aliushkevich.dao;

import by.pvt.aliushkevich.Main;
import by.pvt.aliushkevich.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO<Student> implements DAO<Student> {
  private static Logger log = Logger.getLogger(StudentDAO.class);
  private Transaction transaction = null;

  public StudentDAO() {
  }

  public void saveOrUpdate(Student student) throws DaoException {
    try {
      Session session = Main.util.getSession();
      transaction = session.beginTransaction();
      session.saveOrUpdate(student);
      log.info("saveOrUpdate(student):" + student);
      transaction.commit();
      log.info("Save or update (commit):" + student);
    } catch (HibernateException e) {
      log.error("Error save or update PERSON in DAO" + e);
      transaction.rollback();
      throw new DaoException(e);
    }

  }
}
