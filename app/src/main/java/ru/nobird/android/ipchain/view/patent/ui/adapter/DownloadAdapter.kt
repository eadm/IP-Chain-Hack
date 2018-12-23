package ru.nobird.android.ipchain.view.patent.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_downloads.view.*
import ru.nobird.android.ipchain.R
import ru.nobird.android.ipchain.view.patent.model.Download

class DownloadAdapter(
    val isInDownloadAddMode: Boolean = false,
    val downloads: MutableList<Download> = mutableListOf(),
    val onCLick: ((Download) -> Unit)? = null
) : RecyclerView.Adapter<DownloadAdapter.DownloadVH>() {

    override fun getItemCount(): Int =
        downloads.size


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DownloadVH =
        DownloadVH(LayoutInflater.from(p0.context).inflate(R.layout.item_downloads, p0, false))

    override fun onBindViewHolder(p0: DownloadVH, p1: Int) {
        with(p0.itemView) {
            downloadTitle.text = downloads[p1].title
            downloadSize.text = downloads[p1].size
            
            removeDownload.visibility = if (isInDownloadAddMode) View.GONE else View.VISIBLE

            isEnabled = isInDownloadAddMode
            if (isInDownloadAddMode) {
                setOnClickListener { onCLick?.invoke(downloads[p1]) }
            }
        }
    }

    inner class DownloadVH(root: View) : RecyclerView.ViewHolder(root) {
        init {
            root.removeDownload.setOnClickListener {
                downloads.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }
}