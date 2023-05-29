package com.javarush.jira.profile.web;

import com.javarush.jira.MatcherFactory;
import com.javarush.jira.common.util.JsonUtil;
import com.javarush.jira.profile.ContactTo;
import com.javarush.jira.profile.ProfileTo;

import java.util.Set;

public class ProfileTestData {

    public static final MatcherFactory.Matcher<ProfileTo> PROFILE_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(
            ProfileTo.class,"mailNotifications");

    public static final String USER_PASSWORD = "password";
    public static final ContactTo contact1 = new ContactTo("skype","userSkype");
    public static final ContactTo contact2 = new ContactTo("mobile","+01234567890");
    public static final ContactTo contact3 = new ContactTo("website","user.com");
    public static final Set<ContactTo> userSet = Set.of(contact1, contact2, contact3);

    public static final ContactTo adminContact1 = new ContactTo("github","adminGitHub");
    public static final ContactTo adminContact2 = new ContactTo("tg","adminTg");
    public static final ContactTo adminContact3 = new ContactTo("vk","adminVk");
    public static final Set<ContactTo> adminSet = Set.of(adminContact1, adminContact2, adminContact3);
    public static final Set<String> wrongSet = Set.of("1", "3", "7");
    public static final ProfileTo profileTo = new ProfileTo(1L,null, userSet);
    public static final ProfileTo adminProfileTo = new ProfileTo(2L,null, adminSet);
    public static final ProfileTo newProfileTo = new ProfileTo(3L,null, null);

    public static final String notification1 = "three_days_before_deadline";
    public static final String notification2 = "two_days_before_deadline";
    public static final String notification3 = "deadline";
    public static final Set<String> notificationsSet = Set.of(notification1, notification2, notification3);

    public static <T> String jsonWithPassword(T profileTo, String password) {
        return JsonUtil.writeAdditionProps(profileTo, "password", password);
    }
}
