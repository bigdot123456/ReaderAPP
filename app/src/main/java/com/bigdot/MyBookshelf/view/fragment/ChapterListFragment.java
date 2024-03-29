package com.bigdot.MyBookshelf.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.bigdot.basemvplib.impl.IPresenter;
import com.bigdot.MyBookshelf.R;
import com.bigdot.MyBookshelf.base.MBaseFragment;
import com.bigdot.MyBookshelf.bean.BookChapterBean;
import com.bigdot.MyBookshelf.bean.BookContentBean;
import com.bigdot.MyBookshelf.bean.BookShelfBean;
import com.bigdot.MyBookshelf.bean.OpenChapterBean;
import com.bigdot.MyBookshelf.constant.RxBusTag;
import com.bigdot.MyBookshelf.view.activity.ChapterListActivity;
import com.bigdot.MyBookshelf.view.adapter.ChapterListAdapter;
import com.bigdot.MyBookshelf.widget.recycler.scroller.FastScrollRecyclerView;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ChapterListFragment extends MBaseFragment {
    @BindView(R.id.rv_list)
    FastScrollRecyclerView rvList;
    @BindView(R.id.tv_current_chapter_info)
    TextView tvChapterInfo;
    @BindView(R.id.iv_chapter_top)
    ImageView ivChapterTop;
    @BindView(R.id.iv_chapter_bottom)
    ImageView ivChapterBottom;
    @BindView(R.id.ll_chapter_base_info)
    View llBaseInfo;
    @BindView(R.id.v_shadow)
    View vShadow;

    private Unbinder unbinder;

    private ChapterListAdapter chapterListAdapter;

    private LinearLayoutManager layoutManager;

    private BookShelfBean bookShelf;
    private List<BookChapterBean> chapterBeanList;
    private boolean isChapterReverse;

    @Override
    public int createLayoutId() {
        return R.layout.fragment_chapter_list;
    }

    /**
     * P层绑定   若无则返回null;
     */
    @Override
    protected IPresenter initInjector() {
        return null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
    }

    /**
     * 数据初始化
     */
    @Override
    protected void initData() {
        super.initData();
        if (getFatherActivity() != null) {
            bookShelf = getFatherActivity().getBookShelf();
            chapterBeanList = getFatherActivity().getChapterBeanList();
        }
        isChapterReverse = preferences.getBoolean("isChapterReverse", false);
    }

    /**
     * 控件绑定
     */
    @Override
    protected void bindView() {
        super.bindView();
        unbinder = ButterKnife.bind(this, view);
        rvList.setLayoutManager(layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, isChapterReverse));
        rvList.setItemAnimator(null);
        chapterListAdapter = new ChapterListAdapter(bookShelf, chapterBeanList, (index, page) -> {
            if (index != bookShelf.getDurChapter()) {
                RxBus.get().post(RxBusTag.SKIP_TO_CHAPTER, new OpenChapterBean(index, page));
            }
            if (getFatherActivity() != null) {
                getFatherActivity().searchViewCollapsed();
                getFatherActivity().finish();
            }
        });
        if (bookShelf != null) {
            rvList.setAdapter(chapterListAdapter);
            updateIndex(bookShelf.getDurChapter());
            updateChapterInfo();
        }
    }

    /**
     * 事件触发绑定
     */
    @Override
    protected void bindEvent() {
        super.bindEvent();
        tvChapterInfo.setOnClickListener(view -> layoutManager.scrollToPositionWithOffset(bookShelf.getDurChapter(), 0));
        ivChapterTop.setOnClickListener(v -> rvList.scrollToPosition(0));
        ivChapterBottom.setOnClickListener(v -> {
            if (chapterListAdapter.getItemCount() > 0) {
                rvList.scrollToPosition(chapterListAdapter.getItemCount() - 1);
            }
        });
    }

    public void startSearch(String key) {
        chapterListAdapter.search(key);
    }

    private void updateIndex(int durChapter) {
        chapterListAdapter.setIndex(durChapter);
        layoutManager.scrollToPositionWithOffset(durChapter, 0);
    }

    private void updateChapterInfo() {
        if (bookShelf != null) {
            if (chapterListAdapter.getItemCount() == 0) {
                tvChapterInfo.setText(bookShelf.getDurChapterName());
            } else {
                tvChapterInfo.setText(String.format(Locale.getDefault(), "%s (%d/%d章)", bookShelf.getDurChapterName(), bookShelf.getDurChapter() + 1, bookShelf.getChapterListSize()));
            }
        }
    }

    private ChapterListActivity getFatherActivity() {
        return (ChapterListActivity) getActivity();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        RxBus.get().unregister(this);
    }

    @Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag(RxBusTag.CHAPTER_CHANGE)})
    public void chapterChange(BookContentBean bookContentBean) {
        if (bookShelf != null && bookShelf.getNoteUrl().equals(bookContentBean.getNoteUrl())) {
            chapterListAdapter.upChapter(bookContentBean.getDurChapterIndex());
        }
    }
}
