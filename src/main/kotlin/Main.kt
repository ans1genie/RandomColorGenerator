import kotlin.random.Random

fun generateRandomColorHex(existingColors: List<String>, minDistance: Int): String {
    var color: String
    do {
        color = generateRandomColorHex()
    } while (!isFarEnough(color, existingColors, minDistance))
    return color
}

fun isFarEnough(color: String, existingColors: List<String>, minDistance: Int): Boolean {
    for (existingColor in existingColors) {
        if (calculateColorDistance(color, existingColor) < minDistance) {
            return false
        }
    }
    return true
}

fun generateRandomColors(existingColors: List<String>, numColors: Int, minDistance: Int): List<String> {
    val colors = existingColors.toMutableList()
    while (colors.size < numColors) {
        colors.add(generateRandomColorHex(colors, minDistance))
    }
    return colors
}

fun generateRandomColorHex(): String {
    val r = Random.nextInt(256)
    val g = Random.nextInt(256)
    val b = Random.nextInt(256)
    return rgbToHex(r, g, b)
}

fun rgbToHex(r: Int, g: Int, b: Int): String {
    return String.format("#%02X%02X%02X", r, g, b)
}

fun calculateColorDistance(color1: String, color2: String): Int {
    val rgb1 = hexToRgb(color1)
    val rgb2 = hexToRgb(color2)
    return Math.abs(rgb1[0] - rgb2[0]) + Math.abs(rgb1[1] - rgb2[1]) + Math.abs(rgb1[2] - rgb2[2])
}

fun hexToRgb(hex: String): List<Int> {
    return listOf(
        Integer.parseInt(hex.substring(1, 3), 16),
        Integer.parseInt(hex.substring(3, 5), 16),
        Integer.parseInt(hex.substring(5, 7), 16)
    )
}

fun areColorsDistant(colors: List<String>, minDistance: Int): Boolean {
    for (i in 0 until colors.size - 1) {
        for (j in i + 1 until colors.size) {
            if (calculateColorDistance(colors[i], colors[j]) < minDistance) {
                return false
            }
        }
    }
    return true
}

fun main() {
    val existingColors = listOf(
        "#00FF00"
        , "#FF0000"
    )

    val minDistance = 100
    val numSquares = 34

    val randomColors = generateRandomColors(existingColors, numSquares, minDistance)

    randomColors.forEachIndexed { index, color ->
        println("Square ${index + 1}: Hex: $color")
    }


    //println("areColorsDistant: ${areColorsDistant(existingColors,minDistance)}")
    //println("isFarEnough: ${isFarEnough("#CD7E29",existingColors,minDistance)}")
}
