package com.javarush.jira.bugtracking.internal.repository;

import com.javarush.jira.bugtracking.internal.model.UserBelong;
import com.javarush.jira.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserBelongRepository extends BaseRepository<UserBelong> {

    @Query("SELECT u FROM UserBelong u WHERE u.objectId=:taskId AND u.userId = :userId")
    Optional<UserBelong> getByTaskIdAndUserId(Long taskId, Long userId);
}
