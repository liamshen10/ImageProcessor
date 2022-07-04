package model.image;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Histogram class that extends JPanel that takes in an Image and the intensity and RGB
 * histogram panels, and displaying all 4 histograms in one individual histogram panel.
 */
public class Histogram extends JPanel {

  protected final Image image;
  private final int width;
  private final int height;
  private final HistogramPanel hPanelIntensity;
  private final HistogramPanel hPanelRed;
  private final HistogramPanel hPanelGreen;
  private final HistogramPanel hPanelBlue;

  /**
   * Constructs the Histogram based on the image.
   *
   * @param image is the user given image
   */
  public Histogram(Image image) {

    this.width = 400;

    this.height = 400;

    this.image = image;

    hPanelIntensity = new HistogramPanel(image, this.width / 2, this.height / 2,
            "intensities");
    hPanelRed = new HistogramPanel(image, this.width / 2, this.height / 2,
            "red");
    hPanelGreen = new HistogramPanel(image, this.width / 2, this.height / 2,
            "green");
    hPanelBlue = new HistogramPanel(image, this.width / 2, this.height / 2,
            "blue");

  }

  /**
   * Makes the histogram in a grid with the 4 given individual component histograms.
   */
  public void makeHistogram() {
    this.setLayout(new GridLayout(2, 2));
    this.add(this.hPanelIntensity);
    this.add(this.hPanelRed);
    this.add(this.hPanelGreen);
    this.add(this.hPanelBlue);

    this.setSize(this.width, this.height);
    this.setVisible(true);
  }
}