package by.pvt.aliushkevich.pojos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student implements Serializable {
  private static final long serialVersionUID = 3L;
  private int id;
  private String firstName;
  private String lastName;
  private String login;
  private String password;
  private Set<Relation> relations = new HashSet<>();
  private Map<Integer, Integer> marks = new HashMap<>();
  private Map<Integer, String> feedbacks = new HashMap<>();

  public Student() {
  }

  public Student(String firstName, String lastName, String login, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.login = login;
    this.password = password;
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

  public Set<Relation> getRelations() {
    return relations;
  }

  public void setRelations(Set<Relation> relations) {
    this.relations = relations;
  }

  public Map<Integer, Integer> getMarks() {
    return marks;
  }

  public void setMarks(Map<Integer, Integer> marks) {
    this.marks = marks;
  }

  public Map<Integer, String> getFeedbacks() {
    return feedbacks;
  }

  public void setFeedbacks(Map<Integer, String> feedbacks) {
    this.feedbacks = feedbacks;
  }

  @Override
  public String toString() {
    return "Student ID " + id + ": " + firstName + " " + lastName + " (login: " + login + ")\n<br>"
        + " marks: " + marks + "\n" + " feedbacks: " + feedbacks + "<br><br>";
  }
}
