package entities;

import dtos.UserDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @Column(name = "userName", length = 25)
  private String userName;

  @Basic(optional = false)
  @Size(min = 1, max = 255)
  @Column(name = "userPass")
  private String userPass;

  @JoinTable(name = "userRoles", joinColumns = {
    @JoinColumn(name = "userName", referencedColumnName = "userName")}, inverseJoinColumns = {
    @JoinColumn(name = "roleName", referencedColumnName = "roleName")})
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Role> roleList = new ArrayList<>();

  public List<String> getRolesAsStrings() {
    if (roleList.isEmpty()) {
      return null;
    }
    List<String> rolesAsStrings = new ArrayList<>();
    roleList.forEach((role) -> {
        rolesAsStrings.add(role.getRoleName());
      });
    return rolesAsStrings;
  }

  public User() {}

  public boolean verifyPassword(String pw){
    return(BCrypt.checkpw(pw,userPass));
  }

  public User(String userName, String userPass) {
    this.userName = userName;
    this.userPass = BCrypt.hashpw(userPass,BCrypt.gensalt());
  }
  
   public User(UserDTO u) {
        System.out.println(u);
       // if (u.getId() != null) this.id = u.getId();
        this.userName = u.getUserName();
        this.userPass = BCrypt.hashpw(u.getUserPass(),BCrypt.gensalt());
    }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPass() {
    return this.userPass;
  }

  public void setUserPass(String userPass) {
    this.userPass = userPass;
  }

  public List<Role> getRoleList() {
    return roleList;
  }

  public void setRoleList(List<Role> roleList) {
    this.roleList = roleList;
  }

  public void addRole(Role userRole) {
    roleList.add(userRole);
  }

  @Override
  public String toString() {
    return "User{" +
            "userName='" + userName + '\'' +
            ", userPass='" + userPass + '\'' +
            ", roleList=" + roleList +
            '}';
  }
}
