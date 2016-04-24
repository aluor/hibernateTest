package by.pvt.aliushkevich.pojos;

import java.io.Serializable;

/**
 * Created by Rabotnik on 23.04.2016.
 */
public class Relation implements Serializable {
  private static final long serialVersionUID = 2L;
  private int id;
  private Lecturer lecturer;
  private Student student;
  private int mark;

  public Relation() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Lecturer getLecturer() {
    return lecturer;
  }

  public void setLecturer(Lecturer lecturer) {
    this.lecturer = lecturer;
  }

  public int getMark() {
    return mark;
  }

  public void setMark(int mark) {
    this.mark = mark;
  }
}
