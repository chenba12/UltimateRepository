package com.template.ultimaterepository.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.ultimaterepository.R
import com.template.ultimaterepository.data.AppRepository
import com.template.ultimaterepository.data.BaseItem
import com.template.ultimaterepository.data.Pet
import com.template.ultimaterepository.databinding.MainFragmentBinding
import com.template.ultimaterepository.recyclerView.GenericAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import timber.log.Timber

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

        val genericAdapter = GenericAdapter<Pet>(R.layout.pet_list_item)
        val manager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager=manager
        genericAdapter.setOnListItemViewClickListener(object : GenericAdapter.OnListItemViewClickListener{
            override fun onClick(view: View, item: BaseItem ) {
                Toast.makeText(view.context, "Clicked at row ${(item as Pet).name}", Toast.LENGTH_SHORT).show()
            }

        })
        val list = arrayListOf<Pet>()
        list.add(Pet("1","moshe","jgfgdxhtgf"))
        list.add(Pet("2","moshe2","jgfgdxhtgf"))
        list.add(Pet("3","moshe3","jgfgdxhtgf"))

        genericAdapter.addItems(list)
        Timber.wtf(genericAdapter.itemCount.toString())
        binding.recyclerView.adapter = genericAdapter


        return binding.root
    }
}
