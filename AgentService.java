package com.example.helpdesk.service;
import java.util.Collections;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.helpdesk.model.Agent;
import com.example.helpdesk.repository.AgentRepository;
@Service
@Primary
public class AgentService implements UserDetailsService {
    private final AgentRepository agentRepository;
    public AgentService(AgentRepository agentRepository){ this.agentRepository = agentRepository; }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Agent a = agentRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Agent not found"));
        return new org.springframework.security.core.userdetails.User(a.getUsername(), a.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + a.getRole())));
    }
}