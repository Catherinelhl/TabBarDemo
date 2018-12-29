package bcaas.io.tabbardemo.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bcaas.io.tabbardemo.R;
import bcaas.io.tabbardemo.adapter.TabAdapter;
import bcaas.io.tabbardemo.adapter.TabViewAdapter;
import bcaas.io.tabbardemo.maker.DataGenerationRegister;
import bcaas.io.tabbardemo.view.RichText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catherine.brainwilliam
 * @since 2018/12/3
 */
public class TwoFragment extends Fragment {

    @BindView(R.id.rt_text)
    RichText rtText;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private DataGenerationRegister dataGenerationRegister;

    @BindView(R.id.tv_text)
    TextView tvText;
    Unbinder unbinder;
    @BindView(R.id.top_tab_layout)
    TabLayout topTabLayout;

    private TabViewAdapter tabViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataGenerationRegister = new DataGenerationRegister();
        initListener();
        initTopTab();

    }

    public void setText(String info) {
        System.out.println("setText:" + info + tvText);
        if (tvText != null) {
            tvText.setText(info);
        }
    }

    private void initListener() {
        topTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        rtText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable top = getResources().getDrawable(count % 2 != 0 ? R.drawable.icon_home : R.drawable.icon_home_f);
                rtText.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
                rtText.setTextColor(getResources().getColor(count % 2 != 0 ? R.color.colorPrimary : R.color.colorAccent));
                count++;

            }
        });
    }

    int count;
    private List<View> views;

    private void initTopTab() {

//        ColorStateList colorStateList = ColorStateList.valueOf(getResources().getColor(R.color.colorAccent));
//        bottomTabLayout.setTabTextColors(colorStateList);
//        bottomTabLayout.setTabTextColors(getResources().getColor(R.color.grey), getResources().getColor(R.color.orange));
//        for (int i = 0; i < 3; i++) {
//            TabLayout.Tab tab = topTabLayout.newTab();
////            tab.setIcon(getResources().getDrawable(dataGenerationRegister.getTabDrawable(i, false)));
//            tab.setText(dataGenerationRegister.getTabTopTitle(i));
//            topTabLayout.addTab(tab);
//        }

        views = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            TabView tabView = new TabView(getContext());
            //= LayoutInflater.from(getContext()).inflate(R.layout.fragment_tablayout, null, false);
            tabView.setTextView(i+"");
            views.add(tabView);
        }
        tabViewAdapter = new TabViewAdapter(views);
        viewpager.setAdapter(tabViewAdapter);
        viewpager.setCurrentItem(0);
        viewpager.setOffscreenPageLimit(3);
        topTabLayout.setupWithViewPager(viewpager);

//        List<Fragment> fragments = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            fragments.add(TabLayoutFragment.newInstance(i + 1));
//        }
//        TabAdapter adapter = new TabAdapter(getChildFragmentManager(), fragments);
//        //给ViewPager设置适配器
//        viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来。
        //设置可以滑动
//        topTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
