package de.moritzf.sorting.gui.windows;

import java.awt.*;

import javax.swing.*;

import de.moritzf.sorting.gui.components.DragScrollListener;
import de.moritzf.sorting.gui.util.WindowUtil;

/**
 * This class serves as a template for the graphical representation of any algorithm that can be
 * divided into steps in a gui frame. From here all important actions concerning the sorting
 * algorithm can be performed and displayed.
 *
 * @author Moritz Floeter
 */
public abstract class AbstractSortingWindowSubstructure extends JFrame {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1218755388476653348L;

  /** The protocol pnl. */
  private JPanel protocolPnl = new JPanel(new BorderLayout());

  /** The scroll. */
  private JScrollPane scroll;

  /** The drag scroll. */
  protected DragScrollListener dragScrollListener;

  /** The next step. */
  protected JButton nextStepBtn = new JButton("<html> &nbsp; <br>Next Step<br> &nbsp; </html>");

  /** The undo step. */
  protected JButton undoStepBtn = new JButton("<html>  &nbsp; <br>Undo Step<br> &nbsp; </html>");

  /** The all steps. */
  protected JButton allStepsBtn =
      new JButton("<html>  &nbsp; <br>Execute all steps <br> &nbsp; </html>");

  /** The export btn. */
  protected JButton exportBtn = new JButton("<html> &nbsp; <br>Export (LaTeX) <br> &nbsp; </html>");

  /** The info btn. */
  protected JButton infoBtn =
      new JButton("<html> &nbsp; <br>Additional Information<br> &nbsp; </html>");

  /** The reset button. */
  protected JButton reset = new JButton("<html>&nbsp; <br>Reset to Start<br> &nbsp;</html>");

  /**
   * Instantiates a new sorting window.
   *
   * @param parent the parent
   */
  public AbstractSortingWindowSubstructure(JFrame parent) {
    super("Sorting Algorithm");
    JPanel mainpanel = new JPanel();
    this.getContentPane().add(mainpanel);
    mainpanel.setLayout(new BorderLayout());

    // Create layout for the right side of the window
    JPanel right = new JPanel();
    mainpanel.add(right, BorderLayout.EAST);
    right.setLayout(new BorderLayout());
    Box righttop = Box.createVerticalBox();

    // adding buttons
    righttop.add(nextStepBtn);
    righttop.add(undoStepBtn);
    righttop.add(allStepsBtn);
    righttop.add(reset);

    right.add(righttop, BorderLayout.NORTH);
    Box rightbottom = Box.createVerticalBox();

    rightbottom.add(infoBtn);
    rightbottom.add(exportBtn);
    right.add(rightbottom, BorderLayout.SOUTH);

    protocolPnl.setBackground(Color.white);
    protocolPnl.addMouseListener(this.dragScrollListener);

    // Creating the main area of the window where the protocol is shown
    scroll = new JScrollPane(protocolPnl);
    this.dragScrollListener = new DragScrollListener(protocolPnl);
    scroll.getVerticalScrollBar().setUnitIncrement(25);
    scroll.getHorizontalScrollBar().setUnitIncrement(25);
    mainpanel.add(scroll, BorderLayout.CENTER);

    // setting default window parameters
    this.setMinimumSize(new Dimension(600, 450));
    this.setLocationRelativeTo(parent);
    this.setVisible(true);
    setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    WindowUtil.enableOSXFullscreen(this);
  }

  /** @param comp the protocol component */
  protected void setProtocolComponent(JComponent comp) {
    this.protocolPnl.removeAll();
    this.protocolPnl.add(comp, BorderLayout.WEST);
    comp.addMouseListener(this.dragScrollListener);
    this.validate();
    this.repaint();
  }

  /** Scroll2 bottom. */
  protected void scrollToBottom() {
    JScrollBar vertical = scroll.getVerticalScrollBar();
    vertical.setValue(vertical.getMaximum());
  }

  /** Scroll2 bottom. */
  protected void scrollToTop() {
    JScrollBar vertical = scroll.getVerticalScrollBar();
    vertical.setValue(vertical.getMinimum());
  }
}
