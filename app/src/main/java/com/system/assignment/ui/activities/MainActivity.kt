package com.system.assignment.ui.activities

import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.LinearLayoutManager
import com.system.assignment.R
import com.system.assignment.data.local.entity.User
import com.system.assignment.databinding.ActivityMainBinding
import com.system.assignment.di.component.ActivityComponent
import com.system.assignment.ui.adapter.MainAdapter
import com.system.assignment.ui.adapter.RecyclerViewCallback
import com.system.assignment.ui.base.BaseActivity
import com.system.assignment.ui.viewmodels.MainActivityViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(), RecyclerViewCallback {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewDataBinding

        mViewModel.listen.observe(this, {
            val mainAdapter = MainAdapter(this@MainActivity, it)
            mainAdapter.setOnClickListener(this@MainActivity)
            binding.listView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = mainAdapter
            }
        })

    }

    // Binding and initialization of basic components
    override fun getBindingVariable(): Int = BR._all
    override fun getLayoutId(): Int = R.layout.activity_main
    override fun performDependencyInjection(buildComponent: ActivityComponent?) =
        buildComponent!!.inject(this)

    override fun position(position: User, b: Boolean) {
        mViewModel.saveRecord(position, b)
    }

}