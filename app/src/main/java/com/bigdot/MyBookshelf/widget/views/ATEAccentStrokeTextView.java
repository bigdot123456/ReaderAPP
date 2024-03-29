package com.bigdot.MyBookshelf.widget.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.bigdot.MyBookshelf.R;
import com.bigdot.MyBookshelf.utils.ScreenUtils;
import com.bigdot.MyBookshelf.utils.Selector;
import com.bigdot.MyBookshelf.utils.theme.ThemeStore;

public class ATEAccentStrokeTextView extends AppCompatTextView {
    public ATEAccentStrokeTextView(Context context) {
        super(context);
        init(context, null);
    }

    public ATEAccentStrokeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ATEAccentStrokeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setBackground(Selector.shapeBuild()
                .setCornerRadius(ScreenUtils.dpToPx(3))
                .setStrokeWidth(ScreenUtils.dpToPx(1))
                .setDisabledStrokeColor(context.getResources().getColor(R.color.md_grey_500))
                .setDefaultStrokeColor(ThemeStore.accentColor(context))
                .setPressedBgColor(context.getResources().getColor(R.color.transparent30))
                .create());
        setTextColor(Selector.colorBuild()
                .setDefaultColor(ThemeStore.accentColor(context))
                .setDisabledColor(context.getResources().getColor(R.color.md_grey_500))
                .create());
    }
}
