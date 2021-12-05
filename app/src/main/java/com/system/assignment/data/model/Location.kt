package com.system.assignment.data.model

import com.google.gson.annotations.SerializedName
import com.system.assignment.data.model.Coordinates
import com.system.assignment.data.model.Street
import com.system.assignment.data.model.Timezone


data class Location (

    @SerializedName("street"      ) var street      : Street?      = Street(),
    @SerializedName("city"        ) var city        : String?      = null,
    @SerializedName("state"       ) var state       : String?      = null,
    @SerializedName("country"     ) var country     : String?      = null,
    @SerializedName("postcode"    ) var postcode    : String?      = null,
    @SerializedName("coordinates" ) var coordinates : Coordinates? = Coordinates(),
    @SerializedName("timezone"    ) var timezone    : Timezone?    = Timezone()

)