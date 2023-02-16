package mockLog;

import nl.altindag.log.LogCaptor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FooServiceShould {
    @Test
    public void logInfoAndWarnMessages() {
        LogCaptor logCaptor = LogCaptor.forClass(FooService.class);
        
        FooService fooService = new FooService();
        fooService.sayHello();
    
        System.out.println(logCaptor.getInfoLogs());
        
        // Get logs based on level
        assertThat(logCaptor.getInfoLogs()).containsExactly("Keyboard not responding. Press any key to continue...");
        assertThat(logCaptor.getWarnLogs()).containsExactly("Congratulations, you are pregnant!");
        
        // Get all logs
        assertThat(logCaptor.getLogs())
                .hasSize(2)
                .contains(
                        "Keyboard not responding. Press any key to continue...",
                        "Congratulations, you are pregnant!"
                );
    }
}
