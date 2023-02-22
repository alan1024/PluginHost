package com.alan.pluginhost;

import java.sql.Timestamp;
import java.util.List;


public class UtilRepositoryImpl implements UtilRepositoryCustom {
    private UserOperationRepository userOperationRepository;


    @Override
    public List<Long> findSeenNewsIds(long userId) {
        List<UserOperation> userOperations = this.userOperationRepository.findByUserId(userId);
        return null;
    }

    @Override
    public List<Long> findSeenNewsIdsBefore(long userId, Timestamp timestamp) {
        List<UserOperation> userOperations = this.userOperationRepository.findByUserId(userId);
        return null;
    }
}
