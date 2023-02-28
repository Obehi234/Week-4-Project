package com.example.week4project.partnerData

import com.example.week4project.R
import com.example.week4project.partnercards.PartnerCard

class Datasource {
    fun loadCards(): List<PartnerCard> {
        return listOf<PartnerCard>(
            PartnerCard(R.drawable.aliexpress, R.drawable.discount, R.drawable.clothes_and_shoes, R.drawable.shopping_bag_1),
            PartnerCard(R.drawable.aviasales, R.drawable.discount_2, R.drawable.tickets_and_travels, R.drawable.blue_shopping_bag),
            PartnerCard(R.drawable.bookgram, R.drawable.discount, R.drawable.booking_and_scheduling, R.drawable.shopping_bag_1)
        )
    }
}