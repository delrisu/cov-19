package com.delrisu.pcsscovid.api;

import com.delrisu.pcsscovid.model.UserDto;
import com.delrisu.pcsscovid.model.UserUpdate;
import com.delrisu.pcsscovid.service.UserService;
import com.delrisu.pcsscovid.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/user/token")
    public String getAuthenticationToken(@RequestBody UserDto authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        return jwtTokenUtil.generateToken(userService
                .loadUserByUsername(authenticationRequest.getUsername()));
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto).getUsername());
    }

    @DeleteMapping("/user")
    public ResponseEntity<?> delete(@RequestBody UserDto userDto) throws Exception {
        authenticate(userDto.getUsername(), userDto.getPassword());
        return ResponseEntity.ok(userService.delete(userDto.getUsername()));

    }

    @PutMapping("/user")
    public ResponseEntity<?> updatePassword(@RequestBody UserUpdate userUpdate) throws Exception {
        authenticate(userUpdate.getUsername(), userUpdate.getPassword());
        return ResponseEntity.ok(userService.update(userUpdate));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
