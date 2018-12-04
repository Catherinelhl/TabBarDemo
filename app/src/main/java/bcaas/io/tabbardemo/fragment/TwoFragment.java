package bcaas.io.tabbardemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bcaas.io.tabbardemo.R;
import bcaas.io.tabbardemo.maker.DataGenerationRegister;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author catherine.brainwilliam
 * @since 2018/12/3
 */
public class TwoFragment extends Fragment {

    private DataGenerationRegister dataGenerationRegister;

    @BindView(R.id.tv_text)
    TextView tvText;
    Unbinder unbinder;
    @BindView(R.id.top_tab_layout)
    TabLayout topTabLayout;

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
        dataGenerationRegister=new DataGenerationRegister();
        initListener();
        initTopTab();

    }

    public void setText(String info) {
        System.out.println("setText:" + info + tvText);
        if (tvText != null) {
            tvText.setText(info);
        }
    }

    private void initListener(){
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
    }
    private void initTopTab() {

//        ColorStateList colorStateList = ColorStateList.valueOf(getResources().getColor(R.color.colorAccent));
//        bottomTabLayout.setTabTextColors(colorStateList);
//        bottomTabLayout.setTabTextColors(getResources().getColor(R.color.grey), getResources().getColor(R.color.orange));
        for (int i = 0; i < 3; i++) {
            TabLayout.Tab tab = topTabLayout.newTab();
//            tab.setIcon(getResources().getDrawable(dataGenerationRegister.getTabDrawable(i, false)));
            tab.setText(dataGenerationRegister.getTabTopTitle(i));
            topTabLayout.addTab(tab);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
