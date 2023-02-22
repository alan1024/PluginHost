package com.alan.pluginhost;

import java.sql.Timestamp;
import java.util.List;

public interface UtilRepositoryCustom {
    List<Long> findSeenNewsIds(long userId);

    List<Long> findSeenNewsIdsBefore(long userId, Timestamp timestamp);

}
