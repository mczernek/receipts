package pl.mobilechampions.recipts.list.presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import pl.mobilechampions.recipts.list.view.ReciptListView;

public interface ReciptListPresenter extends MvpPresenter<ReciptListView>{

    void newReciptRequested();

}
