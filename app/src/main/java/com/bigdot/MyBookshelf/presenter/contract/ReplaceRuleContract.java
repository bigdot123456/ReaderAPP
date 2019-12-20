package com.bigdot.MyBookshelf.presenter.contract;


import com.google.android.material.snackbar.Snackbar;
import com.bigdot.basemvplib.impl.IPresenter;
import com.bigdot.basemvplib.impl.IView;
import com.bigdot.MyBookshelf.bean.ReplaceRuleBean;

import java.util.List;

public interface ReplaceRuleContract {
    interface Presenter extends IPresenter {

        void saveData(List<ReplaceRuleBean> replaceRuleBeans);

        void delData(ReplaceRuleBean replaceRuleBean);

        void delData(List<ReplaceRuleBean> replaceRuleBeans);

        void importDataSLocal(String uri);

        void importDataS(String text);
    }

    interface View extends IView {

        void refresh();

        Snackbar getSnackBar(String msg, int length);

    }

}
