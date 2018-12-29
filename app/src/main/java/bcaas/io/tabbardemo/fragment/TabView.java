package bcaas.io.tabbardemo.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import bcaas.io.tabbardemo.R;

/**
 * @author catherine.brainwilliam
 * @since 2018/12/28
 */
public class TabView extends LinearLayout {
    private String TAG = "BuyView";
    private Context context;
    private TextView textView;

    public TabView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_tablayout, this, true);
        textView = view.findViewById(R.id.tab_txt);

    }

    public void setTextView(String info) {
        if (textView != null) {
            textView.setText(info);
        }
    }

}
