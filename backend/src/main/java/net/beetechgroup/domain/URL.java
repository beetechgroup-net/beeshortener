package net.beetechgroup.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@RegisterForReflection
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class URL extends ModelBase {
    private String longURL;
    private String code;
}
