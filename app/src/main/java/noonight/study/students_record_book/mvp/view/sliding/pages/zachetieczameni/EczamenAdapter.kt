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
import noonight.study.students_record_book.mvp.model.Eczamen
import noonight.study.students_record_book.mvp.view.sliding.RootPageFragment


class EczamenAdapter : RecyclerView.Adapter<EczamenAdapter.ViewHolder>() {

    lateinit var args: Bundle
    var value = 0

    companion object {
        fun newInstance(args: Bundle): EczamenAdapter {
            val itAdapter = EczamenAdapter()
            itAdapter.args = args
            itAdapter.eczameni = RootPageFragment
                    .person
                    .sessions!![args.getInt("position")]
                    .eczameni!!.eczameni as MutableList<Eczamen>?
            return itAdapter
        }
        fun newInstance(value: Int): EczamenAdapter {
            val itAdapter = EczamenAdapter()
            itAdapter.value = value
            itAdapter.eczameni = RootPageFragment
                    .person
                    .sessions!![value-1]
                    .eczameni!!.eczameni as MutableList<Eczamen>?
            return itAdapter
        }
    }

    var eczameni: MutableList<Eczamen>? = null

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(eczameni!!.get(position))
    }

    override fun getItemCount(): Int = eczameni!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_eczamen, parent, false)
        return ViewHolder(view)
    }

    fun setData(eczameni: MutableList<Eczamen>) {
        eczameni.clear()
        eczameni.addAll(eczameni)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.title_eczamen)
        lateinit var titleEczamen: TextView
        @BindView(R.id.ocenka_eczamen)
        lateinit var ocenkaEczamen: TextView
        @BindView(R.id.data_sdachi_eczamen)
        lateinit var dataSdachiEczamen: TextView
        @BindView(R.id.prepodavatel_eczamen)
        lateinit var prepodavatelEczamen: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(item: Eczamen) {
            titleEczamen.text = item.predmet
            ocenkaEczamen.text = item.ocenka
            dataSdachiEczamen.text = item.dataSdachi
            prepodavatelEczamen.text = item.prepodavatel
        }

    }
}