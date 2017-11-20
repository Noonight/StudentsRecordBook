package noonight.study.students_record_book.mvp.base;


import noonight.study.students_record_book.common.loading.LoadingView;

/*
* LoadingView: LoadingDialog
* */
public interface BaseView extends LoadingView{

    void showMessage(String message);

    void showError(String errorMessage);

}
