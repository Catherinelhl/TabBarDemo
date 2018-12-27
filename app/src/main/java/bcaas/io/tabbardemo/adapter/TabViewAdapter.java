package bcaas.io.tabbardemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import bcaas.io.tabbardemo.maker.DataGenerationRegister;

import java.util.List;

public class TabViewAdapter extends PagerAdapter {
    List<View> views;

    public TabViewAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        ((ViewPager) container).addView(view, 0);
        return view;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    //设置tablayout标题
    @Override
    public CharSequence getPageTitle(int position) {
        return new DataGenerationRegister().getTabTopTitle(position);

    }
}