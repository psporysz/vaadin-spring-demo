package to.lova.vaadin.spring;

import java.util.List;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.vaadin.flow.i18n.I18NProvider;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public I18NProvider i18nProvider() {
        return new I18NProvider() {

            @Override
            public String getTranslation(String key, Locale locale,
                    Object... params) {
                return "";
            }

            @Override
            public List<Locale> getProvidedLocales() {
                return List.of(Locale.ENGLISH, Locale.ITALIAN);
            }
        };
    }

}
