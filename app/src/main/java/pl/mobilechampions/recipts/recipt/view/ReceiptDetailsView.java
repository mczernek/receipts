package pl.mobilechampions.recipts.recipt.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

import pl.mobilechampions.recipts.recipt.model.ReciptItem;

public interface ReceiptDetailsView extends MvpView {

    void showItem(ReciptItem item);

    void finish();

    void requestForNewPhoto();

}
