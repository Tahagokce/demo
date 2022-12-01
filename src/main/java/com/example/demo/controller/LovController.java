package com.example.demo.controller;

import com.example.demo.dto.ADSignInDto;
import com.example.demo.dto.ValueLabel;
import com.example.demo.repository.LovRepository;
import com.example.demo.util.ActiveDirectoryAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NamingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("lov")
@RequiredArgsConstructor
public class LovController {
    private final LovRepository lovRepository;

    @GetMapping("label-label")
    public List<ValueLabel> lovListLabelLabel(@RequestParam String group) {
        List<ValueLabel> result = new ArrayList<>();

        lovRepository.findAllByGroupOrderByDisplayName(group).forEach(lov -> {
            result.add(new ValueLabel(lov.getDisplayName(), lov.getDisplayName()));
        });

        return result;
    }

    @GetMapping("label-value")
    public List<ValueLabel> lovListValueLabel(@RequestParam String group) {
        List<ValueLabel> result = new ArrayList<>();

        lovRepository.findAllByGroupOrderByDisplayName(group).forEach(lov -> {
            result.add(new ValueLabel(lov.getDisplayName(), lov.getLov().getDisplayName()));
        });

        return result;
    }


    @PostMapping("ad-login")
    public ResponseEntity<Void> adLogin(@RequestBody ADSignInDto signInDto) throws UnknownHostException, NamingException {
        ActiveDirectoryAuthentication.getConnection(signInDto.getUsername(), signInDto.getPassword(), signInDto.getDomainName(), signInDto.getServerName());
       return ResponseEntity.ok().build();
    }
}
