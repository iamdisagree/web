package ru.yarsu.web.functions

import ru.yarsu.Triangle
import kotlin.math.sqrt

fun CreateArea(triangle: Triangle):Double{
    val a = triangle.sideA
    val b = triangle.sideB
    val c = triangle.sideC
    val p = (a+b+c)/2
    return sqrt(p*(p-a)*(p-b)*(p-c))
}