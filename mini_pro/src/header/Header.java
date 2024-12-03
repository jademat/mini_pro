package header;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel  {

	private static final long serialVersionUID = 1L;

	public Header() {
		JLabel exLabel = new JLabel("EXERCISE");
	      exLabel.setBounds(200, 30, 159, 40);
	      exLabel.setFont(new Font("굴림", Font.BOLD, 25));
	      exLabel.setForeground(Color.WHITE);
	      add(exLabel);

	      JLabel calLabel = new JLabel("CALENDER");
	      calLabel.setForeground(Color.WHITE);
	      calLabel.setFont(new Font("굴림", Font.BOLD, 25));
	      calLabel.setBounds(500, 30, 159, 40);
	      add(calLabel);
	      JLabel borLabel = new JLabel("BOARD");
	      borLabel.setForeground(Color.WHITE);
	      borLabel.setFont(new Font("굴림", Font.BOLD, 25));
	      borLabel.setBounds(800, 30, 159, 40);
	      add(borLabel);

	      
		setBackground(java.awt.Color.black);
		setPreferredSize(new Dimension(1200, 100)); // 헤더 높이를 100으로 설정
		setLayout(null);
		
		ImageIcon icon = new ImageIcon("images/user.png");
	      JLabel iconLabel = new JLabel(icon);
	      iconLabel.setForeground(Color.WHITE);
	      iconLabel.setBounds(1050, 0, 100, 100);
	      add(iconLabel);
	      
	      JLabel logoImage = new JLabel(new ImageIcon("images/LOGO.png"));
	      logoImage.setBounds(0, 0, 200, 100);
	      add(logoImage);
		
	}

}
