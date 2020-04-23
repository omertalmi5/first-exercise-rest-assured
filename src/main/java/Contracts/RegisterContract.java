package Contracts;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class RegisterContract implements Serializable {
  private static final long serialVersionUID = 5767787440650656765L;

  public String FirstName;

  public String LastName;

  public String UserName;

  public String Password;

  public String Email;
}
