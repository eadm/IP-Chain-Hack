package ru.nobird.android.ipchain.view.patent.ui.dialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.dialog_author.*
import ru.nobird.android.ipchain.R
import ru.nobird.android.ipchain.view.patent.ui.activity.PatentActivity

class AddAuthorDialogFragment : DialogFragment() {
    companion object {
        const val TAG = "AddAuthorDialogFragment"
        const val REQUEST_CODE = 1323

        fun newInstance() = AddAuthorDialogFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialog_author, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        negative.setOnClickListener { dismiss() }
        positive.setOnClickListener {
            (activity as PatentActivity).addAuthor(firstName.text.toString() + " " + lastName.text.toString())
            dismiss()
        }
    }
}