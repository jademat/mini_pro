package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jdbc.JDBC;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel container;
	JDBC jdbc = new JDBC();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 553);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(container);
		container.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(31, 70, 295, 391);
		container.add(panel);
		panel.setLayout(null);

		JLabel idField = new JLabel("ID");
		idField.setFont(new Font("굴림", Font.BOLD, 17));
		idField.setForeground(Color.WHITE);
		idField.setBounds(12, 72, 63, 24);
		panel.add(idField);

		JTextField idText = new JTextField(20);
		idText.setFont(new Font("굴림", Font.PLAIN, 15));
		idText.setBounds(12, 106, 133, 21);
		panel.add(idText);
		idText.setColumns(10);

		JLabel passField = new JLabel("PASSWORD");
		passField.setForeground(Color.WHITE);
		passField.setBackground(Color.WHITE);
		passField.setFont(new Font("굴림", Font.BOLD, 17));
		passField.setBounds(12, 168, 108, 15);
		panel.add(passField);

		JPasswordField passTexst = new JPasswordField(20);
		passTexst.setFont(new Font("굴림", Font.PLAIN, 15));
		passTexst.setBounds(12, 193, 133, 21);
		panel.add(passTexst);

		JLabel jl3 = new JLabel("ALL RIGHT");
		jl3.setFont(new Font("굴림", Font.BOLD, 20));
		jl3.setForeground(Color.WHITE);
		jl3.setBounds(67, 10, 133, 32);
		panel.add(jl3);

		JButton logB = new JButton("LOGIN");
		logB.setBackground(Color.BLACK);
		logB.setForeground(Color.WHITE);
		logB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = idField.getText();
					String password = new String(passTexst.getPassword());
					if (authenticate(id, password)) {
						JOptionPane.showMessageDialog(null, "로그인 성공!");
						
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "ID 또는 비밀번호가 잘못되었습니다.");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "로그인 중 오류가 발생했습니다.");
				}
			}
		});
		logB.setBounds(12, 291, 91, 23);
		panel.add(logB);

		JButton upB = new JButton("SIGN UP");
		upB.setBackground(Color.BLACK);
		upB.setForeground(Color.WHITE);
		upB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SignUp s = new SignUp();
				setVisible(false);
				s.setVisible(true);
				
			}
		});
		upB.setBounds(142, 291, 91, 23);
		panel.add(upB);

		JLabel back = new JLabel();
		back.setIcon(new ImageIcon("backimage/young_mini.jpg"));
		back.setBounds(0, 0, 1000, 520);
		container.add(back);
	}

	private boolean authenticate(String id, String password) throws SQLException {
		jdbc.connect();
		String hashedPassword = SecurityUtil.hashPassword(password); // 비밀번호 해싱
		jdbc.sql = "SELECT * FROM member WHERE mem_id = ? AND mem_pass = ?";
		jdbc.pstmt = jdbc.con.prepareStatement(jdbc.sql);
		jdbc.pstmt.setString(1, id);
		jdbc.pstmt.setString(2, hashedPassword);

		ResultSet rs = jdbc.pstmt.executeQuery();
		boolean isAuthenticated = rs.next();
		return isAuthenticated;
	}
}
