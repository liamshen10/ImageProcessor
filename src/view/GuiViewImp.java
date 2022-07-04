package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import model.image.Histogram;
import model.image.Image;

/**
 * Class GuiViewImp displays the graphical user interface.
 */
public class GuiViewImp extends JFrame implements GuiView {
  private JPanel h;
  private final Map<String, JButton> actionCommandToButton;
  private JLabel editImageLabel;
  private final JPanel editImagePanel;
  private final JButton fileOpenButton;
  private final JButton saveFileButton;

  /**
   * constructor for the view that initializes all the buttons and the window layout.
   */
  public GuiViewImp() {
    super("Image Processing Application");
    setSize(500, 500);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setMinimumSize(new Dimension(500, 500));
    this.setLayout(new FlowLayout());
    this.setPreferredSize(new Dimension(1250, 1000));

    // edit image panel
    editImagePanel = new JPanel();
    editImagePanel.setBorder(BorderFactory.createTitledBorder("Image working on"));
    editImagePanel.setLayout(new FlowLayout());
    this.add(editImagePanel);

    fileOpenButton = new JButton("Load an Image");
    fileOpenButton.setActionCommand("Load Image");
    editImagePanel.add(fileOpenButton);

    saveFileButton = new JButton("Save file");
    saveFileButton.setActionCommand("Save file");
    editImagePanel.add(saveFileButton);

    //image
    editImageLabel = new JLabel();
    JScrollPane imageScrollPane;
    editImageLabel = new JLabel();
    imageScrollPane = new JScrollPane(editImageLabel);
    editImageLabel.setIcon(new ImageIcon(""));
    imageScrollPane.setPreferredSize(new Dimension(400, 400));
    editImagePanel.add(imageScrollPane);

    this.h = new JPanel();
    h.setPreferredSize(new Dimension(400, 400));
    editImagePanel.add(h);

    JPanel commandsPanel = new JPanel();
    commandsPanel.setBorder(BorderFactory.createTitledBorder("Commands"));
    commandsPanel.setLayout(new FlowLayout());
    commandsPanel.setPreferredSize(new Dimension(600, 200));
    this.add(commandsPanel);

    actionCommandToButton = new TreeMap<String, JButton>();
    actionCommandToButton.put("Blur", null);
    actionCommandToButton.put("Brighten", null);
    actionCommandToButton.put("Green Component", null);
    actionCommandToButton.put("Grey Scale", null);
    actionCommandToButton.put("Horizontal Flip", null);
    actionCommandToButton.put("Intensity Component", null);
    actionCommandToButton.put("Luma Component", null);
    actionCommandToButton.put("Red Component", null);
    actionCommandToButton.put("Sepia", null);
    actionCommandToButton.put("Sharpen", null);
    actionCommandToButton.put("Value Component", null);
    actionCommandToButton.put("Vertical Flip", null);
    actionCommandToButton.put("Downscale",null);

    actionCommandToButton.replaceAll((k, v) -> new JButton(k));

    for (Map.Entry<String, JButton> entry : actionCommandToButton.entrySet()) {
      commandsPanel.add(actionCommandToButton.get(entry.getKey()));
      actionCommandToButton.get(entry.getKey()).setActionCommand(entry.getKey());
    }
    this.setVisible(true);
    this.pack();

  }


  @Override
  public void setActionListener(ActionListener listener) {
    fileOpenButton.addActionListener(listener);
    saveFileButton.addActionListener(listener);
    for (Map.Entry<String, JButton> entry : actionCommandToButton.entrySet()) {
      entry.getValue().addActionListener(listener);
    }
  }

  @Override
  public void setEditImage(ImageIcon icon) {
    editImageLabel.setIcon(icon);
  }

  @Override
  public String getUserInputBox(String message) {
    return JOptionPane.showInputDialog(this, message);
  }

  @Override
  public void showPopUp(String message) {
    JOptionPane.showMessageDialog(this, message);
  }

  @Override
  public void setHistogramPanel(Image image) {
    this.editImagePanel.remove(h);

    this.editImagePanel.revalidate();
    this.editImagePanel.repaint();

    h = new Histogram(image);
    Histogram histogram = (Histogram) h;
    histogram.makeHistogram();
    histogram.setPreferredSize(new Dimension(400, 400));
    this.editImagePanel.add(histogram);

    this.editImagePanel.revalidate();
    this.editImagePanel.repaint();
  }
}
