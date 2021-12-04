package com.mesteban.aad_playground.commons.serializer

import com.google.gson.Gson
import javax.inject.Inject

class GsonSerializer @Inject constructor(val gson: Gson) : JsonSerializer {

    override fun <T> toJson(obj: T, typeClass: Class<T>): String = gson.toJson(obj, typeClass)

    override fun <T> fromJson(json: String, typeClass: Class<T>): T = gson.fromJson(json, typeClass)
}