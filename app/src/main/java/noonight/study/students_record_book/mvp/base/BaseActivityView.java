package noonight.study.students_record_book.mvp.base;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import noonight.study.students_record_book.common.loading.LoadingDialog;
import noonight.study.students_record_book.common.loading.LoadingView;

public abstract class BaseActivityView<T extends BasePresenter> extends AppCompatActivity implements BaseViewInterface {

    protected T presenter;

    private LoadingView loadingView;

    public BaseActivityView() {
        initLoadingView();
    }

    public FragmentManager activitySupportFragmentManager() {
        return this.getSupportFragmentManager();
    }

    protected void attachPresenter(T presenter) {
        this.presenter = presenter;
    }

    protected void detachPresenter() {
        this.presenter = null;
    }

    protected boolean presenterIsSetup() {
        return presenter != null;
    }

    protected T getPresenter() {
        return presenter;
    }

    protected abstract void bindView();

    private void initLoadingView() {
        loadingView = LoadingDialog.view(getSupportFragmentManager());
    }

    protected boolean loadingIsSetup() {
        return loadingView != null;
    }

    @Override
    public void showLoadingDialog() {
        if (!loadingIsSetup())
            loadingView.showLoadingDialog();
    }

    @Override
    public void hideLoadingDialog() {
        if (!loadingIsSetup())
            loadingView.hideLoadingDialog();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String errorMessage) {
        showMessage(errorMessage);
    }
}
