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

class TestDS extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	TestDS	() {
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
			label.setText("Que1:  Which of the following is a linear data structure?");
			radioButton[0].setText("Array");
			radioButton[1].setText("AVL Trees");
			radioButton[2].setText("Binary Trees");
			radioButton[3].setText("Graphs");
		}
		if (current == 1) {
			label.setText("Que2:  Which of the following is not the type of queue?");
			radioButton[0].setText("Priority queue");
			radioButton[1].setText("Single-ended queue");
			radioButton[2].setText("Circular queue");
			radioButton[3].setText("Ordinary queue");
		}
		if (current == 2) {
			label.setText("Que3: Minimum number of fields in each node of a doubly linked list is");
			radioButton[0].setText("2");
			radioButton[1].setText("3");
			radioButton[2].setText("4");
			radioButton[3].setText("None of the above");
		}
		if (current == 3) {
			label.setText("Que4: The elements of a linked list are stored");
			radioButton[0].setText("In a structure");
			radioButton[1].setText("In an array");
			radioButton[2].setText("Anywhere the computer has space for them");
			radioButton[3].setText("In contiguous memory locations");
		}
		if (current == 4) {
			label.setText("Que5: To perform level-order traversal on a binary tree, which of the following data structure will be required?");
			radioButton[0].setText("Hash table");
			radioButton[1].setText("Queue");
			radioButton[2].setText("Binary search tree");
			radioButton[3].setText("Stack");
		}
		if (current == 5) {
			label.setText("Que6: Which of the follwoing data structure is more appropriate for implementing quick sort iteratively?");
			radioButton[0].setText("Deque");
			radioButton[1].setText("Queue");
			radioButton[2].setText("Stack");
			radioButton[3].setText("Priority queue");
		}
		if (current == 6) {
			label.setText("Que7:  The data structure which follows Last-In-First-Out principle is");
			radioButton[0].setText("Stacks");
			radioButton[1].setText("Queues");
			radioButton[2].setText("Binary Trees");
			radioButton[3].setText("Linked lists");
		}
		if (current == 7) {
			label.setText("Que8: What is the other name for the Circular Linked Lists?");
			radioButton[0].setText("Square Buffer");
			radioButton[1].setText("Rectangle Buffer");
			radioButton[2].setText("Ring Buffer");
			radioButton[3].setText("None of the above");
		}
		if (current == 8) {
			label.setText("Que9: When the user tries to delete an element from an empty stack the condition is called as ____");
			radioButton[0].setText("Overflow");
			radioButton[1].setText("Underflow");
			radioButton[2].setText("Garbage Collection");
			radioButton[3].setText("None of the above");
		}
		if (current == 9) {
			label.setText("Que10: Which data structure is mainly used to implement recursions?");
			radioButton[0].setText("Stacks");
			radioButton[1].setText("Queues");
			radioButton[2].setText("Binary Tress");
			radioButton[3].setText("Linked Lists");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[0].isSelected());
		if (current == 4)
			return (radioButton[2].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[0].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[1].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}
}
	 
