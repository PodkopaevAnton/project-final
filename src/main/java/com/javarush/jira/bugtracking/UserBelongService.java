package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.internal.model.UserBelong;
import com.javarush.jira.bugtracking.internal.repository.UserBelongRepository;
import com.javarush.jira.bugtracking.to.ObjectType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBelongService {
    private final UserBelongRepository userBelongRepository;

    public UserBelongService(UserBelongRepository userBelongRepository) {
        this.userBelongRepository = userBelongRepository;
    }

    public void subscribeToTask(Long taskId, Long userId){
        Optional<UserBelong> userIdList = userBelongRepository.getByTaskIdAndUserId(taskId,userId);
        if(userIdList.isEmpty()){
            UserBelong subscriber = new UserBelong();
            subscriber.setObjectId(taskId);
            subscriber.setUserId(userId);
            subscriber.setObjectType(ObjectType.TASK);
            if (userId == 2L){
                subscriber.setUserTypeCode("admin");
            }else{
                subscriber.setUserTypeCode("user");}
            userBelongRepository.save(subscriber);
        }
    }
}
