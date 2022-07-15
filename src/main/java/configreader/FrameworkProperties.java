package configreader;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources("classpath:config.properties")
public interface FrameworkProperties extends Config {

    @Key("foo.bar")
    String getFooBar();

    @Key("selenium.timeout")
    int getTimeout();


}
