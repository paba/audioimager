package imager;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;




/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField txtImageLink;
	private JLabel imgLabel;
	private JButton btnBrowse;
	private JSlider slider;
	private JTable tblImage;
	private JScrollPane jScrollPane2;
	private JPanel jPanel1;
	private JButton btnStop;
	private JButton btnPlay;
	private JButton btnAdd;
	private JLabel lblCaption;
	private JTable tblCaption;
	private JLabel caption;
	private JScrollPane scrollCaption;
	private JButton btnCaption;
	private JTextField txtCaption;
	private JButton btnFlickrSearch;
	private JTextField txtFlickr;
	private JScrollPane flickrScroll;
	private JTabbedPane jTabbedPane1;
	private JButton btnZoomOut;
	private JButton btnZoomIn;
	private JMenuItem movItem;
	private JMenuItem aviItem;
	private JMenu expVideoMenu;
	private JSeparator jSeparator1;
	private JMenuItem newProjItem;
	private JMenuItem saveProjMenu;
	private JMenuItem projOpenMenu;
	private JMenu helpMenu;
	private JMenu jMenu1;
	private JMenuBar jMenuBar;
	private JButton btnPlus;
	private JButton btnSplit;
	private JButton jButton1;
	private JTextField txtCaptionEdit;
	private JLabel jLabel8;
	private JSpinner spinnerCaptionEndTime;
	private JSpinner spinnerCaptionStartTime;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JSpinner spinnerEndTime;
	private JSpinner spinnerStartTime;
	private JScrollPane scrollSlider;
	private JButton btnAudioBrowse;
	private JTextField txtAudio;
	private JLabel jLabel3;
	private JLabel jLabel2;

	private ArrayList<ImageData> imageArray;
	private ArrayList<CaptionData> captionArray;
	private int startTime;
	private int endTime;
	private String path;
	private String audioPath;
	private int sliderPosition ;
	private int cellWidth;
	private int tableWidth;
	private float spacing;
	private TableModel tblImageModel;
	private ImageData selectedImage;
	float tickWeight;
	int audioDuration;
	int noOfAudioSamples;
	boolean columnMoved;
	//boolean captionPropertyChanged;
	int columnMovedPosition;
	int columnMovedFromPosition;
	int selectedCaption;
	int gapFiller;
	int zoomingFactor;
	int minimumZoomingFactor;
	DecodeAndPlayAudio audioDecoder;
	Thread audioPlayerThread;
	int sliderWidth;
	
	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
		initVariables();
	
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, new AnchorConstraint(17, 593, 537, 22, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTabbedPane1.setPreferredSize(new java.awt.Dimension(505, 375));
				JPanel flickrPannel = new JPanel();
				AnchorLayout flickrPannelLayout = new AnchorLayout();
				flickrPannel.setLayout(flickrPannelLayout);
				jTabbedPane1.addTab("Images from Flickr", flickrPannel);
				{
					btnFlickrSearch = new JButton();
					flickrPannel.add(btnFlickrSearch, new AnchorConstraint(27, 975, 93, 799, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnFlickrSearch.setText("Search");
					btnFlickrSearch.setPreferredSize(new java.awt.Dimension(88, 23));
				}
				{
					txtFlickr = new JTextField();
					flickrPannel.add(txtFlickr, new AnchorConstraint(30, 789, 84, 349, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					txtFlickr.setPreferredSize(new java.awt.Dimension(220, 19));
				}
				{
					flickrScroll = new JScrollPane();
					flickrPannel.add(flickrScroll, new AnchorConstraint(116, 977, 967, 25, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					flickrScroll.setPreferredSize(new java.awt.Dimension(476, 297));
				}
				JPanel diskPannel = new JPanel();
				jTabbedPane1.addTab("Add From Your Disk", diskPannel);

			}
			{
				btnZoomOut = new JButton();
				getContentPane().add(btnZoomOut, new AnchorConstraint(580, 71, 609, 41, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnZoomOut.setText("-");
				btnZoomOut.setPreferredSize(new java.awt.Dimension(27, 21));
				btnZoomOut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnZoomOutActionPerformed(evt);
					}
				});
			}
			{
				btnZoomIn = new JButton();
				getContentPane().add(btnZoomIn, new AnchorConstraint(580, 36, 609, 8, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnZoomIn.setText("+");
				btnZoomIn.setPreferredSize(new java.awt.Dimension(25, 21));
				btnZoomIn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnZoomInActionPerformed(evt);
					}
				});
			}
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					jMenu1 = new JMenu();
					jMenuBar.add(jMenu1);
					jMenu1.setText("File");
					{
						newProjItem = new JMenuItem();
						jMenu1.add(newProjItem);
						newProjItem.setText("New Project");
					}
					{
						projOpenMenu = new JMenuItem();
						jMenu1.add(projOpenMenu);
						projOpenMenu.setText("Open Project");
					}
					{
						saveProjMenu = new JMenuItem();
						jMenu1.add(saveProjMenu);
						saveProjMenu.setText("Save Project");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu1.add(jSeparator1);
					}
					{
						expVideoMenu = new JMenu();
						jMenu1.add(expVideoMenu);
						expVideoMenu.setText("Export Video");
						{
							movItem = new JMenuItem();
							expVideoMenu.add(movItem);
							movItem.setText("MOV");
							movItem.addPropertyChangeListener(new PropertyChangeListener() {
								public void propertyChange(PropertyChangeEvent evt) {
									movItemPropertyChange(evt);
								}
							});
							movItem.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									movItemActionPerformed(evt);
								}
							});
						}
						{
							aviItem = new JMenuItem();
							expVideoMenu.add(aviItem);
							aviItem.setText("AVI");
							aviItem.addPropertyChangeListener(new PropertyChangeListener() {
								public void propertyChange(PropertyChangeEvent evt) {
									aviItemPropertyChange(evt);
								}
							});
							aviItem.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									aviItemActionPerformed(evt);
								}
							});
						}
					}
				}
				{
					helpMenu = new JMenu();
					jMenuBar.add(helpMenu);
					helpMenu.setText("Help");
				}
			}
			{
				btnPlus = new JButton();
				getContentPane().add(btnPlus, new AnchorConstraint(898, 130, 921, 86, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnPlus.setText("[+]");
				btnPlus.setPreferredSize(new java.awt.Dimension(39, 17));
				btnPlus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnPlusActionPerformed(evt);
					}
				});
			}
			{
				btnSplit = new JButton();
				getContentPane().add(btnSplit, new AnchorConstraint(898, 180, 921, 136, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnSplit.setText("]|[");
				btnSplit.setPreferredSize(new java.awt.Dimension(39, 17));
				btnSplit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSplitActionPerformed(evt);
					}
				});
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, new AnchorConstraint(900, 981, 925, 862, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton1.setText("Change Caption");
				jButton1.setPreferredSize(new java.awt.Dimension(105, 18));
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				txtCaptionEdit = new JTextField();
				getContentPane().add(txtCaptionEdit, new AnchorConstraint(898, 554, 927, 281, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtCaptionEdit.setPreferredSize(new java.awt.Dimension(242, 21));
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8, new AnchorConstraint(903, 284, 921, 191, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel8.setText(" Selected Text");
				jLabel8.setPreferredSize(new java.awt.Dimension(82, 13));
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7, new AnchorConstraint(899, 805, 921, 720, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel7.setText("End Time");
				jLabel7.setPreferredSize(new java.awt.Dimension(76, 16));
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6, new AnchorConstraint(899, 646, 923, 568, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel6.setText("Start Time");
				jLabel6.setPreferredSize(new java.awt.Dimension(69, 17));
			}
			{
				lblCaption = new JLabel();
				getContentPane().add(lblCaption, new AnchorConstraint(342, 986, 370, 625, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				lblCaption.setPreferredSize(new java.awt.Dimension(320, 21));
				lblCaption.setOpaque(true);
				lblCaption.setBackground(new java.awt.Color(0,0,0));
				lblCaption.setForeground(new java.awt.Color(255,255,255));
				lblCaption.setLabelFor(lblCaption);
			}
			{
				caption = new JLabel();
				getContentPane().add(caption, new AnchorConstraint(832, 67, 850, 6, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				caption.setText("Caption");
				caption.setPreferredSize(new java.awt.Dimension(54, 13));
			}
			{
				btnCaption = new JButton();
				getContentPane().add(btnCaption, new AnchorConstraint(813, 82, 842, 57, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnCaption.setText("+");
				btnCaption.setPreferredSize(new java.awt.Dimension(22, 21));
				btnCaption.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCaptionActionPerformed(evt);
					}
				});
			}
			{
				txtCaption = new JTextField();
				getContentPane().add(txtCaption, new AnchorConstraint(580, 870, 608, 817, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtCaption.setPreferredSize(new java.awt.Dimension(47, 20));
				txtCaption.setVisible(false);
				txtCaption.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						txtCaptionPropertyChange(evt);
					}
				});
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5, new AnchorConstraint(744, 78, 767, 8, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel5.setText("Images");
				jLabel5.setPreferredSize(new java.awt.Dimension(62, 17));
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4, new AnchorConstraint(651, 68, 673, 8, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel4.setText("Audio");
				jLabel4.setPreferredSize(new java.awt.Dimension(53, 16));
			}
			{
				/*SpinnerListModel spinnerStartTimeModel = 
					new SpinnerListModel(
							new String[] { "Sun", "Mon" , "Tue" , "Wed" , "Thu" , "Fri" , "Sat" });*/
				Number value = 0;
				Number stetpsize =1;
				
				SpinnerNumberModel spinnerStartTimeModel = new SpinnerNumberModel(value,0,null,stetpsize); 
				spinnerStartTime = new JSpinner();
				getContentPane().add(spinnerStartTime, new AnchorConstraint(401, 815, 425, 706, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				spinnerStartTime.setModel(spinnerStartTimeModel);
				spinnerStartTime.setPreferredSize(new java.awt.Dimension(96, 18));
				spinnerStartTime.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						spinnerStartTimeStateChanged(evt);
					}
				});
			}
			{
				btnAudioBrowse = new JButton();
				getContentPane().add(btnAudioBrowse, new AnchorConstraint(637, 82, 667, 57, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnAudioBrowse.setText("+");
				btnAudioBrowse.setPreferredSize(new java.awt.Dimension(22, 22));
				btnAudioBrowse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAudioBrowseActionPerformed(evt);
					}
				});
			}
			{
				txtAudio = new JTextField();
				getContentPane().add(txtAudio, new AnchorConstraint(580, 296, 608, 263, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtAudio.setPreferredSize(new java.awt.Dimension(30, 20));
				txtAudio.setVisible(false);
				txtAudio.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						txtAudioPropertyChange(evt);
					}
				});
			}
			{
				btnStop = new JButton();
				getContentPane().add(btnStop, new AnchorConstraint(580, 251, 609, 194, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnStop.setText("Stop");
				btnStop.setPreferredSize(new java.awt.Dimension(51, 21));
				btnStop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnStopActionPerformed(evt);
					}
				});
			}
			{
				btnPlay = new JButton();
				getContentPane().add(btnPlay, new AnchorConstraint(580, 188, 610, 83, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnPlay.setText("Play");
				btnPlay.setPreferredSize(new java.awt.Dimension(93, 22));
				btnPlay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnPlayActionPerformed(evt);
					}
				});
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3, new AnchorConstraint(452, 681, 476, 625, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel3.setText("End Time");
				jLabel3.setPreferredSize(new java.awt.Dimension(50, 18));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2, new AnchorConstraint(401, 696, 426, 625, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("Start Time");
				jLabel2.setPreferredSize(new java.awt.Dimension(63, 19));
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd, new AnchorConstraint(444, 981, 476, 870, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnAdd.setText("Add Image");
				btnAdd.setPreferredSize(new java.awt.Dimension(98, 24));
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, new AnchorConstraint(637, 981, 888, 86, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1Layout.rowWeights = new double[] {0.0, 0.1, 0.0};
				jPanel1Layout.rowHeights = new int[] {50, 7, 50};
				jPanel1Layout.columnWeights = new double[] {0.0, 0.1};
				jPanel1Layout.columnWidths = new int[] {9, 7};
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(791, 187));
				jPanel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				{
					scrollSlider = new JScrollPane();
					//scrollSlider.getHorizontalScrollBar().setVisible(false);
					//scrollSlider.getHorizontalScrollBar().setAutoscrolls(false);
					scrollSlider.remove(scrollSlider.getHorizontalScrollBar());
					//jPanel1.add(scrollSlider, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel1.add(scrollSlider, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					scrollSlider.setPreferredSize(new java.awt.Dimension(1119, 101));
					scrollSlider.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					{
						slider = new JSlider();
						scrollSlider.setViewportView(slider);
						slider.setMinorTickSpacing(1);
						slider.setMajorTickSpacing(5);
						slider.setPaintTicks(true);
						slider.setSnapToTicks(true);
						slider.setPaintTrack(false);
						slider.setPaintLabels(true);
						
						slider.setValue(0);
						slider.setMaximum(400);
						
						//getContentPane().add(slider, BorderLayout.CENTER);
						slider.setPreferredSize(new java.awt.Dimension(3006, 48));
						slider.addChangeListener(new ChangeListener() {
							public void stateChanged(ChangeEvent evt) {
								sliderStateChanged(evt);
							}
						});
						slider.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent evt) {
								sliderMousePressed(evt);
							}
							public void mouseReleased(MouseEvent evt) {
								sliderMouseReleased(evt);
							}
						});
						
					}
					
				}
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jScrollPane2.setPreferredSize(new java.awt.Dimension(1136, 101));
					jScrollPane2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					jScrollPane2.remove(jScrollPane2.getVerticalScrollBar());
					jScrollPane2.remove(jScrollPane2.getHorizontalScrollBar());
					jScrollPane2.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						public void adjustmentValueChanged(AdjustmentEvent evt) {
							horizontalScrollBarAdjustmentValueChanged(evt);
						}
					});
					
				
					
					{
						
						/*TableModel tblImageModel = 
							new DefaultTableModel(
									new String[][] { { "" }},
									new String[] { ""}); */
									
									tblImageModel = new ImageTableModel();
									//((DefaultTableModel) tblImageModel).setColumnCount(1);
									
									
									tblImage = new JTable();
									tblImage.setModel(tblImageModel);
									
									CardLayout tblImageLayout = new CardLayout();
									tblImageLayout.setHgap(400);
									tblImage.setLayout(tblImageLayout);
									tblImage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
									//tblImage.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
								
									jScrollPane2.setViewportView(tblImage);
									
									tblImage.setAutoscrolls(false);
									tblImage.setCellSelectionEnabled(true);
									tblImage.setRowHeight(92);

									tblImage.setShowVerticalLines(true);
									tblImage.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
									tblImage.setFillsViewportHeight(true);
									tblImage.setDragEnabled(true);
									tblImage.setColumnSelectionAllowed(true);
									tblImage.getTableHeader().setReorderingAllowed(false);
									tblImage.getTableHeader().setSize(780, 0);
									tblImage.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 7));
									tblImage.getTableHeader().setForeground(new java.awt.Color(0,0,0));
									tblImage.getTableHeader().addMouseListener(new MouseAdapter() {
										public void mouseReleased(MouseEvent evt) {
											tableHeaderMouseReleased(evt);
										}
									});

									tblImage.addKeyListener(new KeyAdapter() {
										public void keyTyped(KeyEvent evt) {
											tblImageKeyTyped(evt);
										}
									});
									//tblImage.setPreferredSize(new java.awt.Dimension(64, 80));
									//tblImage.setPreferredSize(new java.awt.Dimension(60, 80));
									tblImage.getColumnModel().addColumnModelListener(new TableColumnModelListener(){

										@Override
										public void columnAdded(
												TableColumnModelEvent e) {																		
										}

										@Override
										public void columnMarginChanged(
												ChangeEvent e) {
										}

										@Override
										public void columnMoved(
												TableColumnModelEvent e) {
											if(columnMoved == false)
											{
												columnMovedFromPosition = e.getFromIndex();
											}
											columnMoved = true;
											columnMovedPosition = e.getToIndex();
											
											
											
										}

										@Override
										public void columnRemoved(
												TableColumnModelEvent e) {
										}

										@Override
										public void columnSelectionChanged(
												ListSelectionEvent e) {
											
										}
										
									});
									tblImage.addComponentListener(new ComponentAdapter() {
										public void componentResized(ComponentEvent evt) {
											tblImageComponentResized(evt);
										}
									});
									//tblImage.setPreferredSize(new java.awt.Dimension(56, 98));
									tblImage.addPropertyChangeListener(new PropertyChangeListener() {
										public void propertyChange(PropertyChangeEvent evt) {
											tblImagePropertyChange(evt);
										}
									});
									//tblImage.setPreferredSize(new java.awt.Dimension(54, 54));
									//tblImage.setPreferredSize(new java.awt.Dimension(91, 98));
									tblImage.addMouseListener(new MouseAdapter() {
										
										public void mouseReleased(MouseEvent evt) {
											tblImageMouseReleased(evt);
										}
									});
									tblImage.addFocusListener(new FocusAdapter() {
										public void focusGained(FocusEvent evt) {
											tblImageFocusGained(evt);
										}
									});
									

					}
				}
				{
					scrollCaption = new JScrollPane();
					jPanel1.add(scrollCaption, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					
					tblCaption = new JTable();
					scrollCaption.setViewportView(tblCaption);
					//scrollCaption.setSize(1119,30);
					//scrollCaption.setPreferredSize(new java.awt.Dimension(789, 40));
					scrollCaption.setMaximumSize(new java.awt.Dimension(789, 40));
					scrollCaption.setPreferredSize(new java.awt.Dimension(789, 52));
					scrollCaption.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					scrollCaption.remove(scrollCaption.getVerticalScrollBar());
					scrollCaption.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						public void adjustmentValueChanged(AdjustmentEvent evt) {
							horizontalScrollBarAdjustmentValueChanged(evt);
						}
					});
					//tblCaption.setModel(tblCaptionModel);
					tblCaption.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					tblCaption.setRowHeight(30);
					tblCaption.getTableHeader().setReorderingAllowed(false);
					tblCaption.setCellSelectionEnabled(true);
					tblCaption.addMouseListener(new MouseAdapter() {
						
						public void mouseReleased(MouseEvent evt) {
							tblCaptionMouseReleased(evt);
						}
					});
					tblCaption.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent evt) {
							tblCaptionKeyTyped(evt);
						}
					});
					tblCaption.addPropertyChangeListener(new PropertyChangeListener() {
						public void propertyChange(PropertyChangeEvent evt) {
							tblCaptionPropertyChange(evt);
						}
					});
					tblCaption.addComponentListener(new ComponentAdapter() {
						public void componentResized(ComponentEvent evt) {
							tblCaptionComponentResized(evt);
						}
					});
					
				}
			}
			{
				imgLabel = new JLabel();
				getContentPane().add(imgLabel, new AnchorConstraint(19, 986, 342, 625, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				imgLabel.setPreferredSize(new java.awt.Dimension(320, 241));
				imgLabel.setBackground(new java.awt.Color(0,0,0));
				imgLabel.setForeground(new java.awt.Color(128,0,255));
				imgLabel.setOpaque(true);
				imgLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			}
			{
				txtImageLink = new JTextField();
				getContentPane().add(txtImageLink, new AnchorConstraint(580, 620, 608, 585, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtImageLink.setText("");
				txtImageLink.setPreferredSize(new java.awt.Dimension(31, 20));
				txtImageLink.setVisible(false);
				txtImageLink.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						txtImageLinkPropertyChange(evt);
					}
				});

			}
			{
				btnBrowse = new JButton();
				getContentPane().add(btnBrowse, new AnchorConstraint(708, 82, 737, 57, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnBrowse.setText("+");
				btnBrowse.setPreferredSize(new java.awt.Dimension(22, 21));
				btnBrowse.setMinimumSize(new java.awt.Dimension(75, 56));
				btnBrowse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBrowseActionPerformed(evt);
					}
				});
			}
			
			{
				Number value = 0;
				Number stetpsize =1;
				
				SpinnerNumberModel spinnerEndTimeModel = new SpinnerNumberModel(value,0,null,stetpsize);
				
				spinnerEndTime = new JSpinner();
				getContentPane().add(spinnerEndTime, new AnchorConstraint(452, 815, 476, 706, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				spinnerEndTime.setModel(spinnerEndTimeModel);
				spinnerEndTime.setValue(value);
				spinnerEndTime.setPreferredSize(new java.awt.Dimension(96, 18));
				spinnerEndTime.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						spinnerEndTimeStateChanged(evt);
					}
				});
			}
			{
				Number value = 0;
				Number stetpsize =1;
				SpinnerNumberModel spinnerCaptinEndTimeModel = new SpinnerNumberModel(value,0,null,stetpsize);
				spinnerCaptionStartTime = new JSpinner();
				getContentPane().add(spinnerCaptionStartTime, new AnchorConstraint(896, 706, 924, 628, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				spinnerCaptionStartTime.setModel(spinnerCaptinEndTimeModel);
				//spinnerCaptionStartTime.setValue(0);
				spinnerCaptionStartTime.setPreferredSize(new java.awt.Dimension(69, 20));
				spinnerCaptionStartTime.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						spinnerCaptionStartTimeStateChanged(evt);
					}
				});
			}
			{
				Number value = 0;
				Number stetpsize =1;
				SpinnerNumberModel spinnerCaptinStartTimeModel = new SpinnerNumberModel(value,0,null,stetpsize);
				spinnerCaptionEndTime = new JSpinner();
				getContentPane().add(spinnerCaptionEndTime, new AnchorConstraint(896, 853, 924, 773, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				spinnerCaptionEndTime.setModel(spinnerCaptinStartTimeModel);
				//spinnerCaptionEndTime.setValue(0);
				spinnerCaptionEndTime.setPreferredSize(new java.awt.Dimension(71, 20));
				spinnerCaptionEndTime.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						spinnerCaptionEndTimeStateChanged(evt);
					}
				});
			}
			pack();
			this.setSize(892, 780);
			Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
			Dimension screenDimension = toolkit.getScreenSize(); 
			
			//this.setSize((int) screenDimension.getWidth(), (int) screenDimension.getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initVariables()
	{
		imageArray = new ArrayList<ImageData>();
		captionArray = new ArrayList<CaptionData>();
		startTime = 0;
		endTime = 0;
		path = null;
		audioPath = null;
		sliderPosition = 0;
		cellWidth = 0 ;
		tableWidth = 0 ;
		spacing = 0 ;
		tickWeight = (float) 0.0 ;
		audioDuration = 0 ;
		noOfAudioSamples = 0 ;
		audioDecoder= null;
		audioPlayerThread = null;
		columnMoved = false;
		selectedCaption = -1;
		gapFiller = 0;
		zoomingFactor = 1 ;
		minimumZoomingFactor = 1 ;
		sliderWidth = 3006;
		
		//captionPropertyChanged = true;
		
	}
	
	private void btnBrowseActionPerformed(ActionEvent evt) {
		System.out.println("btnBrowse.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(txtImageLink);
		
	}
	
	private void txtImageLinkPropertyChange(PropertyChangeEvent evt) {
		
		path =txtImageLink.getText();
		System.out.println(path);
		if(imgLabel.getHeight()>0 && imgLabel.getWidth()>0 && !path.equals(""))
		{
		//ResizeImage resizeImage = new ResizeImage(imgLabel.getHeight(),imgLabel.getWidth());
		ResizeImage resizeImage = new ResizeImage(240,320);
		Image image = new ImageIcon(path).getImage();
		Image scaledImage = resizeImage.resize(path);
		selectedImage = new ImageData(-1,-1,-1,path,scaledImage);
		ImageIcon icon = new ImageIcon(scaledImage);
		imgLabel.setIcon(icon);
		txtImageLink.setText("");
		}
		if(imageArray != null)
		{
			if(imageArray.size()>0)
			{
				ImageData lastImage= (ImageData) tblImage.getValueAt(0,imageArray.size()-1);
				Number lastValue = (Number)(lastImage.getEndTime());
				spinnerStartTime.setValue(lastValue);
			}
		}
	}
	
	private void btnAddActionPerformed(ActionEvent evt) {
		synchronized (evt){
		System.out.println("btnAdd.actionPerformed, event="+evt);
		Number startvalue = (Number) spinnerStartTime.getValue();
		Number endValue = (Number) spinnerEndTime.getValue();
		startTime = startvalue.intValue();
		endTime = endValue.intValue();
		System.out.println("Image array size"+imageArray.size()+"path ="+ path );
		ImageData idata = new ImageData(startTime,endTime,imageArray.size(),path,selectedImage.getImage());
		imageArray.add(idata);
		
		if(endTime >slider.getMaximum())
		{	
		slider.setMaximum(endTime);
		slider.setPreferredSize(new Dimension((3006/400)*endTime,slider.getHeight()));
		slider.setMinimumSize(new Dimension((3006/400)*endTime,slider.getHeight()));
		slider.setMaximumSize(new Dimension((3006/400)*endTime,slider.getHeight()));
		slider.resize(new Dimension((3006/400)*endTime,slider.getHeight()));
		validate();
		
		spacing = (slider.getWidth()/endTime);
		}
		else
		{
		
		spacing = (float)slider.getWidth()/slider.getMaximum();	
		System.out.println("spacing " +spacing+ "slider width "+slider.getWidth() + " slider max "+ slider.getMaximum());
		}	
		cellWidth = Math.round( spacing*(endTime - startTime));
		tableWidth = Math.round(spacing*endTime);
		System.out.println("tableWidth "+tableWidth +"cell Width"+ cellWidth);
		if(imageArray.size()== 1)
		{
		
		/*tblImage.setSize(tableWidth,56);	
		tblImage.getColumnModel().addColumn(new TableColumn(0,cellWidth));
		TableCellRenderer mycellrenderer = new MyTableCellRenderer();
		tblImage.getColumnModel().getColumn(0).setCellRenderer(mycellrenderer);
		tblImageModel.setValueAt(idata, 0,0 );
		System.out.println("cellwidth ="+cellWidth+"tablewidth ="+ tableWidth + "table height" + tblImage.getHeight());*/
	
		//tblImage.getColumnModel().addColumn(new TableColumn(0,5));	
		//cellWidth = cellWidth +17;
		//tableWidth = tableWidth +17;
		//--------------------
		cellWidth = cellWidth + gapFiller;
		tableWidth = tableWidth + gapFiller;
				
		}
		//else
		{
			 tblImage.setSize(tableWidth,tblImage.getHeight());
			 //tblImage.getColumnModel().getColumn(imageArray.size()-1).setWidth(cellWidth);
			 tblImage.getColumnModel().addColumn(new TableColumn(imageArray.size()-1,cellWidth));
			 TableCellRenderer mycellrenderer = new MyTableCellRenderer();
			 tblImage.getColumnModel().getColumn(imageArray.size()-1).setCellRenderer(mycellrenderer);
			 tblImage.setValueAt(idata, 0,imageArray.size()-1);
			 System.out.println("cellwidth ="+cellWidth+"tablewidth ="+ tableWidth + "table height" + tblImage.getHeight());
			 tblImage.getColumnModel().getColumn(imageArray.size()-1).setResizable(true);
		}
		
		if(selectedImage.getIndex()<0)
		{
			if(imageArray.size()==0)
			{
				spinnerStartTime.setValue(0);
			}
			else if(imageArray.size()>0)
			{
				ImageData lastImage= (ImageData) tblImage.getValueAt(0,imageArray.size()-1);
				Number lastValue = (Number)lastImage.getEndTime();
				spinnerStartTime.setValue(lastValue);
			}
		}
		
	}	
	}
	
	private void sliderMouseReleased(MouseEvent evt) {
		System.out.println("slider.mouseReleased, event="+evt);
		sliderPosition = slider.getValue();
		slider.setToolTipText("The value is "+ sliderPosition);
		selectedImage = findImage(sliderPosition);
		if(selectedImage != null)
		{
			Image image = selectedImage.getImage();
			ImageIcon icon = new ImageIcon(image);
			imgLabel.setIcon(icon);
						
		}
		if( (audioDuration != 0))
		{
			if(audioPlayerThread == null)
			{
				audioDecoder.startingPoint = Math.round(sliderPosition*tickWeight);
				audioDecoder.slider = slider;
				audioPlayerThread = new Thread(audioDecoder);
				audioPlayerThread.start();
				btnPlay.setText("Pause");
			}
			else
			{
				audioPlayerThread.stop();
				System.out.println("TickWeight"+ tickWeight + " sliderPosition "+ sliderPosition+ "final value "+ (int) (sliderPosition*tickWeight) );
				audioDecoder.startingPoint =Math.round(sliderPosition*tickWeight);
				audioDecoder.slider = slider;
				slider.setValue(Math.round(sliderPosition*tickWeight));
				audioPlayerThread = new Thread(audioDecoder);
				audioPlayerThread.start();
				btnPlay.setText("Pause");
			}
		}
	}
	
	private ImageData findImage(int sliderPosition)
	{
		int position = sliderPosition;
		for(int i=0; i < imageArray.size() ; i++)
		{
			ImageData image = imageArray.get(i);
			if( position >= image.getStartTime() && position <= image.getEndTime() )
			{
				return image;
				
			}
			
		}
		return null;
	}
	
	private CaptionData findCaption(int sliderPosition)
	{
		int position = sliderPosition;
		for(int i=0; i < captionArray.size() ; i++)
		{
			CaptionData caption = captionArray.get(i);
			if(position >= caption.getStartTime() && position <= caption.getEndTime())
			{
				return caption;
			}
		}
		return null;
		
	}
	
	private void btnPlayActionPerformed(ActionEvent evt){
		System.out.println("btnPlay.actionPerformed, event="+evt);
			if(audioDuration!=0)
		{
			audioDecoder.startingPoint = Math.round(slider.getValue()*tickWeight);
			audioDecoder.slider = this.slider;
			if(audioPlayerThread==null)
			{
				audioPlayerThread = new Thread(audioDecoder);
				audioPlayerThread.start();
				btnPlay.setText("Pause");
			}	
			else
			{
			 
			 if(btnPlay.getText().equals("Pause"))
			 {
				 audioPlayerThread.stop();
				 btnPlay.setText("Play");
			 }
			 else 
			 {
				 audioDecoder.startingPoint = Math.round(slider.getValue()*tickWeight);
				 audioDecoder.slider = slider;
				 audioPlayerThread = new Thread(audioDecoder);
				 audioPlayerThread.start();
				 btnPlay.setText("Pause");
				 
			 }
			 
			}
		}
	}
	
	private void btnAudioBrowseActionPerformed(ActionEvent evt) {
		System.out.println("btnAudioBrowse.actionPerformed, event="+evt);
		System.out.println("btnBrowse.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(txtAudio);
	}
	

	
	private void horizontalScrollBarAdjustmentValueChanged(AdjustmentEvent evt) {
		System.out.println("jScrollPane2.getHorizontalScrollBar().adjustmentValueChanged, event="+evt);
		jScrollPane2.getHorizontalScrollBar().setValue(scrollCaption.getHorizontalScrollBar().getValue());
		//scrollSlider.getHorizontalScrollBar().setValue(jScrollPane2.getHorizontalScrollBar().getValue());
		scrollSlider.getHorizontalScrollBar().setValue(scrollCaption.getHorizontalScrollBar().getValue());
	}
	
	private void tblImageFocusGained(FocusEvent evt) {
		
	}
	
	private void tblImageMouseReleased(MouseEvent evt) {
		System.out.println("tblImage.focusGained, event="+evt);
		int selecteColumn = tblImage.getSelectedColumn();
		//selectedImage =(ImageData) tblImage.getModel().getValueAt(0,selecteColumn);
		selectedImage = imageArray.get(selecteColumn);
		
		if(! selectedImage.equals(null))
		{
			Image image = selectedImage.getImage();
			ImageIcon icon = new ImageIcon(image);
			imgLabel.setIcon(icon);
			Number startValue = selectedImage.getStartTime();
			Number endValue = selectedImage.getEndTime();
			spinnerStartTime.setValue(startValue);
			spinnerStartTime.getEditor().setPreferredSize(new java.awt.Dimension(78, 24));
			spinnerEndTime.setValue(endValue);		
			spinnerEndTime.getEditor().setPreferredSize(new java.awt.Dimension(77, 20));
		}
		
	}
	
	private void spinnerStartTimeStateChanged(ChangeEvent evt) {
		System.out.println("spinnerStartTime.stateChanged, event="+evt);
		System.out.println(selectedImage.getIndex());
		//TODO add your code for spinnerStartTime.stateChanged
		Number value = (Number) spinnerStartTime.getValue();
		int startTime = value.intValue();
		
		
		
		if(selectedImage.getIndex()>1)
		{
			ImageData image1= (ImageData) tblImage.getValueAt(0,selectedImage.getIndex()-1);
			ImageData image2 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex());
			
			if(startTime < selectedImage.getStartTime())
			{	
			
			int timeDifference = selectedImage.getStartTime()-startTime;
			image1.setEndTime(image1.getEndTime()- timeDifference );
			System.out.println(timeDifference);
			System.out.println("old Width" + tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).getWidth());
			tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).setPreferredWidth(Math.round(spacing*(image1.getEndTime()-image1.getStartTime())));
			tblImage.setValueAt(image1,0,selectedImage.getIndex()-1 );
	
			image2.setStartTime(startTime);
			tblImage.setValueAt(image2,0,selectedImage.getIndex());
			tblImage.doLayout();
			tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round(spacing*(image2.getEndTime()-image2.getStartTime())));
			System.out.println("New Width" + tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).getWidth());
			
			}
			else if(startTime > selectedImage.getStartTime())
			{
				int timeDifference = startTime - selectedImage.getStartTime();
				image1.setEndTime(image1.getEndTime()+timeDifference);
				tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).setPreferredWidth(Math.round(spacing*(image1.getEndTime()-image1.getStartTime())));
				tblImage.setValueAt(image1,0,selectedImage.getIndex()-1 );
				
				image2.setStartTime(startTime);
				tblImage.setValueAt(image2,0,selectedImage.getIndex());
				tblImage.doLayout();
				tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round( spacing*(image2.getEndTime()-image2.getStartTime())));
				System.out.println("New Width" + tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).getWidth());
			}
			
			
				
		}
		else if(selectedImage.getIndex()==1)
		{
			ImageData image1= (ImageData) tblImage.getValueAt(0,selectedImage.getIndex()-1);
			ImageData image2 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex());
			
			if(startTime < selectedImage.getStartTime())
			{	
			
			int timeDifference = selectedImage.getStartTime()-startTime;
			image1.setEndTime(image1.getEndTime()- timeDifference);
			System.out.println(timeDifference);
			System.out.println("old Width" + tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).getWidth());
			tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).setPreferredWidth(Math.round(spacing*(image1.getEndTime()-image1.getStartTime()))+gapFiller);
			tblImage.setValueAt(image1,0,selectedImage.getIndex()-1 );
	
			image2.setStartTime(startTime);
			tblImage.setValueAt(image2,0,selectedImage.getIndex());
			tblImage.doLayout();
			tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round(spacing*(image2.getEndTime()-image2.getStartTime())));
			System.out.println("New Width" + tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).getWidth());
			
			}
			else if(startTime > selectedImage.getStartTime())
			{
				int timeDifference = startTime - selectedImage.getStartTime();
				image1.setEndTime(image1.getEndTime()+timeDifference);
				tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).setPreferredWidth(Math.round(spacing*(image1.getEndTime()-image1.getStartTime()))+gapFiller);
				tblImage.setValueAt(image1,0,selectedImage.getIndex()-1 );
				
				image2.setStartTime(startTime);
				tblImage.setValueAt(image2,0,selectedImage.getIndex());
				tblImage.doLayout();
				tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round( spacing*(image2.getEndTime()-image2.getStartTime())));
				System.out.println("New Width" + tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).getWidth());
			}
		}
		else if(selectedImage.getIndex()==0)
		{
			Number stop = 0 ;
			spinnerStartTime.setValue(0);
		}
		else if(selectedImage.getIndex() == -1)
		{
			if(imageArray.size()==0)
			{
				spinnerStartTime.setValue(0);
			}
			else if(imageArray.size()>0)
			{
				ImageData lastImage= (ImageData) tblImage.getValueAt(0,imageArray.size()-1);
				Number lastValue = (Number)(lastImage.getEndTime());
				spinnerStartTime.setValue(lastValue);
			}
		}
	}
	
	private void spinnerEndTimeStateChanged(ChangeEvent evt) {
		System.out.println("spinnerEndTime.stateChanged, event="+evt);
		Number endValue = (Number) spinnerEndTime.getValue();
		int endTime = endValue.intValue();
		if(selectedImage.getIndex()>0)
		{
			
			ImageData image2 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex());
		
			if(endTime < selectedImage.getEndTime())
			{
				if((selectedImage.getIndex()+1) < imageArray.size() )
				{
					ImageData image3 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex()+1);
					int timeDifference = selectedImage.getEndTime()-endTime;
					image3.setStartTime(image3.getStartTime() - timeDifference);
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()+1).setPreferredWidth(Math.round(spacing*(image3.getEndTime()-image3.getStartTime())));
					tblImage.setValueAt(image3,0,selectedImage.getIndex()+1 );
					
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round(spacing*(image2.getEndTime()-image2.getStartTime())));
				}
				else 
				{
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round(spacing*(image2.getEndTime()-image2.getStartTime())));
				}
				
			}
			else if(endTime > selectedImage.getEndTime())
			{
				if((selectedImage.getIndex()+1) < imageArray.size() )
				{
					ImageData image3 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex()+1);
					int timeDifference = endTime - selectedImage.getEndTime();
					image3.setStartTime(image3.getStartTime() + timeDifference);
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()+1).setPreferredWidth(Math.round(spacing*(image3.getEndTime()-image3.getStartTime())));
					tblImage.setValueAt(image3,0,selectedImage.getIndex()+1 );
					
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round(spacing*(image2.getEndTime()-image2.getStartTime())));
				}
				else
				{
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round(spacing*(image2.getEndTime()-image2.getStartTime())));
				}
				
			}	
		
		}
		else if(selectedImage.getIndex()==0)
		{
			ImageData image2 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex());
			
			if(endTime < selectedImage.getEndTime())
			{
				if((selectedImage.getIndex()+1) < imageArray.size() )
				{
					ImageData image3 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex()+1);
					int timeDifference = selectedImage.getEndTime()-endTime;
					image3.setStartTime(image3.getStartTime() - timeDifference);
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()+1).setPreferredWidth(Math.round(spacing*(image3.getEndTime()-image3.getStartTime())));
					tblImage.setValueAt(image3,0,selectedImage.getIndex()+1 );
					
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round(spacing*(image2.getEndTime()-image2.getStartTime()))+gapFiller);
				}
				else
				{
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round(spacing*(image2.getEndTime()-image2.getStartTime()))+gapFiller);
				}
				
			}
			else if(endTime > selectedImage.getEndTime())
			{
				if((selectedImage.getIndex()+1) < imageArray.size() )
				{
					ImageData image3 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex()+1);
					int timeDifference = endTime - selectedImage.getEndTime();
					image3.setStartTime(image3.getStartTime() + timeDifference);
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()+1).setPreferredWidth(Math.round( spacing*(image3.getEndTime()-image3.getStartTime())));
					tblImage.setValueAt(image3,0,selectedImage.getIndex()+1 );
					
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round( spacing*(image2.getEndTime()-image2.getStartTime()))+gapFiller);
				}
				else
				{
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth(Math.round(spacing*(image2.getEndTime()-image2.getStartTime()))+gapFiller);
				}
				
			}		
		}
		
	}
	
	private void txtAudioPropertyChange(PropertyChangeEvent evt) {
		System.out.println("txtAudio.propertyChange, event="+evt);
		audioPath=txtAudio.getText();
		System.out.println(audioPath);
		if(!audioPath.equals(""))
		{
			//resetting audio , image and caption time lines
			sliderWidth = 3006;
			zoomAudioTimeLine(1);
			
			
			audioDecoder = new DecodeAndPlayAudio();
			AudioData audioData = audioDecoder.getAudioData(audioPath);
			audioDuration = audioData.getSongDuration();
			noOfAudioSamples = audioData.getSongLength();
			if(slider.getMaximum()< audioDuration)
			{
				sliderWidth = audioDuration*(sliderWidth/400);
				slider.setMaximum(audioDuration);
				slider.setPreferredSize(new Dimension(sliderWidth,slider.getHeight()));
				slider.setMinimumSize(new Dimension(sliderWidth,slider.getHeight()));
				slider.setMaximumSize(new Dimension(sliderWidth,slider.getHeight()));
				slider.resize(new Dimension(sliderWidth,slider.getHeight()));
					
				zoomImageTimeLine(1);
				zoomCaptionTimeLine();
			}
			else
			{
				slider.setMaximum(400);
				slider.setPreferredSize(new Dimension(sliderWidth,slider.getHeight()));
				slider.setMinimumSize(new Dimension(sliderWidth,slider.getHeight()));
				slider.setMaximumSize(new Dimension(sliderWidth,slider.getHeight()));
				slider.resize(new Dimension(sliderWidth,slider.getHeight()));
				
				zoomImageTimeLine(1);
				zoomCaptionTimeLine();
			}
			tickWeight = (float)noOfAudioSamples/audioDuration;
			System.out.println(tickWeight);
			audioDecoder.slider = slider;
			
		}
		
	}
	
	private void sliderMousePressed(MouseEvent evt) {
		System.out.println("slider.mousePressed, event="+evt);
		if(audioPlayerThread != null)
		{
			audioPlayerThread.stop();
		}
	}
	
	private void sliderStateChanged(ChangeEvent evt) {
		System.out.println("slider.stateChanged, event="+evt);
		sliderPosition = slider.getValue();
		//slider.setToolTipText("The value is "+ sliderPosition);
		//scrollSlider.getHorizontalScrollBar().setValue(sliderPosition);
		System.out.println("Maximum horizontal scroll bar slider "+scrollSlider.getHorizontalScrollBar().getMaximum());
		if(imageArray != null)
		{
			
			ImageData currentImage =  findImage(sliderPosition);
			if(currentImage != null)
			{	
				if(selectedImage != null && (selectedImage.getIndex()!= currentImage.getIndex()))
				{
					
					Image image = currentImage.getImage();
					ImageIcon icon = new ImageIcon(image);
					imgLabel.setIcon(icon);
					selectedImage = currentImage;
				}
			}
			
			 
		}
		CaptionData currentCaption = findCaption(sliderPosition);
		if(currentCaption != null){
			System.out.println(currentCaption.getCaption());
			lblCaption.setText(currentCaption.getCaption());
			
		}
		//jScrollPane2.getHorizontalScrollBar().setValue(slider.getValue());
	}
	
	private void tblImagePropertyChange(PropertyChangeEvent evt) {
		System.out.println("tblImage.propertyChange, event="+evt);
		//TODO add your code for tblImage.propertyChange
	}
	
	private void btnStopActionPerformed(ActionEvent evt) {
		System.out.println("btnStop.actionPerformed, event="+evt);
		if(audioPlayerThread != null)
		{
			audioPlayerThread.stop();
			btnPlay.setText("Play");
			
		}
		slider.setValue(0);
	}
	
	private void btnCaptionActionPerformed(ActionEvent evt) {
		System.out.println("btnCaption.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(txtCaption);
	}
	
	private void txtCaptionPropertyChange(PropertyChangeEvent evt) {
		System.out.println("txtCaption.propertyChange, event="+evt);
		String captionPath = txtCaption.getText();
		File file = null;
	    FileInputStream fileInputStream = null;
	    BufferedInputStream bufferedInputStream = null;
	    DataInputStream dataInputStream = null;
	    String caption = "";
	    if(captionArray != null)
	    {	if( !captionArray.isEmpty())
	    	{
	    		captionArray.clear();
	    	}
	    }
	    if(spacing == 0)
	    {
	    	spacing = (float)slider.getWidth()/slider.getMaximum();	
	    	System.out.println("spacing calculated for captions"+ spacing+"slider widht"+ slider.getWidth()+"slider maximum"+slider.getMaximum());
	    }
	    int lineCount=0 ;
		if(!captionPath.equals(""))
		{
			System.out.println("The caption path " + captionPath);
			
			file = new File(captionPath);
			try {
				fileInputStream = new FileInputStream(file);
				bufferedInputStream = new BufferedInputStream(fileInputStream);
			    dataInputStream = new DataInputStream(bufferedInputStream);
				
			    while (dataInputStream.available() != 0) {
			    	
			        caption= caption +dataInputStream.readLine()+ "\n";
			        
			        lineCount++;
			    }
			  //if(audioDuration != 0)
			  {  
				String  []wordArray = caption.split("\r|\n|\r\n|,");
				ArrayList<String> wordArrayList = new ArrayList<String>();
				for(int i = 0 ; i <wordArray.length ; i ++)
				{
					wordArrayList.add(wordArray[i]);
				}
				TableModel tblCaptionModel = new CaptionTableModel(wordArrayList);
				tblCaption.setModel(tblCaptionModel);
			  	//tblCaption.setSize((int)(spacing*audioDuration),tblCaption.getHeight());
				//tblCaption.setSize(scrollCaption.getWidth(),tblCaption.getHeight());
				
				//float width = (float)(scrollCaption.getWidth()/wordArray.length);
				
				float width = (float) (slider.getWidth()/caption.length());
			  	System.out.println("new caption width"+ width+"no of letters"+caption.length());
				for(int i= 0; i < wordArray.length ; i++)
			    {
			  		int captionWidth = Math.round(width*wordArray[i].length());
			  		int realWidth = Math.round(captionWidth/spacing);
			  		//int realWidth = Math.round(captionWidth*spacing);
			  		System.out.println("real width of word"+ i +"width"+realWidth);
			  		CaptionData  captionData;
			    	if(captionArray.size() == 0)
			  		{
			    		captionData = new CaptionData(0,realWidth,wordArray[i]);
			    		captionArray.add(captionData);
			    		tblCaption.getColumnModel().getColumn(i).setPreferredWidth((captionWidth+gapFiller));
			    	}
			    	else
			    	{
			    		int capStartTime = captionArray.get(i-1).captionEndTime;
			    		captionData = new CaptionData(capStartTime,capStartTime +realWidth,wordArray[i]);
			    		captionArray.add(captionData);
			    		tblCaption.getColumnModel().getColumn(i).setPreferredWidth(captionWidth);
			    	}
			    	
			  		
			    	System.out.println("Word "+ i+ "=" + wordArray[i] +"start time ="+captionArray.get(i).getStartTime()+ " caption endtime =" + captionArray.get(i).getEndTime());
			    }
			  }  
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void tblCaptionComponentResized(ComponentEvent evt) {
		System.out.println("tblCaption.componentResized, event="+evt);
		float width ;
		System.out.println("caption array size "+captionArray.size());
		for(int i=0; i< captionArray.size() ; i++)
		{
			if(i==0)
			{
				
				width = (float) ((tblCaption.getColumnModel().getColumn(0).getWidth()-gapFiller)/spacing);
				captionArray.get(i).setEndTime(Math.round(width));
				captionArray.get(i).setStartTime(0);
			}
			else
			{
				width = (float) (tblCaption.getColumnModel().getColumn(i).getWidth()/spacing);
				captionArray.get(i).setStartTime(captionArray.get(i-1).getEndTime());
				captionArray.get(i).setEndTime(Math.round(captionArray.get(i).getStartTime() + width));
				
			}
			System.out.println("New start time ="+captionArray.get(i).getStartTime()+ " caption endtime =" + captionArray.get(i).getEndTime());	
		}
		
		
	}
	
	private void tblCaptionPropertyChange(PropertyChangeEvent evt) {
		System.out.println("tblCaption.propertyChange, event="+evt);
		int selectedCoulumn =tblCaption.getSelectedColumn();
		if(selectedCoulumn >=0 )
		{	
		System.out.println((String) tblCaption.getValueAt(0,selectedCoulumn));
		captionArray.get(selectedCoulumn).setCaption((String) tblCaption.getValueAt(0,selectedCoulumn));
		}
		//captionPropertyChanged = true;
	}
	
	private void tblCaptionKeyTyped(KeyEvent evt) {
		System.out.println("tblCaption.keyTyped, event="+evt);
		int keyvalue = (int)evt.getKeyChar();
		int selectedColumn;
		if(keyvalue == 127)
		{
			
			int[] selectedColumns = tblCaption.getSelectedColumns();
			int selectedColumnCount = tblCaption.getSelectedColumnCount();
			tblCaption.clearSelection();
		
			for(int j=0; j< selectedColumnCount ; j++ )
			{
				
				//captionPropertyChanged = false;
				selectedColumn = selectedColumns[j]-j;
				System.out.println("Selected Column ="+ selectedColumn);
				
				tblCaption.getColumnModel().removeColumn(tblCaption.getColumnModel().getColumn(selectedColumn));
				int newStartTime = captionArray.get(selectedColumn).getStartTime();
				captionArray.remove(selectedColumn);
				System.out.println("after remove caption"+ captionArray.size());
		
				for(int i= selectedColumn ; i < captionArray.size() ; i++)
				{
					int width = captionArray.get(i).getEndTime() - captionArray.get(i).getStartTime();
					captionArray.get(i).setStartTime(newStartTime);
					captionArray.get(i).setEndTime(newStartTime +width);
					newStartTime = captionArray.get(i).getEndTime();
				}
				
				for(int i=0 ; i < captionArray.size() ; i++)
				{
					tblCaption.getModel().setValueAt(captionArray.get(i).getCaption(),0,i);
				}
			
				ArrayList<String> captionString = new ArrayList<String>();
				for(int i=0; i< captionArray.size() ; i++)
				{
					captionString.add(captionArray.get(i).getCaption());
				}
			
				TableModel tblCaptionModel = new CaptionTableModel(captionString);
				tblCaption.setModel(tblCaptionModel);
			
				for(int i=0; i< captionArray.size() ; i++)
				{
					int width = Math.round(spacing*(captionArray.get(i).getEndTime() - captionArray.get(i).getStartTime()));
					System.out.println("captions" +captionArray.get(i).getCaption());
					//tblCaption.getModel().setValueAt(captionArray.get(i).getCaption(), 0,i);
					tblCaption.getColumnModel().getColumn(i).setPreferredWidth(width);
				}
			}
						
				tblCaption.clearSelection();
				tblCaption.revalidate();
				tblCaption.repaint();
			
			
		}
	}
	
	private void tblImageComponentResized(ComponentEvent evt) {
		System.out.println("tblImage.componentResized, event="+evt);
		//TODO add your code for tblImage.componentResized
		
		float width;
		for (int i=0; i< imageArray.size() ; i++)
		{
			
			if(i==0)
			{
				width = (float) ((tblImage.getColumnModel().getColumn(i).getWidth()-gapFiller)/spacing);
				System.out.println("Width ="+ tblImage.getColumnModel().getColumn(i).getWidth() +"spacing ="+ spacing + "Width  after calculation=" + width);
				imageArray.get(0).setEndTime(Math.round(width));
				
			}
			else
			{
				width = (float) (tblImage.getColumnModel().getColumn(i).getWidth()/spacing);
				imageArray.get(i).setStartTime(imageArray.get(i-1).getEndTime());
				imageArray.get(i).setEndTime(Math.round(imageArray.get(i).getStartTime() + width));
				
			}
		}
	}
	
	private void tblImageKeyTyped(KeyEvent evt) {
		System.out.println("tblImage.keyTyped, event="+evt);
		int keyvalue = (int)evt.getKeyChar();
		int columnId;
		TableColumn column;
		float width;
		if(keyvalue == 127)
		{
			synchronized (tblImage) {
				
				
			
			columnId = tblImage.getSelectedColumn();
			System.out.println("selected column id for deleting"+ columnId);
			column = tblImage.getColumnModel().getColumn(columnId);
			System.out.println("removable column id"+ columnId);
			
			for (int i=columnId;i<imageArray.size()-1;i++){
                imageArray.set(i, imageArray.get(i+1));
                tblImage.setValueAt(imageArray.get(i+1), 0,i);
              
            }
						
			int newcolumnId = imageArray.size()-1;
            column = tblImage.getColumnModel().getColumn(newcolumnId);
            imageArray.remove(newcolumnId);
            tblImage.getColumnModel().removeColumn(column);
           // tblImage.removeColumn(column);
            
           // ((ImageTableModel)tblImage.getModel()).removeValueAt(newcolumnId);
            
			/*((ImageTableModel)tblImage.getModel()).removeValueAt(columnId);
			System.out.println("Size of image list======= "+((ImageTableModel)tblImage.getModel()).imageList.size());
			imageArray.remove(columnId);
			tblImage.getColumnModel().removeColumn(tblImage.getColumnModel().getColumn(columnId));*/
	      
			
			
	    for (int i=columnId; i< imageArray.size() ; i++)
			{
				
				if(i==0)
				{
					//width = (float) ((tblImage.getColumnModel().getColumn(i).getWidth()-17)/spacing);
					
					//System.out.println("Width ="+ tblImage.getColumnModel().getColumn(i).getWidth() +"spacing ="+ spacing + "Width  after calculation=" + width);
					imageArray.get(0).setEndTime(imageArray.get(0).getEndTime() - imageArray.get(0).getStartTime());
					imageArray.get(0).setStartTime(0);
					//imageArray.get(0).setEndTime(Math.round(width));
					
					imageArray.get(0).setIndex(0);
					tblImage.getColumnModel().getColumn(0).setPreferredWidth((Math.round(imageArray.get(0).getEndTime()*spacing)+gapFiller));
					
					//tblImage.getModel().setValueAt(imageArray.get(0),0 , 0);
					//TableCellRenderer mycellrenderer = new MyTableCellRenderer();
					//tblImage.getColumnModel().getColumn(0).setCellRenderer(mycellrenderer);
					tblImage.setValueAt(imageArray.get(0), 0,0);
				}
				else if(i >0)
				{
					//width = (float) (tblImage.getColumnModel().getColumn(i).getWidth()/spacing);
					int currentEnd = imageArray.get(i).getEndTime();
					int currentStart = imageArray.get(i).getStartTime();
					int imageWidth = currentEnd -currentStart;
					
					int newStart =imageArray.get(i-1).getEndTime();
					imageArray.get(i).setStartTime(newStart);
					imageArray.get(i).setEndTime(newStart+imageWidth);
					imageArray.get(i).setIndex(i);
					tblImage.getColumnModel().getColumn(i).setPreferredWidth(Math.round(imageWidth*spacing));
					
					//tblImage.getModel().setValueAt(imageArray.get(i),0 , i);
					//TableCellRenderer mycellrenderer = new MyTableCellRenderer();
					//tblImage.getColumnModel().getColumn(i).setCellRenderer(mycellrenderer);
					tblImage.setValueAt(imageArray.get(i), 0,i);
				}
			}
			
			for(int i= 0 ; i < imageArray.size(); i++)
			{
				System.out.println("start time" +imageArray.get(i).getStartTime() + "end time"+ imageArray.get(i).getEndTime() +"Index"+ imageArray.get(i).getIndex());
			
			}
			
			selectedImage.setIndex(-1);
			//if(imageArray.size()>columnId-1)
			System.out.println("after remove image array size"+ imageArray.size());
		
			tblImage.validate();
			
		}
		
	}
	}
	
	private void tableHeaderMouseReleased(MouseEvent evt) {
		System.out.println("tblImage.getTableHeader().mouseReleased, event="+evt);
		synchronized (tblImage) {
			
		
		if(columnMoved == true)
		{
			if((columnMovedFromPosition != columnMovedPosition) && (columnMovedPosition<columnMovedFromPosition))
			{
				System.out.println("Column Moved from"+ columnMovedFromPosition +  " to"+columnMovedPosition);
				ImageData dataFromMoved = imageArray.get(columnMovedFromPosition);
				for (int i = columnMovedFromPosition ; i >=columnMovedPosition  ;i--)
				{
					
					if(i== columnMovedPosition)
					{
						imageArray.set(i,dataFromMoved);
						tblImage.setValueAt(dataFromMoved, 0, i);
					}
					else
					{
						imageArray.set(i,imageArray.get(i-1));
						tblImage.setValueAt(imageArray.get(i-1), 0, i);
					}
					
				}
				for(int i= columnMovedPosition ; i < imageArray.size(); i++)
				{
					int currentEnd = imageArray.get(i).getEndTime();
					int currentStart = imageArray.get(i).getStartTime();
					int imageWidth = currentEnd -currentStart;
					if(i != 0)
					{
						int newStart =imageArray.get(i-1).getEndTime();
						imageArray.get(i).setStartTime(newStart);
						imageArray.get(i).setEndTime(newStart+imageWidth);
						imageArray.get(i).setIndex(i);
						
						
					}
					else if(i == 0)
					{
						imageArray.get(i).setStartTime(0);
						imageArray.get(i).setEndTime(imageWidth);
						imageArray.get(i).setIndex(0);					
									
					}
					
					
					//TableCellRenderer mycellrenderer = new MyTableCellRenderer();
					//tblImage.getColumnModel().getColumn(i).setCellRenderer(mycellrenderer);
					tblImage.setValueAt(imageArray.get(i), 0,i);
					//tblImage.getModel().setValueAt(imageArray.get(i),0 , i);
				}
			}
			
		}
		columnMoved = false;
	}
	}
	
	private void spinnerCaptionStartTimeStateChanged(ChangeEvent evt) {
		System.out.println("spinnerCaptionStartTime.stateChanged, event="+evt);
		
		Number value = (Number) spinnerCaptionStartTime.getValue();
		int startTime = value.intValue();
		selectedCaption = tblCaption.getSelectedColumn();
		
		if(selectedCaption >1)
		{
			CaptionData previousCaptionData = captionArray.get(selectedCaption-1);
			CaptionData currentCaptionData = captionArray.get(selectedCaption);;
		
			
			if(startTime < currentCaptionData.getStartTime())
			{	
			
			int timeDifference = currentCaptionData.getStartTime()-startTime;
			System.out.println("time difference" + timeDifference);
			previousCaptionData.setEndTime(previousCaptionData.getEndTime()- timeDifference );
			
			tblCaption.getColumnModel().getColumn(selectedCaption-1).setPreferredWidth(Math.round(spacing*(previousCaptionData.getEndTime()-previousCaptionData.getStartTime())));
			captionArray.set(selectedCaption-1,previousCaptionData );
			//tblCaption.setValueAt(previousCaptionData, 0, selectedCaption-1);
			
			currentCaptionData.setStartTime(startTime);
			//tblCaption.setValueAt(currentCaptionData,0,selectedCaption);
			tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime())));
			tblCaption.doLayout();
			captionArray.set(selectedCaption,currentCaptionData );

			
			}
			else if(startTime > currentCaptionData.getStartTime())
			{
				int timeDifference = startTime - currentCaptionData.getStartTime();
				previousCaptionData.setEndTime(previousCaptionData.getEndTime()+ timeDifference );
				tblCaption.getColumnModel().getColumn(selectedCaption-1).setPreferredWidth(Math.round(spacing*(previousCaptionData.getEndTime()-previousCaptionData.getStartTime())));
				captionArray.set(selectedCaption-1,previousCaptionData );
				
				currentCaptionData.setStartTime(startTime);
				tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime())));
				tblCaption.doLayout();
				captionArray.set(selectedCaption,currentCaptionData );
				
			}
		}
		else if (selectedCaption ==1)
		{
			CaptionData previousCaptionData = captionArray.get(selectedCaption-1);
			CaptionData currentCaptionData = captionArray.get(selectedCaption);;
		
			
			if(startTime < currentCaptionData.getStartTime())
			{	
			
			int timeDifference = currentCaptionData.getStartTime()-startTime;
			System.out.println("time difference" + timeDifference);
			previousCaptionData.setEndTime(previousCaptionData.getEndTime()- timeDifference );
			
			tblCaption.getColumnModel().getColumn(selectedCaption-1).setPreferredWidth(Math.round(spacing*(previousCaptionData.getEndTime()-previousCaptionData.getStartTime()))+gapFiller);
			captionArray.set(selectedCaption-1,previousCaptionData );
			//tblCaption.setValueAt(previousCaptionData, 0, selectedCaption-1);
			
			currentCaptionData.setStartTime(startTime);
			//tblCaption.setValueAt(currentCaptionData,0,selectedCaption);
			tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime())));
			tblCaption.doLayout();
			captionArray.set(selectedCaption,currentCaptionData );

			
			}
			else if(startTime > currentCaptionData.getStartTime())
			{
				int timeDifference = startTime - currentCaptionData.getStartTime();
				previousCaptionData.setEndTime(previousCaptionData.getEndTime()+ timeDifference );
				tblCaption.getColumnModel().getColumn(selectedCaption-1).setPreferredWidth(Math.round(spacing*(previousCaptionData.getEndTime()-previousCaptionData.getStartTime()))+gapFiller);
				captionArray.set(selectedCaption-1,previousCaptionData );
				
				currentCaptionData.setStartTime(startTime);
				tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime())));
				tblCaption.doLayout();
				captionArray.set(selectedCaption,currentCaptionData );
				
			}
		}
		else if( selectedCaption == 0)
		{
			spinnerCaptionStartTime.setValue(0);
		}
		

		
		
	}
	
	private void spinnerCaptionEndTimeStateChanged(ChangeEvent evt) {
		System.out.println("spinnerCaptionEndTime.stateChanged, event="+evt);
		
		Number endValue = (Number) spinnerCaptionEndTime.getValue();
		int endTime = endValue.intValue();
		selectedCaption = tblCaption.getSelectedColumn();
		if(selectedCaption>0)
		{
			
			CaptionData currentCaptionData = captionArray.get(selectedCaption);
			if(endTime < currentCaptionData.getEndTime())
			{
				if((selectedCaption+1) < captionArray.size() )
				{
					CaptionData nextCaptionData =captionArray.get(selectedCaption+1) ;
					int timeDifference = currentCaptionData.getEndTime()-endTime;
					nextCaptionData.setStartTime(nextCaptionData.getStartTime() - timeDifference);
					tblCaption.getColumnModel().getColumn(selectedCaption+1).setPreferredWidth(Math.round(spacing*(nextCaptionData.getEndTime()-nextCaptionData.getStartTime())));
					captionArray.set(selectedCaption+1, nextCaptionData);
					
					currentCaptionData.setEndTime(endTime);
					tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime())));
					tblCaption.doLayout();
					captionArray.set(selectedCaption, currentCaptionData);
					
				}
				else 
				{
					currentCaptionData.setEndTime(endTime);
					tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime())));
					tblCaption.doLayout();
					captionArray.set(selectedCaption, currentCaptionData);
				}
				
			}
			else if(endTime > currentCaptionData.getEndTime())
			{
				if((selectedCaption+1) < captionArray.size() )
				{
					CaptionData nextCaptionData =captionArray.get(selectedCaption+1) ;
					int timeDifference = endTime - currentCaptionData.getEndTime();
					nextCaptionData.setStartTime(nextCaptionData.getStartTime() +timeDifference);
					tblCaption.getColumnModel().getColumn(selectedCaption+1).setPreferredWidth(Math.round(spacing*(nextCaptionData.getEndTime()-nextCaptionData.getStartTime())));
					captionArray.set(selectedCaption+1, nextCaptionData);
					
					currentCaptionData.setEndTime(endTime);
					tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime())));
					tblCaption.doLayout();
					captionArray.set(selectedCaption, currentCaptionData);
				}
				else
				{
					currentCaptionData.setEndTime(endTime);
					tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime())));
					tblCaption.doLayout();
					captionArray.set(selectedCaption, currentCaptionData);
				}
				
			}	
		
		}
		else if(selectedCaption==0)
		{
			CaptionData currentCaptionData = captionArray.get(selectedCaption);
			
			if(endTime < currentCaptionData.getEndTime())
			{
				if((selectedCaption+1) < captionArray.size() )
				{
					CaptionData nextCaptionData =captionArray.get(selectedCaption+1) ;
					int timeDifference = currentCaptionData.getEndTime()-endTime;
					nextCaptionData.setStartTime(nextCaptionData.getStartTime() - timeDifference);
					tblCaption.getColumnModel().getColumn(selectedCaption+1).setPreferredWidth(Math.round(spacing*(nextCaptionData.getEndTime()-nextCaptionData.getStartTime())));
					captionArray.set(selectedCaption+1, nextCaptionData);
					
					currentCaptionData.setEndTime(endTime);
					tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime()))+gapFiller);
					tblCaption.doLayout();
					captionArray.set(selectedCaption, currentCaptionData);
					
				}
				else 
				{
					currentCaptionData.setEndTime(endTime);
					tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime()))+gapFiller);
					tblImage.doLayout();
					captionArray.set(selectedCaption, currentCaptionData);
				}
				
			}
			else if(endTime > currentCaptionData.getEndTime())
			{
				if((selectedCaption+1) < captionArray.size() )
				{
					CaptionData nextCaptionData =captionArray.get(selectedCaption+1) ;
					int timeDifference = endTime - currentCaptionData.getEndTime();
					nextCaptionData.setStartTime(nextCaptionData.getStartTime() +timeDifference);
					tblCaption.getColumnModel().getColumn(selectedCaption+1).setPreferredWidth(Math.round(spacing*(nextCaptionData.getEndTime()-nextCaptionData.getStartTime())));
					captionArray.set(selectedCaption+1, nextCaptionData);
					
					currentCaptionData.setEndTime(endTime);
					tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime()))+gapFiller);
					tblCaption.doLayout();
					captionArray.set(selectedCaption, currentCaptionData);
				}
				else
				{
					currentCaptionData.setEndTime(endTime);
					tblCaption.getColumnModel().getColumn(selectedCaption).setPreferredWidth(Math.round(spacing*(currentCaptionData.getEndTime()-currentCaptionData.getStartTime()))+gapFiller);
					tblImage.doLayout();
					captionArray.set(selectedCaption, currentCaptionData);
				}
				
			}		
		}
		
	}
	
	
	
	private void tblCaptionMouseReleased(MouseEvent evt) {
		System.out.println("tblCaption.mouseReleased, event="+evt);
		int selectedColumn =tblCaption.getSelectedColumn();
		CaptionData captionData = captionArray.get(selectedColumn);
		
		txtCaptionEdit.setText(captionData.getCaption());
		System.out.println(captionData.getStartTime());
		spinnerCaptionStartTime.setValue(captionData.getStartTime());
		spinnerCaptionEndTime.setValue(captionData.getEndTime());
		

	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		System.out.println("jButton1.actionPerformed, event="+evt);
		selectedCaption = tblCaption.getSelectedColumn();
		tblCaption.setValueAt(txtCaptionEdit.getText(), 0, selectedCaption);
		captionArray.get(selectedCaption).setCaption(txtCaptionEdit.getText());
		tblCaption.repaint();
	}
	
	private void btnCreateActionPerformed(ActionEvent evt) {
		System.out.println("btnCreate.actionPerformed, event="+evt);
		String videoName = "video2.avi";
		ImagesToVideo iToVideo = new ImagesToVideo(videoName);
		iToVideo.createVideo(imageArray,videoName);
		
		
		String command = new String("ffmpeg -i "+videoName+" -i \""+audioPath+"\" -acodec copy -vcodec copy final3.mov");
		System.out.println(command);
		try {
			Process p = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void btnSplitActionPerformed(ActionEvent evt) {
		System.out.println("btnSplit.actionPerformed, event="+evt);
		//TODO add your code for btnSplit.actionPerformed
		int selectedColumnIndex = tblCaption.getSelectedColumn();
		if(selectedColumnIndex >= 0)
		{
			int duration = captionArray.get(selectedColumnIndex).getEndTime() - captionArray.get(selectedColumnIndex).getStartTime();
			int newEndTime;
			if(selectedColumnIndex == 0)
			{
				newEndTime = Math.round(duration/2);
			}
			else
			{
				newEndTime =Math.round(duration/2) + captionArray.get(selectedColumnIndex).getStartTime();
			}
			CaptionData newCaptionData = new CaptionData(newEndTime,captionArray.get(selectedColumnIndex).getEndTime(),"");
			captionArray.get(selectedColumnIndex).setEndTime(newEndTime);
			captionArray.add(selectedColumnIndex+1, newCaptionData);
		
			ArrayList<String> captionString = new ArrayList<String>();
			for(int i=0; i< captionArray.size() ; i++)
			{
				captionString.add(captionArray.get(i).getCaption());
			}
			
			TableModel tblCaptionModel = new CaptionTableModel(captionString);
			tblCaption.setModel(tblCaptionModel);
			
			//TableColumn newColumn = new TableColumn(captionArray.size()-1);
			//tblCaption.getColumnModel().addColumn(newColumn);
		
			for(int i=0; i< captionArray.size() ; i++)
			{
				int width = Math.round(spacing*(captionArray.get(i).getEndTime() - captionArray.get(i).getStartTime()));
				System.out.println("captions" +captionArray.get(i).getCaption());
				tblCaption.getModel().setValueAt(captionArray.get(i).getCaption(), 0,i);
				tblCaption.getColumnModel().getColumn(i).setPreferredWidth(width);
				
			}
			
			
			tblCaption.clearSelection();
			tblCaption.revalidate();
			tblCaption.repaint();
		}
	}
	
	private void btnPlusActionPerformed(ActionEvent evt) {
		System.out.println("btnPlus.actionPerformed, event="+evt);
		int [] selectedCells = tblCaption.getSelectedColumns();
		int selectedColumnCount = tblCaption.getSelectedColumnCount();
		boolean consecutiveColumns= true;
		tblCaption.clearSelection();
		
		for(int i=0 ; i < selectedColumnCount-1 ; i++)
		{
		   int currentColumn = selectedCells[i];
		   int nextColumn = selectedCells[i+1];
		   
		   if(nextColumn == (currentColumn+1))
		   {
			   consecutiveColumns = true;
		   }
		   else
		   {
			   consecutiveColumns = false ;
			  break;
		   }
		}
		
		System.out.println("Merge Allowed ="+ consecutiveColumns);
		
		if(consecutiveColumns && (selectedColumnCount >1))
		{
			int newStartTime = captionArray.get(selectedCells[0]).getStartTime();
			int newEndTime = captionArray.get(selectedCells[selectedColumnCount-1]).getEndTime();
			String newCaption = captionArray.get(selectedCells[0]).getCaption();
			
			captionArray.get(selectedCells[0]).setStartTime(newStartTime);
			captionArray.get(selectedCells[0]).setEndTime(newEndTime);
			
			
			
			for(int i = 0 ; i < (selectedColumnCount -1) ; i++)
			{
				int selectedCell = selectedCells[i]-i;
				newCaption = newCaption +  captionArray.get(selectedCell +1).getCaption();
				captionArray.remove(selectedCell +1);
				tblCaption.getColumnModel().removeColumn(tblCaption.getColumnModel().getColumn(selectedCell +1));
			}
			
			captionArray.get(selectedCells[0]).setCaption(newCaption);
			tblCaption.getModel().setValueAt(captionArray.get(selectedCells[0]).getCaption(),0,selectedCells[0]);
			
			ArrayList<String> captionString = new ArrayList<String>();
			for(int i=0; i< captionArray.size() ; i++)
			{
				captionString.add(captionArray.get(i).getCaption());
			}
		
			TableModel tblCaptionModel = new CaptionTableModel(captionString);
			tblCaption.setModel(tblCaptionModel);
			
			for(int i=0 ; i < captionArray.size();i++)
			{
				int width = Math.round(spacing*(captionArray.get(i).getEndTime() - captionArray.get(i).getStartTime()));
				tblCaption.getColumnModel().getColumn(i).setPreferredWidth(width);
			}
			
			//int width = Math.round(spacing*(captionArray.get(selectedCells[0]).getEndTime() - captionArray.get(selectedCells[0]).getStartTime()));
			//tblCaption.getColumnModel().getColumn(selectedCells[0]).setPreferredWidth(width);
			

			tblCaption.revalidate();
			tblCaption.repaint();
			
			
		}
	}
	
	private void movItemActionPerformed(ActionEvent evt) {
		System.out.println("movItem.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(movItem);
		
	}
	
	private void aviItemActionPerformed(ActionEvent evt) {
		System.out.println("aviItem.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(aviItem);
		
	}
	
	private void movItemPropertyChange(PropertyChangeEvent evt) {
		System.out.println("movItem.propertyChange, event="+evt);
		if(!evt.getPropertyName().equals("ancestor") && (audioPath != null) )
		{
			System.out.println("Property name" +evt.getPropertyName());
			String video = "video.avi";
			ImagesToVideo iToVideo = new ImagesToVideo(video);
			iToVideo.createVideo(imageArray,video);
			String savingPath = evt.getPropertyName()+".mov";
		
			if(savingPath != null)
			{
				String command = new String("ffmpeg -i "+video+" -i \""+audioPath+"\" -acodec copy -vcodec copy \""+savingPath +"\"");
				System.out.println(command);
				try {
					Process p = Runtime.getRuntime().exec(command);
				} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		}	
	
	}
	
	private void aviItemPropertyChange(PropertyChangeEvent evt) {
		if(!evt.getPropertyName().equals("ancestor")  && (audioPath != null))
		{
			System.out.println("aviItem.propertyChange, event="+evt);
			String video = "video.avi";
			ImagesToVideo iToVideo = new ImagesToVideo(video);
			iToVideo.createVideo(imageArray,video);
			String savingPath = evt.getPropertyName()+".avi";
		
			if(savingPath != null)
			{
				String command = new String("ffmpeg -i "+video+" -i \""+audioPath+"\" -acodec copy -vcodec copy \""+savingPath +"\"");
				System.out.println(command);
				try {
					Process p = Runtime.getRuntime().exec(command);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	private void zoomAudioTimeLine(int zoomFactor)
	{
		
		int newSliderWidth = (zoomFactor)*(sliderWidth);
	
		slider.setPreferredSize(new Dimension(newSliderWidth,slider.getHeight()));
		slider.setMinimumSize(new Dimension(newSliderWidth,slider.getHeight()));
		slider.setMaximumSize(new Dimension(newSliderWidth,slider.getHeight()));
		slider.resize(new Dimension(newSliderWidth,slider.getHeight()));
		
	}
	
	private void zoomImageTimeLine(int zoomFactor)
	{
		spacing = (float)slider.getWidth()/slider.getMaximum();
		//float newSpacing = spacing * zoomFactor;	
		
		for(int i= 0 ; i < imageArray.size() ; i++)
		{
			tblImage.getColumnModel().getColumn(i).setPreferredWidth(Math.round(spacing*(imageArray.get(i).getEndTime()-imageArray.get(i).getStartTime())));
			
		}
		tblImage.doLayout();
	}
	
	private void zoomCaptionTimeLine()
	{
		spacing = (float)slider.getWidth()/slider.getMaximum();	
		
		for(int i= 0 ; i < captionArray.size() ; i++)
		{
			tblCaption.getColumnModel().getColumn(i).setPreferredWidth(Math.round(spacing*(captionArray.get(i).getEndTime()-captionArray.get(i).getStartTime())));
		}
		
	}
	
	private void btnZoomInActionPerformed(ActionEvent evt) {
		System.out.println("btnZoomIn.actionPerformed, event="+evt);
		zoomingFactor = zoomingFactor+1;
		
		zoomAudioTimeLine(zoomingFactor);
		zoomImageTimeLine(zoomingFactor);
		zoomCaptionTimeLine();
		
	}
	
	private void btnZoomOutActionPerformed(ActionEvent evt) {
		System.out.println("btnZoomOut.actionPerformed, event="+evt);
		
		if(zoomingFactor > 1)
		{
			zoomingFactor = zoomingFactor -1;
			zoomAudioTimeLine(zoomingFactor);
			zoomImageTimeLine(zoomingFactor);
			zoomCaptionTimeLine();
		}
		
	}

}
