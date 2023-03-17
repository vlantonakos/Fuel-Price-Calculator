import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


public class InputGUI extends JFrame{
	private JPanel panel;
	private JLabel lKmLabel;
	private JTextField lKm;
	private JLabel distanceLabel;
	private JTextField distance;
	private JLabel priceLabel;
	private JTextField price;
	private JButton calculateBtn;
	private JTextField finalprice;
	
	public InputGUI(Fuel fuel) {
		
		panel = new JPanel();
		
		lKmLabel = new JLabel("Litres per 100km: ");
		lKm = new JTextField("Litres per 100km");
		distanceLabel = new JLabel("The distance is(in KM): ");
		distance = new JTextField("Distance");
		priceLabel = new JLabel("The price of " + fuel.getName() + " is: ");
		price = new JTextField("Price of " + fuel.getName() );
		calculateBtn = new JButton("Calculate the cost");
		finalprice = new JTextField(20);
		
		panel.add(lKmLabel);
		panel.add(lKm);
		panel.add(distanceLabel);
		panel.add(distance);
		panel.add(priceLabel);
		panel.add(price);
		panel.add(calculateBtn);
		panel.add(finalprice);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		calculateBtn.addActionListener(listener);
		
		this.setVisible(true);
		this.setTitle("Price Calculator");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(calculateBtn)) {
				String litresText = lKm.getText();
				double litresD = Double.parseDouble(litresText);
				
				String distanceText = distance.getText();
				double distanceD = Double.parseDouble(distanceText);
				
				String priceText = price.getText();
				double priceD = Double.parseDouble(priceText);
				
				double litres_cost = (litresD*distanceD)/100;
				double cost = Math.floor(priceD * litres_cost);
				finalprice.setText("The cost is close to: " + Double.toString(cost) + " Euros");
			}
			
		}
	}	
	
}
