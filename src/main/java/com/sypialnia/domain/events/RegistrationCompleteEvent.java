package com.sypialnia.domain.events;

import com.sypialnia.domain.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
public class RegistrationCompleteEvent extends ApplicationEvent {
  private String appUrl;
  private User user;

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

  public RegistrationCompleteEvent(String appUrl, User user) {
    super(user);
    this.user = user;
    this.appUrl = appUrl;
  }
}
