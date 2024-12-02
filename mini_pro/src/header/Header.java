package header;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import jdbc.JDBC;
import login.Login;
import login.Profile;
import login.Welcome;

public class Header extends JPanel {
	private String mem_id;
	private JDBC jdbc;

	public Header(JDBC jdbc, String mem_id) {
		this.jdbc = jdbc;
		this.mem_id = mem_id;
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(1200, 100));
        setLayout(null);

        // 로고 추가
        JLabel logoLabel = new JLabel(new ImageIcon("backimage/logo.png"));
        logoLabel.setBounds(10, 10, 150, 80); // 크기 및 위치 설정
        add(logoLabel);

        // 네비게이션 버튼
        String[] navItems = {"EXECRISE", "CALENDAR", "BOARD"};
        int xPos = 200; // 시작 위치

        for (String item : navItems) {
            JLabel navLabel = new JLabel(item);
            navLabel.setForeground(Color.WHITE);
            navLabel.setFont(new Font("굴림", Font.BOLD, 20));
            navLabel.setBounds(xPos, 30, 150, 40);
            navLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // 클릭 이벤트
            navLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(item + " Clicked!"); // 실제 페이지 전환 구현
                }
            });

            add(navLabel);
            xPos += 200; // 다음 버튼 위치로 이동
        }

        // 사용자 아이콘 및 팝업 메뉴
        JLabel userIcon = new JLabel(new ImageIcon("backimage/user.png"));
        userIcon.setBounds(1050, 10, 80, 80);
        userIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(userIcon);

        JPopupMenu userMenu = new JPopupMenu();
        JMenuItem profile = new JMenuItem("Profile");
        JMenuItem myBoard = new JMenuItem("MY Board");
        JMenuItem settingsItem = new JMenuItem("Settings");
        JMenuItem logout = new JMenuItem("Logout");	

        userMenu.add(profile);
        userMenu.add(myBoard);
        userMenu.add(logout);

        userIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userMenu.show(userIcon, e.getX(), e.getY());
            }
        });
        
        profile.addActionListener(e -> {
        	new Profile(jdbc,mem_id).setVisible(true);
        });

        // 로그아웃 버튼 클릭 시 행동
        logout.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(Header.this).dispose(); // 현재 창 닫기
            new Login().setVisible(true); // 로그인 화면 열기
        });
    }
}