package org.lenve.myviewpagercards;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by hncgc on 2016/8/26.
 */
public class MyVpAdater extends PagerAdapter {
    private List<Integer> list;
    private Context context;
    private LayoutInflater inflater;

    public MyVpAdater(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final int position1 = position;
        View view = inflater.inflate(R.layout.view_page_item, container, false);
        RoundAngleImageView iv = (RoundAngleImageView) view.findViewById(R.id.iv);
        iv.setImageResource(list.get(position));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //增加监听
        iv.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Toast.makeText(context, "点击位置：" + position1, Toast.LENGTH_LONG).show();

                                  }
                              }

        );


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}
