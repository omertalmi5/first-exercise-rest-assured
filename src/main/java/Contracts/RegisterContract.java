package Contracts;

import Utils.StringUtils;
import lombok.Builder;
import lombok.Builder.Default;

import java.io.Serializable;

import static Utils.StringUtils.getRandomString;

@Builder(builderMethodName = "aRegisterDetails")
public class RegisterContract implements Serializable {
  private static final long serialVersionUID = 1L;

  @Default private String FirstName = getRandomString();

  @Default private String LastName = getRandomString();

  @Default private String UserName = getRandomString();

  @Default private String Password = "password1";

  @Default private String Email = "someuser@gmail.com";
}
