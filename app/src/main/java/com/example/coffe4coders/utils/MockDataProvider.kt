package com.example.coffe4coders.utils

import com.example.coffe4coders.models.Product

class MockDataProvider {

    companion object{

        fun getListOfProducts(): List<Product>{
            return listOf(
                Product(
                    0,
                    "Café de Colombia",
                    PRODUCT_DESCRIPTION,
                    LOREM_FACT,
                    55.0,
                    "USD",
                    "COL"
                ),
                Product(
                    1,
                    "Café de Brasil",
                    PRODUCT_DESCRIPTION,
                    LOREM_FACT,
                    40.0,
                    "USD",
                    "BRA"
                ),
                Product(
                    2,
                    "Café de Costa Ríca",
                    PRODUCT_DESCRIPTION,
                    LOREM_FACT,
                    35.0,
                    "USD",
                    "CRI"
                ),
                Product(
                    3,
                    "Café de Nicaragua",
                    PRODUCT_DESCRIPTION,
                    LOREM_FACT,
                    50.0,
                    "USD",
                    "NIC"
                )
            )
        }

        fun getListOfCities(): List<String>{
            return listOf(
                "Mexico City, Mexico",
                "The Habana, Cuba",
                "Cancun, Mexico",
                "Medellin, Colombia",
                "Buenos Aires, Argentina",
                "Sao Paulo, Brasil",
                "Lima, Peru",
                "Montevideo, Uruguay",
                "Panama City, Panama"
            )
        }

        fun getProductByID(id: Int): Product?{
            val list = MockDataProvider.getListOfProducts()
            return list.filter { it.id == id }[0]
        }

    }

    private constructor()
}