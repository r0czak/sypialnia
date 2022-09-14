package com.sypialnia.domain.events;

import com.sypialnia.domain.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
public class ResendVerificationTokenEvent extends ApplicationEvent {
  private String appUrl;
  private User user;
  private String existingToken;

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

  public String getExistingToken() {
    return existingToken;
  }

  public void setExistingToken(String existingToken) {
    this.existingToken = existingToken;
  }

  public ResendVerificationTokenEvent(String appUrl, User user, String existingToken) {
    super(user);
    this.user = user;
    this.appUrl = appUrl;
    this.existingToken = existingToken;
  }
}
