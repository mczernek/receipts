package pl.mobilechampions.recipts.recipt.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mobilechampions.recipts.R;
import pl.mobilechampions.recipts.recipt.model.ReciptItem;
import pl.mobilechampions.recipts.recipt.presenter.ReceiptDetailsBasePresenter;
import pl.mobilechampions.recipts.recipt.presenter.ReceiptDetailsPresenter;

@SuppressWarnings("unused")
public class ReceiptDetailsActivity extends AppCompatActivity implements ReceiptDetailsView {

    private static final String ACTION_NEW_RECIPT = "pl.mobilechampions.recipts.ACTION_NEW_RECIPT";

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Bind(R.id.details_toolbar)
    Toolbar toolbar;

    @Bind(R.id.details_fab)
    FloatingActionButton fab;

    @Bind(R.id.receipt_image)
    ImageView receiptImage;

    ReceiptDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipt_details);
        ButterKnife.bind(this);
        setupViews();
        presenter = new ReceiptDetailsBasePresenter();
        presenter.attachView(this);
        if (getIntent() != null) {
            if (ACTION_NEW_RECIPT.equals(getIntent().getAction())) {
                presenter.firstReceiptRequested();
            }
        }
    }

    @Override
    public void requestForNewPhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                receiptImage.setImageBitmap(imageBitmap);
            } else {
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }

    private void setupViews() {
        setSupportActionBar(toolbar);
    }

    @Override
    public void showItem(ReciptItem item) {
    }

    public static Intent getNewReciptIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, ReceiptDetailsActivity.class);
        intent.setAction(ACTION_NEW_RECIPT);
        return intent;
    }

    @OnClick(R.id.details_fab)
    public void saveReceipt(View view) {
        presenter.saveClicked();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
