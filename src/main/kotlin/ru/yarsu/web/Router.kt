package ru.yarsu.web

import org.http4k.core.Method
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.template.TemplateRenderer
import ru.yarsu.web.functions.ReadTrianglesFromJson
import ru.yarsu.web.handlers.*

val listTriangles = ReadTrianglesFromJson("triangles.json")
fun router(renderer: TemplateRenderer)
= routes(
    "/ping" bind Method.GET to PingHandler(),
    "/templates/pebble" bind Method.GET to PebbleHandler(),
    "/" bind Method.GET to HomeHandler(renderer),
    "/trianglesJson" bind Method.GET to JsonTrianglesHandler(renderer, listTriangles),
    "/triangles" bind Method.GET to TrianglesHandler(renderer, listTriangles),
    "/triangles/{id}" bind Method.GET to CurrentTriangleHandler(renderer, listTriangles)
)
