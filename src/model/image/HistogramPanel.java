package model.image;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.BorderFactory;

/**
 * Histogram Panel class makes each component histogram by creating
 * a linked list of the values, and painting it onto the content pane.
 */
public class HistogramPanel extends JPanel {
  private final int height;
  private final int width;
  private final String valueType;
  private final List<Integer> values = new LinkedList<Integer>();

  /**
   * Creates each component histogram panel.
   *
   * @param image     is the image given by user
   * @param width     is the width of the histogram
   * @param height    is the height of the histogram
   * @param valueType is what value is being displayed
   */
  public HistogramPanel(Image image, int width, int height, String valueType) {

    this.width = width;
    this.height = height;
    this.valueType = valueType;

    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {

        switch (valueType) {
          case "intensities":
            values.add(image.getPixel(x, y).getIntensity());
            break;
          case "red":
            values.add(image.getPixel(x, y).getRed());
            break;
          case "green":
            values.add(image.getPixel(x, y).getGreen());
            break;
          case "blue":
            values.add(image.getPixel(x, y).getBlue());
            break;
          default:
            //Will never reach this default case
            throw new IllegalArgumentException("None of the values");
        }
      }
    }
    setBorder(BorderFactory.createLineBorder(Color.black));
  }

  /**
   * Paints the list components onto the histogram.
   *
   * @param g the <code>Graphics</code> object that is painted onto the histogram
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    double minValue = 0;
    double maxValue = 255;
    int numbBins = 1 + (int) (3.322 * Math.log(this.values.size()));
    int intensityRange = (int) (maxValue - minValue);
    double valueWidthRatio = ((double) this.width / (double) intensityRange) * 0.85;
    double binSize = (maxValue - minValue) / (double) numbBins;

    if (binSize < 1) {
      binSize = 1;
      numbBins = (int) ((maxValue - minValue) / binSize);
    }

    if (maxValue - minValue == 0 && this.values.size() > 1) {
      numbBins = 1;
    }

    int[] bins = new int[numbBins];

    for (int value : this.values) {
      int bin = (int) ((value - minValue) / binSize);

      if (bin == 0) {
        bin = 1;
      }
      bins[bin - 1] = bins[bin - 1] + 1;
    }

    int spacing = 25;
    int baseline = this.height - spacing;

    int maxFrequency = 0;
    for (int bin : bins) {
      if (maxFrequency <= bin) {
        maxFrequency = bin;
      }
    }

    double frequencyUnit = ((double) (this.height - 2 * spacing) / maxFrequency);

    switch (this.valueType) {
      case "intensities":
        g.drawString("Intensities", this.width / 2, 20);
        g.setColor(Color.GRAY);
        break;
      case "red":
        g.drawString("Red", this.width / 2, 20);
        g.setColor(Color.RED);
        break;
      case "green":
        g.drawString("Green", this.width / 2, 20);
        g.setColor(Color.GREEN);
        break;
      case "blue":
        g.drawString("Blue", this.width / 2, 20);
        g.setColor(Color.BLUE);
        break;
      default:
        //Will never reach this default case
        throw new IllegalArgumentException("None of the values");
    }

    Font font = new Font("Dialog", Font.PLAIN, 7);
    int cushion = 10;

    g.setFont(font);
    g.drawString("0", cushion, this.height - spacing - 1);
    g.drawString("" + maxFrequency, cushion / 2, spacing);
    g.drawLine(cushion + 5, baseline - 1, cushion + 5, cushion);

    g.drawString("0", cushion + 4, baseline + 7);
    g.drawString("" + (int) maxValue / 5, cushion + (this.width - spacing) / 5,
            baseline + 7);
    g.drawString("" + (int) (maxValue * 2) / 5, cushion + ((this.width - spacing) * 2) / 5,
            baseline + 7);
    g.drawString("" + (int) (maxValue * 3) / 5, cushion + ((this.width - spacing) * 3) / 5,
            baseline + 7);
    g.drawString("" + (int) (maxValue * 4) / 5, cushion + ((this.width - spacing) * 4) / 5,
            baseline + 7);
    g.drawString("" + (int) maxValue, this.width - spacing, baseline + 7);
    g.drawString("Range of Values", this.width / 2 - 25, baseline + cushion + 5);
    g.drawLine(cushion, baseline, this.width - cushion, baseline);

    AffineTransform affineTransform = new AffineTransform();
    affineTransform.rotate(Math.toRadians(270), 0, 0);
    Font rotatedFont = font.deriveFont(affineTransform);
    g.setFont(rotatedFont);
    g.drawString("Number of Occurrences", cushion, this.height / 2 + 25);

    for (int i = 0; i < bins.length; i++) {
      int binWidth;

      int x_left = (int) (i * binSize * valueWidthRatio) + cushion + 5;
      int x_right = (int) (i * binSize * valueWidthRatio) + cushion + 5 +
              (int) (binSize * valueWidthRatio);
      int next_x_left = (int) ((i + 1) * binSize * valueWidthRatio) + cushion + 5;

      if ((next_x_left - x_right) > 0 &&
              (i != bins.length - 1)) {
        binWidth = next_x_left - x_left;
      } else {
        binWidth = (int) (binSize * valueWidthRatio);
      }

      g.fillRect(x_left,
              baseline - (int) (bins[i] * frequencyUnit),
              binWidth,
              (int) (bins[i] * frequencyUnit));
    }
  }
}
