//Copyright (c) 2017. 章钦豪. All rights reserved.
package com.bigdot.MyBookshelf.view.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.widget.ImageView;

import com.bigdot.basemvplib.impl.IPresenter;
import com.bigdot.MyBookshelf.R;
import com.bigdot.MyBookshelf.base.MBaseActivity;
import com.bigdot.MyBookshelf.presenter.ReadBookPresenter;
import com.bigdot.MyBookshelf.utils.theme.ThemeStore;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeToReadActivity extends MBaseActivity {

    @BindView(R.id.iv_bg)
    ImageView ivBg;

    @Override
    protected IPresenter initInjector() {
        return null;
    }

    @Override
    protected void onCreateActivity() {
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        ivBg.setColorFilter(ThemeStore.accentColor(this));
        ValueAnimator welAnimator = ValueAnimator.ofFloat(1f, 0f).setDuration(800);
        welAnimator.setStartDelay(500);
        welAnimator.addUpdateListener(animation -> {
            float alpha = (Float) animation.getAnimatedValue();
            ivBg.setAlpha(alpha);
        });
        welAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                startReadActivity();
                finish();
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        welAnimator.start();
    }

    private void startReadActivity() {
        Intent intent = new Intent(this, ReadBookActivity.class);
        intent.putExtra("openFrom", ReadBookPresenter.OPEN_FROM_APP);
        startActivity(intent);
    }

    @Override
    protected void initData() {

    }

}
