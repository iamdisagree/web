package ru.yarsu.web.functions

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import ru.yarsu.Triangles
import java.io.File

fun ReadTrianglesFromJson(path:String):Triangles {
    val rawJsonData = File(path).readText(Charsets.UTF_8)
    val obj = jacksonObjectMapper()
    val listTriangles: Triangles = obj.readValue(rawJsonData)
    return listTriangles

}