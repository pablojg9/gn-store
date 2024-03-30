package com.gntech.store.gnstore.entity.user;


import com.gntech.store.gnstore.entity.role.Role;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_user")
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1)
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
  @EqualsAndHashCode.Include
  @Column(name = "id")
  private Long id;

  @Column(name = "login")
  private String login;

  @Column(name = "password")
  private String password;

  @Temporal(TemporalType.DATE)
  @Column(name = "password_current_date")
  private Date passwordCurrentdate;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"}, name = "unique_role_user"),
          joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", table = "tb_user", foreignKey = @ForeignKey(name = "user_fk", value = ConstraintMode.CONSTRAINT)),
          inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "role", foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)))
  private List<Role> roles;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
