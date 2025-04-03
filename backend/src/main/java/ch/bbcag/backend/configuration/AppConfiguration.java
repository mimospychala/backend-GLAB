package ch.bbcag.backend.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfiguration {
    private String[] allowedUrls;
    private String[] authUrls;
    private String[] allowedOrigins;

    public String[] getAllowedUrls() {
        return allowedUrls;
    }

    public void setAllowedUrls(String[] allowedUrls) {
        this.allowedUrls = allowedUrls;
    }

    public String[] getAuthUrls() {
        return authUrls;
    }

    public void setAuthUrls(String[] authUrls) {
        this.authUrls = authUrls;
    }

    public String[] getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(String[] allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    @Override
    public String toString() {
        return "AppConfiguration{" +
                "allowedUrls=" + Arrays.toString(allowedUrls) +
                ", authUrls=" + Arrays.toString(authUrls) +
                ", allowedOrigins=" + Arrays.toString(allowedOrigins) +
                '}';
    }
}
