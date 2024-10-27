package ru.yarsu.web.handlers

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.template.TemplateRenderer
import ru.yarsu.Triangles
import ru.yarsu.web.functions.CreateJsonTriangles
import ru.yarsu.web.models.HomeVM
import ru.yarsu.web.models.JsonTrianglesVM

class JsonTrianglesHandler(private val renderer:TemplateRenderer,
    private val listTriangles: Triangles
):HttpHandler {
    override fun invoke(request: Request): Response{
        val stringTriangles = CreateJsonTriangles(listTriangles)
        val viewModel = JsonTrianglesVM(stringTriangles)
        val htmlDocument = renderer(viewModel)
        return Response(Status.OK).body(htmlDocument)
    }
}