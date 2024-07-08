package net.bmbsolutions.driveanddeliver.web;

import net.bmbsolutions.driveanddeliver.mappers.CustomerMapper;
import net.bmbsolutions.driveanddeliver.model.Customer;
import net.bmbsolutions.driveanddeliver.security.AuthenticationService;
import net.bmbsolutions.driveanddeliver.security.JwtService;
import net.bmbsolutions.driveanddeliver.model.dto.AuthRequestDTO;
import net.bmbsolutions.driveanddeliver.model.dto.AuthResponseDTO;
import net.bmbsolutions.driveanddeliver.model.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/auth")
@RestController
public class AuthController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;
    private final CustomerMapper mapper;


    public AuthController(CustomerMapper mapper, JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.mapper = mapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<CustomerDTO> register(@RequestBody AuthRequestDTO registerUserDto) {
        CustomerDTO registeredUser = mapper.mapToDTO(authenticationService.signup(registerUserDto));

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO loginUserDto) {
        Customer authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        AuthResponseDTO authResponseDTO = new AuthResponseDTO().token(jwtToken);

        return ResponseEntity.ok(authResponseDTO);
    }
}
