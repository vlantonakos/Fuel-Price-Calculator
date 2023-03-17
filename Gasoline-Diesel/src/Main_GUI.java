import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Main_GUI extends JFrame{
	private JPanel panel;
	private JButton gasBtn;
	private JButton dieselBtn;
	private JLabel label;
	
	public Main_GUI() {
		
		panel = new JPanel();
		
		label = new JLabel("What fuel does your car use?");
		gasBtn = new JButton("GASOLINE");
		dieselBtn = new JButton("DIESEL");
		
		panel.add(label);
		panel.add(gasBtn);
		panel.add(dieselBtn);
		
		this.setContentPane(panel);
		
		
		ButtonListener listener = new ButtonListener();
		gasBtn.addActionListener(listener);
		dieselBtn.addActionListener(listener);
		
		
		this.setVisible(true);
		this.setTitle("Fuel");
		this.setSize(400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(dieselBtn)) {
					dispose();
					Fuel fuel = new Fuel("Diesel");
					InputGUI myGUI = new InputGUI(fuel);
				} else {
					dispose();
					Fuel fuel = new Fuel("Gasoline");
					InputGUI myGUI = new InputGUI(fuel);
				}
		}	
	}


}
