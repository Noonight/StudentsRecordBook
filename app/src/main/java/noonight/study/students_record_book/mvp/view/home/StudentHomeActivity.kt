package noonight.study.students_record_book.mvp.view.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import noonight.study.students_record_book.R
import noonight.study.students_record_book.mvp.base.BaseActivityView
import noonight.study.students_record_book.mvp.presenter.StudentHomePresenter
import noonight.study.students_record_book.mvp.repository.XmlHelper
import noonight.study.students_record_book.mvp.view.sliding.RootPageFragment
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife


class StudentHomeActivity : BaseActivityView<StudentHomePresenter>(), HomeView {

    @BindView(R.id.write)
    lateinit var write: Button
    @BindView(R.id.read)
    lateinit var read: Button
    @BindView(R.id.menu)
    lateinit var menu: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_home)
        //showRootPageFragment()
        if (shouldAskPermissions()) {
            askPermissions();
        }
        ButterKnife.bind(this)
        write.setOnClickListener({ XmlHelper.writeXml() })
        read.setOnClickListener({
            //XmlHelper.readXml()
            showRootPageFragment()
            menu.setVisibility(View.GONE)
        })
        //getPresenter().attachView(this)
        //XmlHelper.writeXml()
    }

    init {
        attachPresenter(StudentHomePresenter())

    }

    override fun bindView() {
        getPresenter().updateView()
    }

    private fun showRootPageFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.home_fragment_container, RootPageFragment.newInstance(Bundle()), RootPageFragment.javaClass.name)
                .commit()
    }

    protected fun shouldAskPermissions(): Boolean {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1
    }

    @TargetApi(23)
    protected fun askPermissions() {
        val permissions = arrayOf("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE")
//        val permissions = arrayOf("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE")

        val requestCode = 200
        requestPermissions(permissions, requestCode)
    }

}
