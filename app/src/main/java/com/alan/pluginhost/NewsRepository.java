package com.alan.pluginhost;


import java.util.List;


public interface NewsRepository {

    News findById(long id);


    List<News> findHostestNews();


}