package com.example.week4project

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.week4project.partnercards.PartnerCard

class RecyclerCustomAdapter(private val context: Context,
                            private val dataset: List<PartnerCard>) : RecyclerView.Adapter<RecyclerCustomAdapter.CardViewHolder>() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        //This creates a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.partner_card_list, parent, false)
            return CardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = dataset[position]
        holder.brandName.setImageResource(card.ImageResourceId1)
        holder.discount.setImageResource(card.ImageResourceId2)
        holder.brandNiche.setImageResource(card.ImageResourceId3)
        holder.shoppingBag.setImageResource(card.ImageResourceId4)
    }

    override fun getItemCount() = dataset.size

    class CardViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    val brandName: ImageView = view.findViewById(R.id.brand_name)
    val discount: ImageView = view.findViewById(R.id.discount)
    val brandNiche: ImageView = view.findViewById(R.id.brand_niche)
    val shoppingBag: ImageView = view.findViewById(R.id.shopping_bag_icon)
}
}
