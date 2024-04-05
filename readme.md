# Random Color Generator

This Kotlin project generates random colors with a minimum distance constraint. It provides functions to generate random colors as hex strings, calculate the distance between colors, and ensure that generated colors maintain a minimum distance from each other and from an existing list of colors.

## Usage

To use this project, you can directly copy the provided code into your Kotlin project or use it as a standalone module. The main functions are:

- `generateRandomColorHex()`: Generates a random color as a hex string.
- `calculateColorDistance()`: Calculates the distance between two colors in RGB space.
- `generateRandomColors()`: Generates random colors while ensuring a minimum distance between them.

You can customize the number of random colors to generate, the minimum distance between colors, and provide an existing list of colors to maintain distance constraints.

## Example

```kotlin
val existingColors = listOf("#ED8CF5", "#56C22E", "#76023D", "#5A0AAE", "#CE9753")
val numColors = 10
val minDistance = 200

val randomColors = generateRandomColors(existingColors, numColors, minDistance)

randomColors.forEachIndexed { index, color ->
    println("Square ${index + 1}: Hex: $color")
}
