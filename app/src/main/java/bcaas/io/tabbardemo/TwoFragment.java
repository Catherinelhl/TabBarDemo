package bcaas.io.tabbardemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author catherine.brainwilliam
 * @since 2018/12/3
 */
public class TwoFragment extends Fragment {


    @BindView(R.id.tv_text)
    TextView tvText;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container,false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public void setText(String info) {
        System.out.println("setText:" + info + tvText);
        if (tvText != null) {
            tvText.setText(info);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
