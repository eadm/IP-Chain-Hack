package ru.nobird.android.ipchain.view.patent.ui.activity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_patent.*
import kotlinx.android.synthetic.main.view_patent_tab_1.view.*
import kotlinx.android.synthetic.main.view_patent_tab_2.view.*
import kotlinx.android.synthetic.main.view_patent_tab_3.view.*
import ru.nobird.android.ipchain.App
import ru.nobird.android.ipchain.R
import ru.nobird.android.ipchain.presentation.patent.PatentPresenter
import ru.nobird.android.ipchain.presentation.patent.PatentView
import ru.nobird.android.ipchain.view.patent.model.Download
import ru.nobird.android.ipchain.view.patent.model.Item
import ru.nobird.android.ipchain.view.patent.ui.adapter.DownloadAdapter
import ru.nobird.android.ipchain.view.patent.ui.adapter.InputDataAdapter
import ru.nobird.android.ipchain.view.patent.ui.adapter.PatentPagerAdapter
import ru.nobird.android.ipchain.view.patent.ui.dialog.AddAuthorDialogFragment
import ru.nobird.android.ipchain.view.patent.ui.dialog.AddDonwloadDialog
import ru.nobird.android.ipchain.view.patent.ui.dialog.LoadingProgressDialogFragment
import javax.inject.Inject

class PatentActivity : AppCompatActivity(), PatentView {
    companion object {
        const val RQ = 132
    }

    private lateinit var presenter: PatentPresenter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val downloadAdapter = DownloadAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patent)

        injectComponent()
        presenter = ViewModelProviders.of(this, viewModelFactory).get(PatentPresenter::class.java)

        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }

        pager.offscreenPageLimit = 3
        pager.adapter = PatentPagerAdapter()

        pager.post {
            pager.nextButton1.setOnClickListener { pager.currentItem++ }
            pager.nextButton2.setOnClickListener { pager.currentItem++ }
            pager.prevButton2.setOnClickListener { pager.currentItem-- }
            pager.prevButton3.setOnClickListener { pager.currentItem-- }

            pager.nextButton3.setOnClickListener {
                presenter.createTransaction(pager.titleField.text.toString())
            }

            pager.descriptionTypeField.adapter =
                    ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.description_types)).apply {
                        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    }

            pager.countryField.adapter =
                    ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.countries_array)).apply {
                        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    }

            pager.addAuthor.setOnClickListener {
                AddAuthorDialogFragment
                    .newInstance()
                    .show(supportFragmentManager, AddAuthorDialogFragment.TAG)
            }

            val inputFieldAdapter = InputDataAdapter(R.layout.item_input_data)
            with(pager.inputField) {
                adapter = inputFieldAdapter
                layoutManager = LinearLayoutManager(context)
            }

            pager.inputFieldAdd.setOnClickListener {
                inputFieldAdapter.counter++
            }

            val interfacesAdapter = InputDataAdapter(R.layout.item_interface)
            with(pager.usedInterfacesField) {
                adapter = interfacesAdapter
                layoutManager = LinearLayoutManager(context)
            }
            pager.usedInterfacesAdd.setOnClickListener {
                interfacesAdapter.counter++
            }

            with(pager.files) {
                adapter = downloadAdapter
                layoutManager = LinearLayoutManager(context)
            }

            pager.addFile.setOnClickListener {
                AddDonwloadDialog
                    .newInstance()
                    .show(supportFragmentManager, AddDonwloadDialog.TAG)
            }
        }
    }

    fun addAuthor(author: String) {
        val authorsField = pager.authorsField
        if (authorsField.text.isEmpty()) {
            authorsField.text = author
        } else {
            authorsField.text = authorsField.text.toString() + ", $author"
        }
    }

    fun addDownload(download: Download) {
        downloadAdapter.downloads.add(download)
        downloadAdapter.notifyItemInserted(downloadAdapter.itemCount - 1)
    }

    private fun injectComponent() {
        App.component
            .inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        presenter.detachView(this)
        super.onStop()
    }

    override fun showLoading() {
        if (supportFragmentManager.findFragmentByTag(LoadingProgressDialogFragment.TAG) == null) {
            LoadingProgressDialogFragment.newInstance().show(supportFragmentManager, LoadingProgressDialogFragment.TAG)
        }
    }

    override fun hideLoading() {
        (supportFragmentManager.findFragmentByTag(LoadingProgressDialogFragment.TAG) as? DialogFragment)?.dismiss()
    }

    override fun onSuccess(item: Item) {
        setResult(RQ, Intent().putExtra("item", item))
        finish()
    }

    override fun onError() {
        Snackbar.make(pager, R.string.error, Snackbar.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }

    override fun onBackPressed() {
        if (pager.currentItem > 0) {
            pager.currentItem--
        } else {
            super.onBackPressed()
        }
    }
}