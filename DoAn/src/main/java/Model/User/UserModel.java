package Model.User;

public class UserModel {

	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Long getGroupId() {
		return GroupId;
	}
	public void setGroupId(Long groupId) {
		GroupId = groupId;
	}
	public String getPaswword() {
		return Paswword;
	}
	public void setPaswword(String paswword) {
		Paswword = paswword;
	}

	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String Username;
	public Long GroupId;
	public String Paswword;
	public Long UserId;
}

