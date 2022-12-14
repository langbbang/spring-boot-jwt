package me.songha.tutorial.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "MEMBER")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "NICKNAME", length = 50)
    private String nickname;

    @Column(name = "STATUS")
    private byte status;

    @CreatedDate
    @Column(name = "INSERT_DATE")
    private ZonedDateTime insertDate;

    @LastModifiedDate
    @Column(name = "UPDATE_DATE")
    private ZonedDateTime updateDate;

    @OneToMany(mappedBy = "member")
    private Set<MemberAuthority> memberAuthorities;
}
