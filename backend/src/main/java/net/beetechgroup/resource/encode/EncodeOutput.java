package net.beetechgroup.resource.encode;

import io.quarkus.runtime.annotations.RegisterForReflection;
import java.time.LocalDateTime;
import lombok.Data;
import net.beetechgroup.domain.URL;

public class EncodeOutput {
    private Long id;
    private Boolean active;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String longURL;
    private String code;

    public EncodeOutput() {
    }

    public EncodeOutput(URL url) {
        this.id = url.getId();
        this.active = url.getActive();
        this.createAt = url.getCreateAt();
        this.updateAt = url.getUpdateAt();
        this.longURL = url.getLongURL();
        this.code = url.getCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
