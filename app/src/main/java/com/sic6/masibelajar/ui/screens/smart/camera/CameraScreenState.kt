package com.sic6.masibelajar.ui.screens.smart.camera

data class CameraScreenState(
    val ipCamera : String = "",
    val points : List<Point> = listOf(
        Point(1, 0, 0),
        Point(2, 0, 0),
        Point(3, 0, 0),
    ),
) {
    val numberOfPoints: Int
        get() = points.size
}

data class Point(
    val id: Int,
    val x: Int,
    val y: Int,
)
