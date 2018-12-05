package bcaas.io.tabbardemo.maker;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    private List<String> tabTopTitles = new ArrayList<>();
    private List<Integer> tabDrawables = new ArrayList<>();
    private List<Integer> tabFocusDrawables = new ArrayList<>();
    private int tabTitleCount;

    public DataGenerationRegister() {
        super();
        initData();
    }

    private void initData() {
        //初始化底部栏文本数据
        tabTitles.add("买进");
        tabTitles.add("卖出");
        tabTitles.add("订单");
        tabTitles.add("账户");
        tabTitleCount = tabTitles.size();

        //初始化顶部栏数据
        tabTopTitles.add("ETH");
        tabTopTitles.add("BTC");
        tabTopTitles.add("ZBB");

        //初始化底部栏图标数据
        tabDrawables.add(R.drawable.icon_home);
        tabDrawables.add(R.drawable.icon_home);
        tabDrawables.add(R.drawable.icon_home);
        tabDrawables.add(R.drawable.icon_home);
        tabFocusDrawables.add(R.drawable.icon_home_f);
        tabFocusDrawables.add(R.drawable.icon_home_f);
        tabFocusDrawables.add(R.drawable.icon_home_f);
        tabFocusDrawables.add(R.drawable.icon_home_f);
    }

    /**
     * 根据底部栏当前的位置返回当前位置信息
     *
     * @param position
     * @return
     */
    public String getTabTitle(int position) {

        if (position >= tabTitleCount) {
            return "";
        }
        return tabTitles.get(position);
    }

    /**
     * 根据当前顶部栏的位置返回当前位置上的标题信息
     *
     * @param position
     * @return
     */
    public String getTabTopTitle(int position) {
        if (position >= tabTopTitles.size()) {
            return "";
        }
        return tabTopTitles.get(position);
    }

    /**
     * 根据当前底部栏的位置返回当前位置上图标信息
     *
     * @param position
     * @return
     */
    public int getTabDrawable(int position, boolean isSelect) {
        if (position >= tabTitleCount) {
            return 0;
        }
        return isSelect ? tabFocusDrawables.get(position) : tabDrawables.get(position);
    }

    /**
     * 根据位置下标，是否是选中的状态
     *
     * @param i
     * @param isSelect
     * @return
     */
    public Drawable getDrawableTop(Context context, int i, boolean isSelect) {
        Drawable top = context.getResources().getDrawable(getTabDrawable(i, isSelect));
        return top;

    }
}
