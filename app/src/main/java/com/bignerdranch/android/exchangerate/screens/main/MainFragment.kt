package com.bignerdranch.android.exchangerate.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.exchangerate.adapters.MainAdapter
import com.bignerdranch.android.exchangerate.databinding.FragmentMainBinding
import com.bignerdranch.android.exchangerate.model.InputData

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var rv: RecyclerView
    private lateinit var adapter: MainAdapter
    private lateinit var currentData: ArrayList<InputData>
    private lateinit var currentDate: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        currentData = arguments?.getParcelableArrayList<InputData>("list") as ArrayList<InputData>
        currentDate = arguments?.getString("date") as String
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        (activity as AppCompatActivity).supportActionBar?.title = "Курс валют на $currentDate"
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        rv = binding.rvMain
        rv.layoutManager =
            LinearLayoutManager(viewModel.context, LinearLayoutManager.VERTICAL, false)
        adapter = MainAdapter()
        rv.adapter = adapter
        adapter.setList(currentData)
    }
}