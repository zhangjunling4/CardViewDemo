package com.gu.cardstackviewpager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.bartoszlipinski.flippablestackview.FlippableStackView;
import com.gu.cardstackviewpager.AppUrl;
import com.gu.cardstackviewpager.LiveTypeInfo;
import com.gu.cardstackviewpager.R;
import com.gu.cardstackviewpager.adapter.ContentFragmentAdapter;
import com.gu.cardstackviewpager.fragment.CardFragment;
import com.gu.cardstackviewpager.fragment.CourseFragment;
import com.gu.library.OrientedViewPager;
import com.gu.library.transformer.VerticalStackTransformer;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nate on 2016/7/22.
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {


    private OrientedViewPager mOrientedViewPager;
    private ContentFragmentAdapter mContentFragmentAdapter;
    private List<Fragment> mFragments = new ArrayList<>();

    private LinearLayout llXiaoBan;
    private LinearLayout llDaBan;
    private LinearLayout llOther;
    private LinearLayout llMore;

    private String currentType;

    private List<LiveTypeInfo.DataBean> livingCoursesList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);

        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);

        initViews();

        initData();


        //跳转关于我的界面
//        findViewById(R.id.about_iv).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
//                startActivity(intent);
//            }
//        });

        llXiaoBan.setOnClickListener(this);
        llDaBan.setOnClickListener(this);
        llOther.setOnClickListener(this);
        llMore.setOnClickListener(this);

    }

    private void initData() {
        OkHttpUtils.get().url(AppUrl.GetTypeLiveUrl).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(com.squareup.okhttp.Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.i("requestLiveListData", response);

                        parseLiveList(response);
                    }
                });
    }

    private void parseLiveList(String result) {
        final LiveTypeInfo liveListBean = JSONObject.parseObject(result, LiveTypeInfo.class);
        livingCoursesList = liveListBean.getData();
        Log.i("livingCoursesList", "Size="+livingCoursesList.size());

        //判断是否请求到直播视频数据列表
        if (livingCoursesList.size() > 0){

        }
        //制造数据
        for (int i = 0; i < 10; i++) {
//            mFragments.add(CardFragment.newInstance(i + 1));
            mFragments.add(CourseFragment.newInstance(livingCoursesList.get(i % 3)));
        }

        mContentFragmentAdapter = new
                ContentFragmentAdapter(getSupportFragmentManager(), mFragments);
        //设置viewpager的方向为竖直
        mOrientedViewPager.setOrientation(OrientedViewPager.Orientation.VERTICAL);
        //设置limit
        mOrientedViewPager.setOffscreenPageLimit(4);
        //设置transformer
        mOrientedViewPager.setPageTransformer(true, new VerticalStackTransformer(getApplicationContext()));
        mOrientedViewPager.setAdapter(mContentFragmentAdapter);


    }

    private void initViews() {
        mOrientedViewPager = (OrientedViewPager) findViewById(R.id.view_pager);
        llXiaoBan = (LinearLayout) findViewById(R.id.ll_xiaoban);
        llDaBan = (LinearLayout) findViewById(R.id.ll_daban);
        llOther = (LinearLayout) findViewById(R.id.ll_other);
        llMore = (LinearLayout) findViewById(R.id.ll_more);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_xiaoban:
                Toast.makeText(HomeActivity.this, getResources().getString(R.string.index_xiaoban), Toast.LENGTH_SHORT).show();

                break;
            case R.id.ll_daban:
                Toast.makeText(HomeActivity.this, getResources().getString(R.string.index_daban), Toast.LENGTH_SHORT).show();

                break;
            case R.id.ll_other:
                Toast.makeText(HomeActivity.this, getResources().getString(R.string.index_other), Toast.LENGTH_SHORT).show();

                break;
            case R.id.ll_more:
                Toast.makeText(HomeActivity.this, getResources().getString(R.string.index_more), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, FlippableStackViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
