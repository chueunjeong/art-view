package skhu.artview.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import skhu.artview.mapper.UserMapper;
import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserMapper UserMapper;

    public UserDetailsServiceImpl(UserMapper UserMapper) {
        this.UserMapper = UserMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String login_id) throws UsernameNotFoundException {
        skhu.artview.dto.User applicationUser = UserMapper.findOneByLoginId(login_id);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(login_id);
        }
        return new User(applicationUser.getLogin_id(), applicationUser.getPwd(), emptyList());
    }
}