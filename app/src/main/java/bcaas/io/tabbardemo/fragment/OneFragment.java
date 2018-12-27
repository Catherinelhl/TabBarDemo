package bcaas.io.tabbardemo.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bcaas.io.tabbardemo.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author catherine.brainwilliam
 * @since 2018/12/3
 */
public class OneFragment extends Fragment {


    @BindView(R.id.tv_text)
    TextView tvText;
    Unbinder unbinder;
    protected Context context;
    protected Activity activity;
    private String args;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        activity = getActivity();
        if (activity != null) {
            getArgs(activity.getIntent().getExtras());
        }
        initView();
    }

    private void getArgs(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        args = bundle.getString("args");
        System.out.println("getArgs："+args);

    }

    private void initView() {
        System.out.println("initView:" + tvText != null);
        System.out.println("initView:" + args);
        if (tvText != null) {
            tvText.setText(TextUtils.isEmpty(args)?"this is a test":args);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
