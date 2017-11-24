package noonight.study.students_record_book

import android.app.Application
import noonight.study.students_record_book.mvp.repository.XmlHelper


class App : Application() {

    companion object {
        private var mInstance: App? = null
        fun context(): App? {
            return mInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        //XmlHelper.writeXml()

        mInstance = this
    }

}