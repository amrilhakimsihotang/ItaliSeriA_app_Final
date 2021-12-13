package com.amrilhs.italiseria_app.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.amrilhs.italiaseria.core.data.Resource
import com.amrilhs.italiaseria.core.ui.SeriaAdapter
import com.amrilhs.italiseria_app.R
import com.amrilhs.italiseria_app.databinding.HomeFragmentBinding
import com.amrilhs.italiseria_app.detail.DetailItaliSeriaActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var homeFragmentBinding: HomeFragmentBinding? = null

    private val _binding get() = homeFragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeFragmentBinding = HomeFragmentBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val seriaAdapter = SeriaAdapter()
            seriaAdapter.onItemClick = { selectedData ->
                val mIntent = Intent(activity, DetailItaliSeriaActivity::class.java)
                mIntent.putExtra(DetailItaliSeriaActivity.INTENT_DATA, selectedData)
                startActivity(mIntent)
            }

            homeViewModel.italiSeriA.observe(viewLifecycleOwner, { italiaseria ->
                if (italiaseria != null) {

                    when (italiaseria) {
                        is Resource.Loading -> _binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            _binding.progressBar.visibility = View.GONE
                            seriaAdapter.setData(italiaseria.data)
                        }
                        is Resource.Error -> {
                            _binding.progressBar.visibility = View.GONE
                            _binding.viewError.root.visibility = View.VISIBLE
                            _binding.viewError.tvError.text =
                                italiaseria.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(_binding.rvItaliaseria) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = seriaAdapter
            }


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        homeFragmentBinding = null
    }

}