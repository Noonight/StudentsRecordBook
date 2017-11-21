package noonight.study.students_record_book.mvp.view.sliding

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import noonight.study.students_record_book.R
import noonight.study.students_record_book.mvp.base.BaseFragmentView


class RootPageFragment : BaseFragmentView<RootPresenter>(), RootView {

    @BindView(R.id.view_pager)
    val viewPager: ViewPager? = null

    companion object {
        fun newInstance(args: Bundle): RootPageFragment {
            val itFragment = RootPageFragment()
            itFragment.arguments = args
            return itFragment
        }
    }

    init {
        attachPresenter(RootPresenter())
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_root_page_sliding, container, false)
        ButterKnife.bind(this, view!!)
        return view
    }

    override fun bindView() {

    }

}