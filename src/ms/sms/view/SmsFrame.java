/*
 * Created by JFormDesigner on Wed Jul 16 04:10:07 VET 2014
 */

package ms.sms.view;

import java.awt.Color;
import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import ms.sms.model.ValideInput;

/**
 * @author hakan aydÄ±n
 */
public class SmsFrame extends JFrame {
	public SmsFrame() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - hakan aydÄ±n
		tabbedPane1 = new JTabbedPane();
		panel1 = new JPanel();
		label1 = new JLabel();
		scrollPane1 = new JScrollPane();
		txtNumarayaz = new JTextArea();
		label2 = new JLabel();
		cboxOriginatör = new JComboBox();
		label3 = new JLabel();
		label4 = new JLabel();
		scrollPane2 = new JScrollPane();
		txtMesajYaz = new JTextArea();
		label5 = new JLabel();
		label6 = new JLabel();
		btGonder = new JButton();
		lbKalanKontör = new JLabel();
		lbSecilicepsayi = new JLabel();
		lbKaraktersayisi = new JLabel();
		lbMesaajsayisi = new JLabel();
		label11 = new JLabel();
		panel2 = new JPanel();
		scrollPane3 = new JScrollPane();
		tbRapor = new JTable();

		// ======== this ========
		Container contentPane = getContentPane();

		// ======== tabbedPane1 ========
		{
			tabbedPane1.setBackground(Color.white);

			// ======== panel1 ========
			{

				// JFormDesigner evaluation mark
				panel1.setBorder(new javax.swing.border.CompoundBorder(
						new javax.swing.border.TitledBorder(
								new javax.swing.border.EmptyBorder(0, 0, 0, 0),
								"JFormDesigner Evaluation",
								javax.swing.border.TitledBorder.CENTER,
								javax.swing.border.TitledBorder.BOTTOM,
								new java.awt.Font("Dialog", java.awt.Font.BOLD,
										12), java.awt.Color.red), panel1
								.getBorder()));
				panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(java.beans.PropertyChangeEvent e) {
						if ("border".equals(e.getPropertyName()))
							throw new RuntimeException();
					}
				});

