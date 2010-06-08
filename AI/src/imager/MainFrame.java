package imager;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
	private JLabel jLabel1;
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
	private JSpinner spinnerEndTime;
	private JSpinner spinnerStartTime;
	private JScrollPane scrollSlider;
	private JButton btnAudioBrowse;
	private JTextField txtAudio;
	private JLabel lblAudio;
	private JLabel jLabel3;
	private JLabel jLabel2;

	private ArrayList<ImageData> imageArray;
	private int startTime;
	private int endTime;
	private String path;
	private int sliderPosition ;
	private int cellWidth;
	private int tableWidth;
	private double spacing;
	private TableModel tblImageModel;
	private ImageData selectedImage;

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
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				/*SpinnerListModel spinnerStartTimeModel = 
					new SpinnerListModel(
							new String[] { "Sun", "Mon" , "Tue" , "Wed" , "Thu" , "Fri" , "Sat" });*/
				Number value = 0;
				Number stetpsize =1;
				
				SpinnerNumberModel spinnerStartTimeModel = new SpinnerNumberModel(value,0,null,stetpsize); 
				spinnerStartTime = new JSpinner();
				getContentPane().add(spinnerStartTime, new AnchorConstraint(376, 714, 405, 651, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				spinnerStartTime.setModel(spinnerStartTimeModel);
				spinnerStartTime.setPreferredSize(new java.awt.Dimension(80, 29));
				spinnerStartTime.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						spinnerStartTimeStateChanged(evt);
					}
				});
			}
			{
				btnAudioBrowse = new JButton();
				getContentPane().add(btnAudioBrowse, new AnchorConstraint(77, 571, 107, 483, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnAudioBrowse.setText("Browse");
				btnAudioBrowse.setPreferredSize(new java.awt.Dimension(112, 30));
				btnAudioBrowse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAudioBrowseActionPerformed(evt);
					}
				});
			}
			{
				txtAudio = new JTextField();
				getContentPane().add(txtAudio, new AnchorConstraint(77, 465, 108, 126, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtAudio.setPreferredSize(new java.awt.Dimension(431, 31));
			}
			{
				lblAudio = new JLabel();
				getContentPane().add(lblAudio, new AnchorConstraint(71, 126, 104, 58, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				lblAudio.setText("Add Audio");
				lblAudio.setPreferredSize(new java.awt.Dimension(86, 33));
			}
			{
				btnStop = new JButton();
				getContentPane().add(btnStop, new AnchorConstraint(941, 60, 963, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnStop.setText("Stop");
				btnStop.setPreferredSize(new java.awt.Dimension(65, 21));
			}
			{
				btnPlay = new JButton();
				getContentPane().add(btnPlay, new AnchorConstraint(895, 60, 921, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnPlay.setText("Play");
				btnPlay.setPreferredSize(new java.awt.Dimension(65, 26));
				btnPlay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							btnPlayActionPerformed(evt);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3, new AnchorConstraint(425, 648, 444, 592, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel3.setText("End Time");
				jLabel3.setPreferredSize(new java.awt.Dimension(71, 19));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2, new AnchorConstraint(379, 671, 402, 596, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("Start Time");
				jLabel2.setPreferredSize(new java.awt.Dimension(96, 23));
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd, new AnchorConstraint(282, 689, 318, 596, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnAdd.setText("Add Image");
				btnAdd.setPreferredSize(new java.awt.Dimension(119, 36));
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, new AnchorConstraint(782, 961, 991, 68, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_NONE, AnchorConstraint.ANCHOR_REL));
				GridLayout jPanel1Layout = new GridLayout(2, 1);
				jPanel1Layout.setColumns(1);
				jPanel1Layout.setHgap(5);
				jPanel1Layout.setVgap(5);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(1136, 207));
				{
					scrollSlider = new JScrollPane();
					//scrollSlider.getHorizontalScrollBar().setVisible(false);
					//scrollSlider.getHorizontalScrollBar().setAutoscrolls(false);
					scrollSlider.remove(scrollSlider.getHorizontalScrollBar());
					jPanel1.add(scrollSlider);
					scrollSlider.setPreferredSize(new java.awt.Dimension(1119, 101));
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
						slider.setPreferredSize(new java.awt.Dimension(3007, 83));
						slider.addMouseListener(new MouseAdapter() {
							public void mouseReleased(MouseEvent evt) {
								sliderMouseReleased(evt);
							}
						});
						
					}
					
				}
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2);
					jScrollPane2.setPreferredSize(new java.awt.Dimension(1136, 101));
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
									tblImage.setColumnSelectionAllowed(true);
									tblImage.setRowHeight(98);
									
									
									tblImage.setDragEnabled(true);
									tblImage.setShowVerticalLines(true);
									tblImage.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
									tblImage.setFillsViewportHeight(true);
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
			}
			{
				imgLabel = new JLabel();
				getContentPane().add(imgLabel, new AnchorConstraint(282, 552, 767, 49, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				imgLabel.setPreferredSize(new java.awt.Dimension(640, 480));
			}
			{
				txtImageLink = new JTextField();
				getContentPane().add(txtImageLink, new AnchorConstraint(135, 465, 160, 127, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtImageLink.setText("");
				txtImageLink.setPreferredSize(new java.awt.Dimension(429, 24));
				txtImageLink.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						txtImageLinkPropertyChange(evt);
					}
				});

			}
			{
				btnBrowse = new JButton();
				getContentPane().add(btnBrowse, new AnchorConstraint(134, 572, 178, 483, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				btnBrowse.setText("Browse");
				btnBrowse.setPreferredSize(new java.awt.Dimension(113, 43));
				btnBrowse.setMinimumSize(new java.awt.Dimension(75, 56));
				btnBrowse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBrowseActionPerformed(evt);
					}
				});
			}
			
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, new AnchorConstraint(128, 127, 182, 61, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("Add Images");
				jLabel1.setPreferredSize(new java.awt.Dimension(84, 53));
			}
			{
				Number value = 0;
				Number stetpsize =1;
				
				SpinnerNumberModel spinnerEndTimeModel = new SpinnerNumberModel(value,0,null,stetpsize);
				
				spinnerEndTime = new JSpinner();
				getContentPane().add(spinnerEndTime, new AnchorConstraint(420, 715, 447, 651, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				spinnerEndTime.setModel(spinnerEndTimeModel);
				spinnerEndTime.setValue(value);
				spinnerEndTime.setPreferredSize(new java.awt.Dimension(82, 27));
				spinnerEndTime.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						spinnerEndTimeStateChanged(evt);
					}
				});
			}
			pack();
			Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
			Dimension screenDimension = toolkit.getScreenSize(); 
			
			this.setSize((int) screenDimension.getWidth(), (int) screenDimension.getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initVariables()
	{
		imageArray = new ArrayList<ImageData>();
		startTime = 0;
		endTime = 0;
		path = null;
		sliderPosition = 0;
		cellWidth = 0 ;
		tableWidth = 0 ;
		spacing = 0 ;
		
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
		ResizeImage resizeImage = new ResizeImage(imgLabel.getHeight(),imgLabel.getWidth());
		Image image = new ImageIcon(path).getImage();
		Image scaledImage = resizeImage.resize(path);
		selectedImage = new ImageData(-1,-1,-1,path);
		ImageIcon icon = new ImageIcon(scaledImage);
		imgLabel.setIcon(icon);
		txtImageLink.setText("");
		}
	}
	
	private void btnAddActionPerformed(ActionEvent evt) {
		System.out.println("btnAdd.actionPerformed, event="+evt);
		Number startvalue = (Number) spinnerStartTime.getValue();
		Number endValue = (Number) spinnerEndTime.getValue();
		startTime = startvalue.intValue();
		endTime = endValue.intValue();
		ImageData idata = new ImageData(startTime,endTime,imageArray.size(),path);
		imageArray.add(idata);
		
		if(endTime >slider.getMaximum())
		{	
		slider.setMaximum(endTime);
		spacing = (slider.getWidth()/endTime);
		}
		else
		{
		
		spacing = (double)slider.getWidth()/slider.getMaximum();	
		System.out.println("spacing " +spacing+ "slider width "+slider.getWidth() + " slider max "+ slider.getMaximum());
		}	
		cellWidth = (int) (spacing*(endTime - startTime));
		tableWidth = (int) (spacing*endTime);
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
		cellWidth = cellWidth +17;
		tableWidth = tableWidth + 17;
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
		
		//TODO add your code for btnAdd.actionPerformed
	}
	
	private void sliderMouseReleased(MouseEvent evt) {
		System.out.println("slider.mouseReleased, event="+evt);
		//TODO add your code for slider.mouseReleased
		sliderPosition = slider.getValue();
		slider.setToolTipText("The value is "+ sliderPosition);
		//scrollSlider.getHorizontalScrollBar().setValue(sliderPosition);
		//scrollSlider.getHorizontalScrollBar().setEnabled(true);
		selectedImage = findImage(sliderPosition);
		if(! selectedImage.equals(null))
		{
			path =selectedImage.getPath();
			Image image2 = new ImageIcon(path).getImage();
			ResizeImage resizeImage = new ResizeImage(480,640);
			Image scaledImage = resizeImage.resize(path);
			ImageIcon icon = new ImageIcon(scaledImage);
			imgLabel.setIcon(icon);
						
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
	
	private void btnPlayActionPerformed(ActionEvent evt) throws InterruptedException{
		System.out.println("btnPlay.actionPerformed, event="+evt);
		{
		    ++sliderPosition;
		    System.out.println(sliderPosition);
			slider.setValue(sliderPosition);
			slider.firePropertyChange(getName(), 0, 1);
			
		}
	}
	
	private void btnAudioBrowseActionPerformed(ActionEvent evt) {
		System.out.println("btnAudioBrowse.actionPerformed, event="+evt);
		System.out.println("btnBrowse.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(txtAudio);
	}
	

	
	private void horizontalScrollBarAdjustmentValueChanged(AdjustmentEvent evt) {
		System.out.println("jScrollPane2.getHorizontalScrollBar().adjustmentValueChanged, event="+evt);
		scrollSlider.getHorizontalScrollBar().setValue(jScrollPane2.getHorizontalScrollBar().getValue());
	}
	
	private void tblImageFocusGained(FocusEvent evt) {
		
	}
	
	private void tblImageMouseReleased(MouseEvent evt) {
		System.out.println("tblImage.focusGained, event="+evt);
		int selecteColumn = tblImage.getSelectedColumn();
		selectedImage =(ImageData) tblImage.getModel().getValueAt(0,selecteColumn);
		if(! selectedImage.equals(null))
		{
			path =selectedImage.getPath();
			Image image2 = new ImageIcon(path).getImage();
			ResizeImage resizeImage = new ResizeImage(480,640);
			Image scaledImage = resizeImage.resize(path);
			ImageIcon icon = new ImageIcon(scaledImage);
			imgLabel.setIcon(icon);
			Number startValue = selectedImage.getStartTime();
			Number endValue = selectedImage.getEndTime();
			spinnerStartTime.setValue(startValue);
			spinnerEndTime.setValue(endValue);
			
						
		}
	}
	
	private void spinnerStartTimeStateChanged(ChangeEvent evt) {
		System.out.println("spinnerStartTime.stateChanged, event="+evt);
		System.out.println(selectedImage.getIndex());
		//TODO add your code for spinnerStartTime.stateChanged
		Number value = (Number) spinnerStartTime.getValue();
		int startTime = value.intValue();
		
		
		
		if(selectedImage.getIndex()>0)
		{
			ImageData image1= (ImageData) tblImage.getValueAt(0,selectedImage.getIndex()-1);
			ImageData image2 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex());
			
			if(startTime < selectedImage.getStartTime())
			{	
			
			int timeDifference = selectedImage.getStartTime()-startTime;
			image1.setEndTime(image1.getEndTime()- timeDifference );
			System.out.println(timeDifference);
			System.out.println("old Width" + tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).getWidth());
			//tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).setWidth((int) (spacing*(image1.getEndTime()-image1.getStartTime())));
			tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).setPreferredWidth((int) (spacing*(image1.getEndTime()-image1.getStartTime())));
			//TableCellRenderer mycellrenderer = new MyTableCellRenderer();
			//tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).setCellRenderer(mycellrenderer);
						
			tblImage.setValueAt(image1,0,selectedImage.getIndex()-1 );
	
			image2.setStartTime(startTime);
			tblImage.setValueAt(image2,0,selectedImage.getIndex());
			tblImage.doLayout();
			tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth((int) (spacing*(image2.getEndTime()-image2.getStartTime())));
			System.out.println("New Width" + tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).getWidth());
			
			}
			else
			{
				int timeDifference = startTime - selectedImage.getStartTime();
				image1.setEndTime(image1.getEndTime()+timeDifference);
				tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).setPreferredWidth((int) (spacing*(image1.getEndTime()-image1.getStartTime())));
				tblImage.setValueAt(image1,0,selectedImage.getIndex()-1 );
				
				image2.setStartTime(startTime);
				tblImage.setValueAt(image2,0,selectedImage.getIndex());
				tblImage.doLayout();
				tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth((int) (spacing*(image2.getEndTime()-image2.getStartTime())));
				System.out.println("New Width" + tblImage.getColumnModel().getColumn(selectedImage.getIndex()-1).getWidth());
			}
			
			
				
		}
		else if(selectedImage.getIndex()==0)
		{
			Number stop = 0 ;
			spinnerStartTime.setValue(0);
		}
	}
	
	private void spinnerEndTimeStateChanged(ChangeEvent evt) {
		System.out.println("spinnerEndTime.stateChanged, event="+evt);
		Number endValue = (Number) spinnerEndTime.getValue();
		int endTime = endValue.intValue();
		if(selectedImage.getIndex()>=0)
		{
			
			ImageData image2 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex());
		
			if(endTime < selectedImage.getEndTime())
			{
				if((selectedImage.getIndex()+1) < imageArray.size() )
				{
					ImageData image3 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex()+1);
					int timeDifference = selectedImage.getEndTime()-endTime;
					image3.setStartTime(image3.getStartTime() - timeDifference);
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()+1).setPreferredWidth((int) (spacing*(image3.getEndTime()-image3.getStartTime())));
					tblImage.setValueAt(image3,0,selectedImage.getIndex()+1 );
					
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth((int) (spacing*(image2.getEndTime()-image2.getStartTime())));
				}
				else
				{
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth((int) (spacing*(image2.getEndTime()-image2.getStartTime())));
				}
				
			}
			else
			{
				if((selectedImage.getIndex()+1) < imageArray.size() )
				{
					ImageData image3 = (ImageData) tblImage.getValueAt(0,selectedImage.getIndex()+1);
					int timeDifference = endTime - selectedImage.getEndTime();
					image3.setStartTime(image3.getStartTime() + timeDifference);
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()+1).setPreferredWidth((int) (spacing*(image3.getEndTime()-image3.getStartTime())));
					tblImage.setValueAt(image3,0,selectedImage.getIndex()+1 );
					
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth((int) (spacing*(image2.getEndTime()-image2.getStartTime())));
				}
				else
				{
					image2.setEndTime(endTime);
					tblImage.setValueAt(image2,0,selectedImage.getIndex());
					tblImage.doLayout();
					tblImage.getColumnModel().getColumn(selectedImage.getIndex()).setPreferredWidth((int) (spacing*(image2.getEndTime()-image2.getStartTime())));
				}
				
			}	
		
		}
		
	}

}