//Beanクラス
package twitter;

import java.io.Serializable;

public class TweetList implements Serializable{
	private String contentId;
	private String content;
	private int count;
	private String timeSetting;
	private String visibility;
	
	public TweetList() {}
	
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTimeSetting() {
		return timeSetting;
	}
	public void setTimeSetting(String timeSetting) {
		this.timeSetting = timeSetting;
	}
	
}
