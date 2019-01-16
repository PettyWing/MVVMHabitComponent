package com.xyc.base.utils;

import android.content.Context;
import android.net.Uri;

/**
 * Created by xieyusheng on 2019/1/15.
 */

public class FileUtil {

    /**
     * 从本地raw文件中获取
     *
     * @param context
     * @param fileId
     * @return
     */
    public static Uri getFileFromRaw(Context context, int fileId) {
        return Uri.parse("android.resource://" + context.getPackageName() + "/" + fileId);
    }
}
