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
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class FileChooser extends javax.swing.JFrame {
	private JFileChooser filechooser;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	/*
	 * public static void main(String[] args) { SwingUtilities.invokeLater(new
	 * Runnable() { public void run() { FileChooser inst = new FileChooser();
	 * inst.setLocationRelativeTo(null); inst.setVisible(true); } }); }
	 */
	private JTextField imageTxt;
	private String path;
	private JMenuItem menuItem;
	private String fileorFolder;

	public FileChooser(JTextField txt, String type) {
		super();
		imageTxt = txt;
		this.fileorFolder = type;
		initGUI();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public FileChooser(JMenuItem item, String type) {
		super();
		menuItem = item;
		initTxtGUI(type);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/*
	 * public void runChooser(FileData f) { fd = f;
	 * 
	 * SwingUtilities.invokeLater(new Runnable() { public void run() {
	 * FileChooser inst = new FileChooser(); inst.setLocationRelativeTo(null);
	 * inst.setVisible(true); } });
	 * 
	 * this.setLocationRelativeTo(null); this.setVisible(true); }
	 */
	private void initTxtGUI(String type) {
		try {
			AnchorLayout thisLayout = new AnchorLayout();

			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				filechooser = new JFileChooser();
				getContentPane().add(
						filechooser,
						new AnchorConstraint(1, 991, 976, 3,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				filechooser.setPreferredSize(new java.awt.Dimension(494, 308));
				if (type.equals("SAVE_PROJECT")) {
					filechooser
							.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					filechooser.setApproveButtonText("Save");
					filechooser.setDialogTitle("Save Project");

				} else if (type.equals("OPEN_PROJECT")) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
							"XML Files", "XML");
					filechooser.setFileFilter(filter);
					filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				}

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

	private void filechooserTxtActionPerformed(ActionEvent evt)
			throws IOException {
		System.out.println("filechooser.actionPerformed, event=" + evt);
		if (evt.getActionCommand().toString().equals(
				filechooser.APPROVE_SELECTION)) {
			path = filechooser.getSelectedFile().getCanonicalPath();
			this.dispose();
			menuItem.firePropertyChange(path, false, true);
		} else if (evt.getActionCommand().toString().equals(
				filechooser.CANCEL_SELECTION)) {
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
				if (fileorFolder.equals("FoldersAndFiles")) {
					filechooser
							.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				} else if (fileorFolder.equals("Files")) {
					filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				} else if (fileorFolder.equals("Folders")) {
					filechooser
							.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				}
				getContentPane().add(
						filechooser,
						new AnchorConstraint(1, 991, 976, 3,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
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
		System.out.println("filechooser.actionPerformed, event=" + evt);
		if (evt.getActionCommand().toString().equals(
				filechooser.APPROVE_SELECTION)) {
			String absolutePath = filechooser.getSelectedFile()
					.getCanonicalPath();
			imageTxt.setText(absolutePath);
			this.dispose();
			imageTxt.firePropertyChange("Text", 0, 1);

		} else if (evt.getActionCommand().toString().equals(
				filechooser.CANCEL_SELECTION)) {
			this.dispose();
		}

	}

}
