package net.bmbsolutions.driveanddeliver.security;

import net.bmbsolutions.driveanddeliver.model.Customer;
import net.bmbsolutions.driveanddeliver.model.dto.AuthRequestDTO;
import net.bmbsolutions.driveanddeliver.repository.CustomerRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final CustomerRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            CustomerRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer signup(AuthRequestDTO input) {
        Customer user = new Customer(null, input.getUsername(), passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public Customer authenticate(AuthRequestDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}
