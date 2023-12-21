import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

//Represents the GUI for checking order history
public class CheckOrderHistory extends JFrame{

	private JFrame frame;
	private String totalOrderList;


	// Constructor to create the CheckOrderHistory window with order history content
	public CheckOrderHistory(String totalOrderList) {
		this.totalOrderList = totalOrderList;
		initialize();
	}


	// Method to initialize the contents of the frame
	private void initialize() {
		
		frame = new JFrame();
		
		frame.setTitle("Order History");
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(20);
		textArea.setLineWrap(true);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JButton backButton = new JButton("Back");
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		
		frame.getContentPane().add(backButton, BorderLayout.SOUTH);
		
		textArea.setText(totalOrderList);
		
		frame.setVisible(true);
		
		
	}
	
		//Method for saving result to txt.file
		//gets content from outputTextArea and save result as 'output.txt'
		private void saveResultToFile(String content) {
		    try (PrintWriter writer = new PrintWriter(new FileOutputStream("order_history.txt"), false)) {
		        writer.println(content);
		        writer.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

}
