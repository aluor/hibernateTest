package by.pvt.aliushkevich.pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Lecturer implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String firstName;
  private String lastName;
  private String login;
  private String password;
  private int courseId;
  private Set<Student> students = new HashSet<>();

  public Lecturer() {
  }

  public Lecturer(String firstName, String lastName, String login, String password, int courseId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.login = login;
    this.password = password;
    this.courseId = courseId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public Set<Student> getStudents() {
    return students;
  }

  public void setStudents(Set<Student> students) {
    this.students = students;
  }


//  public void setMark(Student student, int mark) {
//    student.setMark(mark);
//  }
//
//  public void setFeedback(Student student, String feedback) {
//    student.setFeedback(feedback);
//  }

  @Override
  public String toString() {
    return "Lecturer №" + id + ": " + firstName + " " + lastName + " (login: " + login + ")\n"
        + "Teaches courses:" + courseId;
  }
}
