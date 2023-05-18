package com.javarush.jira.bugtracking;

import com.javarush.jira.AbstractControllerTest;
import com.javarush.jira.bugtracking.internal.model.UserBelong;
import com.javarush.jira.bugtracking.internal.repository.UserBelongRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserBelongServiceTest  extends AbstractControllerTest {

    @Autowired
    UserBelongService userBelongService;
    @Autowired
    UserBelongRepository userBelongRepository;

    @Test
    void SubscribeToTaskWithDifferentUser() {
        Long taskId = 2L;
        Long newSubscriberToTask = 1L;
        userBelongService.subscribeToTask(taskId,newSubscriberToTask);
        assertTrue(userBelongRepository.getByTaskIdAndUserId(taskId,newSubscriberToTask).isPresent());
    }
    @Test
    void checkThatNothingChangesIfSubscribeWithSameUserId(){
        Long userId = 2L;
        Long taskId = 2L;
        Optional<UserBelong> oldSubscriber = userBelongRepository.getByTaskIdAndUserId(userId, taskId);
        userBelongService.subscribeToTask(taskId,userId);
        Optional<UserBelong> newSubscriber = userBelongRepository.getByTaskIdAndUserId(userId, taskId);
        assertEquals(oldSubscriber,newSubscriber);
    }
}