package model.Filters;

import java.awt.*;

import model.AImage;
import model.IImage;
import model.ILayer;
import model.IPixel;

import model.Pixel;

/**
 * Represents a blue filter.
 */
public class RedFilter implements IFilter {
  String name;

  public RedFilter() {
    this.name = "redFilter";
  }
  /**
   * This applies blue filter to Image.
   * @param layer is original image.
   * @return IImage is original image with filter applied.
   */
  public IPixel[][] apply(ILayer layer) {
    IPixel[][] pixels =  layer.getCanvas();
    IPixel[][] newPixels = new IPixel[pixels.length][pixels[0].length];

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        IPixel pixel = pixels[i][j];
        int color = pixel.getRed();
        newPixels[i][j] = new Pixel(color, 0, 0, pixel.getAlpha());
      }
    }
    return newPixels;
  }

  /**
   * Gets the name of the filter.
   * @return string name of the filter.
   */
  public String getName() {
    return this.name;
  }
}