package noonight.study.students_record_book.mvp.view.sliding.pages.zachetieczameni

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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
import noonight.study.students_record_book.mvp.model.Eczamen
import noonight.study.students_record_book.mvp.model.Zachet


class ZachetiEczamenFragment : BaseFragmentView<ZachetiEczamenPresenter>(), ZachetiEczamenView {

    @BindView(R.id.list_zacheti)
    lateinit var listZacheti: RecyclerView
    @BindView(R.id.list_eczameni)
    lateinit var listEczameni: RecyclerView

    var layoutManager: LinearLayoutManager? = null
    var zachetAdapter: ZachetAdapter? = null
    var eczamenAdapter: EczamenAdapter? = null

    var value: Int = 0

    companion object {
        fun newInstance(args: Bundle): ZachetiEczamenFragment {
            val itFragment = ZachetiEczamenFragment()
            itFragment.arguments = args
            return itFragment
        }
        fun newInstance(value: Int) : ZachetiEczamenFragment {
            val itFragment = ZachetiEczamenFragment()
            itFragment.value = value
            return itFragment
        }
    }

    override fun onStart() {
        super.onStart()
        //getPresenter().attachView(this)
        loadingView = LoadingDialog.view(activity.supportFragmentManager)
    }

    init {
        attachPresenter(ZachetiEczamenPresenter())




        val bundleZachet: Bundle = Bundle()
//        bundleZachet.putInt("position", arguments.getInt("position"))

        val bundleEczamen = Bundle()
//        bundleEczamen.putInt("position", arguments.getInt("position"))

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.zachet_eczamen_fragment)
        ButterKnife.bind(this, view!!)
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        listZacheti.layoutManager = layoutManager

        listEczameni.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        zachetAdapter = ZachetAdapter.newInstance(value)
        Log.d(value.toString())
        eczamenAdapter = EczamenAdapter.newInstance(value)
        listZacheti.adapter = zachetAdapter
        listEczameni.adapter = eczamenAdapter
        listZacheti.setHasFixedSize(true)
        listEczameni.setHasFixedSize(true)

        return view
    }

    override fun setZachetData(listZachet: MutableList<Zachet>) {
        zachetAdapter!!.setData(listZachet)
    }

    override fun setEczamenData(listEczamen: MutableList<Eczamen>) {
        eczamenAdapter!!.setData(listEczamen)
    }

    override fun bindView() {
        getPresenter().updateView()
    }

    override fun initLoadingView() {
        loadingView = LoadingDialog.view(activity.supportFragmentManager)
    }
}