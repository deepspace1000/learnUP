package ch.learntrack.backend.security

import ch.learntrack.backend.persistence.tables.pojos.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

public class LearnTrackUserDetails(public val user: User) : UserDetails {
    override fun getAuthorities(): List<GrantedAuthority> = listOf()
    override fun getPassword(): Nothing? = null
    override fun getUsername(): String = user.eMail
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isEnabled(): Boolean = true
}
