package pl.mobilechampions.recipts.recipt.presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import pl.mobilechampions.recipts.recipt.view.ReceiptDetailsView;

public interface ReceiptDetailsPresenter extends MvpPresenter<ReceiptDetailsView>{

    void saveClicked();

    void firstReceiptRequested();

}
