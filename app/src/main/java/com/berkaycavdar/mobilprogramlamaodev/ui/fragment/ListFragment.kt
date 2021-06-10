package com.berkaycavdar.mobilprogramlamaodev.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.berkaycavdar.mobilprogramlamaodev.useradapter.Adapter
import com.berkaycavdar.mobilprogramlamaodev.MainActivity
import com.berkaycavdar.mobilprogramlamaodev.R
import com.berkaycavdar.mobilprogramlamaodev.ui.main.MainViewModel
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.berkaycavdar.mobilprogramlamaodev.utils.Resource


class ListFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var navController: NavController
    private lateinit var userAdapter: Adapter
    private lateinit var rvUsers: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).mainViewModel

        rvUsers = view.findViewById(R.id.user_list)
        setupRecyclerView()

        navController = Navigation.findNavController(requireActivity(), R.id.ac_ma_nav_host_fragment)

        rvUsers = view.findViewById(R.id.user_list)

        viewModel.userRes.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    (requireActivity() as MainActivity).showLoading()
                }
                is Resource.Error -> {
                    (requireActivity() as MainActivity).hideLoading()
                    response.message?.let { message ->
                        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Success -> {
                    (requireActivity() as MainActivity).hideLoading()
                    response.data?.let { userResponse ->
                        if (userResponse != null) {
                            val userList = userResponse.toList()
                            userAdapter.differ.submitList(userList)
                        } else {

                        }
                    }
                }
            }
            response.data = null
            response.message = null
        })

        userAdapter.setUserItemClickListener {
            val bundle: Bundle = Bundle().apply {
                putSerializable("userItemDetail", it)
            }
            navController.navigate(
                R.id.action_listFragment_to_detailFragment,
                bundle
            )
        }
    }

    private fun setupRecyclerView() {
        userAdapter = Adapter()
        rvUsers.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(activity)
            viewModel.getUser()
        }
    }
}