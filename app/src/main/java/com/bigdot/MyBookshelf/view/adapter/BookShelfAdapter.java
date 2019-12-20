package com.bigdot.MyBookshelf.view.adapter;

import com.bigdot.MyBookshelf.bean.BookShelfBean;
import com.bigdot.MyBookshelf.help.ItemTouchCallback;
import com.bigdot.MyBookshelf.view.adapter.base.OnItemClickListenerTwo;

import java.util.HashSet;
import java.util.List;

public interface BookShelfAdapter {

    void setArrange(boolean isArrange);

    void selectAll();

    ItemTouchCallback.OnItemTouchCallbackListener getItemTouchCallbackListener();

    List<BookShelfBean> getBooks();

    void replaceAll(List<BookShelfBean> newDataS, String bookshelfPx);

    void refreshBook(String noteUrl);

    void setItemClickListener(OnItemClickListenerTwo itemClickListener);

    HashSet<String> getSelected();

}
