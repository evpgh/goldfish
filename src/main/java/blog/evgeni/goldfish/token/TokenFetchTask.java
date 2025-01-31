package blog.evgeni.goldfish.token;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TokenFetchTask {

    private final TokenRepository tokenRepository;
    private final DexscreenerClient thirdPartyApiClient;

    @Autowired
    public TokenFetchTask(TokenRepository tokenRepository, DexscreenerClient thirdPartyApiClient) {
        this.tokenRepository = tokenRepository;
        this.thirdPartyApiClient = thirdPartyApiClient;
    }

    @Scheduled(fixedRate = 60000) // Run the task every minute
    public void fetchTokens() {
        List<Token> tokens = thirdPartyApiClient.getTokens();
        // tokenRepository.saveAll(tokens);
        System.out.println("Tokens fetched: " + tokens.size());
        for (Token token : tokens) {
          System.out.println(token.toString());
        }
    }
}