package imager;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
	private JButton btnStop;
	private JButton btnPlay;
	private JButton btnAdd;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;
	
	private ArrayList<ImageData> imageArray;
	private int startTime;
	private int endTime;
	private String path;
	private int sliderPosition ;
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
				txtStartTime = new JTextField();
				getContentPane().add(txtStartTime, new AnchorConstraint(374, 709, 406, 648, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtStartTime.setPreferredSize(new java.awt.Dimension(77, 32));
			}
			{
				txtEndTime = new JTextField();
				getContentPane().add(txtEndTime, new AnchorConstraint(417, 708, 454, 648, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				txtEndTime.setPreferredSize(new java.awt.Dimension(77, 36));
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
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, new AnchorConstraint(895, 962, 981, 87, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jScrollPane1.setPreferredSize(new java.awt.Dimension(1113, 85));
				{
					slider = new JSlider();
					jScrollPane1.setViewportView(slider);
					slider.setMinorTickSpacing(1);
					slider.setMajorTickSpacing(5);
					slider.setPaintTicks(true);
					slider.setSnapToTicks(true);
					slider.setPaintTrack(false);
					slider.setPaintLabels(true);
					slider.setToolTipText("The value is 50");
					slider.setValue(0);
					slider.setMaximum(30);
					//getContentPane().add(slider, BorderLayout.CENTER);
					slider.setPreferredSize(new java.awt.Dimension(1095, 105));
					slider.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							sliderMouseReleased(evt);
						}
					});

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
				btnBrowse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBrowseActionPerformed(evt);
					}
				});
			}
			
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, new AnchorConstraint(128, 127, 182, 61, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("Add Audio Track");
				jLabel1.setPreferredSize(new java.awt.Dimension(84, 53));
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
	}
	
	private void btnBrowseActionPerformed(ActionEvent evt) {
		System.out.println("btnBrowse.actionPerformed, event="+evt);
		FileChooser fc = new FileChooser(txtImageLink);
		
	}
	
	private void txtImageLinkPropertyChange(PropertyChangeEvent evt) {
		System.out.println("txtImageLink.propertyChange, event="+evt);
		path =txtImageLink.getText();
		if(imgLabel.getHeight()>0 && imgLabel.getWidth()>0 && !path.equals(""))
		{
		ResizeImage resizeImage = new ResizeImage(imgLabel.getHeight(),imgLabel.getWidth());
		Image image = new ImageIcon(path).getImage();
		Image scaledImage = resizeImage.resize(path);
		ImageIcon icon = new ImageIcon(scaledImage);
		imgLabel.setIcon(icon);
		txtImageLink.setText("");
		}
	}
	
	private void btnAddActionPerformed(ActionEvent evt) {
		System.out.println("btnAdd.actionPerformed, event="+evt);
		startTime = Integer.parseInt(txtStartTime.getText());
		endTime = Integer.parseInt(txtEndTime.getText());
		ImageData idata = new ImageData(startTime,endTime,imageArray.size(),path);
		imageArray.add(idata);
		slider.setMaximum(endTime);
		
		
		//TODO add your code for btnAdd.actionPerformed
	}
	
	private void sliderMouseReleased(MouseEvent evt) {
		System.out.println("slider.mouseReleased, event="+evt);
		//TODO add your code for slider.mouseReleased
		sliderPosition = slider.getValue();
		ImageData image = findImage(sliderPosition);
		if(! image.equals(null))
		{
			path =image.getPath();
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
	
	

}
