package com.bignerdranch.android.exchangerate.screens.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bignerdranch.android.exchangerate.APP
import com.bignerdranch.android.exchangerate.R
import com.bignerdranch.android.exchangerate.databinding.FragmentSplashBinding
import com.bignerdranch.android.exchangerate.screens.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
        viewModel.getData()
        CoroutineScope(Dispatchers.Main).launch {
            delay(1500)
            val bundle = Bundle()
            bundle.putSerializable("data", viewModel.data)
            APP.navController.navigate(R.id.action_splashFragment_to_mainFragment)
        }
    }
}