package Filters;

import java.awt.*;

import model.IImage;
import model.IPixel;

import model.Pixel;

/**
 * Represents a blue filter.
 */
public class BlueFilter implements IFilter {
  int blue;

  /**
   * Represents constructor for BlueFilter.
   * @param blue is the int value of the blue component.
   */
  public BlueFilter(int blue) {
    this.blue = blue;
  }

  /**
   * This applies blue filter to Image.
   * @param image is original image.
   * @return IImage is original image with filter applied.
   */
  public IImage apply(IImage image) {
    IPixel[][] pixels =  image.getPixels();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color = pixel.getGreen();
        newPixels[i][j] = new Pixel(0, color, 0, pixel.getAlpha());
      }
    }
    return new Image(newPixels, image.getHeight, image.getWidth);
  }
}
