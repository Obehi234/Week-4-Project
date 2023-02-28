package com.example.week4project.navFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.week4project.PageAdapter
import com.example.week4project.R
import com.example.week4project.RecyclerCustomAdapter
import com.example.week4project.partnerData.Datasource


class Product : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        val viewPager = view.findViewById<ViewPager>(R.id.myViewPager)
        // Adding adapter on viewpager
        viewPager.adapter = PageAdapter(childFragmentManager)

        // Creating Adapter for my RecyclerView displaying all my partner cards
        val myDataset = Datasource().loadCards()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = RecyclerCustomAdapter(requireContext(), myDataset)
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        return view
    }
}