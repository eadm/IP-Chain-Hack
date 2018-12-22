package ru.nobird.android.ipchain.view.patents.ui.activity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_patents.*
import ru.nobird.android.ipchain.App
import ru.nobird.android.ipchain.R
import ru.nobird.android.ipchain.presentation.patents.PatentsPresenter
import javax.inject.Inject

class PatentsActivity : AppCompatActivity() {

    private lateinit var presenter: PatentsPresenter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patents)

        injectComponent()
        presenter = ViewModelProviders.of(this, viewModelFactory).get(PatentsPresenter::class.java)

    }

    private fun injectComponent() {
        App.component
            .inject(this)
    }
}
