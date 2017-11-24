package noonight.study.students_record_book.mvp.view.sliding.pages.zachetieczameni

import noonight.study.students_record_book.mvp.model.Eczamen
import noonight.study.students_record_book.mvp.model.Zachet


interface ZachetiEczamenView {

    fun setZachetData(listZachet: MutableList<Zachet>)

    fun setEczamenData(listEczamen: MutableList<Eczamen>)

}