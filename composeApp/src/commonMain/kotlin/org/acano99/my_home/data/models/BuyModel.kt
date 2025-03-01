package org.acano99.my_home.data.models

data class BuyModel(
    val id: Int? = null,
    val items: List<BuyItem> = listOf()
)

data class BuyItem(
    val id: Int? = null,
    val name: String = "",
    val price: Float = 0.0f,
    val comprado: Boolean = false
)
