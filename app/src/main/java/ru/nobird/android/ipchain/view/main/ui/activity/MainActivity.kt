package ru.nobird.android.ipchain.view.main.ui.activity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.nobird.android.ipchain.App
import ru.nobird.android.ipchain.R
import ru.nobird.android.ipchain.presentation.main.MainPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: MainPresenter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectComponent()
        presenter = ViewModelProviders.of(this, viewModelFactory).get(MainPresenter::class.java)

        button.setOnClickListener {
            presenter.fetchObjectTypes()
        }
    }

    private fun injectComponent() {
        App.component
            .inject(this)
    }
}
