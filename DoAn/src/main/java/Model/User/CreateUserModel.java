package Model.User;
import Model.User.UserModel;
import POJO_entities.SystemUser;
public class CreateUserModel {

	public UserModel user;
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public SystemUser getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(SystemUser userInfo) {
		this.userInfo = userInfo;
	}
	public SystemUser userInfo;

}
