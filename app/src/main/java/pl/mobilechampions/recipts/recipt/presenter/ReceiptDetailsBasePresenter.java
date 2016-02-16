package pl.mobilechampions.recipts.recipt.presenter;

import pl.mobilechampions.recipts.recipt.view.ReceiptDetailsView;

public class ReceiptDetailsBasePresenter implements ReceiptDetailsPresenter {

    private ReceiptDetailsView view;

    @Override
    public void attachView(ReceiptDetailsView view) {
        this.view = view;
    }

    @Override
    public void detachView(boolean retainInstance) {
        view = null;
    }

    @Override
    public void saveClicked() {
        view.finish();
    }

    @Override
    public void firstReceiptRequested() {
        view.requestForNewPhoto();
    }
}
