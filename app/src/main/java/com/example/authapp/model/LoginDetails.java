package com.example.authapp.model;

public class LoginDetails {
    private String token;
    private Integer id;
    private String name;
    private String email;
    private Object emailVerifiedAt;
    private Object socialType;
    private Object socialId;
    private Object socialEmail;
    private String createdAt;
    private String updatedAt;
    private Integer newsletter;
    private String isSocial;
    private Boolean hasSubscription;
    private int notifications_opted;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public Object getSocialType() {
        return socialType;
    }

    public void setSocialType(Object socialType) {
        this.socialType = socialType;
    }

    public Object getSocialId() {
        return socialId;
    }

    public void setSocialId(Object socialId) {
        this.socialId = socialId;
    }

    public Object getSocialEmail() {
        return socialEmail;
    }

    public void setSocialEmail(Object socialEmail) {
        this.socialEmail = socialEmail;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Integer newsletter) {
        this.newsletter = newsletter;
    }

    public String getIsSocial() {
        return isSocial;
    }

    public void setIsSocial(String isSocial) {
        this.isSocial = isSocial;
    }

    public Boolean getHasSubscription() {
        return hasSubscription;
    }

    public void setHasSubscription(Boolean hasSubscription) {
        this.hasSubscription = hasSubscription;
    }

    public int isNotifications_opted() {
        return notifications_opted;
    }

    public void setNotifications_opted(int notifications_opted) {
        this.notifications_opted = notifications_opted;
    }
}
