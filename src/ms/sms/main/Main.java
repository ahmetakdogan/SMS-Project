package ms.sms.main;

import ms.sms.controller.Controller;
import ms.sms.view.SmsFrame;

public class Main {

	public static void main(String[] args) {
		SmsFrame mf = new SmsFrame();
		Controller ctlr = new Controller(mf);
		mf.setVisible(true);
	}

}