				// ---- label1 ----
				label1.setText("Kalan Kont\u00f6r :");
				DefaultTableModel model = new DefaultTableModel(null,
						ValideInput.columnName());
				tbRapor.setModel(model);
				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(txtNumarayaz);
				}

				// ---- label2 ----
				label2.setText("Se\u00e7ilen Ge\u00e7erli Cep Telefonu Say\u0131s\u0131 :");

				// ---- label3 ----
				label3.setText("Mesaj Ba\u015fl\u0131\u011f\u0131:");

				// ---- label4 ----
				label4.setText("Mesaj:");

				// ======== scrollPane2 ========
				{

					// ---- txtMesajYaz ----
					txtMesajYaz.setWrapStyleWord(true);
					txtMesajYaz.setLineWrap(true);
					scrollPane2.setViewportView(txtMesajYaz);
				}

				// ---- label5 ----
				label5.setText("Karakter Sayisi :");

				// ---- label6 ----
				label6.setText("Mesaj Sayisi :");

				// ---- btGonder ----
				btGonder.setText("G\u00f6nder");
				btGonder.setIcon(new ImageIcon(
						"D:\\Workspace\\MutluSmsProject\\src\\ms\\sms\\image\\email-send-icon.png"));

				// ---- lbKalanKontör ----
				lbKalanKontör.setForeground(Color.red);

				// ---- lbSecilicepsayi ----
				lbSecilicepsayi.setForeground(Color.red);

				// ---- lbKaraktersayisi ----
				lbKaraktersayisi.setForeground(Color.red);
				lbKaraktersayisi.setText("0");

				// ---- lbMesaajsayisi ----
				lbMesaajsayisi.setForeground(Color.red);
				lbMesaajsayisi.setText("0");

				// ---- label11 ----
				label11.setIcon(new ImageIcon(
						"C:\\Users\\HAKAN AYDIN\\Desktop\\indsfsfir.jpg"));

				GroupLayout panel1Layout = new GroupLayout(panel1);
				panel1.setLayout(panel1Layout);
				panel1Layout
						.setHorizontalGroup(panel1Layout
								.createParallelGroup()
								.addGroup(
										panel1Layout
												.createSequentialGroup()
												.addGap(28, 28, 28)
												.addGroup(
														panel1Layout
																.createParallelGroup()
																.addComponent(
																		label11)
																.addGroup(
																		panel1Layout
																				.createSequentialGroup()
																				.addComponent(
																						label1,
																						GroupLayout.PREFERRED_SIZE,
																						83,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						lbKalanKontör,
																						GroupLayout.PREFERRED_SIZE,
																						48,
																						GroupLayout.PREFERRED_SIZE)))
												.addGap(51, 51, 51)
												.addGroup(
														panel1Layout
																.createParallelGroup(
																		GroupLayout.Alignment.LEADING,
																		false)
																.addGroup(
																		panel1Layout
																				.createSequentialGroup()
																				.addComponent(
																						label2,
																						GroupLayout.PREFERRED_SIZE,
																						226,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						lbSecilicepsayi,
																						GroupLayout.PREFERRED_SIZE,
																						37,
																						GroupLayout.PREFERRED_SIZE))
																.addComponent(
																		scrollPane1,
																		GroupLayout.PREFERRED_SIZE,
																		392,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		label3,
																		GroupLayout.PREFERRED_SIZE,
																		185,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		cboxOriginatör,
																		GroupLayout.PREFERRED_SIZE,
																		307,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		label4,
																		GroupLayout.PREFERRED_SIZE,
																		63,
																		GroupLayout.PREFERRED_SIZE)
																.addGroup(
																		panel1Layout
																				.createSequentialGroup()
																				.addComponent(
																						label5,
																						GroupLayout.PREFERRED_SIZE,
																						94,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(18,
																						18,
																						18)
																				.addComponent(
																						lbKaraktersayisi,
																						GroupLayout.PREFERRED_SIZE,
																						56,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(53,
																						53,
																						53)
																				.addComponent(
																						label6,
																						GroupLayout.PREFERRED_SIZE,
																						86,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(18,
																						18,
																						18)
																				.addComponent(
																						lbMesaajsayisi,
																						GroupLayout.PREFERRED_SIZE,
																						69,
																						GroupLayout.PREFERRED_SIZE))
																.addComponent(
																		scrollPane2,
																		GroupLayout.DEFAULT_SIZE,
																		0,
																		Short.MAX_VALUE))
												.addGap(0, 32, Short.MAX_VALUE))
								.addGroup(
										GroupLayout.Alignment.TRAILING,
										panel1Layout
												.createSequentialGroup()
												.addContainerGap(325,
														Short.MAX_VALUE)
												.addComponent(
														btGonder,
														GroupLayout.PREFERRED_SIZE,
														160,
														GroupLayout.PREFERRED_SIZE)
												.addGap(224, 224, 224)));
				panel1Layout
						.setVerticalGroup(panel1Layout
								.createParallelGroup()
								.addGroup(
										panel1Layout
												.createSequentialGroup()
												.addGap(41, 41, 41)
												.addGroup(
														panel1Layout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		label2)
																.addComponent(
																		lbSecilicepsayi)
																.addComponent(
																		label1)
																.addComponent(
																		lbKalanKontör))
												.addGap(18, 18, 18)
												.addComponent(
														scrollPane1,
														GroupLayout.PREFERRED_SIZE,
														41,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(label3)
												.addGap(2, 2, 2)
												.addGroup(
														panel1Layout
																.createParallelGroup()
																.addComponent(
																		label11,
																		GroupLayout.PREFERRED_SIZE,
																		204,
																		GroupLayout.PREFERRED_SIZE)
																.addGroup(
																		panel1Layout
																				.createSequentialGroup()
																				.addComponent(
																						cboxOriginatör,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(18,
																						18,
																						18)
																				.addComponent(
																						label4)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(
																						scrollPane2,
																						GroupLayout.PREFERRED_SIZE,
																						118,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(18,
																						18,
																						18)
																				.addGroup(
																						panel1Layout
																								.createParallelGroup(
																										GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										label5)
																								.addComponent(
																										lbKaraktersayisi)
																								.addComponent(
																										label6)
																								.addComponent(
																										lbMesaajsayisi))))
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(
														btGonder,
														GroupLayout.PREFERRED_SIZE,
														53,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap()));
			}
			tabbedPane1
					.addTab("Sms",
							new ImageIcon(
									"D:\\Workspace\\MutluSmsProject\\src\\ms\\sms\\image\\messages-icon.png"),
							panel1);

			// ======== panel2 ========
			{

				// ======== scrollPane3 ========
				{

					// ---- tbRapor ----
					tbRapor.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					scrollPane3.setViewportView(tbRapor);
				}

				GroupLayout panel2Layout = new GroupLayout(panel2);
				panel2.setLayout(panel2Layout);
				panel2Layout
						.setHorizontalGroup(panel2Layout
								.createParallelGroup()
								.addGroup(
										panel2Layout
												.createSequentialGroup()
												.addGap(60, 60, 60)
												.addComponent(
														scrollPane3,
														GroupLayout.PREFERRED_SIZE,
														617,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(32,
														Short.MAX_VALUE)));
				panel2Layout
						.setVerticalGroup(panel2Layout
								.createParallelGroup()
								.addGroup(
										panel2Layout
												.createSequentialGroup()
												.addGap(36, 36, 36)
												.addComponent(
														scrollPane3,
														GroupLayout.PREFERRED_SIZE,
														244,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(149,
														Short.MAX_VALUE)));
			}
			tabbedPane1
					.addTab("Rapor",
							new ImageIcon(
									"D:\\Workspace\\MutluSmsProject\\src\\ms\\sms\\image\\reportsicon35x35.png"),
							panel2);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(contentPaneLayout
				.createParallelGroup().addGroup(
						contentPaneLayout.createSequentialGroup()
								.addContainerGap().addComponent(tabbedPane1)
								.addContainerGap()));
		contentPaneLayout.setVerticalGroup(contentPaneLayout
				.createParallelGroup().addGroup(
						contentPaneLayout.createSequentialGroup()
								.addContainerGap().addComponent(tabbedPane1)));
		pack();
		setLocationRelativeTo(getOwner());
		// //GEN-END:initComponents
	}

	public void setTbRapor(JTable tbRapor) {
		this.tbRapor = tbRapor;
	}

	public JTabbedPane getTabbedPane1() {
		return tabbedPane1;
	}

	public void setTxtMesajYaz(JTextArea txtMesajYaz) {
		this.txtMesajYaz = txtMesajYaz;
	}

	public JTable getTbRapor() {
		return tbRapor;
	}

	public JLabel getLbSecilicepsayi() {
		return lbSecilicepsayi;
	}

	public JTextArea getTxtNumarayaz() {
		return txtNumarayaz;
	}

	public JLabel getLbKaraktersayisi() {
		return lbKaraktersayisi;
	}

	public JLabel getLbMesaajsayisi() {
		return lbMesaajsayisi;
	}

	public JTextArea getTxtMesajYaz() {
		return txtMesajYaz;
	}

	public JComboBox getCboxOriginatör() {
		return cboxOriginatör;
	}

	public JButton getBtGonder() {
		return btGonder;
	}

	public JLabel getLbKalanKontör() {
		return lbKalanKontör;
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - hakan aydÄ±n
	private JTabbedPane tabbedPane1;
	private JPanel panel1;
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JTextArea txtNumarayaz;
	private JLabel label2;
	private JComboBox cboxOriginatör;
	private JLabel label3;
	private JLabel label4;
	private JScrollPane scrollPane2;
	private JTextArea txtMesajYaz;
	private JLabel label5;
	private JLabel label6;
	private JButton btGonder;
	private JLabel lbKalanKontör;
	private JLabel lbSecilicepsayi;
	private JLabel lbKaraktersayisi;
	private JLabel lbMesaajsayisi;
	private JLabel label11;
	private JPanel panel2;
	private JScrollPane scrollPane3;
	private JTable tbRapor;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
