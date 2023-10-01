package twitter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TweetDelete {
	private static Connection cn = null;
	private PreparedStatement st = null;
	//登録したツイートを削除
	public void tweetDelete(TweetList tl) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","twitter","tw");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			
			String sql = "DELETE FROM tweet_list　WHERE content_id = ?";
			st = cn.prepareStatement(sql);
			System.out.println("1行削除しました");
			
			st.setString(1, tl.getContentId());
			System.out.println(tl.getContentId());

			st.executeUpdate();
			
			cn.close();
			System.out.println("接続終了");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}