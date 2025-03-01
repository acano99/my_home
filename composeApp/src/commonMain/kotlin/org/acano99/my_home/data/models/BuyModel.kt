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

val buyModel = BuyModel(
    id = null, items = listOf(
        BuyItem(
            id = null, name = "Pepinos", price = 13f, comprado = false
        ),
        BuyItem(
            id = null, name = "Tomates", price = 15f, comprado = false
        ),
        BuyItem(
            id = null, name = "Aji", price = 25f, comprado = true
        ),
        BuyItem(
            id = null, name = "Cebolla", price = 103f, comprado = true
        ),
        BuyItem(
            id = null, name = "Pollo", price = 1333f, comprado = false
        ),
        BuyItem(
            id = null, name = "Lechuga", price = 13f, comprado = false
        ),
        BuyItem(
            id = null, name = "Ajo", price = 1300f, comprado = true
        ),
        BuyItem(
            id = null, name = "Platano de fruta", price = 13f, comprado = true
        ),
        BuyItem(
            id = null, name = "Naranja agria", price = 100f, comprado = true
        ),
    )
)
