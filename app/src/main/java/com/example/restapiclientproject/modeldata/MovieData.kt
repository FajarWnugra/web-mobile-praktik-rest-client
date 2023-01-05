package com.example.restapiclientproject.modeldata

import com.google.gson.annotations.SerializedName

class MovieData (
    val Year:String,
    val Title:String,
    @SerializedName("Poster") val gambar:String
        )

