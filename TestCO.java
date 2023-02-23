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

class TestCO extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	TestCO() {
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
			//System.exit(0);
			//userhome object
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: Complement of the expression A’B + CD’ is _________ ");
			radioButton[0].setText("(A’ + B)(C’ + D) ");
			radioButton[1].setText("(A + B')(C’ + D) ");
			radioButton[2].setText("(A’ + B')(C’ + D) ");
			radioButton[3].setText("(A + B')(C + D') ");
		}
		if (current == 1) {
			label.setText("Que2: Given that F = (A + B'+ C)(D + E), which of the following represents the only correct expression for F'?  ");
			radioButton[0].setText("F' = A'BC'+ D'+ E' ");
			radioButton[1].setText("F' = AB'C + DE ");
			radioButton[2].setText("F' = (A'+ B + C')(D'+ E') ");
			radioButton[3].setText("F' = A'BC' + D'E'");
		}
		if (current == 2) {
			label.setText("Que3: Which is used for storing the one-bit digital data?");
			radioButton[0].setText("NAND gate");
			radioButton[1].setText("NOR gate");
			radioButton[2].setText("Flip FLop");
			radioButton[3].setText("Registers");
		}
		if (current == 3) {
			label.setText("Que4: D flip flop can be made from a J-K flip flop by making");
			radioButton[0].setText("J=K");
			radioButton[1].setText("J=K=1");
			radioButton[2].setText("J=0, K=1");
			radioButton[3].setText("J=K");
		}
		if (current == 4) {
			label.setText("Que5: Master-slave configuration is used in flip flop to");
			radioButton[0].setText("Increasing it's clocking rate");
			radioButton[1].setText("Reduces power dissipation");
			radioButton[2].setText("Eliminates race around condition");
			radioButton[3].setText("Improves it's reliability");
		}
		if (current == 5) {
			label.setText("Que6: Wher two asynchronous active low inputs PRESET and CLEAR are applied to a J-K flip flop the output will be");
			radioButton[0].setText("0");
			radioButton[1].setText("Undefined");
			radioButton[2].setText("Previous state");
			radioButton[3].setText("1");
		}
		if (current == 6) {
			label.setText("Que7: In a J-K flip flop, when J=1 and K=1 then it will be considered as");
			radioButton[0].setText("Set condition");
			radioButton[1].setText("Reset condition");
			radioButton[2].setText("No change condition");
			radioButton[3].setText("Toggle condition");
		}
		if (current == 7) {
			label.setText("Que8: A stack-based CPU organization uses ____ address instructions");
			radioButton[0].setText("2");
			radioButton[1].setText("0");
			radioButton[2].setText("1");
			radioButton[3].setText("3");
		}
		if (current == 8) {
			label.setText("Que9: What is the Von Neumann architecture?");
			radioButton[0].setText("SISD");
			radioButton[1].setText("SIMD");
			radioButton[2].setText("MIMD");
			radioButton[3].setText("MISD");
		}
		if (current == 9) {
			label.setText("Que10: RISC stands for:");
			radioButton[0].setText("Remaining Instruction Set of Computer");
			radioButton[1].setText("Remaining Intermediate Storage of Computer");
			radioButton[2].setText("Reduced Intermediate Storage of Computer");
			radioButton[3].setText("Reduced Instruction Set Computer");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[2].isSelected());
		if (current == 5)
			return (radioButton[1].isSelected());
		if (current == 6)
			return (radioButton[3].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[3].isSelected());
		return false;
	}
}
	 
