package ru.yarsu.web.functions

import ru.yarsu.Triangle
import ru.yarsu.Triangles

fun SortedTriangles(listTriangles: Triangles):Triangles {
    val triangles = listTriangles.triangles.sortedBy{CreateArea(it)}
    return Triangles(triangles)
}