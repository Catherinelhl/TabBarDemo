package bcaas.io.tabbardemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catherine.brainwilliam
 * @since 2018/12/3
 */
public class MainJActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private List<Fragment> mFragmensts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmensts = new ArrayList<>();
        initView();

    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.bottom_tab_layout);
        for (int i = 0; i < 4; i++) {
            if (i%2==0) {
                OneFragment fragment = new OneFragment();
                fragment.setText(" 当前页面:" + i);
                mFragmensts.add(fragment);
            }else{
                TwoFragment twoFragment=new TwoFragment();
                twoFragment.setText(" 当前页面:" + i);
                mFragmensts.add(twoFragment);

            }
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());

                //改变Tab 状态
                for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                    if (i == tab.getPosition()) {
                        mTabLayout.getTabAt(i).setIcon(getResources().getDrawable(R.drawable.ic_launcher_background));
                    } else {
                        mTabLayout.getTabAt(i).setIcon(getResources().getDrawable(R.drawable.ic_launcher_background));
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mTabLayout.addTab(mTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_launcher_background)).setText("1"));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_launcher_background)).setText("2"));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_launcher_background)).setText("3"));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_launcher_background)).setText("4"));

    }

    private void onTabItemSelected(int position) {
        Fragment fragment  = mFragmensts.get(position);
        System.out.println("onTabItemSelected"+position);
//        switch (position) {
//            case 0:
//                fragment = mFragmensts.get(0);
//                break;
//            case 1:
//                fragment = mFragmensts[1];
//                break;
//
//            case 2:
//                fragment = mFragmensts[2];
//                break;
//            case 3:
//                fragment = mFragmensts[3];
//                break;
//        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
        }
    }

}
