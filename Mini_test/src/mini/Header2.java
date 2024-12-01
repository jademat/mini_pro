package mini;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Header 클래스
class Header2 extends JPanel {
	private static final long serialVersionUID = 1L;

	public Header2() {
		setBackground(java.awt.Color.black);
		setPreferredSize(new Dimension(1200, 100)); // 헤더 높이를 100으로 설정
		setLayout(null);
		
		JLabel logoImage = new JLabel(new ImageIcon("IMAGE/LOGO.png"));
		logoImage.setBounds(0, 0, 200, 100);
		add(logoImage);
		
		ImageIcon icon = new ImageIcon("IMAGE/sp.png");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setForeground(Color.WHITE);
        iconLabel.setBounds(1050, 0, 100, 100);
        add(iconLabel);

		JLabel exLabel = new JLabel("EXERCISE");
		exLabel.setBounds(170, 53, 159, 40);
		exLabel.setFont(new Font("굴림", Font.BOLD, 25));
		exLabel.setForeground(Color.WHITE);
		add(exLabel);

		JLabel calLabel = new JLabel("CALENDAR");
		calLabel.setBounds(400, 53, 159, 40);
		calLabel.setFont(new Font("굴림", Font.BOLD, 25));
		calLabel.setForeground(Color.WHITE);
		add(calLabel);

		JLabel borLabel = new JLabel("BORDER");
		borLabel.setBounds(681, 53, 159, 40);
		borLabel.setFont(new Font("굴림", Font.BOLD, 25));
		borLabel.setForeground(Color.WHITE);
		add(borLabel);
	}
}
