package net.beetechgroup.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import net.beetechgroup.domain.URL;
import net.beetechgroup.repository.URLRepository;
import net.beetechgroup.resource.encode.EncodeInput;
import net.beetechgroup.resource.encode.EncodeOutput;

@ApplicationScoped
@RequiredArgsConstructor
public class SaveURL {

    private final URLRepository urlRepository;
    private final GenerateCode generateCode = new GenerateCode();

    @Transactional
    public EncodeOutput execute(EncodeInput encodeInput) {
        URL url = new URL();
        url.setLongURL(encodeInput.getLongURL());
        url.setCode(generateCode.generateCode());

        urlRepository.persist(url);

        return new EncodeOutput(url);
    }

}
