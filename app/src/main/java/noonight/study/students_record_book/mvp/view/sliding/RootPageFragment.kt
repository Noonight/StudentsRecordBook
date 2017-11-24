package noonight.study.students_record_book.mvp.view.sliding

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import noonight.study.students_record_book.R
import noonight.study.students_record_book.common.Log
import noonight.study.students_record_book.common.inflate
import noonight.study.students_record_book.common.loading.LoadingDialog
import noonight.study.students_record_book.mvp.base.BaseFragmentView
import noonight.study.students_record_book.mvp.model.Person
import noonight.study.students_record_book.mvp.repository.XmlHelper
import noonight.study.students_record_book.mvp.view.sliding.pages.first.FirstPageFragment
import noonight.study.students_record_book.mvp.view.sliding.pages.zachetieczameni.ZachetiEczamenFragment


class RootPageFragment : BaseFragmentView<RootPresenter>(), RootView {

    @BindView(R.id.view_pager)
    lateinit var viewPager: ViewPager

    companion object {
        fun newInstance(args: Bundle): RootPageFragment {
            val itFragment = RootPageFragment()
            itFragment.arguments = args
            return itFragment
        }
        lateinit var person: Person
    }

    init {
        person = XmlHelper.readXml()
        attachPresenter(RootPresenter())

    }

    override fun onStart() {
        super.onStart()
        //getPresenter().attachView(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.fragment_root_page_sliding)
        ButterKnife.bind(this, view!!)
        viewPager.adapter = ScreenSlidePageAdapter(childFragmentManager, activity)
        return view
    }

    override fun initLoadingView() {
        loadingView = LoadingDialog.view(activity.supportFragmentManager)
    }

    override fun bindView() {
        getPresenter().updateView()
    }

    class ScreenSlidePageAdapter(fm: FragmentManager, context: Context) : FragmentStatePagerAdapter(fm) {

        var listOfPage: ArrayList<Fragment> = ArrayList()

        init {
            addFragments()
        }

        override fun getItem(position: Int): Fragment {

            if (position == 0) {
                Log.d("position: $position")
            } else {

            }
            return listOfPage.get(position)
        }

        fun addFragments() {
            listOfPage.add(FirstPageFragment())
            Log.d(listOfPage.size.toString())
            Log.d("------------------------------------------------------------")
            for (i in 0..person.sessions!!.size-1){
                var bundle = Bundle()
                bundle.putInt("position", i)
                listOfPage.add(ZachetiEczamenFragment.newInstance(person.sessions!![i].numSessions))
            }
        }

        override fun getCount(): Int {
            if (listOfPage.size > 0) {
                return listOfPage.size
            } else {
                return 1
            }
        }

    }

}