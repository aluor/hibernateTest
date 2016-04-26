package by.pvt.aliushkevich.pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable {
  private static final long serialVersionUID = 3L;
  private int id;
  private String firstName;
  private String lastName;
  private String login;
  private String password;
  private Set<Relation> relations = new HashSet<>();

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

  @Override
  public String toString() {
    return "Student ID " + id + ": " + firstName + " " + lastName + " (login: " + login + ")\n" + "relations: " +relations;
  }
}
