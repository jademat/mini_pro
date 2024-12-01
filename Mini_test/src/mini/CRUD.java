package mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD {

	private JDBC jdbc;	// connect 메소드 호출을 위한 초기화
	
	// Board 테이블 데이터를 조회하여 JTable 모델에 추가하고 데이터를 반환하는 메서드
	// 기본(default) 정렬
	public static List<Object[]> loadTable(DefaultTableModel model) {
     List<Object[]> dataList = new ArrayList<>();
	    String sql = "SELECT boa_no, boa_name, boa_write, boa_notice, boa_like, boa_date, b.mem_id, mem_rank"
	    		+ " FROM board b JOIN member m ON b.mem_id = m.mem_id ORDER BY boa_notice DESC, boa_no DESC";
	    try (Connection con = JDBC.connect(); // 연결 생성
	         PreparedStatement pstmt = con.prepareStatement(sql); // SQL 실행 준비
	         ResultSet rs = pstmt.executeQuery()) { // 쿼리 실행 및 결과 반환
	          
	         // ResultSet을 반복하여 데이터를 추출하고 처리
	         while (rs.next()) {
	             Object[] fullData = {
	                 rs.getInt("boa_no"),
	                 rs.getString("boa_name"),
	                 rs.getString("boa_write"),
	                 rs.getInt("boa_notice"),
	                 rs.getInt("boa_like"),
	                 rs.getString("boa_date").substring(0, 10),
	                 rs.getString("mem_id"),
	                 rs.getInt("mem_rank")
	             };
	             Object[] tableData = { 
	                 rs.getInt("boa_no"),
	                 rs.getString("boa_name"),
	                 rs.getString("mem_id"),
	                 rs.getInt("mem_rank"),
	                 rs.getInt("boa_like"),
	                 rs.getString("boa_date").substring(0, 10)
	             };

	             // JTable 모델에 간단한 데이터 추가
	             model.addRow(tableData);

	             // 전체 데이터를 리스트에 추가
	             dataList.add(fullData);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return dataList; // 조회된 데이터 반환
	 }
	
	
	// 번호 오름차순 정렬
	public static List<Object[]> loadTable2(DefaultTableModel model) {
     List<Object[]> dataList = new ArrayList<>();
	    String sql = "SELECT boa_no, boa_name, boa_write, boa_notice, boa_like, boa_date, b.mem_id, mem_rank"
	    		+ " FROM board b JOIN member m ON b.mem_id = m.mem_id ORDER BY boa_notice DESC, boa_no";
	    try (Connection con = JDBC.connect(); // 연결 생성
	         PreparedStatement pstmt = con.prepareStatement(sql); // SQL 실행 준비
	         ResultSet rs = pstmt.executeQuery()) { // 쿼리 실행 및 결과 반환
	          
	         // ResultSet을 반복하여 데이터를 추출하고 처리
	         while (rs.next()) {
	             Object[] fullData = {
	                 rs.getInt("boa_no"),
	                 rs.getString("boa_name"),
	                 rs.getString("boa_write"),
	                 rs.getInt("boa_notice"),
	                 rs.getInt("boa_like"),
	                 rs.getString("boa_date").substring(0, 10),
	                 rs.getString("mem_id"),
	                 rs.getInt("mem_rank")
	             };
	             Object[] tableData = { 
	                 rs.getInt("boa_no"),
	                 rs.getString("boa_name"),
	                 rs.getString("mem_id"),
	                 rs.getInt("mem_rank"),
	                 rs.getInt("boa_like"),
	                 rs.getString("boa_date").substring(0, 10)
	             };

	             // JTable 모델에 간단한 데이터 추가
	             model.addRow(tableData);

	             // 전체 데이터를 리스트에 추가
	             dataList.add(fullData);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return dataList; // 조회된 데이터 반환
	 }
	
	
	// 인기글순 정렬
	public static List<Object[]> loadTable3(DefaultTableModel model) {
     List<Object[]> dataList = new ArrayList<>();
	    String sql = "SELECT boa_no, boa_name, boa_write, boa_notice, boa_like, boa_date, b.mem_id, mem_rank"
	    		+ " FROM board b JOIN member m ON b.mem_id = m.mem_id ORDER BY boa_notice DESC, boa_like DESC";
	    try (Connection con = JDBC.connect(); // 연결 생성
	         PreparedStatement pstmt = con.prepareStatement(sql); // SQL 실행 준비
	         ResultSet rs = pstmt.executeQuery()) { // 쿼리 실행 및 결과 반환
	          
	         // ResultSet을 반복하여 데이터를 추출하고 처리
	         while (rs.next()) {
	             Object[] fullData = {
	                 rs.getInt("boa_no"),
	                 rs.getString("boa_name"),
	                 rs.getString("boa_write"),
	                 rs.getInt("boa_notice"),
	                 rs.getInt("boa_like"),
	                 rs.getString("boa_date").substring(0, 10),
	                 rs.getString("mem_id"),
	                 rs.getInt("mem_rank")
	             };
	             Object[] tableData = { 
	                 rs.getInt("boa_no"),
	                 rs.getString("boa_name"),
	                 rs.getString("mem_id"),
	                 rs.getInt("mem_rank"),
	                 rs.getInt("boa_like"),
	                 rs.getString("boa_date").substring(0, 10)
	             };

	             // JTable 모델에 간단한 데이터 추가
	             model.addRow(tableData);

	             // 전체 데이터를 리스트에 추가
	             dataList.add(fullData);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return dataList; // 조회된 데이터 반환
	 }
	
	
	// 등급순 정렬
	public static List<Object[]> loadTable4(DefaultTableModel model) {
     List<Object[]> dataList = new ArrayList<>();
	    String sql = "SELECT boa_no, boa_name, boa_write, boa_notice, boa_like, boa_date, b.mem_id, mem_rank"
	    		+ " FROM board b JOIN member m ON b.mem_id = m.mem_id ORDER BY boa_notice DESC, mem_rank DESC";
	    try (Connection con = JDBC.connect(); // 연결 생성
	         PreparedStatement pstmt = con.prepareStatement(sql); // SQL 실행 준비
	         ResultSet rs = pstmt.executeQuery()) { // 쿼리 실행 및 결과 반환
	          
	         // ResultSet을 반복하여 데이터를 추출하고 처리
	         while (rs.next()) {
	             Object[] fullData = {
	                 rs.getInt("boa_no"),
	                 rs.getString("boa_name"),
	                 rs.getString("boa_write"),
	                 rs.getInt("boa_notice"),
	                 rs.getInt("boa_like"),
	                 rs.getString("boa_date").substring(0, 10),
	                 rs.getString("mem_id"),
	                 rs.getInt("mem_rank")
	             };
	             Object[] tableData = { 
	                 rs.getInt("boa_no"),
	                 rs.getString("boa_name"),
	                 rs.getString("mem_id"),
	                 rs.getInt("mem_rank"),
	                 rs.getInt("boa_like"),
	                 rs.getString("boa_date").substring(0, 10)
	             };

	             // JTable 모델에 간단한 데이터 추가
	             model.addRow(tableData);

	             // 전체 데이터를 리스트에 추가
	             dataList.add(fullData);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return dataList; // 조회된 데이터 반환
	 }

	 
	 public static void deleteTable(JTable table) {		 
		try {
			String sql = "delete from board where BOA_NO = ?";
			Connection con = JDBC.connect();
	        PreparedStatement pstmt;
			pstmt = con.prepareStatement(sql);
			
			// 선택 된 행의 값을 반환
			int row = table.getSelectedRow();
			pstmt.setInt(1, (int)table.getValueAt(row, 0));
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "게시글 삭제 성공");
			} else {
				JOptionPane.showMessageDialog(null, "게시글 삭제 실패");
			}
			table.removeRowSelectionInterval(row, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}   
	 }
	 
	 public static void updateBoard(int boardNo, String title, String content) {
		    String sql = "UPDATE board SET boa_name = ?, boa_write = ? WHERE boa_no = ?";
		    try (
		    	Connection con = JDBC.connect(); 
		    	PreparedStatement pstmt = con.prepareStatement(sql)) {
		        pstmt.setString(1, title);
		        pstmt.setString(2, content);
		        pstmt.setInt(3, boardNo);
		        int result = pstmt.executeUpdate();
		        if (result > 0) {
		        	JOptionPane.showMessageDialog(null, "게시글 수정 완료");
		        } else {
		        	JOptionPane.showMessageDialog(null, "게시글 수정 실패");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();		    
		    }
		}

	 
	 public static int updateLikes(int boardNo) {
		    String sql = "UPDATE board SET boa_like = boa_like + 1 WHERE boa_no = ?";
		    try (
		    	Connection con = JDBC.connect(); 
		    	PreparedStatement pstmt = con.prepareStatement(sql)) {
		        pstmt.setInt(1, boardNo);
		        pstmt.executeUpdate();

		        // 좋아요 수 반환
		        String fetchSql = "SELECT boa_like FROM board WHERE boa_no = ?";
		        try (
		        	PreparedStatement fetchPstmt = con.prepareStatement(fetchSql)) {
		            fetchPstmt.setInt(1, boardNo);
		            ResultSet rs = fetchPstmt.executeQuery();
		            if (rs.next()) {
		                return rs.getInt("boa_like");
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return -1;
		}
	 
	 public static void deleteBoard(int boardNo) {
		    String sql = "DELETE FROM board WHERE boa_no = ?";
		    try (
		    	Connection con = JDBC.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
		        pstmt.setInt(1, boardNo);
		        pstmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "게시글 삭제 실패: " + e.getMessage());
		    }
	 }
	 
	 public static void insertBoard(String board_name, String board_write) {
		 	try {
		        Connection con = JDBC.connect();
		        PreparedStatement pstmt;
				
				// 게시판번호(최신화) 구하는 코드
				String select = "select max(boa_no) from board";
				pstmt = con.prepareStatement(select);
				ResultSet rs = pstmt.executeQuery();
				int count = 0;
				if (rs.next()) {
					count = rs.getInt(1);
				}
				//insert into board values(2, '게시물 2', '게시물 내용 2', 0, 0, sysdate, 4);
				String sql = "insert into board values(?, ?, ?, 0, 0, sysdate, 'kang')";
				pstmt = con.prepareStatement(sql);					
				pstmt.setInt(1, count + 1);					// 글 번호(최신화)
				pstmt.setString(2, board_name);	// 글 제목
				pstmt.setString(3, board_write);	// 글 내용
				//pstmt.setInt(4, '0');
				//pstmt.setInt(5, '0');
				
				int result = pstmt.executeUpdate();
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "글 등록 완료");
				} else {
					JOptionPane.showMessageDialog(null, "글 등록 실패");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
}
