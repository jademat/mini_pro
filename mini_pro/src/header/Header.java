package header;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel  {

	private static final long serialVersionUID = 1L;

	public Header() {
		
		setBackground(java.awt.Color.black);
		setPreferredSize(new Dimension(1200, 150)); // 헤더 높이를 100으로 설정
		setLayout(null);
		
		JLabel exLabel = new JLabel("EXERCISE");
		exLabel.setBounds(170, 53, 159, 40);
		exLabel.setFont(new Font("굴림", Font.BOLD, 25));
		exLabel.setForeground(Color.WHITE);
		add(exLabel);
		
		JLabel calLabel = new JLabel("CALENDER");
		calLabel.setForeground(Color.WHITE);
		calLabel.setFont(new Font("굴림", Font.BOLD, 25));
		calLabel.setBounds(400, 53, 159, 40);
		add(calLabel);
		
		JLabel borLabel = new JLabel("BORDER");
		borLabel.setForeground(Color.WHITE);
		borLabel.setFont(new Font("굴림", Font.BOLD, 25));
		borLabel.setBounds(681, 53, 159, 40);
		add(borLabel);
		
	}

}
