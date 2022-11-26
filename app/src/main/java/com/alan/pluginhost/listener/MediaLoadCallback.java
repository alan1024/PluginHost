package com.alan.pluginhost.listener;


import com.alan.pluginhost.data.MediaFolder;

import java.util.List;

public interface MediaLoadCallback {

    void loadMediaSuccess(List<MediaFolder> mediaFolderList);
}
