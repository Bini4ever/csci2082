package poject1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/*****************************************************************
 * @author biniam lemma and Ismail Abiola
 *	
 ****************************************************************/
public class ProjectGui extends JFrame implements ActionListener{
	
	static IndexArrayList xList = new IndexArrayList(); //arraylist used to store the human player index
	static IndexArrayList oList = new IndexArrayList(); // //arraylist used to store the computer index
	
	// Gui components
	private JPanel contentPane;
	private JPanel firstPanel = new JPanel(new BorderLayout());
	private JPanel topPanel = new JPanel(new GridLayout(1, 3));
	private JPanel midPanel = new JPanel(new GridLayout(1, 3));
	private JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
	private JPanel bottomPanel1 = new JPanel(new BorderLayout());
	private JPanel bottomPanel2 = new JPanel(new BorderLayout());
	private JTextField[] field = new JTextField[9];
	private JButton addButton = new JButton("add");
	private JButton reStartButton = new JButton("Restart");
	private JTextArea txtArea = new JTextArea();
	private JTextField field1 = new JTextField();

	
	/*************************************************************
	 * Launch the application.
	 * main function
	 *************************************************************/
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectGui frame = new ProjectGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/****************************************************************
	 * Create the frame.
	 ***************************************************************/
	public ProjectGui() {
		this.setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 400, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(6, 1));
		setContentPane(contentPane);
		this.getContentPane().setBackground(Color.black);
		firstPanel.setBackground(Color.black);
		topPanel.setBackground(Color.black);
		midPanel.setBackground(Color.black);
		bottomPanel.setBackground(Color.black);
		bottomPanel1.setBackground(Color.black);
		bottomPanel2.setBackground(Color.black);
		
		// declare the fonts
		Font font = new Font("font", Font.BOLD, 19);
		Font font1 = new Font("font1", Font.BOLD, 90);
		Font font2 = new Font("font2", Font.BOLD, 50);
		
		addButton.addActionListener(this);
		reStartButton.addActionListener(this);
		
		for (int i = 0; i < 9; i ++){
			field[i] = new JTextField();
		}
		
		for (int i = 0; i < 9; i++){
			field[i].setFont(font1);
			field[i].setForeground(Color.BLUE);
		}
		
		for (int i = 0; i < 9; i++){
			field[i].setHorizontalAlignment(JTextField.CENTER);
		}
	  
		// set the fonts
		txtArea.setFont(font2);
		field1.setFont(font);
		field1.setText("Enter 'X' in the boxes then click 'add'");
		//add fields to the panel
		firstPanel.add(field1, BorderLayout.CENTER);
		topPanel.add(field[0]);
		topPanel.add(field[1]);
		topPanel.add(field[2]);
		midPanel.add(field[3]);
		midPanel.add(field[4]);
		midPanel.add(field[5]);
		bottomPanel.add(field[6]);
		bottomPanel.add(field[7]);
		bottomPanel.add(field[8]);
		
		// set the frame border for the bottom panel
		bottomPanel1.setBorder(new EmptyBorder(30, 10, 30, 10));
		
		// add buttons to the buttom panel
		bottomPanel1.add(addButton, BorderLayout.WEST);
		bottomPanel1.add(reStartButton, BorderLayout.EAST);
		
		// add textArea to the bottom panel
		bottomPanel2.add(txtArea, BorderLayout.CENTER);
		
		// add panels to the contentPane
		contentPane.add(firstPanel);
		contentPane.add(topPanel);
		contentPane.add(midPanel);
		contentPane.add(bottomPanel);
		contentPane.add(bottomPanel1);
		contentPane.add(bottomPanel2);
		
		
	}

	/****************************************************************
	 * Action Listener
	 ***************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//when click add, add the index to the arrayList for user(X)
		if (e.getActionCommand().equalsIgnoreCase("add")){
			for (int i = 0; i < 9; i++){
				// check if the input is x and add the field index to the xList
				if (field[i].getText().equalsIgnoreCase("x"))
				{
					xList.addInt(i);
				}else{		
					field1.setText("Please Restart and enter X");
				}
			}
			
			//Check the winner and if there is one display
			if (xList.checkSecondRow() || xList.checkSecondRow() || xList.checkThirdRow() 
					|| xList.checkFirstColm() || xList.checkSecondColm() 
					|| xList.checkThirdColm() || xList.checkFirstDiagonal() 
					|| xList.checkSecondDiagonal()){
				txtArea.setForeground(Color.BLUE);
				txtArea.setText("You Win!");
				field1.setText("Click 'Restart' to play again");
				
			} else if((xList.getSize() + oList.getSize()) < 9)//else put O randomly
				{
					int move = randomMove();
						for (int i = 0; i < 9; i++){
							if (move == i){
								field[i].setForeground(Color.RED);
								field[i].setText("O");
								oList.addInt(i);
								break;
							}		
				}
				
				//Check the winner and if there is one display		
				if (oList.checkSecondRow() || oList.checkSecondRow() || oList.checkThirdRow() 
						|| oList.checkFirstColm() || oList.checkSecondColm() 
						|| oList.checkThirdColm() || oList.checkFirstDiagonal() 
						|| oList.checkSecondDiagonal()){
					txtArea.setForeground(Color.RED);
					txtArea.setText("You Lost!");
					field1.setText("Click 'Restart' to play again");
				}
			}
		}
		
		//if the user click restart reset everything and start over.
		else if (e.getActionCommand().equalsIgnoreCase("Restart")){
			for (int i = 0; i < 9; i++){
					field[i].setForeground(Color.BLUE);
					field[i].setText("");
				}
				txtArea.setText("");
				field1.setText("Enter X in the boxes and click 'add'");
				xList.clearList();
				oList.clearList();
			}	
		}
		
	/****************************************************************
	 * Random generator
	 ***************************************************************/
	public static int randomMove(){
		Random random = new Random();
		int num = random.nextInt(8);
		
		// Check if the index is taken
		while(xList.searchInt(num) == true || oList.searchInt(num) == true){	
				num = random.nextInt(8);
		}	
		return num; //return the random number for the index
	}
	
}
