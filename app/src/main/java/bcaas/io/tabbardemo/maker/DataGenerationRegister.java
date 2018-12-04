package bcaas.io.tabbardemo.maker;

import bcaas.io.tabbardemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catherine.brainwilliam
 * @since 2018/12/4
 * <p>
 * 数据生成寄存器
 */
public class DataGenerationRegister {

    private List<String> tabTitles = new ArrayList<>();
    private List<Integer> tabDrawables = new ArrayList<>();
    private List<Integer> tabFocusDrawables = new ArrayList<>();
    private int count;

    public DataGenerationRegister() {
        super();
        initData();
    }

    private void initData() {
        tabTitles.add("买进");
        tabTitles.add("卖出");
        tabTitles.add("订单");
        tabTitles.add("账户");
        count = tabTitles.size();
        tabDrawables.add(R.drawable.icon_home);
        tabDrawables.add(R.drawable.icon_home);
        tabDrawables.add(R.drawable.icon_home);
        tabDrawables.add(R.drawable.icon_home);
        tabFocusDrawables.add(R.drawable.icon_home_f);
        tabFocusDrawables.add(R.drawable.icon_home_f);
        tabFocusDrawables.add(R.drawable.icon_home_f);
        tabFocusDrawables.add(R.drawable.icon_home_f);
    }

    public String getTabTitle(int position) {
        if (position >= count) {
            return "";
        }
        return tabTitles.get(position);
    }

    public int getTabDrawable(int position, boolean isSelect) {
        if (position >= count) {
            return 0;
        }
        return isSelect ? tabFocusDrawables.get(position) : tabDrawables.get(position);
    }
}
