package ru.nobird.android.ipchain.view.patent.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment


class LoadingProgressDialogFragment : DialogFragment() {
    companion object {
        fun newInstance(): DialogFragment =
            LoadingProgressDialogFragment()

        const val TAG = "LoadingProgressDialogFragment"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        isCancelable = false
        return LoadingProgressDialog(requireContext())
    }
}
