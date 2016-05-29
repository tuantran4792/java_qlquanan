package Model;

public final class GlobalModel {

//	public GlobalModel() {
//		// TODO Auto-generated constructor stub
//	}
	static public String Username;
	static public long UserId;
	static public long RoleId;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public long getRoleId() {
		return RoleId;
	}
	public void setRoleId(long roleId) {
		RoleId = roleId;
	}
}
