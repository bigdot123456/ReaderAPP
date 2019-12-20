package com.bigdot.MyBookshelf.model.content;

import com.bigdot.MyBookshelf.MApplication;
import com.bigdot.MyBookshelf.R;

public class VipThrowable extends Throwable {

    private final static String tag = "VIP_THROWABLE";

    VipThrowable() {
        super(MApplication.getInstance().getString(R.string.donate_s));
    }
}
