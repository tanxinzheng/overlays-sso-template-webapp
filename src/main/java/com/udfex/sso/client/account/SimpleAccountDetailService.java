package com.udfex.sso.client.account;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.List;
import java.util.Map;

/**
 * Created by Jeng on 2016/5/6.
 */
public class SimpleAccountDetailService implements AccountDetailService {

    private static String USER_ID = "userid";
    private static String USERNAME = "username";
    private static String EMAIL = "email";
    private static String PHONE_NUMBER = "phoneNumber";

    private Map<String, Object> getAttribute(){
        Subject subject = SecurityUtils.getSubject();
        List<Object> listPrincipals = subject.getPrincipals().asList();
        Map<String, Object> attributes = (Map<String, Object>) listPrincipals.get(1);
        return attributes;
    }

    @Override
    public String getUsername() {
        Map<String, Object> attributes = getAttribute();
        String username = (String)attributes.get(USERNAME);
        if(StringUtils.trimToNull(username) != null){
            return username;
        }
        return null;
    }

    @Override
    public String getUserId() {
        Map<String, Object> attributes = getAttribute();
        String userId = (String)attributes.get(USER_ID);
        if(StringUtils.trimToNull(userId) != null){
            return userId;
        }
        return null;
    }

    @Override
    public String getEmail() {
        Map<String, Object> attributes = getAttribute();
        String email = (String)attributes.get(EMAIL);
        if(StringUtils.trimToNull(email) != null){
            return email;
        }
        return null;
    }

    @Override
    public String getPhoneNumber() {
        Map<String, Object> attributes = getAttribute();
        String phoneNumber = (String)attributes.get(PHONE_NUMBER);
        if(StringUtils.trimToNull(phoneNumber) != null){
            return phoneNumber;
        }
        return null;
    }
}
