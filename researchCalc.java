package researchCalc;

//TODO: Koios color scheme?
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class researchCalc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtremainRP;
	private JTextField txtrStudy;
	private JTextField txtticksStudy;
	private JTextField txttickTime;
	private JTextField txtcurrentStudies;
	private JTextField txtstudiesBar;
	private JTextField txtkoiCrew;
	private JTextField txtk5Installs;
	private JTextField txtTimeNeeded;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					researchCalc frame = new researchCalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public researchCalc() {
		setTitle("Koios Research Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Labels of all the fields
		
		JLabel lblNewLabel = new JLabel("Remaining research Cost");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(46, 34, 137, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RP per study");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(46, 57, 76, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ticks per study");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(46, 80, 76, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Seconds per tick");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(46, 103, 90, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Completed Studies");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(46, 126, 90, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Studies per bar");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(46, 149, 76, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Number of Koios Crew");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(46, 172, 114, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Koi5 points (out of 5)");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(46, 195, 114, 13);
		contentPane.add(lblNewLabel_7);
		
		//text fields that users input data into
		
		txtremainRP = new JTextField();
		txtremainRP.setBounds(206, 31, 96, 19);
		contentPane.add(txtremainRP);
		txtremainRP.setColumns(10);
		
		txtrStudy = new JTextField();
		txtrStudy.setBounds(206, 54, 96, 19);
		contentPane.add(txtrStudy);
		txtrStudy.setColumns(10);
		
		txtticksStudy = new JTextField();
		txtticksStudy.setBounds(206, 77, 96, 19);
		contentPane.add(txtticksStudy);
		txtticksStudy.setColumns(10);
		
		txttickTime = new JTextField();
		txttickTime.setBounds(206, 100, 96, 19);
		contentPane.add(txttickTime);
		txttickTime.setColumns(10);
		
		txtcurrentStudies = new JTextField();
		txtcurrentStudies.setBounds(206, 123, 96, 19);
		contentPane.add(txtcurrentStudies);
		txtcurrentStudies.setColumns(10);
		
		txtstudiesBar = new JTextField();
		txtstudiesBar.setBounds(206, 146, 96, 19);
		contentPane.add(txtstudiesBar);
		txtstudiesBar.setColumns(10);
		
		txtkoiCrew = new JTextField();
		txtkoiCrew.setBounds(206, 169, 96, 19);
		contentPane.add(txtkoiCrew);
		txtkoiCrew.setColumns(10);
		
		txtk5Installs = new JTextField();
		txtk5Installs.setBounds(206, 192, 96, 19);
		contentPane.add(txtk5Installs);
		txtk5Installs.setColumns(10);
		
		//Does the hard part, hopefully
		JButton btnCalc = new JButton("Calculate!");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//grabs the values, hopefully
				double remainingRP = Double.valueOf(txtremainRP.getText());
				double researchStudy = Double.valueOf(txtrStudy.getText());
				double ticks = Double.valueOf(txtticksStudy.getText());
				double secondsPerTick = Double.valueOf(txttickTime.getText());
				double studies = Double.valueOf(txtcurrentStudies.getText());
				double bar = Double.valueOf(txtstudiesBar.getText());
				int crew = Integer.parseInt(txtkoiCrew.getText());
				int k5Points = Integer.parseInt(txtk5Installs.getText());
				//getting initial details ironed out
				double koi5x = 0.00001 * studies * crew * k5Points;
				double baseRP = researchStudy/koi5x;
				int studyBars2Finish = 0;
				
				while (remainingRP > 0) {
					remainingRP -= baseRP * koi5x;
					studies += bar;
					studyBars2Finish++;
					koi5x = 0.00001 * studies * crew * k5Points;
				}
				
				double remainingTimeSec = studyBars2Finish * ticks * secondsPerTick;
				/*
				 * time[0] = days
				 * time[1] = hours
				 * time[2] = minutes
				 * time[3] = seconds
				 */
				int[] time= new int[4];
				
				//dirty work, maybe
				
				while(remainingTimeSec > 0) {
					if(remainingTimeSec > 86400) {
						time[0] += 1;
						remainingTimeSec -= 86400;
					}
					else if(remainingTimeSec > 3600) {
						time[1] +=1;
						remainingTimeSec -= 3600;
					}
					else if(remainingTimeSec > 60) {
						time[2] += 1;
						remainingTimeSec -= 60;
					}
					else {
						time[3] = (int) remainingTimeSec;
						remainingTimeSec = 0;
					}
				}
				txtTimeNeeded.setText(time[0] + " days " + time[1] + " hours " + time[2] + " minutes " + time[3] + " seconds");
			}
		});
		btnCalc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCalc.setBounds(206, 232, 85, 21);
		contentPane.add(btnCalc);
		
		//Clears all fields
		
		JButton btnReset = new JButton("Reset values");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtremainRP.setText("");
				txtrStudy.setText("");
				txtticksStudy.setText("");
				txttickTime.setText("");
				txtcurrentStudies.setText("");
				txtstudiesBar.setText("");
				txtkoiCrew.setText("");
				txtk5Installs.setText("");
				txtTimeNeeded.setText("");
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnReset.setBounds(361, 232, 108, 21);
		contentPane.add(btnReset);
		
		txtTimeNeeded = new JTextField();
		txtTimeNeeded.setBounds(206, 299, 393, 19);
		contentPane.add(txtTimeNeeded);
		txtTimeNeeded.setColumns(20);
		
		JLabel lblNewLabel_8 = new JLabel("Time Remaining for Research");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(46, 302, 150, 13);
		contentPane.add(lblNewLabel_8);
		
	}
}
