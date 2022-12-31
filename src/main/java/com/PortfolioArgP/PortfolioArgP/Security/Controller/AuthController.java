package com.PortfolioArgP.PortfolioArgP.Security.Controller;

import com.PortfolioArgP.PortfolioArgP.Security.Entity.Rol;
import com.PortfolioArgP.PortfolioArgP.Security.Entity.User;
import com.PortfolioArgP.PortfolioArgP.Security.Service.RolService;
import com.PortfolioArgP.PortfolioArgP.Security.Service.UserService;
import com.PortfolioArgP.PortfolioArgP.Security.Jwt.JwtProvider;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
import com.PortfolioArgP.PortfolioArgP.Security.Enums.RolName;
import com.PortfolioArgP.PortfolioArgP.Security.Dto.JwtDto;
import com.PortfolioArgP.PortfolioArgP.Security.Dto.LoginUser;
import com.PortfolioArgP.PortfolioArgP.Security.Dto.NewUser;

import java.util.HashSet;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager AuthenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    //Crear nuevo Usuario
    @PostMapping("/new")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Campos invalidos o email incorrecto"), HttpStatus.BAD_REQUEST);
        }
        if (userService.existByUsername(newUser.getUsername())) {
            return new ResponseEntity(new Message("Nombre de usuario NO disponible"), HttpStatus.BAD_REQUEST);
        }
        if (userService.existByUsername(newUser.getEmail())) {
            return new ResponseEntity(new Message("Este email no está disponible"), HttpStatus.BAD_REQUEST);
        }

        User user = new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());

        if (newUser.getRoles().contains("admin")) {
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        }
        user.setRoles(roles);
        userService.save(user);

        return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
    }

    //Login
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Campos invalidos"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
}
