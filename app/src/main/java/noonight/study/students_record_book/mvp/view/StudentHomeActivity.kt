package noonight.study.students_record_book.mvp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import noonight.study.students_record_book.R
import noonight.study.students_record_book.mvp.base.BaseView

class StudentHomeActivity : AppCompatActivity(), HomeView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_home)
    }

    override fun showLoadingDialog() {
    }

    override fun hideLoadingDialog() {
    }

    override fun showMessage(message: String?) {
    }

    override fun showError(errorMessage: String?) {
    }

    override fun onData() {
    }
}
