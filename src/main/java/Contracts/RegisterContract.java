package Contracts;

import Utils.StringUtils;
import lombok.Builder;
import lombok.Builder.Default;

import java.io.Serializable;

import static Utils.StringUtils.getRandomString;

@Builder(builderMethodName = "aRegisterDetails")
public class RegisterContract implements Serializable {
  private static final long serialVersionUID = 5767787440650656765L;

  @Default public String FirstName = getRandomString();

  @Default public String LastName = getRandomString();

  @Default public String UserName = getRandomString();

  @Default public String Password = getRandomString();

  @Default public String Email = getRandomString() + "@gmail.com";
}
