package bcaas.io.tabbardemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import bcaas.io.tabbardemo.R;
import bcaas.io.tabbardemo.fragment.OneFragment;
import bcaas.io.tabbardemo.fragment.TwoFragment;
import bcaas.io.tabbardemo.maker.DataGenerationRegister;
import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catherine.brainwilliam
 * @since 2018/12/3
 */
public class MainJActivity extends AppCompatActivity {
    @BindView(R.id.home_container)
    FrameLayout homeContainer;
    @BindView(R.id.bottom_tab_layout)
    TabLayout bottomTabLayout;
    private List<Fragment> fragments;

    private DataGenerationRegister dataGenerationRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragments = new ArrayList<>();
        dataGenerationRegister = new DataGenerationRegister();
        initView();
        initListener();
    }

    private void initListener() {
        bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                System.out.println("onTabSelected");
                onTabItemSelected(tab.getPosition());
                TextView textView=tab.getCustomView().findViewById(R.id.tv_tab_title);
                textView.setSelected(true);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                ImageButton imageButton=tab.getCustomView().findViewById(R.id.ib_tab_drawable);
                imageButton.setImageResource(R.drawable.icon_home_f);
                imageButton.setSelected(true);
//                //改变Tab 状态
//                for (int i = 0; i < bottomTabLayout.getTabCount(); i++) {
//                    bottomTabLayout.getTabAt(i).setIcon(getResources().getDrawable(dataGenerationRegister.getTabDrawable(i, i == tab.getPosition())));
//                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                System.out.println("onTabUnselected");
                TextView textView=tab.getCustomView().findViewById(R.id.tv_tab_title);
                textView.setTextColor(getResources().getColor(R.color.grey));
                textView.setSelected(false);
                ImageButton imageButton=tab.getCustomView().findViewById(R.id.ib_tab_drawable);
                imageButton.setImageResource(R.drawable.icon_home);
                imageButton.setSelected(false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                System.out.println("onTabReselected");
                TextView textView=tab.getCustomView().findViewById(R.id.tv_tab_title);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                textView.setSelected(true);
                ImageButton imageButton=tab.getCustomView().findViewById(R.id.ib_tab_drawable);
                imageButton.setImageResource(R.drawable.icon_home_f);
                imageButton.setSelected(true);
            }
        });
    }

    private void initView() {
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                OneFragment fragment = new OneFragment();
                fragment.setText(" 当前页面:" + i);
                fragments.add(fragment);
            } else {
                TwoFragment twoFragment = new TwoFragment();
                twoFragment.setText(" 当前页面:" + i);
                fragments.add(twoFragment);

            }
        }
//        ColorStateList colorStateList = ColorStateList.valueOf(getResources().getColor(R.color.colorAccent));
//        bottomTabLayout.setTabTextColors(colorStateList);
//        bottomTabLayout.setTabTextColors(getResources().getColor(R.color.grey), getResources().getColor(R.color.orange));
        for (int i = 0; i < fragments.size(); i++) {
            TabLayout.Tab tab = bottomTabLayout.newTab();
//            tab.setIcon(getResources().getDrawable(dataGenerationRegister.getTabDrawable(i, false)));
//            tab.setText(dataGenerationRegister.getTabTitle(i));
            //自定义布局-----
            tab.setCustomView(R.layout.tab_item);
            ImageButton imageButton = tab.getCustomView().findViewById(R.id.ib_tab_drawable);
            imageButton.setImageResource(dataGenerationRegister.getTabDrawable(i, false));
            TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_title);
            textView.setText(dataGenerationRegister.getTabTitle(i));
//            if (i == 0) {
//                tab.getCustomView().setSelected(true);
//            }
            //自定义布局-----


            bottomTabLayout.addTab(tab);
        }
        bottomTabLayout.getTabAt(0).getCustomView().setSelected(true);

    }

    private void onTabItemSelected(int position) {
        Fragment fragment = fragments.get(position);
        System.out.println("onTabItemSelected" + position);
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
        }
    }

}
