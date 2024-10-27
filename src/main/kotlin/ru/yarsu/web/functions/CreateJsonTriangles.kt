package ru.yarsu.web.functions

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import ru.yarsu.Triangles

fun CreateJsonTriangles(listTriangles: Triangles):String {
    val obj = jacksonObjectMapper()
    return obj.writerWithDefaultPrettyPrinter().writeValueAsString(listTriangles)
}