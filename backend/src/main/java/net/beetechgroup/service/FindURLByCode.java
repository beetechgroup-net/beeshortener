package net.beetechgroup.service;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import net.beetechgroup.repository.URLRepository;

@ApplicationScoped
@RequiredArgsConstructor
public class FindURLByCode {
    private final URLRepository urlRepository;
    public String execute(String code) {
        return urlRepository.findByCode(code).getLongURL();
    }
}
