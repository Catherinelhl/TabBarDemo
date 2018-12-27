package bcaas.io.tabbardemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
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
 * <p>
 * 这是一个用Google自带的TabLayout写得一个底部栏和顶部栏的demo
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.home_container)
    FrameLayout homeContainer;
    @BindView(R.id.bottom_tab_layout)
    TabLayout bottomTabLayout;
    //声明当前需要和底部栏搭配的所有fragment
    private List<Fragment> fragments;

    private DataGenerationRegister dataGenerationRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initView() {
        fragments = new ArrayList<>();
        dataGenerationRegister = new DataGenerationRegister();
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                OneFragment fragment = new OneFragment();
                Bundle bundle=new Bundle();
                bundle.putString("args"," 当前页面:\" + i");
                fragment.setArguments(bundle);
                fragments.add(fragment);
            } else {
                TwoFragment twoFragment = new TwoFragment();
                twoFragment.setText(" 当前页面:" + i);
                fragments.add(twoFragment);

            }
        }
        initBottomTab();
    }

    private void initListener() {

        bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //改变当前中间content信息；Fragment变换
                onTabItemSelected(tab.getPosition());
                //自定义:如果是自定义的tabItem，那么就需要调用这句来设置选中状态，虽然没有界面上的变化
                tab.getCustomView().findViewById(R.id.ll_tab_item).setSelected(true);
                TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_title);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                //method 1：如果是直接图片和文字是分开的，那么就需要放开这两句，单独设置状态
//                ImageView imageView = tab.getCustomView().findViewById(R.id.iv_tab_drawable);
//                imageView.setImageResource(R.drawable.icon_home_f);
                //method 2：如果是直接就用一个TextView控件来表示了，那么就可以直接用下面这一句来表示
                textView.setCompoundDrawablesWithIntrinsicBounds(null, dataGenerationRegister.getDrawableTop(MainActivity.this, tab.getPosition(), true), null, null);

                //method 3：如果是直接用默认的就直接调用这个：改变Tab 状态
//                for (int i = 0; i < bottomTabLayout.getTabCount(); i++) {
//                    bottomTabLayout.getTabAt(i).setIcon(getResources().getDrawable(dataGenerationRegister.getTabDrawable(i, i == tab.getPosition())));
//                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //自定义
                tab.getCustomView().findViewById(R.id.ll_tab_item).setSelected(false);
                TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_title);
                textView.setTextColor(getResources().getColor(R.color.grey));
                //method 1
//                ImageView imageView = tab.getCustomView().findViewById(R.id.iv_tab_drawable);
//                imageView.setImageResource(R.drawable.icon_home);
                //method 2
                textView.setCompoundDrawablesWithIntrinsicBounds(null, dataGenerationRegister.getDrawableTop(MainActivity.this, tab.getPosition(), false), null, null);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //自定义
                TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_title);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                //method 1
//                ImageView imageView = tab.getCustomView().findViewById(R.id.iv_tab_drawable);
//                imageView.setImageResource(R.drawable.icon_home_f);
                //method 2
                textView.setCompoundDrawablesWithIntrinsicBounds(null, dataGenerationRegister.getDrawableTop(MainActivity.this, tab.getPosition(), true), null, null);

            }
        });
    }


    private void initBottomTab() {

        //通过 ColorStateList设置颜色
//        ColorStateList colorStateList = ColorStateList.valueOf(getResources().getColor(R.color.colorAccent));
//        bottomTabLayout.setTabTextColors(colorStateList);
        //直接设置默认和选中颜色
//        bottomTabLayout.setTabTextColors(getResources().getColor(R.color.grey), getResources().getColor(R.color.orange));
        for (int i = 0; i < fragments.size(); i++) {
            TabLayout.Tab tab = bottomTabLayout.newTab();
            // method 3：使用自带的布局直接设置图片和文字
//            tab.setIcon(getResources().getDrawable(dataGenerationRegister.getTabDrawable(i, false)));
//            tab.setText(dataGenerationRegister.getTabTitle(i));
//
// method 自定义布局-----

            tab.setCustomView(R.layout.tab_item);
            TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_title);
            textView.setTextColor(getResources().getColor(R.color.grey));
            textView.setCompoundDrawablesWithIntrinsicBounds(null, dataGenerationRegister.getDrawableTop(this, i, false), null, null);
//method 1：
            //            ImageView imageView = tab.getCustomView().findViewById(R.id.iv_tab_drawable);
//            imageView.setImageResource(dataGenerationRegister.getTabDrawable(i, false));
            textView.setText(dataGenerationRegister.getTabTitle(i));
            //自定义布局-----

            bottomTabLayout.addTab(tab);
            if (i == 0) {
                tab.getCustomView().findViewById(R.id.ll_tab_item).setSelected(true);
                //method 1：
//                imageView.setImageResource(dataGenerationRegister.getTabDrawable(i, true));
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                //method 2
                textView.setCompoundDrawablesWithIntrinsicBounds(null, dataGenerationRegister.getDrawableTop(this, 0, true), null, null);


            }
        }
    }

    private void onTabItemSelected(int position) {
        Fragment fragment = fragments.get(position);
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
        }
    }

}
