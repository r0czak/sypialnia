package com.sypialnia.domain.events;

import com.sypialnia.domain.entities.User;
import com.sypialnia.domain.models.PasswordModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
public class ResetPasswordEvent extends ApplicationEvent {
  private String appUrl;
  private User user;
  private PasswordModel passwordModel;

  public String getAppUrl() {
    return appUrl;
  }

  public void setAppUrl(String appUrl) {
    this.appUrl = appUrl;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public PasswordModel getPasswordModel() {
    return passwordModel;
  }

  public void setPasswordModel(PasswordModel passwordModel) {
    this.passwordModel = passwordModel;
  }

  public ResetPasswordEvent(String appUrl, User user, PasswordModel passwordModel) {
    super(user);
    this.user = user;
    this.appUrl = appUrl;
    this.passwordModel = passwordModel;
  }
}
