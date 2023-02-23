package testapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

class TestMath extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	TestMath() {
		super();
		label = new JLabel();
		getContentPane().add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			getContentPane().add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		getContentPane().add(btnNext);
		getContentPane().add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(100, 121, 5, 5);
		getContentPane().add(tabbedPane);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			getContentPane().add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "Correct answers= " + count);
			System.exit(0);
		
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: 0.003*0.02 = ?");
			radioButton[0].setText("0.06");
			radioButton[1].setText("0.006");
			radioButton[2].setText("6");
			radioButton[3].setText("0.00006");
		}
		if (current == 1) {
			label.setText("Que2:  What is the average of the numbers: 0,0,4,10,5 and 5?");
			radioButton[0].setText("2");
			radioButton[1].setText("3");
			radioButton[2].setText("4");
			radioButton[3].setText("5");
		}
		if (current == 2) {
			label.setText("Que3: What is the rate of discount if a car which price was $4,000 was sold for $3,200 ?");
			radioButton[0].setText("14%");
			radioButton[1].setText("16%");
			radioButton[2].setText("18%");
			radioButton[3].setText("20%");
		}
		if (current == 3) {
			label.setText("Que4: |–4| + |4| – 4 + 4 = ?");
			radioButton[0].setText("0");
			radioButton[1].setText("2");
			radioButton[2].setText("4");
			radioButton[3].setText("8");
		}
		if (current == 4) {
			label.setText("Que5: What is the value of x in the equation 3x – 15 – 6 = 0 ?");
			radioButton[0].setText("7");
			radioButton[1].setText("8");
			radioButton[2].setText("9");
			radioButton[3].setText("-9");
		}
		if (current == 5) {
			label.setText("Que6: In a certain class the ratio of men to women is 3:5. If the class has 24 people in it, how many are women?");
			radioButton[0].setText("9");
			radioButton[1].setText("12");
			radioButton[2].setText("15");
			radioButton[3].setText("18");
		}
		if (current == 6) {
			label.setText("Que7: What is the Arithmetic Mean of the following data 3,6,9,12,15.");
			radioButton[0].setText("7");
			radioButton[1].setText("9");
			radioButton[2].setText("12");
			radioButton[3].setText("8");
		}
		if (current == 7) {
			label.setText("Que8:   Complete the series: 4.8.9.13.14.18._______?");
			radioButton[0].setText("22");
			radioButton[1].setText("32");
			radioButton[2].setText("11");
			radioButton[3].setText("19");
		}
		if (current == 8) {
			label.setText("Que9: What is the average of first 150 natural numbers?");
			radioButton[0].setText("70");
			radioButton[1].setText("70.5");
			radioButton[2].setText("75");
			radioButton[3].setText("75.5");
		}
		if (current == 9) {
			label.setText("Que10: The simplest form of 1.5 : 2.5 is …………… ");
			radioButton[0].setText("6:10");
			radioButton[1].setText("15:25");
			radioButton[2].setText("0.75:1.25");
			radioButton[3].setText("3:5");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[3].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[3].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[3].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}
}
	 
