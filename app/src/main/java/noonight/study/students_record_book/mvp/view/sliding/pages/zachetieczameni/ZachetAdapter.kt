package noonight.study.students_record_book.mvp.view.sliding.pages.zachetieczameni

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import noonight.study.students_record_book.R
import noonight.study.students_record_book.common.Log
import noonight.study.students_record_book.mvp.model.Zachet
import noonight.study.students_record_book.mvp.view.sliding.RootPageFragment


class ZachetAdapter : RecyclerView.Adapter<ZachetAdapter.ViewHolder>() {

    lateinit var args: Bundle
    var value: Int = 0

    companion object {
        fun newInstance(args: Bundle): ZachetAdapter {
            val itAdapter = ZachetAdapter()
            itAdapter.args = args
            val position = args.getInt("position")
            itAdapter.zacheti = RootPageFragment.person.sessions!![position].zacheti?.zacheti as MutableList<Zachet>?
            return itAdapter
        }
        fun newInstance(value: Int): ZachetAdapter {
            val itAdapter = ZachetAdapter()
            itAdapter.value = value
            Log.d(value.toString() + "=----------=" + RootPageFragment.person.sessions!!.size)
            itAdapter.zacheti = RootPageFragment.person.sessions!![value-1].zacheti?.zacheti as MutableList<Zachet>?
            Log.d(itAdapter.zacheti.toString())
            return itAdapter
        }
    }

    var zacheti: MutableList<Zachet>? = null

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        //Log.d(zacheti!!.get(position).toString())
        holder?.bind(zacheti!!.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_zachet, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = zacheti?.size!!

    fun setData(zacheti: MutableList<Zachet>) {
        zacheti.clear()
        zacheti.addAll(zacheti)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.title_zachet)
        lateinit var titleZachet: TextView
        @BindView(R.id.ocenka_zachet)
        lateinit var ocenkaZachet: TextView
        @BindView(R.id.data_sdachi_zachet)
        lateinit var dataSdachiZachet: TextView
        @BindView(R.id.prepodavatel_zachet)
        lateinit var prepodavatelZachet: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(item: Zachet) {
            //Log.d(item.toString())
            titleZachet.text = item.predmet
            ocenkaZachet.text = item.ocenka
            dataSdachiZachet.text = item.dataSdachi
            prepodavatelZachet.text = item.prepodavatel
        }

    }
}