package ru.yarsu.web.handlers

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.path
import org.http4k.template.TemplateRenderer
import ru.yarsu.Triangles
import ru.yarsu.web.functions.CreateJsonTriangles
import ru.yarsu.web.models.CurrentTriangleVM
import ru.yarsu.web.models.HomeVM
import ru.yarsu.web.models.JsonTrianglesVM

class CurrentTriangleHandler(private val renderer:TemplateRenderer,
                           private val listTriangles: Triangles
):HttpHandler {
    override fun invoke(request: Request): Response{
        val id = request.path("id")
        val viewModel = CurrentTriangleVM(listTriangles.triangles.find { it.id==id })
        val htmlDocument = renderer(viewModel)
        return Response(Status.OK).body(htmlDocument)
    }
}