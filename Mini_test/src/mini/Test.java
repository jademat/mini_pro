package mini;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Test {
	
    public static void main(String[] args) {
    	
        JFrame frame = new JFrame();
        frame.setTitle("운동관리시스템");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setLayout(null); // 레이아웃 매니저 비활성화 ==> borderlayout 사용으로 비활성화

        // Header 패널
        Header2 headerPanel = new Header2();
        headerPanel.setBounds(0, 0, 1200, 100); // 상단 고정 위치   
        headerPanel.setLayout(new BorderLayout(0, 0));
        
        // 패널 초기화
        Board2 boardPanel = new Board2();
        boardPanel.setBounds(0, 100, 1186, 663);
        boardPanel.setLayout(new BorderLayout(0, 0));

        DetailPanel detailPanel = new DetailPanel();
        detailPanel.setBounds(0, 100, 1186, 663);
        detailPanel.setLayout(new BorderLayout(0, 0));
        
        InsertPanel insertPanel = new InsertPanel();
        insertPanel.setBounds(0, 100, 1186, 663);
        insertPanel.setLayout(new BorderLayout(0, 0));
        
        // 패널 추가
        frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
        frame.getContentPane().add(boardPanel, BorderLayout.CENTER);
        frame.getContentPane().add(detailPanel, BorderLayout.CENTER);
        frame.getContentPane().add(insertPanel, BorderLayout.CENTER);
        
        // 기본 화면 설정
        boardPanel.setVisible(true);
        detailPanel.setVisible(false);
        insertPanel.setVisible(false);

        // Board2에서 DetailPanel에 접근할 수 있도록 연결
        boardPanel.setBoardPanel(detailPanel, insertPanel, boardPanel);        
        detailPanel.setDetailPanel(boardPanel, detailPanel);        
        insertPanel.setInsertPanel(boardPanel, insertPanel);       

        frame.setVisible(true);
    }
}
