package noonight.study.students_record_book.mvp.view.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import noonight.study.students_record_book.R
import noonight.study.students_record_book.mvp.base.BaseActivityView
import noonight.study.students_record_book.mvp.presenter.StudentHomePresenter
import noonight.study.students_record_book.mvp.repository.XmlHelper
import noonight.study.students_record_book.mvp.view.sliding.RootPageFragment

class StudentHomeActivity : BaseActivityView<StudentHomePresenter>(), HomeView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_home)
        showRootPageFragment()
    }

    init {
        XmlHelper.writeXml()
        attachPresenter(StudentHomePresenter())
    }

    override fun bindView() {
    }

    private fun showRootPageFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.home_fragment_container, RootPageFragment.newInstance(Bundle()), RootPageFragment.javaClass.name)
                .commit()
    }
}
