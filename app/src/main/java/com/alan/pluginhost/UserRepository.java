package com.alan.pluginhost;


public interface UserRepository {

    User findById(long id);


    User findUser(long id);


}
