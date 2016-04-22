package by.pvt.aliushkevich.pojos;

//import by.pvt.aliushkevich.enums.Courses;

//@Entity
//@Table
public class Student {

//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  @Column
  private int id;

//  @Column
  private String firstName;

//  @Column
  private String lastName;

//  @Column
  private String login;

//  @Column
  private String password;

//private Courses learningCourse;

//  @Column
  private int mark;

//  @Column
  private String feedback;

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

//  public Courses getLearningCourse() {
//    return learningCourse;
//  }
//
//  public void setLearningCourse(Courses learningCourse) {
//    this.learningCourse = learningCourse;
//  }

  public int getMark() {
    return mark;
  }

  public void setMark(int mark) {
    this.mark = mark;
  }

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  @Override
  public String toString() {
    return "Student ID " + id + ": " + firstName + " " + lastName + " (login: " + login + ")\n<br>"
        +/*"learning:" +learningCourse  + */" mark: " + mark + "\n" + " feedback: " + feedback + "<br><br>";
  }
}
