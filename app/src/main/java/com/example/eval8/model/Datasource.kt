package com.example.eval8.model

import com.example.eval8.model.Offer

class Datasource {

    fun loadData():List<Offer>{
        return listOf(
            Offer(title = "100 Credits Prize/Ticket Game Card"),
            Offer(title = "Card with Coke"),
            Offer(title="New Birthday Card"),
            Offer(title="Birthday game card with Discount"),
            Offer(title="Birthday game card with 10% discount")
        )
    }
}