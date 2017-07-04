package luojie.hnulab.librarydemo.utli;

import android.content.Context;

/**
 * Auther：joahluo
 * E-mail：joahluo@163.com
 * Time：2017/7/2 19:49
 */
public class DensityUtil {
          /**
           * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
           */
          public static int dip2px(Context context, float dpValue) {
                    final float scale = context.getResources().getDisplayMetrics().density;
                    return (int) (dpValue * scale + 0.5f);
          }

          /**
           * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
           */
          public static int px2dip(Context context, float pxValue) {
                    final float scale = context.getResources().getDisplayMetrics().density;
                    return (int) (pxValue / scale + 0.5f);
          }

}
