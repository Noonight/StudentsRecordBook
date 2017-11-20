package noonight.study.students_record_book.mvp.base;


import org.jetbrains.annotations.NotNull;

public abstract class BasePresenter<V extends BaseView> {

    private V view;

    public final void attachView(@NotNull V attachedView) {
        if (!setupDone())
            throw new NullPointerException("View must not be null!");
        view = attachedView;
        updateView();
    }

    public void detachView() {
        view = null;
    }

    protected abstract void updateView();

    protected boolean setupDone() {
        return view != null;
    }

    protected V getView() {
        return view;
    }

}
