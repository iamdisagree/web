package ru.yarsu.web.models

import org.http4k.template.ViewModel
import ru.yarsu.Triangle

class CurrentTriangleVM(val triangle: Triangle?): ViewModel {
}