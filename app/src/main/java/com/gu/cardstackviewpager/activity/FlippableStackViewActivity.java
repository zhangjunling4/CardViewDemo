package com.gu.cardstackviewpager.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.bartoszlipinski.flippablestackview.FlippableStackView;
import com.bartoszlipinski.flippablestackview.StackPageTransformer;
import com.gu.cardstackviewpager.AppUrl;
import com.gu.cardstackviewpager.LiveTypeInfo;
import com.gu.cardstackviewpager.R;
import com.gu.cardstackviewpager.adapter.ContentFragmentAdapter;
import com.gu.cardstackviewpager.fragment.CourseFragment;
import com.gu.library.OrientedViewPager;
import com.gu.library.transformer.VerticalStackTransformer;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

public class FlippableStackViewActivity extends AppCompatActivity implements View.OnClickListener {

    private FlippableStackView flippableStackView;

    private ContentFragmentAdapter mContentFragmentAdapter;
    private List<Fragment> mFragments = new ArrayList<>();

    private LinearLayout llXiaoBan;
    private LinearLayout llDaBan;
    private LinearLayout llOther;
    private LinearLayout llMore;

    private String currentType;

    private List<LiveTypeInfo.DataBean> livingCoursesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flippable_stack_view);

        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);

        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);

        initViews();

        initData();

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
//        //设置viewpager的方向为竖直
        flippableStackView.initStack(3, StackPageTransformer.Orientation.VERTICAL, 0.9f, 0.5f, 0.9f, StackPageTransformer.Gravity.TOP);
        flippableStackView.setAdapter(mContentFragmentAdapter);
//        //设置limit
//        mOrientedViewPager.setOffscreenPageLimit(4);
//        //设置transformer
//        mOrientedViewPager.setPageTransformer(true, new VerticalStackTransformer(getApplicationContext()));
//        mOrientedViewPager.setAdapter(mContentFragmentAdapter);


    }

    private void initViews() {
        flippableStackView = (FlippableStackView) findViewById(R.id.stack);
        llXiaoBan = (LinearLayout) findViewById(R.id.ll_xiaoban);
        llDaBan = (LinearLayout) findViewById(R.id.ll_daban);
        llOther = (LinearLayout) findViewById(R.id.ll_other);
        llMore = (LinearLayout) findViewById(R.id.ll_more);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_xiaoban:
                Toast.makeText(FlippableStackViewActivity.this, getResources().getString(R.string.index_xiaoban), Toast.LENGTH_SHORT).show();

                break;
            case R.id.ll_daban:
                Toast.makeText(FlippableStackViewActivity.this, getResources().getString(R.string.index_daban), Toast.LENGTH_SHORT).show();

                break;
            case R.id.ll_other:
                Toast.makeText(FlippableStackViewActivity.this, getResources().getString(R.string.index_other), Toast.LENGTH_SHORT).show();

                break;
            case R.id.ll_more:
                Toast.makeText(FlippableStackViewActivity.this, getResources().getString(R.string.index_more), Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
