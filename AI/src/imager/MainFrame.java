package imager;
import com.aetrion.flickr.FlickrException;
import com.aetrion.flickr.photos.Photo;
import com.aetrion.flickr.photos.PhotoList;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
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
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




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
	private JButton btnFlickrImg3;
	private JButton btnFlickrImg2;
	private JButton btnFlickrImg1;
	private JRadioButtonMenuItem radioBtnNonCommercial;
	private JRadioButtonMenuItem radioBtnShareAlike;
	private JCheckBoxMenuItem jCheckBoxMenuItem1;
	private JButton btnMoreMyFlickr;
	private JLabel lblInstructions;
	private JLabel lblStatus;
	private JButton jButton2;
	private JLabel lblWait2;
	private JTable tblMyFlickrImages;
	private JScrollPane myFlickrScroll;
	private JButton btnConfigureFlickr;
	private JButton btnChangeImageDisk;
	private JLabel lblPreviewDisk;
	private JButton btnUrlCheck;
	private JButton btnBrowseDisk;
	private JTextField txtUrlPath;
	private JTextField txtImageDiskPath;
	private JLabel lblAddfromUrl;
	private JButton btnChangeImage;
	private JButton btnLoadImages;
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
	private JLabel lblAddTags;
	private JTextField txtTag;
	private JTable tblTags;
	private JScrollPane scrollTags;
	private JButton btnAddTags;
	private JLabel lblTags;

	private JButton btnFlickrSearch;
	private JTextField txtFlickr;
	private JTabbedPane jTabbedPane1;
	private JButton btnZoomOut;
	private JButton btnZoomIn;
	private JMenuItem movItem;
	private JMenuItem aviItem;
	private JMenu expVideoMenu;
	private JSeparator jSeparator1;
	private JMenuItem newProjItem;
	private JMenu configerLicenseMenu;
	private JMenuItem saveProjMenu;
	private JMenuItem projOpenMenu;
	private JMenu helpMenu;
	private JMenu jMenu1;
	private JMenu editMenu;
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
	private JLabel lblWait;
	private JLabel lblAddFromDisk;
	private ArrayList<ImageData> imageArray;
	private ArrayList<CaptionData> captionArray;
	private ArrayList<TagData> tagArray;
	private ArrayList<String> tagStringsArray ;
	private ArrayList<TagImageContainer> tagImageContainerList;
	private PhotoList photoList;
	//private ArrayList<Integer> missingURLS;
	private ArrayList<MyFlickrImage> myFlickrImageList;
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
	private TableModel tblFlickrImagesModel;
	private TableModel tblMyFlickrImagesModel;
	private Image imageFromDisk;
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
	TableModel tblTagsModel;
	int moreCount;
	int myFlickrMoreCount;
	boolean nonCommercial;
	boolean shareAlike;
	int selectedLabel;
	

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
				lblInstructions = new JLabel();
				getContentPane().add(lblInstructions, new AnchorConstraint(45, 608, 533, 51, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				lblInstructions.setPreferredSize(new java.awt.Dimension(492, 352));
				lblInstructions.setDoubleBuffered(true);
				lblInstructions.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/instructions_lbl.jpg")));
				lblInstructions.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

			}
			{
				btnLoadImages = new JButton();
				getContentPane().add(btnLoadImages, new AnchorConstraint(745, 82, 776, 57, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnLoadImages.setPreferredSize(new java.awt.Dimension(22, 22));
				btnLoadImages.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/flickr.png")));
				btnLoadImages.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							try {
								btnLoadImagesActionPerformed(evt);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (SAXException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FlickrException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			{
				lblAddTags = new JLabel();
				getContentPane().add(lblAddTags, new AnchorConstraint(953, 172, 979, 86, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				lblAddTags.setText("Add Tags");
				lblAddTags.setPreferredSize(new java.awt.Dimension(76, 19));
			}
			{
				txtTag = new JTextField();
				getContentPane().add(txtTag, new AnchorConstraint(947, 422, 979, 155, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtTag.setPreferredSize(new java.awt.Dimension(236, 23));
				txtTag.setSelectionColor(new java.awt.Color(49,106,196));
				txtTag.setSelectedTextColor(new java.awt.Color(255,255,255));
				txtTag.addFocusListener(new FocusAdapter() {
					public void focusLost(FocusEvent evt) {
						txtTagFocusLost(evt);
					}
				});
				txtTag.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent evt) {
						txtTagKeyTyped(evt);
					}
				});
			}
			{
				lblTags = new JLabel();
				getContentPane().add(lblTags, new AnchorConstraint(800, 55, 819, 7, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				lblTags.setText("Tags");
				lblTags.setPreferredSize(new java.awt.Dimension(43, 13));
			}
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, new AnchorConstraint(22, 611, 561, 22, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTabbedPane1.setPreferredSize(new java.awt.Dimension(521, 388));
				jTabbedPane1.setVisible(false);
				JPanel flickrPannel = new JPanel();
				AnchorLayout flickrPannelLayout = new AnchorLayout();
				flickrPannel.setLayout(flickrPannelLayout);
				jTabbedPane1.addTab("Images from Flickr", flickrPannel);
				flickrPannel.setPreferredSize(new java.awt.Dimension(516, 360));
				{
					btnFlickrImg3 = new JButton();
					flickrPannel.add(btnFlickrImg3, new AnchorConstraint(161, 942, 409, 710, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnFlickrImg3.setPreferredSize(new java.awt.Dimension(120, 90));
					btnFlickrImg3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnFlickrImg3ActionPerformed(evt);
						}
					});
				}
				{
					btnFlickrImg2 = new JButton();
					flickrPannel.add(btnFlickrImg2, new AnchorConstraint(161, 613, 409, 380, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnFlickrImg2.setPreferredSize(new java.awt.Dimension(120, 90));
					btnFlickrImg2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnFlickrImg2ActionPerformed(evt);
						}
					});
				}
				{
					btnFlickrImg1 = new JButton();
					flickrPannel.add(btnFlickrImg1, new AnchorConstraint(161, 280, 409, 47, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnFlickrImg1.setPreferredSize(new java.awt.Dimension(120, 90));
					btnFlickrImg1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnFlickrImg1ActionPerformed(evt);
						}
					});
				}
				{
					lblWait = new JLabel();
					lblWait.setVisible(false);
					flickrPannel.add(lblWait, new AnchorConstraint(896, 975, 987, 913, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					lblWait.setPreferredSize(new java.awt.Dimension(32, 33));
					lblWait.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/wait.gif")));
				}
				{
					btnChangeImage = new JButton();
					flickrPannel.add(btnChangeImage, new AnchorConstraint(913, 192, 971, 24, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnChangeImage.setText("Change Image");
					btnChangeImage.setPreferredSize(new java.awt.Dimension(87, 21));
					btnChangeImage.setVisible(false);
					btnChangeImage.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnChangeImageActionPerformed(evt);
						}
					});
				}
				{
					btnFlickrSearch = new JButton();
					flickrPannel.add(btnFlickrSearch, new AnchorConstraint(27, 975, 93, 799, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnFlickrSearch.setText("More");
					btnFlickrSearch.setPreferredSize(new java.awt.Dimension(88, 23));
					btnFlickrSearch.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							try {
								btnFlickrSearchActionPerformed(evt);
							} catch (SAXException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (FlickrException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				}
				{
					txtFlickr = new JTextField();
					flickrPannel.add(txtFlickr, new AnchorConstraint(30, 789, 84, 349, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					txtFlickr.setPreferredSize(new java.awt.Dimension(220, 19));
				}
				JPanel diskPannel = new JPanel();
				AnchorLayout diskPannelLayout = new AnchorLayout();
				diskPannel.setLayout(diskPannelLayout);
				jTabbedPane1.addTab("Add From Your Disk", diskPannel);
				{
					btnChangeImageDisk = new JButton();
					diskPannel.add(btnChangeImageDisk, new AnchorConstraint(913, 194, 971, 24, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnChangeImageDisk.setText("Change Image");
					btnChangeImageDisk.setPreferredSize(new java.awt.Dimension(88, 21));
					btnChangeImageDisk.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnChangeImageDiskActionPerformed(evt);
						}
					});
				}
				{
					lblPreviewDisk = new JLabel();
					diskPannel.add(lblPreviewDisk, new AnchorConstraint(304, 973, 973, 365, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					lblPreviewDisk.setPreferredSize(new java.awt.Dimension(314, 243));
				}
				{
					btnUrlCheck = new JButton();
					diskPannel.add(btnUrlCheck, new AnchorConstraint(158, 979, 216, 814, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnUrlCheck.setText("Check");
					btnUrlCheck.setPreferredSize(new java.awt.Dimension(85, 21));
					btnUrlCheck.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnUrlCheckActionPerformed(evt);
						}
					});
				}
				{
					btnBrowseDisk = new JButton();
					diskPannel.add(btnBrowseDisk, new AnchorConstraint(48, 979, 106, 814, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnBrowseDisk.setText("Browse");
					btnBrowseDisk.setPreferredSize(new java.awt.Dimension(85, 21));
					btnBrowseDisk.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnBrowseDiskActionPerformed(evt);
						}
					});
				}
				{
					txtUrlPath = new JTextField();
					diskPannel.add(txtUrlPath, new AnchorConstraint(158, 791, 216, 194, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					txtUrlPath.setPreferredSize(new java.awt.Dimension(308, 21));
				}
				{
					txtImageDiskPath = new JTextField();
					diskPannel.add(txtImageDiskPath, new AnchorConstraint(48, 791, 106, 194, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					txtImageDiskPath.setPreferredSize(new java.awt.Dimension(308, 21));
					txtImageDiskPath.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent evt) {
							txtImageDiskPathKeyTyped(evt);
						}
					});
					txtImageDiskPath.addPropertyChangeListener(new PropertyChangeListener() {
						public void propertyChange(PropertyChangeEvent evt) {
							txtImageDiskPathPropertyChange(evt);
						}
					});
				}
				{
					lblAddfromUrl = new JLabel();
					diskPannel.add(lblAddfromUrl, new AnchorConstraint(166, 154, 205, 24, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					lblAddfromUrl.setText("Image URL");
					lblAddfromUrl.setPreferredSize(new java.awt.Dimension(67, 14));
				}
				{
					lblAddFromDisk = new JLabel();
					diskPannel.add(lblAddFromDisk, new AnchorConstraint(56, 183, 95, 24, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					lblAddFromDisk.setText("Image Path");
					lblAddFromDisk.setPreferredSize(new java.awt.Dimension(82, 14));
				}
				{
				JPanel myFlickrPanel = new JPanel();
				AnchorLayout myFlickrPanelLayout = new AnchorLayout();
				myFlickrPanel.setLayout(myFlickrPanelLayout);
				jTabbedPane1.addTab("Add From Your Flickr", myFlickrPanel);
				myFlickrPanel.setPreferredSize(new java.awt.Dimension(516, 363));
				{
					btnMoreMyFlickr = new JButton();
					myFlickrPanel.add(btnMoreMyFlickr, new AnchorConstraint(42, 871, 100, 801, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnMoreMyFlickr.setText("More");
					btnMoreMyFlickr.setVisible(false);
					btnMoreMyFlickr.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnMoreMyFlickrActionPerformed(evt);
						}
					});
				}
				{
					lblStatus = new JLabel();
					myFlickrPanel.add(lblStatus, new AnchorConstraint(42, 956, 106, 188, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					lblStatus.setPreferredSize(new java.awt.Dimension(396, 23));
					lblStatus.setText("Click Configure to Autherize the Application access your Flickr");
				}
				{
					myFlickrScroll = new JScrollPane();
					myFlickrPanel.add(myFlickrScroll, new AnchorConstraint(122, 956, 885, 24, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					myFlickrScroll.setPreferredSize(new java.awt.Dimension(481, 277));
					{
						tblMyFlickrImagesModel =  new MyFlickrImageTableModel(); 
						tblMyFlickrImages = new JTable();
						myFlickrScroll.setViewportView(tblMyFlickrImages);
						tblMyFlickrImages.setCellSelectionEnabled(true);
						tblMyFlickrImages.setModel(tblMyFlickrImagesModel);
					}
				}
				{
					btnConfigureFlickr = new JButton();
					myFlickrPanel.add(btnConfigureFlickr, new AnchorConstraint(34, 156, 92, 41, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnConfigureFlickr.setText("Configure");
					btnConfigureFlickr.setPreferredSize(new java.awt.Dimension(59, 21));

					btnConfigureFlickr.addActionListener(new ActionListener() {
						ConfigureMyFlickr configureMyFlickr = null;
						public void actionPerformed(ActionEvent evt) {
							
							try {
								if(btnConfigureFlickr.getText().equals("Configure"))
								{
									
									lblStatus.setText("Click OK button to continue loading your Flickr images");
									btnConfigureFlickr.setText("OK");
									configureMyFlickr = new ConfigureMyFlickr();	
									
								}
								else if(btnConfigureFlickr.getText().equals("OK"))
								{
									lblStatus.setText("Please wait while we configure the Flickr access");
									if(configureMyFlickr != null)
									{
										 photoList =configureMyFlickr.btnConfigureFlickrActionPerformed(evt);	
										 if(photoList!=null){
										       //Get search result and check the size of photo result
										       
											lblWait2.setVisible(true);  
											lblStatus.setText("Please wait while loading your Flickr images");
											
											if(photoList.size()>(myFlickrMoreCount+20))
											{
												PhotoList subList = new PhotoList();
												for(int i=myFlickrMoreCount;i<(myFlickrMoreCount+20);i++)
												{
													subList.add(photoList.get(i));
												}
												
												Thread loadFlickrImages = new MyFlickrImageLoadThread(myFlickrImageList,subList,tblMyFlickrImages,tblMyFlickrImagesModel,lblWait2,lblStatus,myFlickrMoreCount);
											    loadFlickrImages.start();
											    btnMoreMyFlickr.setVisible(true);
											    myFlickrMoreCount =myFlickrMoreCount+20;
											}
											else
											{
												Thread loadFlickrImages = new MyFlickrImageLoadThread(myFlickrImageList,photoList,tblMyFlickrImages,tblMyFlickrImagesModel,lblWait2,lblStatus,myFlickrMoreCount);
											    loadFlickrImages.start();
											}
											
											
									    }
										 else
										 {
											 lblStatus.setText("You have not autherised AudioImager to Access your Flickr.Click Configure to Autherize.");
											
										 }
										 

										btnConfigureFlickr.setText("Configure");	
									}
									
									
								}
								
								
							} catch (ParserConfigurationException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							} catch (SAXException e) {
								e.printStackTrace();
							} catch (FlickrException e) {
								e.printStackTrace();
							} catch (URISyntaxException e) {
								e.printStackTrace();
							}
							
							
						}
					});
				}
				{
					lblWait2 = new JLabel();
					myFlickrPanel.add(lblWait2, new AnchorConstraint(885, 981, 984, 915, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					lblWait2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/wait.gif")));
					lblWait2.setVisible(false);
					lblWait2.setPreferredSize(new java.awt.Dimension(34, 36));
				}
				{
					jButton2 = new JButton();
					myFlickrPanel.add(jButton2, new AnchorConstraint(929, 187, 990, 24, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton2.setText("Change Image");
					jButton2.setVisible(true);
					jButton2.setPreferredSize(new java.awt.Dimension(84, 22));
					jButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton2ActionPerformed(evt);
						}
					});
				}
				}

			}
			{
				btnZoomOut = new JButton();
				getContentPane().add(btnZoomOut, new AnchorConstraint(580, 70, 609, 41, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnZoomOut.setPreferredSize(new java.awt.Dimension(26, 26));
				btnZoomOut.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/zout.jpg")));
				btnZoomOut.setSize(26, 26);
				btnZoomOut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnZoomOutActionPerformed(evt);
					}
				});
			}
			{
				btnZoomIn = new JButton();
				getContentPane().add(btnZoomIn, new AnchorConstraint(580, 37, 609, 8, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnZoomIn.setPreferredSize(new java.awt.Dimension(26, 26));
				btnZoomIn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("icons/zin.jpg")));
				btnZoomIn.setSize(26, 26);
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
						newProjItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								newProjItemActionPerformed(evt);
							}
						});
					}
					{
						projOpenMenu = new JMenuItem();
						jMenu1.add(projOpenMenu);
						projOpenMenu.setText("Open Project");
						projOpenMenu.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent evt) {
								projOpenMenuPropertyChange(evt);
							}
						});
						projOpenMenu.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								projOpenMenuActionPerformed(evt);
							}
						});
					}
					{
						saveProjMenu = new JMenuItem();
						jMenu1.add(saveProjMenu);
						saveProjMenu.setText("Save Project");
						saveProjMenu.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent evt) {
								saveProjMenuPropertyChange(evt);
							}
						});
						saveProjMenu.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								saveProjMenuActionPerformed(evt);
							}
						});
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
					editMenu = new JMenu();
					jMenuBar.add(editMenu);
					editMenu.setText("Edit");
					
					configerLicenseMenu = new JMenu();
					editMenu.add(configerLicenseMenu);
					configerLicenseMenu.setText("Configure License");
					{
						radioBtnShareAlike = new JRadioButtonMenuItem();
						configerLicenseMenu.add(radioBtnShareAlike);
						radioBtnShareAlike.setText("Share Alike");
						radioBtnShareAlike.setBounds(206, 0, 75, 19);
						radioBtnShareAlike.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								radioBtnShareAlikeActionPerformed(evt);
							}
						});
					}
					{
						radioBtnNonCommercial = new JRadioButtonMenuItem();
						configerLicenseMenu.add(radioBtnNonCommercial);
						radioBtnNonCommercial.setText("Non-Commercial");
						radioBtnNonCommercial.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								radioBtnNonCommercialActionPerformed(evt);
							}
						});
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
				getContentPane().add(btnPlus, new AnchorConstraint(956, 125, 981, 82, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnPlus.setText("[+]");
				btnPlus.setPreferredSize(new java.awt.Dimension(38, 18));
				btnPlus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnPlusActionPerformed(evt);
					}
				});
			}
			{
				btnSplit = new JButton();
				getContentPane().add(btnSplit, new AnchorConstraint(956, 175, 981, 131, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnSplit.setText("]|[");
				btnSplit.setPreferredSize(new java.awt.Dimension(39, 18));
				btnSplit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSplitActionPerformed(evt);
					}
				});
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, new AnchorConstraint(956, 976, 981, 858, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
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
				getContentPane().add(txtCaptionEdit, new AnchorConstraint(954, 548, 985, 275, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtCaptionEdit.setPreferredSize(new java.awt.Dimension(241, 22));
				txtCaptionEdit.setVisible(false);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8, new AnchorConstraint(960, 279, 981, 184, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel8.setText(" Selected Text");
				jLabel8.setPreferredSize(new java.awt.Dimension(84, 15));
				jLabel8.setVisible(false);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7, new AnchorConstraint(956, 796, 981, 715, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel7.setText("End Time");
				jLabel7.setPreferredSize(new java.awt.Dimension(72, 18));
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6, new AnchorConstraint(956, 641, 981, 563, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel6.setText("Start Time");
				jLabel6.setPreferredSize(new java.awt.Dimension(69, 18));
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
				getContentPane().add(caption, new AnchorConstraint(866, 68, 884, 7, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				caption.setText("Caption");
				caption.setPreferredSize(new java.awt.Dimension(54, 13));
			}
			{
				btnCaption = new JButton();
				AnchorLayout btnCaptionLayout = new AnchorLayout();
				btnCaption.setLayout(btnCaptionLayout);
				getContentPane().add(btnCaption, new AnchorConstraint(861, 82, 891, 57, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
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
				getContentPane().add(jLabel5, new AnchorConstraint(710, 75, 734, 6, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel5.setText("Images");
				jLabel5.setPreferredSize(new java.awt.Dimension(61, 17));
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4, new AnchorConstraint(633, 66, 655, 6, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
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
				AnchorLayout btnAudioBrowseLayout = new AnchorLayout();
				btnAudioBrowse.setLayout(btnAudioBrowseLayout);
				getContentPane().add(btnAudioBrowse, new AnchorConstraint(630, 82, 660, 57, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
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
				btnAdd.setVisible(false);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, new AnchorConstraint(622, 981, 927, 86, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1Layout.rowWeights = new double[] {0.0, 0.1, 0.0, 0.0};
				jPanel1Layout.rowHeights = new int[] {50, 7, 50, 50};
				jPanel1Layout.columnWeights = new double[] {0.0, 0.1, 0.1};
				jPanel1Layout.columnWidths = new int[] {9, 7, 7};
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(791, 220));
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
						slider.setPaintLabels(true);
						
						slider.setValue(0);
						slider.setMaximum(400);
						slider.enable(false);
						
						//getContentPane().add(slider, BorderLayout.CENTER);
						slider.setPreferredSize(new java.awt.Dimension(3006, 48));
						slider.setPaintTrack(false);
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
					jPanel1.add(jScrollPane2, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jScrollPane2.setPreferredSize(new java.awt.Dimension(1136, 101));
					jScrollPane2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					jScrollPane2.remove(jScrollPane2.getVerticalScrollBar());
					jScrollPane2.remove(jScrollPane2.getHorizontalScrollBar());
					jScrollPane2.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						public void adjustmentValueChanged(AdjustmentEvent evt) {
							//horizontalScrollBarAdjustmentValueChanged(evt);
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

									tblImage.setLayout(null);
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
									tblImage.getTableHeader().setReorderingAllowed(true);
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
					jPanel1.add(scrollCaption, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					
					tblCaption = new JTable();
					scrollCaption.setViewportView(tblCaption);
					//scrollCaption.setSize(1119,30);
					//scrollCaption.setPreferredSize(new java.awt.Dimension(789, 40));
					scrollCaption.setMaximumSize(new java.awt.Dimension(789, 40));
					scrollCaption.setPreferredSize(new java.awt.Dimension(789, 52));
					scrollCaption.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					{
						scrollTags = new JScrollPane();
						jPanel1.add(scrollTags, new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						scrollTags.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						scrollTags.remove(scrollTags.getVerticalScrollBar());
						scrollTags.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
							public void adjustmentValueChanged(AdjustmentEvent evt) {
								horizontalScrollTagsAdjustmentValueChanged(evt);
							}
						});
						{
							//TableModel tblTagsModel = new TagTableModel(tagArray); 
							
							tblTags = new JTable();
							scrollTags.setViewportView(tblTags);
							//tblTags.setModel(tblTagsModel);
							tblTags.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							tblTags.getTableHeader().setReorderingAllowed(false);
							tblTags.setCellSelectionEnabled(true);
							tblTags.setRowHeight(30);
							tblTags.addPropertyChangeListener(new PropertyChangeListener() {
								public void propertyChange(PropertyChangeEvent evt) {
									tblTagsPropertyChange(evt);
								}
							});
							tblTags.addComponentListener(new ComponentAdapter() {
								public void componentResized(ComponentEvent evt) {
									tblTagsComponentResized(evt);
								}
							});

						}
					}
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
				AnchorLayout btnBrowseLayout = new AnchorLayout();
				btnBrowse.setLayout(btnBrowseLayout);
				getContentPane().add(btnBrowse, new AnchorConstraint(708, 82, 738, 57, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnBrowse.setText("+");
				btnBrowse.setPreferredSize(new java.awt.Dimension(22, 22));
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
				getContentPane().add(spinnerCaptionStartTime, new AnchorConstraint(956, 701, 981, 623, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				spinnerCaptionStartTime.setModel(spinnerCaptinEndTimeModel);
				//spinnerCaptionStartTime.setValue(0);
				spinnerCaptionStartTime.setPreferredSize(new java.awt.Dimension(69, 18));
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
				getContentPane().add(spinnerCaptionEndTime, new AnchorConstraint(956, 848, 981, 768, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				spinnerCaptionEndTime.setModel(spinnerCaptinStartTimeModel);
				//spinnerCaptionEndTime.setValue(0);
				spinnerCaptionEndTime.setPreferredSize(new java.awt.Dimension(71, 18));
				spinnerCaptionEndTime.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						spinnerCaptionEndTimeStateChanged(evt);
					}
				});
			}
			{
				btnAddTags = new JButton();
				getContentPane().add(btnAddTags, new AnchorConstraint(799, 82, 830, 57, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				AnchorLayout jButton2Layout = new AnchorLayout();
				btnAddTags.setText("+");
				btnAddTags.setLayout(null);
				btnAddTags.setPreferredSize(new java.awt.Dimension(22, 22));
				btnAddTags.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddTagsActionPerformed(evt);
					}
				});
			}
			{
				//Setting visibility
				txtCaptionEdit.setVisible(false);
				jLabel8.setVisible(false);
				jLabel6.setVisible(false);
				spinnerCaptionStartTime.setVisible(false);
				jLabel7.setVisible(false);
				spinnerCaptionEndTime.setVisible(false);
				jButton1.setVisible(false);
				btnPlus.setVisible(false);
				btnSplit.setVisible(false);
				
				txtTag.setVisible(false);
				lblAddTags.setVisible(false);
				btnLoadImages.setVisible(false);
				
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
		tagArray = new ArrayList<TagData>();
		tagStringsArray = new ArrayList<String>();
		tagImageContainerList = new ArrayList<TagImageContainer>();
		//missingURLS = new ArrayList<Integer>();
		myFlickrImageList = new ArrayList<MyFlickrImage>();
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
		moreCount=0;
		myFlickrMoreCount = 0;
		imageFromDisk = null;
		nonCommercial = false;
		shareAlike = false;
		selectedLabel = -1;
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
			ResizeImage resizeImage = new ResizeImage(240,320);
			Image image = new ImageIcon(path).getImage();
			Image scaledImage = resizeImage.resize(path);
			selectedImage = new ImageData(-1,-1,-1,path,scaledImage,null);
			ImageIcon icon = new ImageIcon(scaledImage);
			imgLabel.setIcon(icon);
			txtImageLink.setText("");
		}
		if(imageArray != null)
		{
			btnAdd.setVisible(true);
			if(imageArray.size()>0)
			{
				ImageData lastImage= (ImageData) tblImage.getValueAt(0,imageArray.size()-1);
				Number lastValue = (Number)(lastImage.getEndTime());
				Number endValue = (Number)(lastImage.getEndTime()+2);
				spinnerStartTime.setValue(lastValue);
				spinnerEndTime.setValue(endValue);
			}
			else
			{
				Number endValue = (Number)2;
				spinnerEndTime.setValue(endValue);
				
			}
		}
	}
	
	private void btnAddActionPerformed(ActionEvent evt) {
		synchronized (evt){
			btnAdd.setVisible(false);
		System.out.println("btnAdd.actionPerformed, event="+evt);
		Number startvalue = (Number) spinnerStartTime.getValue();
		Number endValue = (Number) spinnerEndTime.getValue();
		startTime = startvalue.intValue();
		endTime = endValue.intValue();
		System.out.println("Image array size"+imageArray.size()+"path ="+ path );
		ImageData idata = new ImageData(startTime,endTime,imageArray.size(),path,selectedImage.getImage(),null);
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
		
			 //Adding a tag to the tags array with the tag string = "No Tag"
			 TagData tag = new TagData(tagArray.size(),startTime,endTime,"No Tag");
			 				
			 tagArray.add(tag);
			 tagStringsArray.add("No Tag");
			 tblTagsModel = new TagTableModel(tagStringsArray);
			 tblTags.setModel(tblTagsModel);
			 //tblTags.getColumnModel().getColumn(imageArray.size()-1).setPreferredWidth(Math.round(spacing*(endTime - startTime)));
			 
			 for(int i= 0 ; i < tagArray.size(); i++)
				{
					tblTags.getColumnModel().getColumn(i).setPreferredWidth(Math.round(spacing*(tagArray.get(i).getEndTime() - tagArray.get(i).startTime)));
				}
			 
			 // Adding an Item to tagImageContainerList with urlThumb and urlOriginal set to null
			 
			 TagImageContainer tagContainer = new TagImageContainer(tagArray.size()-1,null,null);
				tagImageContainerList.add(tagContainer);
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
				txtTag.setVisible(true);
				lblAddTags.setVisible(true);
				btnLoadImages.setVisible(true);
				
				txtCaptionEdit.setVisible(false);
				jLabel8.setVisible(false);
				jLabel6.setVisible(false);
				spinnerCaptionStartTime.setVisible(false);
				jLabel7.setVisible(false);
				spinnerCaptionEndTime.setVisible(false);
				jButton1.setVisible(false);
				btnPlus.setVisible(false);
				btnSplit.setVisible(false);
				
				
				
				
			
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
		scrollSlider.getHorizontalScrollBar().setValue(scrollCaption.getHorizontalScrollBar().getValue());
		scrollTags.getHorizontalScrollBar().setValue(scrollCaption.getHorizontalScrollBar().getValue());
	}
	
	private void horizontalScrollTagsAdjustmentValueChanged(AdjustmentEvent evt){
		jScrollPane2.getHorizontalScrollBar().setValue(scrollTags.getHorizontalScrollBar().getValue());
		scrollSlider.getHorizontalScrollBar().setValue(scrollTags.getHorizontalScrollBar().getValue());
		
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
			
			ArrayList<Image> thumbImages = tagImageContainerList.get(selecteColumn).getThumbnaiImages();
			Image thumbImage;
			
			
			tblFlickrImagesModel = new FlickrImageTableModel();
			//tblFlickrImages.setModel(tblFlickrImagesModel);
			txtFlickr.setText(tagArray.get(selecteColumn).getTag());
			lblInstructions.setVisible(false);
			jTabbedPane1.setVisible(true);
			
			if(thumbImages != null)
			{
				btnChangeImage.setVisible(true);	
			//for(int i=0; i < (thumbImages.size()/4)*4 ; i++)
				if(thumbImages.size()==0)
				{
					btnFlickrImg1.setIcon(null);
					btnFlickrImg1.repaint();
					btnFlickrImg2.setIcon(null);
					btnFlickrImg2.repaint();
					btnFlickrImg3.setIcon(null);
					btnFlickrImg3.repaint();
				}
				for(int i=0; i < thumbImages.size() ; i++)
			{
				thumbImage = thumbImages.get(i);
				//ImageIcon UrlImgIcon = new ImageIcon(url,"Testing");
	
				{
					if(i==0)
					{
						
						btnFlickrImg1.setIcon(new ImageIcon(thumbImage));	
						btnFlickrImg2.setIcon(null);
						btnFlickrImg3.setIcon(null);
					}
					else if(i==1)
					{
						
						btnFlickrImg2.setIcon(new ImageIcon(thumbImage));
						btnFlickrImg2.repaint();
						btnFlickrImg3.setIcon(null);
					}
					else if(i==2)
					{
						
						btnFlickrImg3.setIcon(new ImageIcon(thumbImage));
						btnFlickrImg3.repaint();
					}
					//TableCellRenderer flickrCellRenderer = new FlickrImgTableCellRenderer();
					//tblFlickrImages.getColumnModel().getColumn(i%4).setCellRenderer(flickrCellRenderer);

					//tblFlickrImagesModel.setValueAt(thumbImage,(int)Math.ceil((double)(i+1)/4), i%4 );
					//tblFlickrImages.getColumnModel().getColumn(i%4).setPreferredWidth(120);
					//tblFlickrImages.setRowHeight(90);
			
				}
				
			}
			}
			else
			{
				btnFlickrImg1.setIcon(null);
				btnFlickrImg1.repaint();
				btnFlickrImg2.setIcon(null);
				btnFlickrImg2.repaint();
				btnFlickrImg3.setIcon(null);
				btnFlickrImg3.repaint();
			}
			
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
		
				if(startTime < (image1.getStartTime()+2))
				{
					startTime = image1.getStartTime()+2;
					spinnerStartTime.setValue((Number)startTime);
				}
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
			
			if(startTime < selectedImage.getStartTime() )
			{	
			
				if(startTime < (image1.getStartTime()+2))
				{
					startTime = image1.getStartTime()+2;
					spinnerStartTime.setValue((Number)startTime);
				}
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
		
		if((startTime > (((Number)spinnerEndTime.getValue()).intValue()-2)))
		{
			
			spinnerEndTime.setValue((Number)(((Number)spinnerStartTime.getValue()).intValue()+2));
		}
		
		
	}
	
	private void spinnerEndTimeStateChanged(ChangeEvent evt) {
		System.out.println("spinnerEndTime.stateChanged, event="+evt);
		Number endValue = (Number) spinnerEndTime.getValue();
		int endTime = endValue.intValue();
		
		if(endTime < (((Number)spinnerStartTime.getValue()).intValue()+2))
		{
			endTime = (((Number)spinnerStartTime.getValue()).intValue()+2);
			spinnerEndTime.setValue((Number)endTime);
		}
		
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
			setupAudio();
			
		}
		
	}
	
	private void setupAudio()
	{
		//resetting audio , image and caption timelines
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
				
			zoomImageTimeLine();
			zoomCaptionTimeLine();
			zoomTagTimeLine();
		}
		else
		{
			slider.setMaximum(400);
			slider.setPreferredSize(new Dimension(sliderWidth,slider.getHeight()));
			slider.setMinimumSize(new Dimension(sliderWidth,slider.getHeight()));
			slider.setMaximumSize(new Dimension(sliderWidth,slider.getHeight()));
			slider.resize(new Dimension(sliderWidth,slider.getHeight()));
			
			zoomImageTimeLine();
			zoomCaptionTimeLine();
			zoomTagTimeLine();
		}
		tickWeight = (float)noOfAudioSamples/audioDuration;
		System.out.println(tickWeight);
		audioDecoder.slider = slider;
		slider.enable(true);
		slider.repaint();
	}
	private void sliderMousePressed(MouseEvent evt) {
		System.out.println("slider.mousePressed, event="+evt);
		if(audioPlayerThread != null)
		{
			audioPlayerThread.stop();
		}
	}
	
	private void sliderStateChanged(ChangeEvent evt) {
		//System.out.println("slider.stateChanged, event="+evt);
		sliderPosition = slider.getValue();
		//slider.setToolTipText("The value is "+ sliderPosition);
		//scrollSlider.getHorizontalScrollBar().setValue(sliderPosition);
		//System.out.println("Maximum horizontal scroll bar slider "+scrollSlider.getHorizontalScrollBar().getMaximum());
		if(imageArray != null)
		{
			
			ImageData currentImage =  findImage(sliderPosition);
			if(currentImage != null)
			{	
				if(sliderPosition == 0)
				{
					Image image = currentImage.getImage();
					ImageIcon icon = new ImageIcon(image);
					imgLabel.setIcon(icon);
					selectedImage = currentImage;
				}
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
		
		txtTag.setVisible(false);
		lblAddTags.setVisible(false);
		//btnLoadImages.setVisible(false);
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
				float width;
				if(audioDuration > 0 && (tblImage.getWidth()>0))
				{
					
					System.out.println("Audio Duration =" + audioDuration);
					System.out.println("Spacing =" + spacing);
					width = (float) ((audioDuration*spacing)/caption.length());
				}
				else
				{
					 width = (float) (slider.getWidth()/caption.length());
				}
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
		//for (int i=0; i< imageArray.size() ; i++)
		for (int i=0; i< tblImage.getColumnCount() ; i++)
		{
			
			//recalculate the new start times and end times of images
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
			
			// reset the star times and end times of tags using the start times and end times of images
			System.out.println("came here");
			tagArray.get(i).setStartTime(imageArray.get(i).getStartTime());
			tagArray.get(i).setEndTime(imageArray.get(i).getEndTime());
			tblTags.getColumnModel().getColumn(i).setPreferredWidth(tblImage.getColumnModel().getColumn(i).getWidth());
		
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
		
			// remove the respective column from the tagArray
			tagArray.remove(columnId);
			tagImageContainerList.remove(columnId);
			
			for (int i=columnId;i<imageArray.size()-1;i++){
                imageArray.set(i, imageArray.get(i+1));
                tblImage.setValueAt(imageArray.get(i+1), 0,i);
              
            }
						
			int newcolumnId = imageArray.size()-1;
            column = tblImage.getColumnModel().getColumn(newcolumnId);
            imageArray.remove(newcolumnId);
            tblImage.getColumnModel().removeColumn(column);
         			
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
					tblImage.setValueAt(imageArray.get(i), 0,i);
				}
			}
			
            //reset the start times and endtimes of the tag array
            tagStringsArray.clear();
			for(int i= 0 ; i < imageArray.size(); i++)
			{
				tagArray.get(i).setStartTime(imageArray.get(i).getStartTime());
				tagArray.get(i).setEndTime(imageArray.get(i).getEndTime());
				tagStringsArray.add(tagArray.get(i).getTag());
			}
			//reset the tblTags table model
			
			tblTagsModel = new TagTableModel(tagStringsArray);
			tblTags.setModel(tblTagsModel);
			
			
			//reset the width of the tblTags 
			for(int i=0 ; i < imageArray.size();i++)
			{
				tblTags.getColumnModel().getColumn(i).setPreferredWidth(tblImage.getColumnModel().getColumn(i).getWidth());
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
				TagData tagFromMoved = tagArray.get(columnMovedFromPosition);
				TagImageContainer tagImageContainerFromMoved = tagImageContainerList.get(columnMovedFromPosition);
				for (int i = columnMovedFromPosition ; i >=columnMovedPosition  ;i--)
				{
					
					if(i== columnMovedPosition)
					{
						imageArray.set(i,dataFromMoved);
						tagArray.set(i,tagFromMoved);
						tagImageContainerList.set(i,tagImageContainerFromMoved);
						//tblImage.setValueAt(dataFromMoved, 0, i);
					}
					else
					{
						imageArray.set(i,imageArray.get(i-1));
						tagArray.set(i, tagArray.get(i-1));
						tagImageContainerList.set(i, tagImageContainerList.get(i-1));
						//tblImage.setValueAt(imageArray.get(i-1), 0, i);
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
						
						tagArray.get(i).setStartTime(newStart);
						tagArray.get(i).setEndTime(newStart+imageWidth);
						
									
						
						
					}
					else if(i == 0)
					{
						imageArray.get(i).setStartTime(0);
						imageArray.get(i).setEndTime(imageWidth);
						imageArray.get(i).setIndex(0);		
						
						tagArray.get(i).setStartTime(0);
						tagArray.get(i).setEndTime(imageWidth);
									
					}
					
					
					//TableCellRenderer mycellrenderer = new MyTableCellRenderer();
					//tblImage.getColumnModel().getColumn(i).setCellRenderer(mycellrenderer);
					//tblImage.setValueAt(imageArray.get(i), 0,i);
					
					//tblImage.getModel().setValueAt(imageArray.get(i),0 , i);
				}
			}
			ArrayList<String> tagStrings = new ArrayList<String>();
			
			tblImageModel = new ImageTableModel();
			tblImage.setModel(tblImageModel);
			for(int j= 0 ; j< imageArray.size() ; j++)
			{
				int width = Math.round(spacing*(imageArray.get(j).getEndTime() - imageArray.get(j).getStartTime()));
				TableCellRenderer mycellrenderer = new MyTableCellRenderer();
				tblImage.getColumnModel().addColumn(new TableColumn(j,width));
				tblImage.getColumnModel().getColumn(j).setCellRenderer(mycellrenderer);
				tblImage.setValueAt(imageArray.get(j), 0,j);
				
				tagStrings.add(tagArray.get(j).getTag());
			}
			
			tblTagsModel = new TagTableModel(tagStrings);
			tblTags.setModel(tblTagsModel);
			
			for(int j=0;j<tagArray.size();j++)
			{
				tblTags.getColumnModel().getColumn(j).setPreferredWidth(tblImage.getColumnModel().getColumn(j).getWidth());
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
		txtCaptionEdit.setVisible(true);
		jLabel8.setVisible(true);
		jLabel6.setVisible(true);
		spinnerCaptionStartTime.setVisible(true);
		jLabel7.setVisible(true);
		spinnerCaptionEndTime.setVisible(true);
		jButton1.setVisible(true);
		btnPlus.setVisible(true);
		btnSplit.setVisible(true);
		
		txtTag.setVisible(false);
		lblAddTags.setVisible(false);
		//btnLoadImages.setVisible(false);
				
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
		FileChooser fc = new FileChooser(movItem,"CREATE_VIDEO");
		
	}
	
	private void aviItemActionPerformed(ActionEvent evt) {
		System.out.println("aviItem.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(aviItem,"CREATE_VIDEO");
		
	}
	
	private void movItemPropertyChange(PropertyChangeEvent evt)  {
		System.out.println("movItem.propertyChange, event="+evt);
		//make sure it's an actual user click
		if(!evt.getPropertyName().equals("ancestor") && (audioPath != null) )
		{
			System.out.println("Property name" +evt.getPropertyName());
			String video = "video.avi";
			ImagesToVideo iToVideo = new ImagesToVideo(video);
				
			ArrayList<AttributionData> attributions = new ArrayList<AttributionData>();
			
			for(int i = 0 ; i < imageArray.size() ; i++)
			{
				attributions.add(imageArray.get(i).getAttribution());
				/*if(!owners.contains(imageArray.get(i).getAttribution().getOwnerName()))
				{
					owners.add(imageArray.get(i).getAttribution().getOwnerName());
					
				}*/
				
			}
			
			//Divide Attribution by license
			ArrayList<AttributionData> flickrCommonsAttributions = new ArrayList<AttributionData>();
			ArrayList<AttributionData> flickrNonCommercialAttributions = new ArrayList<AttributionData>();
			ArrayList<AttributionData> flickrShareAlikeAttributions = new ArrayList<AttributionData>();
			ArrayList<AttributionData> flickrAttributions = new ArrayList<AttributionData>();
			
			for(int i=0; i< attributions.size();i++)
			{
				if(attributions.get(i).getLicense()==7)
				{
					flickrCommonsAttributions.add(attributions.get(i));
				}
				else if(attributions.get(i).getLicense() == 2)
				{
					flickrNonCommercialAttributions.add(attributions.get(i));
				}
				else if (attributions.get(i).getLicense() == 5)
				{
					flickrShareAlikeAttributions.add(attributions.get(i));
				}
				else if(attributions.get(i).getLicense() == 4)
				{
					flickrAttributions.add(attributions.get(i));
				}
			}
			
			//Adding attribution
			int numberOfAttributionImages =0;
			for(int i=0;i<4;i++)
			{
				ArrayList<AttributionData> att=null;
				if(i==0)
				{
					att = flickrAttributions;
				}
				else if(i==1)
				{
					att = flickrShareAlikeAttributions;
				}
				else if(i==2)
				{
					att = flickrNonCommercialAttributions ;
				}
				else if(i ==3)
				{
					att = flickrCommonsAttributions;
				}
				
				for(int x=0 ; x < Math.ceil((float)att.size()/4)*4;x=x+4)
				{
					numberOfAttributionImages++;
					ArrayList<AttributionData> attSub = new ArrayList<AttributionData>();
					int limit = x+4;
					for(int j=x ; j <limit ; j++)
					{
						if(j < att.size())
						{
						 	attSub.add(att.get(j));
							
						}
					}
					
					CCAttribution attribution = new CCAttribution(attSub,this);
					Image image =attribution.createAttributionImage();
					ImageData imgData = new ImageData(imageArray.get(imageArray.size()-1).getEndTime(),imageArray.get(imageArray.size()-1).getEndTime()+5,imageArray.size(),null,image,null);
					imageArray.add(imgData);
									
				}	
			}
			
			
			iToVideo.createVideo(imageArray,video);
			
			//Make a folder to store the video and the subtitle file
			
			File videoOutputFolder = new File(evt.getPropertyName());
			try{
				if(videoOutputFolder.mkdir())
					System.out.println("Directory Created");
				else
					System.out.println("Directory is not created");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			String savingPath = evt.getPropertyName()+"\\"+videoOutputFolder.getName()+".mov";
			
			
		
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
			
			//remove attribution images from the ImageArray otherwise there will be a mismatch between imageArray and TblImage
			for(int i=0;i<numberOfAttributionImages;i++)
			{
				imageArray.remove(imageArray.size()-1);
			}
			
			//creating the subtitle.srt file to save subtitles
			
			File srtFile = new File(evt.getPropertyName()+"\\"+videoOutputFolder.getName()+".SRT");
			try {
				srtFile.createNewFile();
				Writer output = new BufferedWriter(new FileWriter(srtFile));
				
				for(int i=0;i< captionArray.size();i++)
				{
					output.write("\n");
					output.write(Integer.toString(i));
					output.write("\n");
					output.write(secondsToHHMMSSMS(captionArray.get(i).getStartTime())+"-->" + secondsToHHMMSSMS(captionArray.get(i).getEndTime()));
					output.write("\n");
					output.write(captionArray.get(i).getCaption());
					output.write("\n");
								
				}
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}	
	
	}
	
	private void aviItemPropertyChange(PropertyChangeEvent evt) {
		if(!evt.getPropertyName().equals("ancestor")  && (audioPath != null))
		{
			System.out.println("aviItem.propertyChange, event="+evt);
			String video = "video.avi";
			ImagesToVideo iToVideo = new ImagesToVideo(video);
			//ArrayList<String> owners = new ArrayList<String>();
			ArrayList<AttributionData> attributions = new ArrayList<AttributionData>();
			
			for(int i = 0 ; i < imageArray.size() ; i++)
			{
				attributions.add(imageArray.get(i).getAttribution());
				/*if(!owners.contains(imageArray.get(i).getAttribution().getOwnerName()))
				{
					owners.add(imageArray.get(i).getAttribution().getOwnerName());
					
				}*/
				
			}
			
			//Divide Attribution by license
			ArrayList<AttributionData> flickrCommonsAttributions = new ArrayList<AttributionData>();
			ArrayList<AttributionData> flickrNonCommercialAttributions = new ArrayList<AttributionData>();
			ArrayList<AttributionData> flickrShareAlikeAttributions = new ArrayList<AttributionData>();
			ArrayList<AttributionData> flickrAttributions = new ArrayList<AttributionData>();
			
			for(int i=0; i< attributions.size();i++)
			{
				if(attributions.get(i).getLicense()==7)
				{
					flickrCommonsAttributions.add(attributions.get(i));
				}
				else if(attributions.get(i).getLicense() == 2)
				{
					flickrNonCommercialAttributions.add(attributions.get(i));
				}
				else if (attributions.get(i).getLicense() == 5)
				{
					flickrShareAlikeAttributions.add(attributions.get(i));
				}
				else if(attributions.get(i).getLicense() == 4)
				{
					flickrAttributions.add(attributions.get(i));
				}
			}
			
			//Adding attribution
			int numberOfAttributionImages =0;
			for(int i=0;i<4;i++)
			{
				ArrayList<AttributionData> att=null;
				if(i==0)
				{
					att = flickrAttributions;
				}
				else if(i==1)
				{
					att = flickrShareAlikeAttributions;
				}
				else if(i==2)
				{
					att = flickrNonCommercialAttributions ;
				}
				else if(i ==3)
				{
					att = flickrCommonsAttributions;
				}
				
				for(int x=0 ; x < Math.ceil((float)att.size()/4)*4;x=x+4)
				{
					numberOfAttributionImages++;
					ArrayList<AttributionData> attSub = new ArrayList<AttributionData>();
					int limit = x+4;
					for(int j=x ; j <limit ; j++)
					{
						if(j < att.size())
						{
						 	attSub.add(att.get(j));
							
						}
					}
					
					CCAttribution attribution = new CCAttribution(attSub,this);
					Image image =attribution.createAttributionImage();
					ImageData imgData = new ImageData(imageArray.get(imageArray.size()-1).getEndTime(),imageArray.get(imageArray.size()-1).getEndTime()+5,imageArray.size(),null,image,null);
					imageArray.add(imgData);
									
				}	
			}
			
			
								
			iToVideo.createVideo(imageArray,video);
			//Make a folder to store the video and the subtitle file
			
			File videoOutputFolder = new File(evt.getPropertyName());
			try{
				if(videoOutputFolder.mkdir())
					System.out.println("Directory Created");
				else
					System.out.println("Directory is not created");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			String savingPath = evt.getPropertyName()+"\\"+videoOutputFolder.getName()+".avi";
		
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
			
			//remove attribution images from the ImageArray otherwise there will be a mismatch between imageArray and TblImage
			for(int i=0;i<numberOfAttributionImages;i++)
			{
				imageArray.remove(imageArray.size()-1);
			}
			
			//creating the subtitle.srt file to save subtitles
			
			File srtFile = new File(evt.getPropertyName()+"\\"+videoOutputFolder.getName()+".SRT");
			try {
				srtFile.createNewFile();
				Writer output = new BufferedWriter(new FileWriter(srtFile));
				
				for(int i=0;i< captionArray.size();i++)
				{
					output.write("\n");
					output.write(Integer.toString(i));
					output.write("\n");
					output.write(secondsToHHMMSSMS(captionArray.get(i).getStartTime())+"-->" + secondsToHHMMSSMS(captionArray.get(i).getEndTime()));
					output.write("\n");
					output.write(captionArray.get(i).getCaption());
					output.write("\n");
								
				}
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	
	private void zoomImageTimeLine()
	{
		spacing = (float)slider.getWidth()/slider.getMaximum();
		//float newSpacing = spacing * zoomFactor;	
		
		for(int i= 0 ; i < imageArray.size() ; i++)
		{
			tblImage.getColumnModel().getColumn(i).setPreferredWidth(Math.round(spacing*(imageArray.get(i).getEndTime()-imageArray.get(i).getStartTime())));
			
		}
		//tblImage.doLayout();
	}
	
	private void zoomCaptionTimeLine()
	{
		spacing = (float)slider.getWidth()/slider.getMaximum();	
		
		for(int i= 0 ; i < captionArray.size() ; i++)
		{
			tblCaption.getColumnModel().getColumn(i).setPreferredWidth(Math.round(spacing*(captionArray.get(i).getEndTime()-captionArray.get(i).getStartTime())));
		}
		
	}
	
	private void zoomTagTimeLine()
	{
		spacing = (float)slider.getWidth()/slider.getMaximum();	
		
		for(int i= 0 ; i < tagArray.size() ; i++)
		{
			tblTags.getColumnModel().getColumn(i).setPreferredWidth(Math.round(spacing*(tagArray.get(i).getEndTime()-tagArray.get(i).getStartTime())));
		}
		//tblTags.validate();
	}
	
	private void btnZoomInActionPerformed(ActionEvent evt) {
		System.out.println("btnZoomIn.actionPerformed, event="+evt);
		zoomingFactor = zoomingFactor+1;
		
		zoomAudioTimeLine(zoomingFactor);
		zoomImageTimeLine();
		zoomCaptionTimeLine();
		zoomTagTimeLine();
		
	}
	
	private void btnZoomOutActionPerformed(ActionEvent evt) {
		System.out.println("btnZoomOut.actionPerformed, event="+evt);
		
		if(zoomingFactor > 1)
		{
			zoomingFactor = zoomingFactor -1;
			zoomAudioTimeLine(zoomingFactor);
			zoomImageTimeLine();
			zoomCaptionTimeLine();
			zoomTagTimeLine();
		}
		
	}
	
	public ArrayList<URL> flickrURLs(String searchTag,int numberOfPhotos,String size,int pageNumber) throws SAXException, IOException, FlickrException, imager.FlickrException
    {
		ArrayList<URL> URLs = new ArrayList<URL>();
		/*if(missingURLS != null)
		{
			missingURLS.clear();
		}*/
		 
    	try {
    		
    		FlickrClient flickrClient = FlickrClient.createInstance("199d038ad88f6c6c377a4ab2341fb60f");
    		
    		FlickrPhotoList photoList = flickrClient.getPhotosByTag(searchTag,pageNumber,numberOfPhotos,nonCommercial,shareAlike);
           
            	
            	 for (int i = 0; i < photoList.getCount(); i++) {
                 	
                     FlickrPhoto photo = photoList.getPhoto(i);
                     String imageURL = photo.getImageUrl(size);
                     if(imageURL != null)
                     {
                    	 URLs.add(new URL(imageURL));
                    	 //System.out.println(imageURL);
                     }
                     /*else
                     {
                    	 missingURLS.add(i);
                     }*/
                                		
                    
                 }
            
         
            
        } catch (MalformedURLException ex) {
        	 ex.printStackTrace();
        }
        
        return URLs;
        
       
    }
	
	private void btnFlickrSearchActionPerformed(ActionEvent evt) throws SAXException, IOException, FlickrException {
		System.out.println("btnFlickrSearch.actionPerformed, event="+evt);
		//ArrayList<URL> urls = flickrURLs(txtFlickr.getText().replaceAll(" ", ","),8,FlickrPhoto.THUMBNAIL);
		
		
		
		int selectedColumn = tblImage.getSelectedColumn();
		if(txtFlickr.getText().equals(tagArray.get(selectedColumn).getTag()))
		{
			moreCount= moreCount+1;
					
			if(tagImageContainerList.get(selectedColumn).getOriginalImageURLs() != null)
			{
				tagImageContainerList.get(selectedColumn).getOriginalImageURLs().clear();
				tagImageContainerList.get(selectedColumn).getThumbnaiImages().clear();
			}
			
			
			
		}
		else
		{
			moreCount =1;
			tagArray.get(selectedColumn).setTag(txtFlickr.getText());
			tblTags.setValueAt(txtFlickr.getText(),0 ,selectedColumn);
			tblTags.repaint();
			if(tagImageContainerList.get(selectedColumn).getOriginalImageURLs() != null)
			{
				tagImageContainerList.get(selectedColumn).getOriginalImageURLs().clear();
				tagImageContainerList.get(selectedColumn).getThumbnaiImages().clear();
			}
		}
		Thread moreImageSearchThread = new MoreImageSearchThread(selectedColumn,moreCount,txtFlickr.getText().replaceAll(" ", ","),btnFlickrImg1,btnFlickrImg2,btnFlickrImg3,tagImageContainerList,lblWait,btnFlickrSearch,nonCommercial,shareAlike);
		moreImageSearchThread.start();
	
		
	}
	
	private void btnAddTagsActionPerformed(ActionEvent evt) {
		System.out.println("btnAddTags.actionPerformed, event="+evt);
		
		txtTag.setVisible(true);
		lblAddTags.setVisible(true);
		btnLoadImages.setVisible(true);
		
		txtCaptionEdit.setVisible(false);
		jLabel8.setVisible(false);
		jLabel6.setVisible(false);
		spinnerCaptionStartTime.setVisible(false);
		jLabel7.setVisible(false);
		spinnerCaptionEndTime.setVisible(false);
		jButton1.setVisible(false);
		btnPlus.setVisible(false);
		btnSplit.setVisible(false);
		
		
	}
	
	private void txtTagKeyTyped(KeyEvent evt) {
		System.out.println("txtTag.keyTyped, event="+evt);
		int keyChar = (int)evt.getKeyChar();
		int startTime;
		int endTime;
		String tagWord;
		if(keyChar == 10)
		{
			endTime = slider.getValue();
			System.out.println("end Time"+ endTime);
			tagWord = txtTag.getText();
			if(tagArray.size() == 0)
			{
				if(imageArray.size()==0)
				{
					startTime = 0;
				}
				else
				{
					startTime = imageArray.get(imageArray.size()-1).getEndTime();
					
				}
				
			}
			else
			{
				startTime = tagArray.get(tagArray.size()-1).getEndTime();
				
			}
			
			
			TagData tag = new TagData(tagArray.size(),startTime,endTime,tagWord);
						
			tagArray.add(tag);
			tagStringsArray.add(tagWord);
			tblTagsModel = new TagTableModel(tagStringsArray);
			tblTags.setModel(tblTagsModel);
			
			
			//tblTags.getColumnModel().addColumn(new TableColumn(tagArray.size()-1,Math.round(spacing*(endTime -startTime))));
			spacing = (float)slider.getWidth()/slider.getMaximum();
			for(int i= 0 ; i < tagArray.size(); i++)
			{
				tblTags.getColumnModel().getColumn(i).setPreferredWidth(Math.round(spacing*(tagArray.get(i).getEndTime() - tagArray.get(i).startTime)));
			}
			
			Thread searchThread = new ImageSearchThread(tagArray.size()-1,spacing,tagArray,tagImageContainerList,imageArray,tblImage,nonCommercial,shareAlike);
			searchThread.start();
			
			txtTag.setText("");
		}
		
	}
	
	private void btnLoadImagesActionPerformed(ActionEvent evt) throws SAXException, IOException, FlickrException, InterruptedException {
		System.out.println("btnLoadImages.actionPerformed, event="+evt);
		
		lblInstructions.setVisible(false);
		jTabbedPane1.setVisible(true);
		spacing = (float)slider.getWidth()/slider.getMaximum();
		int imageSearchCount = 1;
		ResizeImage imageResize = new ResizeImage(240,320);
		int cellWidth; 
		int timegap;
		for(int i=0;i< tagArray.size();i++)
		{
			
			
				moreCount= moreCount+1;
						
				if(tagImageContainerList.get(i).getOriginalImageURLs() != null)
				{
					tagImageContainerList.get(i).getOriginalImageURLs().clear();
					tagImageContainerList.get(i).getThumbnaiImages().clear();
				}
					
						
			
			Thread moreImageSearchThread = new MoreImageSearchThread(i,moreCount,tagArray.get(i).getTag().replaceAll(" ", ","),btnFlickrImg1,btnFlickrImg2,btnFlickrImg3,tagImageContainerList,lblWait,btnFlickrSearch,nonCommercial,shareAlike);
			moreImageSearchThread.start();
			
		}
		
	}
	
	private void btnChangeImageActionPerformed(ActionEvent evt) {
		System.out.println("btnChangeImage.actionPerformed, event="+evt);
		//int selectedRow = tblFlickrImages.getSelectedRow();
		//int selectedColumn = tblFlickrImages.getSelectedColumn();
		//int selectedImageIndex = (selectedRow)*4 + selectedColumn;
		
		if(selectedLabel >=0)
		{
			int actualImageIndex = tblImage.getSelectedColumn();
			TagImageContainer selectedTagContainer = tagImageContainerList.get(actualImageIndex);
			URL url = selectedTagContainer.getOriginalImageURLs().get(selectedLabel);
				
			ResizeImage imageResize = new ResizeImage(240,320);
			Image newImage = imageResize.resize(url);
				
			//set the new image to the image array
			imageArray.get(actualImageIndex).setImage(newImage);
			//imageArray.get(actualImageIndex).setsetOwner(selectedTagContainer.getOwnerNames().get(selectedImageIndex));
			imageArray.get(actualImageIndex).setAttribution(selectedTagContainer.getAttributionData().get(selectedLabel));
			//set the new imagedata to the tblImage
			tblImage.getModel().setValueAt(imageArray.get(actualImageIndex), 0,actualImageIndex);
			tblImage.validate();
			tblImage.doLayout();
			tblImage.repaint();
			
			ImageIcon icon = new ImageIcon(newImage);
			imgLabel.setIcon(icon);
			
		}
		selectedLabel = -1;
		
		
		
	}
	
	private void tblTagsComponentResized(ComponentEvent evt) {
		System.out.println("tblTags.componentResized, event="+evt);
		
		float width;
		//for (int i=0; i< imageArray.size() ; i++)
		for (int i=0; i< tblImage.getColumnCount() ; i++)
		{
			
			//recalculate the new start times and end times of tags
			width = (float) ((tblTags.getColumnModel().getColumn(i).getWidth())/spacing);
			if(i==0)
			{
				
				tagArray.get(0).setEndTime(Math.round(width));
				
			}
			else
			{
				
				tagArray.get(i).setStartTime(tagArray.get(i-1).getEndTime());
				tagArray.get(i).setEndTime(Math.round(tagArray.get(i).getStartTime() + width));
				
			}
			
			// reset the star times and end times of imageArray using the start times and end times of tagArray
			imageArray.get(i).setStartTime(tagArray.get(i).getStartTime());
			imageArray.get(i).setEndTime(tagArray.get(i).getEndTime());
			tblImage.getColumnModel().getColumn(i).setPreferredWidth(tblTags.getColumnModel().getColumn(i).getWidth());
		
		}
		
		
	}
	
	private void tblTagsPropertyChange(PropertyChangeEvent evt) {
		System.out.println("tblTags.propertyChange, event="+evt);
		//When the user change the tag this will be fired
		
		int selectedCoulumn =tblTags.getSelectedColumn();
		//This event will even fire when the interface is loading. Therefore we use this if condition to
		//make sure that this is executed only when the user selects a tag
		
		if(selectedCoulumn >=0 )
		{	
		
			tagArray.get(selectedCoulumn).setTag((String) tblTags.getValueAt(0,selectedCoulumn));
		}
		
	}
	
	private void txtTagFocusLost(FocusEvent evt) {
		System.out.println("txtTag.focusLost, event="+evt);
		//txtTag.setVisible(false);
		//lblAddTags.setVisible(false);
		
	}
	
	private void btnBrowseDiskActionPerformed(ActionEvent evt) {
		System.out.println("btnBrowseDisk.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(txtImageDiskPath);
	}
	
	private void txtImageDiskPathPropertyChange(PropertyChangeEvent evt) {
		System.out.println("txtImageDiskPath.propertyChange, event="+evt);
		
		path =txtImageDiskPath.getText();
		
		if(!path.equals(""))
		{
			ResizeImage resizeImage = new ResizeImage(240,320);
			Image image = new ImageIcon(path).getImage();
			imageFromDisk = resizeImage.resize(path);
			ImageIcon icon = new ImageIcon(imageFromDisk);
			lblPreviewDisk.setIcon(icon);
			
		}
		else
		{
			imageFromDisk = null;
		}
	}
	
	private void btnChangeImageDiskActionPerformed(ActionEvent evt) {
		
		if(imageFromDisk != null)
		{
			
			int selectedColumn = tblImage.getSelectedColumn();
			//set the new image to the image array
			imageArray.get(selectedColumn).setImage(imageFromDisk);
			imageArray.get(selectedColumn).setAttribution(null);
			
			//set the new imagedata to the tblImage
			tblImage.getModel().setValueAt(imageArray.get(selectedColumn), 0,selectedColumn);
			tblImage.validate();
			tblImage.doLayout();
			tblImage.repaint();
			
			ImageIcon icon = new ImageIcon(imageFromDisk);
			imgLabel.setIcon(icon);
			
			
			txtImageDiskPath.setText("");
			txtUrlPath.setText("");
			imageFromDisk = null;
			lblPreviewDisk.setIcon(null);
		}
	}
	
	private void txtImageDiskPathKeyTyped(KeyEvent evt) {
		System.out.println("txtImageDiskPath.keyTyped, event="+evt);
		int keyChar = (int)evt.getKeyChar();
		if(keyChar == 10)
		{
			path =txtImageDiskPath.getText();
			
			if(!path.equals(""))
			{
				ResizeImage resizeImage = new ResizeImage(240,320);
				//Image image = new ImageIcon(path).getImage();
				imageFromDisk = resizeImage.resize(path);
				ImageIcon icon = new ImageIcon(imageFromDisk);
				lblPreviewDisk.setIcon(icon);
				
			}
			else
			{
				imageFromDisk = null;
			}
		}
	}
	
	private void btnUrlCheckActionPerformed(ActionEvent evt) {
		System.out.println("btnUrlCheck.actionPerformed, event="+evt);
		URL url = null;
		try {
			url = new URL(txtUrlPath.getText());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(url != null)
		{
			ResizeImage resizeImage = new ResizeImage(240,320);
			Image resizedImage = resizeImage.resize(url);
			ImageIcon icon = new ImageIcon(resizedImage);
			imageFromDisk = resizedImage;
			lblPreviewDisk.setIcon(icon);
			
		}
		else
		{
			imageFromDisk = null;
		}
				
		
		
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		System.out.println("jButton2.actionPerformed, event="+evt);
		
		int selectedRow = tblMyFlickrImages.getSelectedRow();
		int selectedColumn = tblMyFlickrImages.getSelectedColumn();
		int selectedImageIndex = (selectedRow)*4 + selectedColumn;
		ResizeImage resize = new ResizeImage(240,320);
		int actualImageIndex = tblImage.getSelectedColumn();
		
		MyFlickrImage myFlickrImage = myFlickrImageList.get(selectedImageIndex);
		Image newImage = resize.resize(myFlickrImage.getMediumImageURL());
					
		//ResizeImage imageResize = new ResizeImage(240,320);
		//Image newImage = imageResize.resize(buffImg);
			
		//set the new image to the image array
		imageArray.get(actualImageIndex).setImage(newImage);
		imageArray.get(actualImageIndex).setAttribution(null);
		
		//set the new imagedata to the tblImage
		tblImage.getModel().setValueAt(imageArray.get(actualImageIndex), 0,actualImageIndex);
		tblImage.validate();
		tblImage.doLayout();
		tblImage.repaint();
		
		ImageIcon icon = new ImageIcon(newImage);
		imgLabel.setIcon(icon);
		
		
		
	}
	
	private void newProjItemActionPerformed(ActionEvent evt) {
		System.out.println("newProjItem.actionPerformed, event="+evt);
		clearAll();
		
		//set the visibility of tabbedpanel to false and visibility of instructionlabel to true
		jTabbedPane1.setVisible(false);
		lblInstructions.setVisible(true);
		
		
	}
	
	private void clearAll(){
		
		//Clearing Images related Data
		//Clearing tblImage
		for(int i=0;i< imageArray.size();i++)
		{
			tblImage.getColumnModel().removeColumn(tblImage.getColumnModel().getColumn(0));
				
		}
	
		tblImage.removeAll();
		
		tblImageModel = new ImageTableModel();
		tblImage.setModel(tblImageModel);
			
				
		
		//remove the image on the preview
		imgLabel.setIcon(null);
		//clear imageArray
		imageArray.clear();
		imageArray = new ArrayList<ImageData>();
		
				//clearing the tag related Data
		for(int i=0;i<tagArray.size();i++)
		{
			tblTags.getColumnModel().removeColumn(tblTags.getColumnModel().getColumn(0));
		}
		//clear tagArray
		tagArray.clear();
		tagStringsArray.clear();
		
		
		//remove Audio
		audioDecoder = null;
		audioDuration = 0;
		slider.setValue(0);
		
		//remove flickrImageTable
		tagImageContainerList.clear();
		tagImageContainerList = new ArrayList<TagImageContainer>();
		
		//tblFlickrImagesModel = new FlickrImageTableModel();
		//tblFlickrImages.setModel(tblFlickrImagesModel);
		
		
		
		//remove captions
		for(int i=0;i<captionArray.size();i++)
		{
			tblCaption.getColumnModel().removeColumn(tblCaption.getColumnModel().getColumn(0));
		}
		captionArray.clear();
		lblCaption.setText("");
	}
	
	private void btnMoreMyFlickrActionPerformed(ActionEvent evt) {
		//System.out.println("btnMoreMyFlickr.actionPerformed, event="+evt);
		lblWait2.setVisible(true);
		if(photoList.size()>(myFlickrMoreCount+20))
		{
			
			PhotoList subList = new PhotoList();
			for(int i=myFlickrMoreCount;i<(myFlickrMoreCount+20);i++)
			{
				subList.add(photoList.get(i));
			}
			
			Thread loadFlickrImages = new MyFlickrImageLoadThread(myFlickrImageList,subList,tblMyFlickrImages,tblMyFlickrImagesModel,lblWait2,lblStatus,myFlickrMoreCount);
		    loadFlickrImages.start();
		    btnMoreMyFlickr.setVisible(true);
		    myFlickrMoreCount =myFlickrMoreCount+20;
		}
		else
		{
			PhotoList subList = new PhotoList();
			System.out.println("mymore count= "+myFlickrMoreCount +" photolistsize ="+photoList.size());
			for(int i=myFlickrMoreCount;i<photoList.size();i++)
			{
				subList.add(photoList.get(i));
			}
			
			Thread loadFlickrImages = new MyFlickrImageLoadThread(myFlickrImageList,subList,tblMyFlickrImages,tblMyFlickrImagesModel,lblWait2,lblStatus,myFlickrMoreCount);
		    loadFlickrImages.start();
		    btnMoreMyFlickr.setVisible(false);
		    myFlickrMoreCount =myFlickrMoreCount+photoList.size();
		}
		
		
	}
	
	private void saveProjMenuActionPerformed(ActionEvent evt) {
		System.out.println("saveProjMenu.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(saveProjMenu,"SAVE_PROJECT");
		
		
		
	}
	
	private void saveProjMenuPropertyChange(PropertyChangeEvent evt) {
		System.out.println("saveProjMenu.propertyChange, event="+evt);
		if(!evt.getPropertyName().equals("ancestor"))
		{
			System.out.println(evt.getPropertyName());
			String folderPath = evt.getPropertyName();
			
			//Creating a directory with name equal to AudioImager-Date
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		   	
			String mainFolderName ="AudioImager-"+sdf.format(cal.getTime());
			File mainFolder = new File(folderPath+"\\"+mainFolderName);
			try{
				if(mainFolder.mkdir())
					System.out.println("Directory Created");
				else
					System.out.println("Directory is not created");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			//create a folder for images
			File imageFolder = new File(folderPath+"\\"+mainFolderName+"\\Images");
			try{
				if(imageFolder.mkdir())
					System.out.println("ImageFolder Created");
				else
					System.out.println("ImageFolder is not created");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			//create a folder for audio
			File audioFolder = new File(folderPath+"\\"+mainFolderName+"\\Audio");
			try{
				if(audioFolder.mkdir())
					System.out.println("AudioFolder Created");
				else
					System.out.println("AudioFolder is not created");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			//create a folder for caption
			File captionFolder = new File(folderPath+"\\"+mainFolderName+"\\Caption");
			try{
				if(captionFolder.mkdir())
					System.out.println("CaptionFolder Created");
				else
					System.out.println("CaptionFolder is not created");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			//Saving the images in the Images Folder
			for(int i=0;i<imageArray.size();i++)
			{
			
				Image image = imageArray.get(i).getImage();
				BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),BufferedImage.TYPE_INT_RGB);
		        Graphics2D g = bufferedImage.createGraphics();
		        g.drawImage(image, null, null);
				
		        File imageOutputfile = new File(folderPath+"\\"+mainFolderName+"\\Images\\"+i+".jpg");
		        try {
					ImageIO.write(bufferedImage, "jpg", imageOutputfile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Copy and paste the audio in the audiopath to Audio Folder 
			String audioFileName="";	
			try {
				
				FileChannel ic = new FileInputStream(audioPath).getChannel();
				File file = new File(audioPath);
				audioFileName =file.getName();
				if(!audioPath.equals(folderPath+"\\"+mainFolderName+"\\Audio\\"+audioFileName))
				{
					FileChannel oc = new FileOutputStream(folderPath+"\\"+mainFolderName+"\\Audio\\"+audioFileName).getChannel();
					try {
						ic.transferTo(0, ic.size(), oc);
						ic.close();
						oc.close(); 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Create an XML file and save all the details about Images and tags
			//Saving Image and Caption details to the XML
					
			try {
				    // first of all we request out DOM-implementation:
				    DocumentBuilderFactory factory = 
				     DocumentBuilderFactory.newInstance();
				    // then we have to create document-loader:
				    DocumentBuilder loader = factory.newDocumentBuilder();

				    // createing a new DOM-document...
				    Document document = loader.newDocument();

				    // create root-element
				    Element root = document.createElement("ImageAndTag");
				    Element mainImage = document.createElement("Images");
				    Element spacingElement = document.createElement("Spacing");
				    Element audioPath = document.createElement("AudioPath");
				    // ... compose the rest document content ...
				    for(int i=0;i< imageArray.size();i++)
				    {
				    	Element image = document.createElement("Image");
				    	Element imagePath = document.createElement("Path");
				    	Element imageStartTime = document.createElement("StartTime");
				    	Element imageEndTime = document.createElement("EndTime");
				    	Element ownerName = document.createElement("Owner");
				    	Element license = document.createElement("License");
				    	Element title = document.createElement("Title");
				    	Element url = document.createElement("URL");
				    	Element tagWord = document.createElement("Tag");
				    	
				    	imagePath.setTextContent(folderPath+"\\"+mainFolderName+"\\Images\\"+i+".jpg");
				    	imageStartTime.setTextContent(Integer.toString(imageArray.get(i).getStartTime()));
				    	imageEndTime.setTextContent(Integer.toString(imageArray.get(i).getEndTime()));
				    	if(imageArray.get(i).getAttribution() != null)
				    	{
				    		
				    		ownerName.setTextContent(imageArray.get(i).getAttribution().getOwnerName());
					    	license.setTextContent(Integer.toString(imageArray.get(i).getAttribution().getLicense()));
					    	title.setTextContent(imageArray.get(i).getAttribution().getTitle());
					    	if(imageArray.get(i).getAttribution().getUrl()==null)
					    	{
					    		url.setTextContent(null);
					    	}
					    	else
					    	{
					    		url.setTextContent(imageArray.get(i).getAttribution().getUrl().toString());	
					    	}
					    	tagWord.setTextContent(tagArray.get(i).getTag());	
				    	}
				    	else
				    	{
				    		ownerName.setTextContent("");
					    	license.setTextContent("");
					    	title.setTextContent("");
					    	url.setTextContent("");
					    	tagWord.setTextContent(tagArray.get(i).getTag());	
				    	}
				    	
				    	
				    	image.appendChild(imagePath);
				    	image.appendChild(imageStartTime);
				    	image.appendChild(imageEndTime);
				    	image.appendChild(ownerName);
				    	image.appendChild(license);
				    	image.appendChild(title);
				    	image.appendChild(url);
				    	image.appendChild(tagWord);
				    	
				    	mainImage.appendChild(image);
				    	
				    	
				    }
				    spacingElement.setTextContent(Float.toString(this.spacing));
				    audioPath.setTextContent(folderPath+"\\"+mainFolderName+"\\Audio\\"+audioFileName);
				    root.appendChild(spacingElement);
				    root.appendChild(audioPath);
				    root.appendChild(mainImage);
				    document.appendChild(root);
				    				    

				    				    
				    // use specific Xerces class to write DOM-data to a file:
				    XMLSerializer serializer = new XMLSerializer();
				    serializer.setOutputCharStream(new java.io.FileWriter(folderPath+"\\"+mainFolderName+"\\Config.XML"));
				    serializer.serialize(document);

			 } catch (Exception ex) {
				      ex.printStackTrace();
			   }
			 
			 
			 //Creating an XML document to store Captions and store the Captions.XML in Caption folder
			 
			 try {
				    // first of all we request out DOM-implementation:
				    DocumentBuilderFactory factory = 
				     DocumentBuilderFactory.newInstance();
				    // then we have to create document-loader:
				    DocumentBuilder loader = factory.newDocumentBuilder();

				    // createing a new DOM-document...
				    Document document = loader.newDocument();

				    // create root-element
				    Element root = document.createElement("Captions");
				   
				    
				    // ... compose the rest document content ...
				    for(int i=0;i< captionArray.size();i++)
				    {
				    	Element caption = document.createElement("Caption");
				    	Element captionStartTime = document.createElement("StartTime");
				    	Element captionEndTime = document.createElement("EndTime");
				    	Element text = document.createElement("Text");
				    	
				    	captionStartTime.setTextContent(Integer.toString(captionArray.get(i).getStartTime()));
				    	captionEndTime.setTextContent(Integer.toString(captionArray.get(i).getEndTime()));
				    	text.setTextContent(captionArray.get(i).getCaption());
				    					    	
				    	caption.appendChild(captionStartTime);
				    	caption.appendChild(captionEndTime);
				    	caption.appendChild(text);
				    	
				    	root.appendChild(caption);
				    	
				    	
				    }
				    document.appendChild(root);
				    				    
			    				    
				    // use specific Xerces class to write DOM-data to a file:
				    XMLSerializer serializer = new XMLSerializer();
				    serializer.setOutputCharStream(new java.io.FileWriter(folderPath+"\\"+mainFolderName+"\\Caption\\Config.XML"));
				    serializer.serialize(document);
				    
				    //Creating an SRT file to save captions
					File srtFile = new File(folderPath+"\\"+mainFolderName+"\\Caption\\Captions.srt");
					srtFile.createNewFile();
					
					//Writing the caption data to the SRT file
					
					Writer output = new BufferedWriter(new FileWriter(srtFile));
					
										
					for(int i=0;i< captionArray.size();i++)
					{
						output.write("\n");
						output.write(Integer.toString(i));
						output.write("\n");
						output.write(secondsToHHMMSSMS(captionArray.get(i).getStartTime())+"-->" + secondsToHHMMSSMS(captionArray.get(i).getEndTime()));
						output.write("\n");
						output.write(captionArray.get(i).getCaption());
						output.write("\n");
						
						
					}
					output.close();
						

			 } catch (Exception ex) {
				      ex.printStackTrace();
			   }
			 
			
			
			
		}
			
	}
	
	private String secondsToHHMMSSMS(int secondsInt)
	{
		int hours = secondsInt / 3600,
		remainder = secondsInt % 3600,
		minutes = remainder / 60,
		seconds = remainder % 60;

		return ( (hours < 10 ? "0" : "") + hours
		+ ":" + (minutes < 10 ? "0" : "") + minutes
		+ ":" + (seconds< 10 ? "0" : "") + seconds+",00" );
	}
	
	private void projOpenMenuActionPerformed(ActionEvent evt) {
		System.out.println("projOpenMenu.actionPerformed, event="+evt);
		
		FileChooser fc = new FileChooser(projOpenMenu,"OPEN_PROJECT");
	
	}
	
	private void projOpenMenuPropertyChange(PropertyChangeEvent evt) {
		System.out.println("projOpenMenu.propertyChange, event="+evt);
		
		if(!evt.getPropertyName().equals("ancestor"))
		{
			System.out.println("Open file :"+evt.getPropertyName());
			
			
			//Clear all the existing data
			clearAll();
			this.clearAll();
			
			
			//Reading the Config.XML
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder;
			try {
				docBuilder = docBuilderFactory.newDocumentBuilder();
				Document doc = docBuilder.parse (new File(evt.getPropertyName()));

	            NodeList listOfImages = doc.getElementsByTagName("Image");
	            //Creating the ImageArray
	           
	            //ArrayList<String> owners;
	            ArrayList<AttributionData> attributionList;
	            for(int i=0;i<listOfImages.getLength();i++)
	            {
	            	String path =listOfImages.item(i).getChildNodes().item(0).getTextContent();
	            	int startTime = Integer.parseInt(listOfImages.item(i).getChildNodes().item(1).getTextContent());
	            	int endTime = Integer.parseInt(listOfImages.item(i).getChildNodes().item(2).getTextContent());
	            	String owner =listOfImages.item(i).getChildNodes().item(3).getTextContent();
	            	String license = listOfImages.item(i).getChildNodes().item(4).getTextContent();
	            	String title = listOfImages.item(i).getChildNodes().item(5).getTextContent();
	            	String url = listOfImages.item(i).getChildNodes().item(6).getTextContent();
	            	String tagValue =listOfImages.item(i).getChildNodes().item(7).getTextContent();
	            	
	            	ImageIcon icon = new ImageIcon(path);
	            	Image imageRetrieved =icon.getImage();
	            	int licenseInt;
	            	URL urlValue;
	            	if(license.equals("") || license.equals(Integer.toString(-1)))
	            	{
	            		licenseInt = -1;
	            		urlValue = null;
	            		
	            	}
	            	else
	            	{
	            		licenseInt =Integer.parseInt(license);
	            		urlValue=new URL(url);
	            	}
	            	AttributionData attributionData = new AttributionData(licenseInt,title,owner,urlValue);   	
	            	ImageData imageData = new ImageData(startTime,endTime,i,path,imageRetrieved,attributionData);
	            	imageArray.add(i,imageData);
	            	
	            	TagData tag = new TagData(i,startTime,endTime,tagValue);
	            	tagArray.add(tag);
	            	tagStringsArray.add(i,tagValue);
	               	
	            	attributionList = new ArrayList<AttributionData>();
	            	attributionList.add(attributionData);
	            	
	            	
	            	TagImageContainer tagImageContainer = new TagImageContainer(i,null,attributionList);
	            	tagImageContainerList.add(i,tagImageContainer);
	            	
	            }
	            //Get Spacing
	            NodeList spacingNode = doc.getElementsByTagName("Spacing");
	            spacing = Float.parseFloat(spacingNode.item(0).getTextContent());
	            
	                       
	            
	            //Creating tblImage
	            tblImageModel = new ImageTableModel();
	            tblImage.setModel(tblImageModel);
	            tblTagsModel = new TagTableModel(tagStringsArray);
	            tblTags.setModel(tblTagsModel);
	            for(int i=0;i<imageArray.size();i++)
	            {
	            	int width= Math.round(spacing*(imageArray.get(i).getEndTime()-imageArray.get(i).getStartTime())); 
	            	tblImage.getColumnModel().addColumn(new TableColumn(i,width));
					TableCellRenderer mycellrenderer = new MyTableCellRenderer();
					tblImage.getColumnModel().getColumn(i).setCellRenderer(mycellrenderer);
					tblImage.setValueAt(imageArray.get(i), 0,i);
					tblImage.getColumnModel().getColumn(i).setResizable(true);
					
					
					tblTags.getColumnModel().getColumn(i).setPreferredWidth(width);
	            }
	           tblImage.repaint();
	            
	            //Get Audio and setupAudio
	           NodeList audio = doc.getElementsByTagName("AudioPath");
	           audioPath = audio.item(0).getTextContent();
	           setupAudio();
	           
	           //Set Slider to zero
	           slider.setValue(0);
	           if(imageArray != null && imageArray.size() >=1)
	           {
	        	   selectedImage = imageArray.get(0);
	        	   imgLabel.setIcon(new ImageIcon(imageArray.get(0).getImage()));   
	        	   btnLoadImages.setVisible(true);
	           }
	           
	           //Reading captions from Caption.XML
	           
	       		  File file = new File(evt.getPropertyName());
	       		 

					Document captionDoc = docBuilder.parse (new File( file.getParent()+"\\Caption\\Config.XML"));

		            NodeList listOfCaptions = captionDoc.getElementsByTagName("Caption");
		            //Creating the CaptionArray
		           
		            for(int i=0;i<listOfCaptions.getLength();i++)
		            {
		            	
		            	int startTime = Integer.parseInt(listOfCaptions.item(i).getChildNodes().item(0).getTextContent());
		            	int endTime = Integer.parseInt(listOfCaptions.item(i).getChildNodes().item(1).getTextContent());
		            	String text =listOfCaptions.item(i).getChildNodes().item(2).getTextContent();
		            	
		            	CaptionData captionData = new CaptionData(startTime,endTime,text);
		            	captionArray.add(i,captionData);
		            	
		            }
		            	                       
		            
		            //Creating tblCaption
		            ArrayList<String> wordArray = new ArrayList<String>();
		            for(int i=0;i<captionArray.size();i++)
		            {
		            	wordArray.add(captionArray.get(i).getCaption());
		            }
		            TableModel tblCaptionModel = new CaptionTableModel(wordArray);
					tblCaption.setModel(tblCaptionModel);
		            					
		            for(int i=0;i<captionArray.size();i++)
		            {
		            	int width= Math.round(spacing*(captionArray.get(i).getEndTime()-captionArray.get(i).getStartTime())); 
		            	tblCaption.getColumnModel().getColumn(i).setPreferredWidth(width);
						tblImage.getColumnModel().getColumn(i).setResizable(true);
										
		            }
	           
	           
	           
	            
	            
				
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            

			
			
		}
	}
	
	
	private void radioBtnNonCommercialActionPerformed(ActionEvent evt) {
		if(radioBtnNonCommercial.isSelected())
		{
			radioBtnShareAlike.setSelected(false);
			shareAlike = false;
		}
		
		
		nonCommercial = radioBtnNonCommercial.isSelected();
		
	}
	
	private void radioBtnShareAlikeActionPerformed(ActionEvent evt) {
		
		if(radioBtnShareAlike.isSelected())
		{
			radioBtnNonCommercial.setSelected(false);
			nonCommercial = false;
		}
		
		shareAlike = radioBtnShareAlike.isSelected();
		
	}
	
	private void btnFlickrImg1ActionPerformed(ActionEvent evt) {
		System.out.println("btnFlickrImg1.actionPerformed, event="+evt);
		selectedLabel = 0;
		
		
	}
	
	private void btnFlickrImg2ActionPerformed(ActionEvent evt) {
		System.out.println("btnFlickrImg2.actionPerformed, event="+evt);
		selectedLabel = 1;
	}
	
	private void btnFlickrImg3ActionPerformed(ActionEvent evt) {
		System.out.println("btnFlickrImg3.actionPerformed, event="+evt);
		selectedLabel = 2;
	}

}
