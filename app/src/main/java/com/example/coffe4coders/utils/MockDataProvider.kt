package com.example.coffe4coders.utils

import android.content.Context
import com.example.coffe4coders.R
import com.example.coffe4coders.models.Product

class MockDataProvider {

    companion object{

        fun getListOfProducts(context: Context): List<Product>{
            return listOf(
                Product(
                    id = 0,
                    name = context.getString(R.string.co_coffee_name),
                    summary = context.getString(R.string.co_coffee_summary),
                    description = context.getString(R.string.co_coffee_desc),
                    price = 55.0,
                    currency = "USD",
                    countryISO = "COL"
                ),
                Product(
                    id = 1,
                    name = context.getString(R.string.br_coffee_name),
                    summary = context.getString(R.string.br_coffee_summary),
                    description = context.getString(R.string.br_coffee_desc),
                    price = 40.0,
                    currency = "USD",
                    countryISO = "BRA"
                ),
                Product(
                    id = 2,
                    name = context.getString(R.string.ri_coffee_name),
                    summary = context.getString(R.string.ri_coffee_summary),
                    description = context.getString(R.string.ri_coffee_desc),
                    price = 35.0,
                    currency = "USD",
                    countryISO = "CRI"
                ),
                Product(
                    id = 3,
                    name = context.getString(R.string.ni_coffee_name),
                    summary = context.getString(R.string.ni_coffee_summary),
                    description = context.getString(R.string.ni_coffee_desc),
                    price = 50.0,
                    currency = "USD",
                    countryISO = "NIC"
                )
            )
        }

        fun getListOfCities(context: Context): List<String>{
            return listOf(
                context.getString(R.string.city_mexico),
                context.getString(R.string.city_habana),
                context.getString(R.string.city_cancun),
                context.getString(R.string.city_medellin),
                context.getString(R.string.city_buenosaires),
                context.getString(R.string.city_saopaulo),
                context.getString(R.string.city_lima),
                context.getString(R.string.city_montevideo),
                context.getString(R.string.city_panama)
            )
        }

        fun getProductByID(context: Context, id: Int): Product?{
            val list = getListOfProducts(context)
            return list.find { it.id == id }
        }

    }

    private constructor()
}