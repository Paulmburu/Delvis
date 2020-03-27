package com.polotechnologies.delvis.dataModels

data class User(
    val user_id: String = "",
    val user_email: String = "",
    val user_password: String = "",
    val user_phone_number: String = "",
    val user_location_address : String = ""
)