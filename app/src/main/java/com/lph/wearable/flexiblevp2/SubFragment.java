package com.lph.wearable.flexiblevp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;


/**
 * Created by 薛贤俊 on 2019/2/13.
 */
public class SubFragment extends Fragment {

    int position = 0;

    public SubFragment(int position) {
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_page, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        ImageView imageView = view.findViewById(R.id.iv);

        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (position % 2 == 1) {
            layoutParams.height = 600;
        } else {
            layoutParams.height = 1200;
        }
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.mipmap.ic_launcher);

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }


}
