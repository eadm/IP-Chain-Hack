package ru.nobird.android.ipchain.view.patent.ui.activity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import ru.nobird.android.ipchain.App
import ru.nobird.android.ipchain.R
import ru.nobird.android.ipchain.presentation.patent.PatentPresenter
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
    }

    private fun injectComponent() {
        App.component
            .inject(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
}