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

class TestJava extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	TestJava() {
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
			label.setText("Que1:  Who developed object oriented programming?");
			radioButton[0].setText("Adele Goldberg");
			radioButton[1].setText("Dennis Richie");
			radioButton[2].setText("Alan Kay");
			radioButton[3].setText("Andrea Ferro");
		}
		if (current == 1) {
			label.setText("Que2:  Which of the following is not an OOPS concept?");
			radioButton[0].setText("Encapsulation");
			radioButton[1].setText("Polymorphism");
			radioButton[2].setText("Exception");
			radioButton[3].setText("Abstraction");
		}
		if (current == 2) {
			label.setText("Que3: Which feature of OOPS described the reusability of code?");
			radioButton[0].setText("Abstraction");
			radioButton[1].setText("Encapsulation");
			radioButton[2].setText("Polymorphism");
			radioButton[3].setText("Inheritance");
		}
		if (current == 3) {
			label.setText("Que4: Which feature of OOPS derives the class from another class?");
			radioButton[0].setText("Inheritance");
			radioButton[1].setText("Data hiding");
			radioButton[2].setText("Encapsulation");
			radioButton[3].setText("Polymorphism");
		}
		if (current == 4) {
			label.setText("Que5:  What of the following definition is incorrect for polymorphism?");
			radioButton[0].setText("Polymorphism helps in redefining the same functionality ");
			radioButton[1].setText("Polymorphism concept is the feature of object-oriented programming (OOP)");
			radioButton[2].setText("It always increases the overhead of function definition");
			radioButton[3].setText("Ease in the readability of the program");
		}
		if (current == 5) {
			label.setText("Que6: Which of the following feature is also known as run-time binding or late-binding?");
			radioButton[0].setText("Dynamic typing");
			radioButton[1].setText("Dynamic loading");
			radioButton[2].setText("Dynamic binding");
			radioButton[3].setText("Data hiding");
		}
		if (current == 6) {
			label.setText("Que7:  Which of the following class is known as the generic class");
			radioButton[0].setText("Final class");
			radioButton[1].setText("Template class");
			radioButton[2].setText("Abstract class");
			radioButton[3].setText("Efficient code");
		}
		if (current == 7) {
			label.setText("Que8:  Which of the following OOP concept binds the code and data together and keeps them secure from the outside world?");
			radioButton[0].setText("Polymorphism");
			radioButton[1].setText("Inheritance");
			radioButton[2].setText("Abstraction");
			radioButton[3].setText("Encapsulation");
		}
		if (current == 8) {
			label.setText("Que9: Which memeber of the superclass is never accesible to the subclass?");
			radioButton[0].setText("Public member");
			radioButton[1].setText("Protected member");
			radioButton[2].setText("Private member");
			radioButton[3].setText("All of the above");
		}
		if (current == 9) {
			label.setText("Que10: Which class cannot create its instance?");
			radioButton[0].setText("Superclass");
			radioButton[1].setText("Nested class");
			radioButton[2].setText("Abstract class");
			radioButton[3].setText("Public class");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[2].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[3].isSelected());
		if (current == 3)
			return (radioButton[0].isSelected());
		if (current == 4)
			return (radioButton[2].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[2].isSelected());
		if (current == 9)
			return (radioButton[2].isSelected());
		return false;
	}
}
	 
