package com.alan.pluginhost;


import java.util.List;

public interface UserOperationRepository {

    UserOperation findById(long id);

    List<UserOperation> findByUserId(long userId);

}