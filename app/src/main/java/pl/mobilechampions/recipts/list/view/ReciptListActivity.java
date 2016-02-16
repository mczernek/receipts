package pl.mobilechampions.recipts.list.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mobilechampions.recipts.R;
import pl.mobilechampions.recipts.recipt.model.ReciptItem;
import pl.mobilechampions.recipts.list.presenter.ReciptListBasePresenter;
import pl.mobilechampions.recipts.list.presenter.ReciptListPresenter;
import pl.mobilechampions.recipts.recipt.view.ReceiptDetailsActivity;

@SuppressWarnings("unused")
public class ReciptListActivity extends AppCompatActivity implements ReciptListView {


    @Bind(R.id.list_toolbar)
    Toolbar toolbar;

    @Bind(R.id.list_fab)
    FloatingActionButton fab;

    @Bind(R.id.content)
    View content;

    @Bind(R.id.loading)
    View loading;

    @Bind(R.id.error)
    View error;

    ReciptListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipt_list);
        ButterKnife.bind(this);
        prepareViews(toolbar);
        presenter = new ReciptListBasePresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }

    private void prepareViews(Toolbar toolbar) {
        setSupportActionBar(toolbar);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        content.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void showContent() {
        content.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        content.setVisibility(View.GONE);
        loading.setVisibility(View.GONE);
        error.setVisibility(View.VISIBLE);
    }

    @Override
    public void openNewReceiptActivity() {
        Intent intent = ReceiptDetailsActivity.getNewReciptIntent(this);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @OnClick(R.id.list_fab)
    public void onFabClick(View view) {
        presenter.newReciptRequested();
    }


    @Override
    public void setData(List<ReciptItem> data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }
}
