package net.beetechgroup.resource.encode;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@RegisterForReflection
@Data
public class EncodeInput {
    private String longURL;
}
