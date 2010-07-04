package imager;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;

import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
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
public class FileChooser extends javax.swing.JFrame{
	private JFileChooser filechooser;

	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FileChooser inst = new FileChooser();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
    private JTextField imageTxt;
     private String path;
    private JMenuItem menuItem;
	public FileChooser(JTextField txt) {
		super();
		imageTxt = txt;
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	public FileChooser(JMenuItem item) {
		super();
		menuItem = item;
		initTxtGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	/*		public void runChooser(FileData f)
	{
		fd = f;
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FileChooser inst = new FileChooser();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	*/
	private void initTxtGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				filechooser = new JFileChooser();
				getContentPane().add(filechooser, new AnchorConstraint(1, 991, 976, 3, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				filechooser.setPreferredSize(new java.awt.Dimension(494, 308));
				filechooser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							filechooserTxtActionPerformed(evt);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			pack();
			this.setSize(508, 350);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void filechooserTxtActionPerformed(ActionEvent evt) throws IOException {
		System.out.println("filechooser.actionPerformed, event="+evt);
		if(evt.getActionCommand().toString().equals(filechooser.APPROVE_SELECTION))
		{
			path = filechooser.getSelectedFile().getCanonicalPath();
			this.dispose();
			menuItem.firePropertyChange(path, false, true);
		}
		else if(evt.getActionCommand().toString().equals(filechooser.CANCEL_SELECTION))
		{
			this.dispose();
		}	
		
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				filechooser = new JFileChooser();
				getContentPane().add(filechooser, new AnchorConstraint(1, 991, 976, 3, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				filechooser.setPreferredSize(new java.awt.Dimension(494, 308));
				filechooser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							filechooserActionPerformed(evt);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			pack();
			this.setSize(508, 350);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void filechooserActionPerformed(ActionEvent evt) throws IOException {
		System.out.println("filechooser.actionPerformed, event="+evt);
		if(evt.getActionCommand().toString().equals(filechooser.APPROVE_SELECTION))
		{
			String absolutePath = filechooser.getSelectedFile().getCanonicalPath();
			imageTxt.setText(absolutePath);
			this.dispose();
			imageTxt.firePropertyChange("Text", 0,1);
			
		}
		else if(evt.getActionCommand().toString().equals(filechooser.CANCEL_SELECTION))
		{
			this.dispose();
		}	
		
	}
	

}
