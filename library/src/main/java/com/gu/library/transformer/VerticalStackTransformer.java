package com.gu.library.transformer;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.gu.library.utils.ScreenUtils;


/**
 * Created by Nate on 2016/7/22.
 */
public class VerticalStackTransformer extends VerticalBaseTransformer {

    private Context context;
    private int spaceBetweenFirAndSecWith =  10 * 4;//第一张卡片和第二张卡片宽度差  dp单位
    private int spaceBetweenFirAndSecHeight = 10 * 2 ;//第一张卡片和第二张卡片高度差   dp单位

    public VerticalStackTransformer(Context context) {
        this.context = context;
    }

    public VerticalStackTransformer(Context context, int spaceBetweenFirAndSecWith, int spaceBetweenFirAndSecHeight) {
        this.context = context;
        this.spaceBetweenFirAndSecWith = spaceBetweenFirAndSecWith;
        this.spaceBetweenFirAndSecHeight = spaceBetweenFirAndSecHeight;
    }

    @Override
    protected void onTransform(View page, float position) {
        if (position <= 0.0f) {
            page.setAlpha(1.0f);
            Log.e("onTransform", "position <= 0.0f ==>" + position);
            page.setTranslationY(0f);
            //控制停止滑动切换的时候，只有最上面的一张卡片可以点击
            page.setClickable(true);
        } else if (position <= 3.0f) {
            Log.e("onTransform", "position <= 3.0f ==>" + position);
            float scaleWidth = (float) (page.getWidth() - ScreenUtils.dp2px(context, spaceBetweenFirAndSecWith * position)) / (float) (page.getWidth());
            float scaleHeight = (float) (page.getWidth() - ScreenUtils.dp2px(context, spaceBetweenFirAndSecHeight * position)) / (float) (page.getWidth());
            //控制下面卡片的可见度
            page.setAlpha(scaleHeight*(4-position)/10 + 0.4f); // 1.0   (1-scaleHeight)*position + 0.5f
            //控制停止滑动切换的时候，只有最上面的一张卡片可以点击
            page.setClickable(false);
            // //设置缩放中点
            page.setPivotX(page.getWidth() / 2f);
            page.setPivotY(page.getHeight() / 2f);
            //设置缩放的比例 此处设置两个相邻的卡片的缩放比率
//            Log.i("onTransformScale", "scaleWidth="+scaleWidth);
            Log.i("onTransformScale", "scaleHeight="+scaleHeight);
            page.setScaleX(scaleWidth);
            page.setScaleY(scaleHeight);
//            page.setTranslationX(page.getWidth() - page.getWidth() * (1-scaleHeight) * 2- ScreenUtils.dp2px(context, spaceBetweenFirAndSecWith) * position  * 2);
//            page.setTranslationY(-page.getHeight() * position + (page.getHeight() * 0.5f) * (1 - scaleHeight) + ScreenUtils.dp2px(context, spaceBetweenFirAndSecHeight) * position);
            page.setTranslationY(-page.getHeight() * position - (page.getHeight() * 0.5f) * (1 - scaleHeight) - ScreenUtils.dp2px(context, spaceBetweenFirAndSecHeight) * position);

        }
    }
}
