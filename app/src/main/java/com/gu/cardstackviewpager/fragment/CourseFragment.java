package com.gu.cardstackviewpager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.gu.cardstackviewpager.LiveTypeInfo;
import com.gu.cardstackviewpager.R;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment {

    private static final String COVER_URL = "COVER";
    private static final String COURSE_NAME = "NAME";

    private ImageView cover;
    private ImageView btnStart;

    private String coverUrl;
    private String courseName;
    private String upAlipha;

    public static CourseFragment newInstance(LiveTypeInfo.DataBean index) {
        CourseFragment fragment = new CourseFragment();
        Bundle bdl = new Bundle();
        bdl.putString(COVER_URL, index.getCover());
        bdl.putString(COURSE_NAME, index.getName());
        fragment.setArguments(bdl);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_course, container, false);
        initViews(view);
        coverUrl = getArguments().getString(COVER_URL);
        courseName = getArguments().getString(COURSE_NAME);
        Log.i("livingCoursesList", "coverUrl=" + coverUrl);
        ImageLoader.getInstance().displayImage(coverUrl, cover);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "开启"+courseName+"直播", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void initViews(View view) {
        cover = (ImageView) view.findViewById(R.id.card_num_cover);
        btnStart = (ImageView) view.findViewById(R.id.card_num_tv);

    }

}
