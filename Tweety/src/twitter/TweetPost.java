package twitter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TweetPost {
	private static Connection cn = null;
	private PreparedStatement st = null;
	//時刻設定なしの公開されてるツイートをランダムで取得
	public TweetList tweetPostNoTime() {
		TweetList tlist = new TweetList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","twitter","tw");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			
			String sql = "SELECT content_id, content, count, TO_CHAR(time_setting, 'yyyy/mm/dd hh24:mi'), visibility FROM ( SELECT dbms_random.random() as rnd, tweet_list.* FROM tweet_list ORDER BY rnd) WHERE ROWNUM <= 1 AND time_setting IS null AND visibility = '公開' ";
			
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				
				tlist.setContentId(rs.getString(1));
				tlist.setContent(rs.getString(2));
				tlist.setCount(rs.getInt(3));
				if(rs.getString(4)==null) {
					tlist.setTimeSetting("時刻設定なし");
				}else {
					tlist.setTimeSetting(rs.getString(4));
				}
				tlist.setVisibility(rs.getString(5));
			
				System.out.println("Listの中"+rs.getString(1));
			}
			
			cn.close();
			System.out.println("接続終了");
		}catch(Exception e){
			e.printStackTrace();
		}
		return tlist;
	}
	
	
}
