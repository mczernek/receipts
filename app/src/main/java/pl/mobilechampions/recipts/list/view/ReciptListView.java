package pl.mobilechampions.recipts.list.view;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.List;

import pl.mobilechampions.recipts.recipt.model.ReciptItem;

public interface ReciptListView extends MvpLceView<List<ReciptItem>>{

    void openNewReceiptActivity();

}
