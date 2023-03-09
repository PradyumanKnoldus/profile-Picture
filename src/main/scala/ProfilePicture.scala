import scala.io.StdIn.readLine

object ProfilePicture {

  def readMinimunDimension(): Int = {
    try {
      val dimension = readLine("Enter the minimum dimension of the picture: ").toInt
      if (dimension <= 0) {
        throw new IllegalArgumentException("Length can't be negative or zero!")
      }
      dimension
    } catch {
      case _: NumberFormatException => throw new IllegalArgumentException("Invalid input!")
    }
  }

  def readPhotoDimensions(): (Int, Int) = {
    try {
      val width = readLine("Enter the width of the picture: ").toInt
      val height = readLine("Enter the height of the picture: ").toInt
      if (width <= 0 || height <= 0) {
        throw new IllegalArgumentException("Length can't be negative or zero!")
      }
      (width, height)


    } catch {
      case _: NumberFormatException => throw new IllegalArgumentException("Invalid input!")
    }
  }

  def checkPhoto(minimumDimension: Int, width: Int, height: Int): String = {
    if (width < minimumDimension || height < minimumDimension) {
      "UPLOAD ANOTHER"
    } else if (width == height && height == minimumDimension) {
      "ACCEPTED"
    } else {
      "CROP IT"
    }
  }

  def main(args: Array[String]): Unit = {
    try {
      val minimumDimension = readMinimunDimension()
      val (width, height) = readPhotoDimensions()

      val result = checkPhoto(minimumDimension, width, height)
      println(result)
    } catch {
      case e: IllegalArgumentException => println(e.getMessage)
    }
  }
}
