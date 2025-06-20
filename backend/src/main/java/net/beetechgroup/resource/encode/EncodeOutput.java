package net.beetechgroup.resource.encode;

import io.quarkus.runtime.annotations.RegisterForReflection;
import java.time.LocalDateTime;
import lombok.Data;
import net.beetechgroup.domain.URL;

@RegisterForReflection
@Data
public class EncodeOutput {
    private Long id;
    private Boolean active;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String longURL;
    private String code;

    public EncodeOutput(URL url) {
        this.id = url.getId();
        this.active = url.getActive();
        this.createAt = url.getCreateAt();
        this.updateAt = url.getUpdateAt();
        this.longURL = url.getLongURL();
        this.code = url.getCode();
    }
}
