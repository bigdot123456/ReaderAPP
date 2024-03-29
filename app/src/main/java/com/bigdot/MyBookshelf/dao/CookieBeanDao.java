package com.bigdot.MyBookshelf.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bigdot.MyBookshelf.bean.CookieBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "COOKIE_BEAN".
*/
public class CookieBeanDao extends AbstractDao<CookieBean, String> {

    public static final String TABLENAME = "COOKIE_BEAN";

    /**
     * Properties of entity CookieBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Url = new Property(0, String.class, "url", true, "URL");
        public final static Property Cookie = new Property(1, String.class, "cookie", false, "COOKIE");
    }


    public CookieBeanDao(DaoConfig config) {
        super(config);
    }
    
    public CookieBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"COOKIE_BEAN\" (" + //
                "\"URL\" TEXT PRIMARY KEY NOT NULL ," + // 0: url
                "\"COOKIE\" TEXT);"); // 1: cookie
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COOKIE_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CookieBean entity) {
        stmt.clearBindings();
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(1, url);
        }
 
        String cookie = entity.getCookie();
        if (cookie != null) {
            stmt.bindString(2, cookie);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CookieBean entity) {
        stmt.clearBindings();
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(1, url);
        }
 
        String cookie = entity.getCookie();
        if (cookie != null) {
            stmt.bindString(2, cookie);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public CookieBean readEntity(Cursor cursor, int offset) {
        CookieBean entity = new CookieBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // url
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // cookie
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CookieBean entity, int offset) {
        entity.setUrl(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCookie(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(CookieBean entity, long rowId) {
        return entity.getUrl();
    }
    
    @Override
    public String getKey(CookieBean entity) {
        if(entity != null) {
            return entity.getUrl();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CookieBean entity) {
        return entity.getUrl() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
