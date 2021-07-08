package com.sundy.test.ui.find
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.sundy.test.R

class FindFragment : Fragment() {

    companion object {
        fun newInstance() = FindFragment()
    }

    private lateinit var viewModel: FindViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bbl_find_fragment_layout, container, false)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        viewModel=ViewModelProvider(this).get(FindViewModel::class.java)
    }
}
