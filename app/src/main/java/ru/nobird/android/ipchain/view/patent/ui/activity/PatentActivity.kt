package ru.nobird.android.ipchain.view.patent.ui.activity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_patent.*
import kotlinx.android.synthetic.main.view_patent_tab_1.view.*
import kotlinx.android.synthetic.main.view_patent_tab_2.view.*
import kotlinx.android.synthetic.main.view_patent_tab_3.view.*
import ru.nobird.android.ipchain.App
import ru.nobird.android.ipchain.R
import ru.nobird.android.ipchain.presentation.patent.PatentPresenter
import ru.nobird.android.ipchain.view.patent.ui.adapter.PatentPagerAdapter
import javax.inject.Inject

class PatentActivity : AppCompatActivity() {

    private lateinit var presenter: PatentPresenter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

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

            pager.nextButton3.setOnClickListener { presenter.createTransaction() }
        }
    }

    private fun injectComponent() {
        App.component
            .inject(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        if (item?.itemId == android.R.id.home) {
            if (pager.currentItem > 0) {
                pager.currentItem--
            } else {
                onBackPressed()
            }
            true
        } else {
            super.onOptionsItemSelected(item)
        }
}