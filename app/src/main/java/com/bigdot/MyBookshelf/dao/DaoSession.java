package com.bigdot.MyBookshelf.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bigdot.MyBookshelf.bean.BookChapterBean;
import com.bigdot.MyBookshelf.bean.BookContentBean;
import com.bigdot.MyBookshelf.bean.BookInfoBean;
import com.bigdot.MyBookshelf.bean.BookmarkBean;
import com.bigdot.MyBookshelf.bean.BookShelfBean;
import com.bigdot.MyBookshelf.bean.BookSourceBean;
import com.bigdot.MyBookshelf.bean.CookieBean;
import com.bigdot.MyBookshelf.bean.ReplaceRuleBean;
import com.bigdot.MyBookshelf.bean.SearchBookBean;
import com.bigdot.MyBookshelf.bean.SearchHistoryBean;
import com.bigdot.MyBookshelf.bean.TxtChapterRuleBean;

import com.bigdot.MyBookshelf.dao.BookChapterBeanDao;
import com.bigdot.MyBookshelf.dao.BookContentBeanDao;
import com.bigdot.MyBookshelf.dao.BookInfoBeanDao;
import com.bigdot.MyBookshelf.dao.BookmarkBeanDao;
import com.bigdot.MyBookshelf.dao.BookShelfBeanDao;
import com.bigdot.MyBookshelf.dao.BookSourceBeanDao;
import com.bigdot.MyBookshelf.dao.CookieBeanDao;
import com.bigdot.MyBookshelf.dao.ReplaceRuleBeanDao;
import com.bigdot.MyBookshelf.dao.SearchBookBeanDao;
import com.bigdot.MyBookshelf.dao.SearchHistoryBeanDao;
import com.bigdot.MyBookshelf.dao.TxtChapterRuleBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bookChapterBeanDaoConfig;
    private final DaoConfig bookContentBeanDaoConfig;
    private final DaoConfig bookInfoBeanDaoConfig;
    private final DaoConfig bookmarkBeanDaoConfig;
    private final DaoConfig bookShelfBeanDaoConfig;
    private final DaoConfig bookSourceBeanDaoConfig;
    private final DaoConfig cookieBeanDaoConfig;
    private final DaoConfig replaceRuleBeanDaoConfig;
    private final DaoConfig searchBookBeanDaoConfig;
    private final DaoConfig searchHistoryBeanDaoConfig;
    private final DaoConfig txtChapterRuleBeanDaoConfig;

    private final BookChapterBeanDao bookChapterBeanDao;
    private final BookContentBeanDao bookContentBeanDao;
    private final BookInfoBeanDao bookInfoBeanDao;
    private final BookmarkBeanDao bookmarkBeanDao;
    private final BookShelfBeanDao bookShelfBeanDao;
    private final BookSourceBeanDao bookSourceBeanDao;
    private final CookieBeanDao cookieBeanDao;
    private final ReplaceRuleBeanDao replaceRuleBeanDao;
    private final SearchBookBeanDao searchBookBeanDao;
    private final SearchHistoryBeanDao searchHistoryBeanDao;
    private final TxtChapterRuleBeanDao txtChapterRuleBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bookChapterBeanDaoConfig = daoConfigMap.get(BookChapterBeanDao.class).clone();
        bookChapterBeanDaoConfig.initIdentityScope(type);

        bookContentBeanDaoConfig = daoConfigMap.get(BookContentBeanDao.class).clone();
        bookContentBeanDaoConfig.initIdentityScope(type);

        bookInfoBeanDaoConfig = daoConfigMap.get(BookInfoBeanDao.class).clone();
        bookInfoBeanDaoConfig.initIdentityScope(type);

        bookmarkBeanDaoConfig = daoConfigMap.get(BookmarkBeanDao.class).clone();
        bookmarkBeanDaoConfig.initIdentityScope(type);

        bookShelfBeanDaoConfig = daoConfigMap.get(BookShelfBeanDao.class).clone();
        bookShelfBeanDaoConfig.initIdentityScope(type);

        bookSourceBeanDaoConfig = daoConfigMap.get(BookSourceBeanDao.class).clone();
        bookSourceBeanDaoConfig.initIdentityScope(type);

        cookieBeanDaoConfig = daoConfigMap.get(CookieBeanDao.class).clone();
        cookieBeanDaoConfig.initIdentityScope(type);

        replaceRuleBeanDaoConfig = daoConfigMap.get(ReplaceRuleBeanDao.class).clone();
        replaceRuleBeanDaoConfig.initIdentityScope(type);

        searchBookBeanDaoConfig = daoConfigMap.get(SearchBookBeanDao.class).clone();
        searchBookBeanDaoConfig.initIdentityScope(type);

        searchHistoryBeanDaoConfig = daoConfigMap.get(SearchHistoryBeanDao.class).clone();
        searchHistoryBeanDaoConfig.initIdentityScope(type);

        txtChapterRuleBeanDaoConfig = daoConfigMap.get(TxtChapterRuleBeanDao.class).clone();
        txtChapterRuleBeanDaoConfig.initIdentityScope(type);

        bookChapterBeanDao = new BookChapterBeanDao(bookChapterBeanDaoConfig, this);
        bookContentBeanDao = new BookContentBeanDao(bookContentBeanDaoConfig, this);
        bookInfoBeanDao = new BookInfoBeanDao(bookInfoBeanDaoConfig, this);
        bookmarkBeanDao = new BookmarkBeanDao(bookmarkBeanDaoConfig, this);
        bookShelfBeanDao = new BookShelfBeanDao(bookShelfBeanDaoConfig, this);
        bookSourceBeanDao = new BookSourceBeanDao(bookSourceBeanDaoConfig, this);
        cookieBeanDao = new CookieBeanDao(cookieBeanDaoConfig, this);
        replaceRuleBeanDao = new ReplaceRuleBeanDao(replaceRuleBeanDaoConfig, this);
        searchBookBeanDao = new SearchBookBeanDao(searchBookBeanDaoConfig, this);
        searchHistoryBeanDao = new SearchHistoryBeanDao(searchHistoryBeanDaoConfig, this);
        txtChapterRuleBeanDao = new TxtChapterRuleBeanDao(txtChapterRuleBeanDaoConfig, this);

        registerDao(BookChapterBean.class, bookChapterBeanDao);
        registerDao(BookContentBean.class, bookContentBeanDao);
        registerDao(BookInfoBean.class, bookInfoBeanDao);
        registerDao(BookmarkBean.class, bookmarkBeanDao);
        registerDao(BookShelfBean.class, bookShelfBeanDao);
        registerDao(BookSourceBean.class, bookSourceBeanDao);
        registerDao(CookieBean.class, cookieBeanDao);
        registerDao(ReplaceRuleBean.class, replaceRuleBeanDao);
        registerDao(SearchBookBean.class, searchBookBeanDao);
        registerDao(SearchHistoryBean.class, searchHistoryBeanDao);
        registerDao(TxtChapterRuleBean.class, txtChapterRuleBeanDao);
    }
    
    public void clear() {
        bookChapterBeanDaoConfig.clearIdentityScope();
        bookContentBeanDaoConfig.clearIdentityScope();
        bookInfoBeanDaoConfig.clearIdentityScope();
        bookmarkBeanDaoConfig.clearIdentityScope();
        bookShelfBeanDaoConfig.clearIdentityScope();
        bookSourceBeanDaoConfig.clearIdentityScope();
        cookieBeanDaoConfig.clearIdentityScope();
        replaceRuleBeanDaoConfig.clearIdentityScope();
        searchBookBeanDaoConfig.clearIdentityScope();
        searchHistoryBeanDaoConfig.clearIdentityScope();
        txtChapterRuleBeanDaoConfig.clearIdentityScope();
    }

    public BookChapterBeanDao getBookChapterBeanDao() {
        return bookChapterBeanDao;
    }

    public BookContentBeanDao getBookContentBeanDao() {
        return bookContentBeanDao;
    }

    public BookInfoBeanDao getBookInfoBeanDao() {
        return bookInfoBeanDao;
    }

    public BookmarkBeanDao getBookmarkBeanDao() {
        return bookmarkBeanDao;
    }

    public BookShelfBeanDao getBookShelfBeanDao() {
        return bookShelfBeanDao;
    }

    public BookSourceBeanDao getBookSourceBeanDao() {
        return bookSourceBeanDao;
    }

    public CookieBeanDao getCookieBeanDao() {
        return cookieBeanDao;
    }

    public ReplaceRuleBeanDao getReplaceRuleBeanDao() {
        return replaceRuleBeanDao;
    }

    public SearchBookBeanDao getSearchBookBeanDao() {
        return searchBookBeanDao;
    }

    public SearchHistoryBeanDao getSearchHistoryBeanDao() {
        return searchHistoryBeanDao;
    }

    public TxtChapterRuleBeanDao getTxtChapterRuleBeanDao() {
        return txtChapterRuleBeanDao;
    }

}
