package noonight.study.students_record_book.mvp.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import noonight.study.students_record_book.common.loading.LoadingDialog;
import noonight.study.students_record_book.common.loading.LoadingView;

public abstract class BaseFragmentView<T extends BasePresenter> extends Fragment implements BaseViewInterface {

    protected T presenter;

    protected LoadingView loadingView;

    public BaseFragmentView() {
        //initLoadingView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView();
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

    // do on view created method
    protected abstract void bindView();

    // code like that
    /*
    * loadingView = LoadingDialog.view(getActivity().getSupportFragmentManager());
    * */
    protected abstract void initLoadingView();

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
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String errorMessage) {
        showMessage(errorMessage);
    }
}
