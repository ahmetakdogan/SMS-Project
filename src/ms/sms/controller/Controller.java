package ms.sms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import ms.sms.model.ValideInput;
import ms.sms.util.Util;
import ms.sms.view.SmsFrame;

public class Controller extends JPanel {
	SmsFrame smsFrame;
	Util util = new Util();
	int totalCharacter = 0;
	int totalMessage = 1;
	String state;
	String header;
	String kontor;
	String amount;
	String successfully;
	String dizi[] = {};
	String[] rapor;
	String[] raporSon = null;
	boolean messageControl = true;
	double gidenSms;
	List<String> orig = new ArrayList<String>();
	List originator = new ArrayList();

	public Controller(SmsFrame smsFrame) {

		this.smsFrame = smsFrame;
		System.out.println("dinleniyor");
		init();

	}

	private void loadOriginator() {
		Thread thread = new Thread() {
			public void run() {
				try {

					DefaultTableModel model = new DefaultTableModel(
							Util.Rapor(), ValideInput.columnName());
					smsFrame.getTbRapor().setModel(model);

					System.out.println("boyut" + Util.Rapor().length);
					orig = util.getOrig();
					for (String or : orig) {
						smsFrame.getCboxOriginatör().addItem(or);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("Mesaj Baþlýklarý Alýnamadý!");
				}

			};
		};
		thread.start();
	}

	private void loadCredits() {
		Thread thread = new Thread() {
			public void run() {

				try {

					double remainCredit = util.getCredit();
					smsFrame.getLbKalanKontör().setText(
							Double.toString(remainCredit));
				} catch (Exception e1) {
					System.out.println("Kontörünüz yetersiz...!");
				}

			};
		};
		thread.start();

	}

	public void init() {
		loadCredits();
		loadOriginator();
		smsFrame.getBtGonder().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				smsGonder();
			}
		});

		smsFrame.getTxtNumarayaz().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) { // tusu býraktýðýn anda aktif
													// olur..
				int count = 0;
				String getPhones = smsFrame.getTxtNumarayaz().getText();
				String phones[] = getPhones.split(",");
				for (int i = 0; i < phones.length; i++) {

					if ((phones[i].startsWith("5") || phones[i].startsWith("0"))
							&& (phones[i].charAt(1) == '3'
									|| phones[i].charAt(1) == '4' || phones[i]
									.charAt(1) == '5')) {
						System.out.println("5 veya 0 ile  baþlýyor");
						if (phones[i].length() >= 10)
							count++;
						smsFrame.getLbSecilicepsayi().setText(" " + count);

						if (phones[i].length() > 11) {
							String text1 = smsFrame.getTxtNumarayaz().getText()
									.substring(0, getPhones.length() - 1);
							System.out.println("text1 :" + text1);
							smsFrame.getTxtNumarayaz().setText(text1);
						}

					} else if ((phones[i].startsWith("9") && phones[i]
							.charAt(1) == '0') && phones[i].charAt(2) == '5') {
						System.out.println("90 ile baþlýyor");
						if (phones[i].length() >= 12)
							count++;
						smsFrame.getLbSecilicepsayi().setText(" " + count);

						if (phones[i].length() > 12) {
							String text1 = smsFrame.getTxtNumarayaz().getText()
									.substring(0, getPhones.length() - 1);
							System.out.println("text1 :" + text1);
							smsFrame.getTxtNumarayaz().setText(text1);
						}

					} else {
						System.out.println("else bloðu");
						String text1 = smsFrame.getTxtNumarayaz().getText()
								.substring(0, getPhones.length() - 1);
						System.out.println("text1 :" + text1);
						smsFrame.getTxtNumarayaz().setText(text1);

					}
				}
				char ch = e.getKeyChar();
				String temp = smsFrame.getTxtNumarayaz().getText();
				System.out.println("temp: " + temp);

				System.out.println("syso else ");
				if (ValideInput.stringNumericTest3(String.valueOf(ch))) {
					String text = smsFrame.getTxtNumarayaz().getText()
							.substring(0, temp.length() - 1);
					smsFrame.getTxtNumarayaz().setText(text);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		smsFrame.getTxtMesajYaz().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String metin = smsFrame.getTxtMesajYaz().getText();
				System.out.println("tetxt uzunluk: " + metin.length());

				if (ValideInput.specialSmsCharacter(String.valueOf(e
						.getKeyChar()))) {

				} else {
					if (metin.length() <= 764) {
						if (metin.length() < 160 && metin.length() != 0) {
							totalMessage = 1;
							totalCharacter = metin.length();
						} else if (metin.length() >= 160
								&& metin.length() < 306) {
							totalMessage = 2;
							totalCharacter = metin.length();
						} else if (metin.length() > 160 && metin.length() < 764) {
							if ((metin.length() - 160) % 153 == 0) {
								totalMessage = ((metin.length() - 160) / 153) + 1;
								totalCharacter = metin.length();
							} else {
								totalMessage = ((((metin.length() - 160) - ((metin
										.length() - 160) % 153)) / 153) + 2);
								totalCharacter = metin.length();
							}

						}
						smsFrame.getLbMesaajsayisi().setText(
								Integer.toString(totalMessage));
						smsFrame.getLbKaraktersayisi().setText(
								Integer.toString(metin.length()));
						System.out.println("totalcharacter artis : "
								+ totalCharacter);
					}

					if (metin.length() > 765) {
						System.out.println("765");
						String message = smsFrame.getTxtMesajYaz().getText();
						smsFrame.getTxtMesajYaz().setText(
								message.substring(0, 765));
						totalCharacter = 765;

					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

	}

	public void smsGonder() {
		try {

			JOptionPane.showMessageDialog(null, "Sms is Sending...");
			Object selectOrginator = smsFrame.getCboxOriginatör()
					.getSelectedItem();
			String numbers = smsFrame.getTxtNumarayaz().getText();
			originator.add(selectOrginator);
			if (numbers.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null,
						"Please enter the cell numbers");
			} else {
				System.out.println("baktým" + originator);
				gidenSms = util.sendSms(smsFrame.getTxtMesajYaz().getText(),
						originator, ValideInput.splitNumbers(numbers));

				System.out.println("gidenSms : " + gidenSms);

				JOptionPane.showMessageDialog(smsFrame, gidenSms
						+ " adet sms gonderýldý.", "Bilgi",
						JOptionPane.INFORMATION_MESSAGE);

				DefaultTableModel model = new DefaultTableModel(Util.Rapor(),
						ValideInput.columnName());
				smsFrame.getTbRapor().setModel(model);

				refreshCredit();

			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		originator.removeAll(originator);
	}

	public void refreshCredit() {

		try {
			double refreshCredit = util.getCredit();
			smsFrame.getLbKalanKontör().setText(Double.toString(refreshCredit));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
