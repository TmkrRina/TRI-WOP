package com.doclink.events;

import com.doclink.model.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private User user;

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public User getUser() {
        return user;
    }

    public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }
}
