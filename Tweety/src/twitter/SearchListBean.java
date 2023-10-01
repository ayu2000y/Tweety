package twitter;

import java.io.Serializable;

public class SearchListBean implements Serializable{
	private String userName;	//ユーザー名(@のやつ)
	private String tweet;	//ツイート内容
	private int tweetCount;	//件数
	
	public int getTweetCount() {
		return tweetCount;
	}
	public void setTweetCount(int tweetCount) {
		this.tweetCount = tweetCount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	
}
