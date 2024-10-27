package ru.yarsu.web.handlers


import org.http4k.core.*
import org.http4k.format.Jackson.auto
import ru.yarsu.Triangles

class SecondJsonHandler(listTriangles: Triangles): HttpHandler {
    private val lTriangles = listTriangles
    override fun invoke(request: Request): Response {
        val jsonLens = Body.auto<Triangles>().toLens()
        return Response(Status.OK).with(jsonLens of lTriangles)
    }
}