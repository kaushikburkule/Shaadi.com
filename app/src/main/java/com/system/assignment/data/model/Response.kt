package com.system.assignment.data.model

import com.google.gson.annotations.SerializedName


data class Response (

  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf(),
  @SerializedName("info"    ) var info    : Info?         = Info()

)