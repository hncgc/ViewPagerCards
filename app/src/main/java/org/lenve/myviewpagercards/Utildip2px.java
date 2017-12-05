package org.lenve.myviewpagercards;
import android.content.Context;

/**
 * 使用到的工具类
 * Created by hncgc on 2017/8/10
 */

public class Utildip2px {
    public static int dip2px(Context context, float dipValue) {
        return (int) (dipValue * context.getResources().getDisplayMetrics().density);
    }

}
