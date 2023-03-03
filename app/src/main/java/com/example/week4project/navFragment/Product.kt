package com.example.week4project.navFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.week4project.PageAdapter
import com.example.week4project.R
import com.example.week4project.RecyclerCustomAdapter
import com.example.week4project.partnerData.Datasource
import kotlin.math.abs


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

        val viewPager: ViewPager2 = view.findViewById(R.id.myViewPager)

        // Adding adapter on viewpager
        viewPager.adapter = PageAdapter(childFragmentManager, lifecycle)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        // Creating Adapter for my RecyclerView displaying all my partner cards
        val myDataset = Datasource().loadCards()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = RecyclerCustomAdapter(requireContext(), myDataset)
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        fun setPageTransformer(transformer: CompositePageTransformer) {
            transformer.addTransformer(MarginPageTransformer(40))
            transformer.addTransformer {page, position ->
                val r = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }

            viewPager.setPageTransformer(transformer)
        }
        val transformer = CompositePageTransformer()
        setPageTransformer(transformer)
        return view
    }

}