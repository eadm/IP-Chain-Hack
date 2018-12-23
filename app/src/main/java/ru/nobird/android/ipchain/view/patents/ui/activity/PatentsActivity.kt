package ru.nobird.android.ipchain.view.patents.ui.activity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_patents.*
import ru.nobird.android.ipchain.App
import ru.nobird.android.ipchain.R
import ru.nobird.android.ipchain.presentation.patents.PatentsPresenter
import ru.nobird.android.ipchain.view.patent.model.Download
import ru.nobird.android.ipchain.view.patent.model.Item
import ru.nobird.android.ipchain.view.patent.ui.activity.PatentActivity
import ru.nobird.android.ipchain.view.patent.ui.adapter.DownloadAdapter
import javax.inject.Inject

class PatentsActivity : AppCompatActivity() {

    private lateinit var presenter: PatentsPresenter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val adapter = DownloadAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patents)

        injectComponent()
        presenter = ViewModelProviders.of(this, viewModelFactory).get(PatentsPresenter::class.java)

        addPatent.setOnClickListener {
            startActivityForResult(Intent(this, PatentActivity::class.java), PatentActivity.RQ)
        }

        patents.adapter = adapter
        patents.layoutManager = LinearLayoutManager(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        data?.getParcelableExtra<Item>("item")?.let {
            adapter.downloads.add(Download(it.title, it.date))
            adapter.notifyItemInserted(adapter.downloads.size - 1)
        }
    }

    private fun injectComponent() {
        App.component
            .inject(this)
    }
}
