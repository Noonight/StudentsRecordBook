package noonight.study.students_record_book.mvp.view.sliding.pages.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import noonight.study.students_record_book.R
import noonight.study.students_record_book.common.inflate
import noonight.study.students_record_book.common.loading.LoadingDialog
import noonight.study.students_record_book.mvp.base.BaseFragmentView
import noonight.study.students_record_book.mvp.model.Person
import noonight.study.students_record_book.mvp.repository.XmlHelper
import noonight.study.students_record_book.mvp.view.sliding.RootPageFragment


class FirstPageFragment : BaseFragmentView<FirstPagePresenter>() {

    @BindView(R.id.name)
    lateinit var name: TextView
    @BindView(R.id.num_book)
    lateinit var numBook: TextView
    @BindView(R.id.otdelenie)
    lateinit var otdelenie: TextView
    @BindView(R.id.facultet)
    lateinit var facultet: TextView
    @BindView(R.id.specialnost)
    lateinit var specialnost: TextView

    companion object {
        fun newInstance(args: Bundle): FirstPageFragment {
            val itFragment = FirstPageFragment()
            itFragment.arguments = args
            return itFragment
        }
        //var person: Person? = null
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.first_page_fragment)
        ButterKnife.bind(this, view!!) // null
        return view
    }

    override fun onStart() {
        super.onStart()
        //getPresenter().attachView(this)

    }

    init {
        attachPresenter(FirstPagePresenter())
        //getPresenter().attachView(this)
    }

    // do on view created method
    override fun bindView() {
        var person = RootPageFragment.person
        name.text = person?.name
        numBook.text = person?.numBook.toString()
        otdelenie.text = person?.otdelenie
        facultet.text = person?.facultet
        specialnost.text = person?.specialnost
        //name = xmlParser.getName();
    }

    override fun initLoadingView() {
        loadingView = LoadingDialog.view(activity.supportFragmentManager)
    }
}