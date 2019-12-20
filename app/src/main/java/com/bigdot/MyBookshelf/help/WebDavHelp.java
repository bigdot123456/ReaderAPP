package com.bigdot.MyBookshelf.help;

import android.text.TextUtils;

import com.bigdot.MyBookshelf.MApplication;
import com.bigdot.MyBookshelf.utils.StringUtils;
import com.bigdot.MyBookshelf.utils.web_dav.http.HttpAuth;

import static com.bigdot.MyBookshelf.constant.AppConstant.DEFAULT_WEB_DAV_URL;

public class WebDavHelp {

    public static String getWebDavUrl() {
        String url = MApplication.getConfigPreferences().getString("web_dav_url", DEFAULT_WEB_DAV_URL);
        if (TextUtils.isEmpty(url)) url = DEFAULT_WEB_DAV_URL;
        assert url != null;
        if (!url.endsWith("/")) {
            url = url + "/";
        }
        return url;
    }

    public static boolean initWebDav() {
        String account = MApplication.getConfigPreferences().getString("web_dav_account", "");
        String password = MApplication.getConfigPreferences().getString("web_dav_password", "");
        if (!StringUtils.isTrimEmpty(account) && !StringUtils.isTrimEmpty(password)) {
            HttpAuth.setAuth(account, password);
            return true;
        }
        return false;
    }

    private WebDavHelp() {

    }
}
