package net.beetechgroup.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import net.beetechgroup.domain.URL;

@ApplicationScoped
public class URLRepository implements PanacheRepository<URL> {

    public URL findByCode(String code) {
        Optional<URL> urlOptional = find("code", code).firstResultOptional();
        if (urlOptional.isEmpty()) {
            throw new EntityNotFoundException("URL with code " + code + " not found");
        }
        return urlOptional.get();
    }
}
