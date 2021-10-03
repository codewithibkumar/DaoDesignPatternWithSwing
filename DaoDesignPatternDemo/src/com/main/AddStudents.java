package com.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.StudentDao;
import com.model.Student;
import javax.swing.JTextArea;

public class AddStudents extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudents frame = new AddStudents();
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
	public AddStudents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(228, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 104, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(228, 143, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(228, 174, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Roll");
		lblNewLabel.setBounds(142, 66, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(142, 107, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course");
		lblNewLabel_2.setBounds(142, 146, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fee");
		lblNewLabel_3.setBounds(142, 177, 46, 14);
		contentPane.add(lblNewLabel_3);
		StudentDao dao = new StudentDao();
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roll = textField.getText();
				String name = textField_1.getText();
				String course = textField_2.getText();
				String fee = textField_3.getText();
				
				
				dao.save(new Student(Integer.parseInt(roll),name,course, Float.parseFloat(fee)));
				JOptionPane.showMessageDialog(AddStudents.this, "Record Saved");

				
			}
		});
		btnNewButton.setBounds(142, 205, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(386, 61, 305, 279);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Show Students");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//fetch record
				List<Student> allStudents = dao.students();
				StringBuffer sb = new StringBuffer();
				for(Student k: allStudents)
				{
					sb.append(k.getRoll()+"\t");
					sb.append(k.getName()+"\t");
					sb.append(k.getCourse()+"\t");
					sb.append(k.getFee()+"\n");
				}
				textArea.setText("");
				textArea.append(sb.toString());
			}
			
		});
		btnNewButton_1.setBounds(382, 351, 161, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int roll = Integer.parseInt(textField.getText());
				dao.delete(roll);
				JOptionPane.showMessageDialog(AddStudents.this,"Student record deleted");
			}
		});
		btnNewButton_2.setBounds(142, 283, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int roll = Integer.parseInt(textField.getText());
				Student k = dao.search(roll);
				if(k != null)
				{
					textArea.setText("");
					textArea.append(k.getRoll()+"\t");
					textArea.append(k.getName()+"\t");
					textArea.append(k.getCourse()+"\t");
					textArea.append(k.getFee()+"\n");
				}
				else
				{
					JOptionPane.showMessageDialog(AddStudents.this,"Student not found");
				}
			}
		});
		btnNewButton_3.setBounds(142, 328, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
