package com.example.demo_forum_web.entities;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="[user]")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 32)
    private String username;

    @Column(nullable = false,length = 32)
    private String password;

    @Column(length = 16)
    private String introduction;

    @Column(nullable = false)
    private LocalDateTime create_date;

    @OneToMany(mappedBy = "user")
    private List<Topic> topics;

    @OneToMany(mappedBy = "user")
    private List<Answer> answers;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
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

    public String displayParsedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.create_date.format(formatter);
    }
}
