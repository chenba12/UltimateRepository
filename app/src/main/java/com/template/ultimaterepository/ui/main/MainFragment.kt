package com.template.ultimaterepository.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.template.ultimaterepository.R
import com.template.ultimaterepository.data.AppRepository
import com.template.ultimaterepository.databinding.MainFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainFragment : BaseFragment() {

    private val appRepository: AppRepository by inject()
    private val viewModel: MainFragmentViewModel by viewModel { parametersOf(appRepository) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: MainFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        binding.mainFragmentViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
