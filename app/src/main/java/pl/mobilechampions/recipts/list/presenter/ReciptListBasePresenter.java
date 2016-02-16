package pl.mobilechampions.recipts.list.presenter;

import pl.mobilechampions.recipts.list.view.ReciptListView;

public class ReciptListBasePresenter implements ReciptListPresenter{

    ReciptListView view;

    @Override
    public void attachView(ReciptListView view) {
        view.showContent();
        this.view = view;
    }

    @Override
    public void detachView(boolean retainInstance) {
        view = null;
    }

    @Override
    public void newReciptRequested() {
        view.openNewReceiptActivity();
    }
}
