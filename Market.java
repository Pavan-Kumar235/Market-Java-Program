import java.awt.*;
import java.awt.event.*;

class Market extends Frame implements ItemListener {

	
	int gtot = 0;
	Choice it,qn;
	List pro,pri,sit,spro,spri,sqn,stot,grand;

	Market() {
		
		setSize((Toolkit.getDefaultToolkit().getScreenSize().width)/2,(Toolkit.getDefaultToolkit().getScreenSize().height)/2);
		setLayout(new FlowLayout());

		it = new Choice();
		qn = new Choice();
		pro = new List();
		pri = new List();
		sit = new List();
		spro = new List();
		spri = new List();	
		sqn = new List();
		stot = new List();
		grand = new List();

		it.add("Mobile");
		it.add("Bluetooth");
		it.add("Laptop");
		it.add("Charger");
		it.add("Slippers");
	
		add(new Label("Items"));
		add(it);
		add(new Label("Products"));
		add(pro);
		add(new Label("Prices"));
		add(pri);

		for(int i=0;i<15;i++)
			qn.add(Integer.toString(i));

		add(new Label("Quantity"));
		add(qn);
		add(new Label("selected Item"));
		add(sit);
		add(new Label("selected Product"));
		add(spro);
		add(new Label("selected Price"));
		add(spri);
		add(new Label("selected Quantity"));
		add(sqn);
		add(new Label("selected Total"));
		add(stot);
		add(new Label("Grand Total"));
		add(grand);

		pri.setEnabled(false);
		qn.setEnabled(false);

		it.addItemListener(this);
		pro.addItemListener(this);
		pri.addItemListener(this);
		qn.addItemListener(this);
		sit.addItemListener(this);

		setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e) {

		if(e.getSource() == it) {

			pro.removeAll();
			pri.removeAll();
			
			if(it.getSelectedItem().equals("Mobile")) {
				pro.add("Realme");	pri.add("12000");
				pro.add("In Note 1");	pri.add("10000");
				pro.add("iPhone");	pri.add("89000");
				pro.add("SamSung");	pri.add("25000");
				pro.add("Redme");	pri.add("16000");
			}
			if(it.getSelectedItem().equals("Bluetooth")) {
				pro.add("Redme");	pri.add("1500");
				pro.add("In Note 2");	pri.add("800");
				pro.add("1+");		pri.add("9000");
				pro.add("VIVO");	pri.add("4000");
				pro.add("Realme");	pri.add("2500");
			}
			if(it.getSelectedItem().equals("Laptop")) {
				pro.add("Lenovo");	pri.add("60000");
				pro.add("HP");		pri.add("75000");
				pro.add("Dell");	pri.add("80000");
				pro.add("Realme");	pri.add("45000");
				pro.add("Apple");	pri.add("150000");
			}
			if(it.getSelectedItem().equals("Charger")) {
				pro.add("SamSung");	pri.add("1000");
				pro.add("Redme");	pri.add("600");
				pro.add("Realme");	pri.add("700");
				pro.add("iPhone");	pri.add("2000");
				pro.add("In Note 1");	pri.add("500");
			}
			if(it.getSelectedItem().equals("Slippers")) {
				pro.add("spark");	pri.add("750");
				pro.add("Tiger");	pri.add("1000");
				pro.add("Paragun");	pri.add("900");
				pro.add("sports");	pri.add("300");
			}
		
		}
		if(e.getSource() == pro) {
			pri.select(pro.getSelectedIndex());
			qn.setEnabled(true);
		}
		if(e.getSource() == qn) {
			int a = Integer.parseInt(pri.getSelectedItem());
			int b = Integer.parseInt(qn.getSelectedItem());
			int c = a*b;
			gtot = c + gtot;

			sit.add(it.getSelectedItem());
			spro.add(pro.getSelectedItem());
			spri.add(pri.getSelectedItem());
			sqn.add(qn.getSelectedItem());
			stot.add(Integer.toString(c));
			grand.removeAll();
			grand.add(Integer.toString(gtot));
			pro.removeAll();
			pri.removeAll();
			qn.select(0);
			qn.setEnabled(false);
		}
		if(e.getSource() == sit) {
			
			spri.setEnabled(false);
			spro.setEnabled(false);
			sqn.setEnabled(false);
			stot.setEnabled(false);
			
			spro.select(sit.getSelectedIndex());
			spri.select(spro.getSelectedIndex());
			sqn.select(spri.getSelectedIndex());
			stot.select(sqn.getSelectedIndex());
		}
	}

	public static void main(String ar[]) {

		new Market();
	}

}