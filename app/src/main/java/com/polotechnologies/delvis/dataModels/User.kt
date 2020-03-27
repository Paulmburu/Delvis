package com.polotechnologies.delvis.dataModels

data class User(
    var user_id: String = "",
    var user_email: String = "",
    var user_password: String = "",
    var user_phone_number: String = "",
    var user_location_address : String = ""
)