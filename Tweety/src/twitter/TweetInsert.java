package twitter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TweetInsert {
	private static Connection cn = null;
	private PreparedStatement st = null;
	public void tweetInsert(TweetList tl) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","twitter","tw");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			
			String sql = "INSERT INTO tweet_list(content_id, content, count, time_setting) VALUES(content_id_seq.NEXTVAL, ?, 0, TO_DATE(?, 'YY-MM-DD HH24:MI:SS') )";
			st = cn.prepareStatement(sql);
			System.out.println("tweet_listにインサートしました");
			
			st.setString(1, tl.getContent());
			st.setString(2, tl.getTimeSetting());

			st.executeUpdate();
			
			cn.close();
			System.out.println("接続終了");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List tweetList() {
		ArrayList tl = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","twitter","tw");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			
			String sql = "SELECT content_id, content, count, TO_CHAR(time_setting, 'yyyy/mm/dd hh24:mi'), visibility FROM tweet_list WHERE time_setting IS NOT null ORDER BY time_setting DESC";
			
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				TweetList tlist = new TweetList();
				tlist.setContentId(rs.getString(1));
				tlist.setContent(rs.getString(2));
				tlist.setCount(rs.getInt(3));
				if(rs.getString(4)==null) {
					tlist.setTimeSetting("時刻設定なし");
				}else {
					tlist.setTimeSetting(rs.getString(4));
				}
				tlist.setVisibility(rs.getString(5));
			
				tl.add(tlist);
				System.out.println("Listの中"+rs.getString(1));
			}
			
			cn.close();
			System.out.println("接続終了");
		}catch(Exception e){
			e.printStackTrace();
		}
		return tl;
	}
	//時間設定されてないものをSELECT
	public List tweetListNoTime() {
		ArrayList tl = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","twitter","tw");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			
			String sql = "SELECT content_id, content, count, TO_CHAR(time_setting, 'yyyy/mm/dd hh24:mi'), visibility FROM tweet_list WHERE time_setting IS null ORDER BY content_id　DESC";
			
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				TweetList tlist = new TweetList();
				tlist.setContentId(rs.getString(1));
				tlist.setContent(rs.getString(2));
				tlist.setCount(rs.getInt(3));
				if(rs.getString(4)==null) {
					tlist.setTimeSetting("時刻設定なし");
				}else {
					tlist.setTimeSetting(rs.getString(4));
				}
				tlist.setVisibility(rs.getString(5));
			
				tl.add(tlist);
				System.out.println("Listの中"+rs.getString(1));
			}
			
			cn.close();
			System.out.println("接続終了");
		}catch(Exception e){
			e.printStackTrace();
		}
		return tl;
	}
	
	public int tweetListCount() {
		int count = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","twitter","tw");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			
			String sql = "SELECT count(content_id) FROM tweet_list";
			
			st = cn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			rs.next();
			count = rs.getInt(1);
			
			cn.close();
			System.out.println("接続終了");
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
}

