package org.lenve.myviewpagercards;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AutoScrollViewPager viewPager;
    List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (AutoScrollViewPager) findViewById(R.id.viewpager);

        list = new ArrayList<>();
        list.add(R.drawable.p001);
        list.add(R.drawable.p002);
        list.add(R.drawable.p003);
        list.add(R.drawable.p004);
        list.add(R.drawable.p005);

        // 轮播图对屏幕的适配  宽高比2倍比例
        /*
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int viewwpagerheight = (int) (width / 2);
        FrameLayout.LayoutParams layoutps = (FrameLayout.LayoutParams) viewPager.getLayoutParams();
        layoutps.width = width;
        layoutps.height = viewwpagerheight;
        viewPager.setLayoutParams(layoutps);
        */


        MyVpAdater adater = new MyVpAdater(this, list);

        viewPager.setAdapter(adater);
        viewPager.setPageTransformer(false, new ScaleTransformer());
//        viewPager.setPageMargin((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,0,getResources().getDisplayMetrics()));
        viewPager.setOffscreenPageLimit(5);
        // 设置图片改变监听
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());

        viewPager.setCurrentItem(0,true); //false:不显示跳转过程的动画
        viewPager.setInterval(4000);
        //viewPager.startAutoScroll();

    }

    @Override
    public void onPause() {
        super.onPause();
        viewPager.stopAutoScroll();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewPager.startAutoScroll();

    }

    /**
     * 轮播图指示器变换
     */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageSelected(int position) {

            /*
            if ( list.size() > 1) { //多于1，才会循环跳转
                if ( position < 1) { //首位之前，跳转到末尾（N）
                    position = list.size()-1;
                    viewPager.setCurrentItem(position,false);
                } else if ( position > list.size()-1) { //末位之后，跳转到首位（1）
                    position = 1;
                    viewPager.setCurrentItem(position,false); //false:不显示跳转过程的动画

                }
            }
            */

            /*
            setUnfocused();
            switch (position % bannerNum) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
           }
            */
            // currIndex = position;
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        //全部设置为非当前
        private void setUnfocused() {
        }
    }

}
