package com.bigdot.basemvplib;

import com.bigdot.basemvplib.impl.IPresenter;
import com.bigdot.basemvplib.impl.IView;

import androidx.annotation.NonNull;

public abstract class BasePresenterImpl<T extends IView> implements IPresenter {
    protected T mView;

    @Override
    public void attachView(@NonNull IView iView) {
        mView = (T) iView;
    }
}
