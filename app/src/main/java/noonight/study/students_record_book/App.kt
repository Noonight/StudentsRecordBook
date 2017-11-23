package noonight.study.students_record_book

import android.app.Application


class App : Application() {

    companion object {
        private var mInstance: App? = null
        fun context(): App? {
            return mInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }

}