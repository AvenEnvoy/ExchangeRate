package com.bignerdranch.android.exchangerate.screens.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.exchangerate.adapters.MainAdapter
import com.bignerdranch.android.exchangerate.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    lateinit var rv: RecyclerView
    lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        rv = binding.rvMain
        rv.layoutManager =
            LinearLayoutManager(viewModel.context, LinearLayoutManager.VERTICAL, false)
        adapter = MainAdapter()
        rv.adapter = adapter
        viewModel.getDataList()
        adapter.setList(viewModel.inputData.ValCurs.Valute)
    }
}