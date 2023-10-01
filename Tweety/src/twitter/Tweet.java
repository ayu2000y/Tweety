package twitter;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

public class Tweet {
	/*private static final String consumerKey = "9b2M2sobqn5Q3llmyCgzW3k2r";
	private static final String consumerSecret = "VP1OQ3PpsHFHzjvk2b5KOyFsbkUG9hqxTFESifDL9kbK2ENKBL";
	private static final String accessToken = "1394116360817442820-1Qrd099h9Yi4cnYGuDTS6vjpodHQlz";
	private static final String accessTokenSecret = "vFav2UYEGW0x7bt9wEx3o4vU2Oq4qadea5l43iKRPpBqX";
	*/
	private static final String consumerKey = "";
	private static final String consumerSecret = "";
	private static final String accessToken = "";
	private static final String accessTokenSecret = "";
	public String tweet(String tweet){
		//Twitterオブジェクトを参照
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(accessToken,accessTokenSecret));
		
		String tweetToken = "NG";
		try{
			if(tweet!=null) {
				twitter.updateStatus(tweet);
				System.out.println("ツイートOK");
				tweetToken = "投稿したよ";
			}else {
				tweetToken = "投稿する内容がないよ";
			}
		} catch(TwitterException e){
			System.err.println("ツイート失敗"+e.getMessage());
			if(e.getErrorCode()==187) {
				System.out.println(e.getErrorCode());
				tweetToken = "ちょっと前の内容と重複してるよ";
			}
		}
		return tweetToken;
	}
	//タイムラインを取得
	public List getTimeLine(){     
		ArrayList al = new ArrayList();
	    AccessToken token = new AccessToken(accessToken, accessTokenSecret);
	     
	    Twitter twitter = new TwitterFactory().getInstance();
	    twitter.setOAuthConsumer(consumerKey, consumerSecret);
	    twitter.setOAuthAccessToken(token);
	    try {
			User user = twitter.verifyCredentials();
			
			List<Status> list_status = twitter.getHomeTimeline();
			
		    for (Status status : list_status) {
		        al.add(status.getText());
		    }
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	    return al;
	}
	//自分のアカウント名取得
	public String getMyName(){
		AccessToken token = new AccessToken(accessToken, accessTokenSecret);
	     
	    Twitter twitter = new TwitterFactory().getInstance();
	    twitter.setOAuthConsumer(consumerKey, consumerSecret);
	    twitter.setOAuthAccessToken(token);
	    User user;
	    String myName = "";
		try {
			user = twitter.verifyCredentials();
			myName = user.getScreenName();
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	    
	    
	    return myName;
	}
	//自分のプロフィール取得
	public String getMyProf(){
		AccessToken token = new AccessToken(accessToken, accessTokenSecret);
	     
	    Twitter twitter = new TwitterFactory().getInstance();
	    twitter.setOAuthConsumer(consumerKey, consumerSecret);
	    twitter.setOAuthAccessToken(token);
	    User user;
	    String myProf = "";
		try {
			user = twitter.verifyCredentials();
			myProf = user.getDescription();
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	    
	    
	    return myProf;
	}
	//検索
	public List searchTweet(String searchWord) {
		ArrayList al = new ArrayList();
		 try {
				AccessToken token = new AccessToken(accessToken, accessTokenSecret);
			     
			    Twitter twitter = new TwitterFactory().getInstance();
			    twitter.setOAuthConsumer(consumerKey, consumerSecret);
			    twitter.setOAuthAccessToken(token);
	                
	              //検索語を指定する（※ここでいろいろとオプションを設定できる）
	              Query query = new Query();
	              
	              query.setQuery(searchWord);  //含まれているツイート取得
	              
	              query.setLang("ja");  //ユーザが設定した使用言語
	               
	               //検索結果を取得
	              QueryResult result = twitter.search(query);
	              List<Status> tresult = result.getTweets(); 
	              System.out.println(searchWord+"で検索した結果：" + result.getTweets().size());
	                  //ツイートの表示
	              for (Status tweet : tresult) {
	            	  SearchListBean search = new SearchListBean();
	            	 
	            	  search.setUserName("@" + tweet.getUser().getScreenName());
	            	  search.setTweet(tweet.getText());
	            	  search.setTweetCount(result.getTweets().size());
	            	  al.add(search);
	            	  
	                } 
	           } catch(TwitterException te){
	                          te.printStackTrace();
	           } catch(Exception e){
	                          e.printStackTrace();
	       }
		 return al;
	}
}
