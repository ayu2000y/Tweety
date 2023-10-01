package twitter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TweetUpdate {
	private static Connection cn = null;
	private PreparedStatement st = null;
	//ツイートを編集
	public void tweetUpdate(TweetList tl) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","twitter","tw");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			
			String sql = "UPDATE tweet_list SET content = ?, time_setting = TO_DATE(?, 'YY-MM-DD HH24:MI:SS') WHERE content_id = ?";
			st = cn.prepareStatement(sql);
			
			
			System.out.println(tl.getTimeSetting() + "\t" + tl.getContentId());
			st.setString(1, tl.getContent());
			st.setString(2, tl.getTimeSetting());
			st.setString(3, tl.getContentId());

			st.executeUpdate();
			System.out.println("更新しました");
			
			cn.close();
			System.out.println("接続終了");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//公開設定変更
	public void visibilityUpdate(TweetList tl) {
		try {
			if(tl.getVisibility()!=null){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","twitter","tw");
				cn.setAutoCommit(false);
				System.out.println("接続完了");
				
				String sql = "UPDATE tweet_list SET visibility = ?  WHERE content_id = ?";
				st = cn.prepareStatement(sql);
				
				System.out.println(tl.getContentId());
				st.setString(1, tl.getVisibility());
				st.setString(2, tl.getContentId());
				
				
				st.executeUpdate();
				System.out.println("公開設定を更新しました");
				
				cn.close();
				System.out.println("接続終了");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//投稿回数変更
	public void tweetCountUp(TweetList tl) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","twitter","tw");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			
			String sql = "UPDATE tweet_list SET count = count + 1 WHERE content_id = ?";
			
			st = cn.prepareStatement(sql);
			
			System.out.println(tl.getContentId());
			st.setString(1, tl.getContentId());
		
			st.executeUpdate();
			System.out.println("投稿回数を更新しました");

			cn.close();
			System.out.println("接続終了");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}