package ru.nobird.android.ipchain.view.patent.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import ru.nobird.android.ipchain.view.patent.model.Download
import ru.nobird.android.ipchain.view.patent.ui.activity.PatentActivity
import ru.nobird.android.ipchain.view.patent.ui.adapter.DownloadAdapter

class AddDonwloadDialog : DialogFragment() {
    companion object {
        const val TAG = "AddDonwloadDialog"

        fun newInstance(): AddDonwloadDialog =
                AddDonwloadDialog()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = requireContext()
        val adapter = DownloadAdapter(isInDownloadAddMode = true, downloads = mutableListOf(Download("Алгоритмы (Университет ИТМО).xlsx", "2.7MB")), onCLick = {
            (activity as PatentActivity).addDownload(it)
            dismiss()
        })

        return MaterialDialog.Builder(context)
            .theme(Theme.DARK)
            .adapter(adapter, LinearLayoutManager(context))
            .build()
    }
}