package com.bigdot.MyBookshelf.presenter.contract;

import com.google.android.material.snackbar.Snackbar;
import com.bigdot.basemvplib.impl.IPresenter;
import com.bigdot.basemvplib.impl.IView;
import com.bigdot.MyBookshelf.bean.BookSourceBean;

import java.util.List;

public interface BookSourceContract {

    interface Presenter extends IPresenter {

        void saveData(BookSourceBean bookSourceBean);

        void saveData(List<BookSourceBean> bookSourceBeans);

        void delData(BookSourceBean bookSourceBean);

        void delData(List<BookSourceBean> bookSourceBeans);

        void importBookSource(String url);

        void importBookSourceLocal(String path);

        void checkBookSource(List<BookSourceBean> sourceBeans);

    }

    interface View extends IView {

        void refreshBookSource();

        Snackbar getSnackBar(String msg, int length);

        void showSnackBar(String msg, int length);

        void setResult(int resultCode);

        int getSort();
    }

}
