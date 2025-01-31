package blog.evgeni.goldfish.token;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository
public class TokenRepository {

  private List<Token> tokens = new ArrayList<>();

  List<Token> getTokens() {
    return tokens;
  }

  @PostConstruct
  public void init() {
    // Initialize the token repository with some sample data matching the new structure
    // List<Link> links1 = List.of(new Link("twitter", "https://x.com/mrpunkdoteth/status/1885324580576755806"));
    // Token sampleToken1 = new Token(
    //     "https://dexscreener.com/solana/h2bnu7koyrkhzluh3ggn4xffeqb4vqhen9uvez6ppump",
    //     "solana",
    //     "H2Bnu7KoYrkHzLUH3ggN4XFFeQb4Vqhen9UvEZ6ppump",
    //     "https://dd.dexscreener.com/ds-data/tokens/solana/H2Bnu7KoYrkHzLUH3ggN4XFFeQb4Vqhen9UvEZ6ppump.png",
    //     "https://dd.dexscreener.com/ds-data/tokens/solana/H2Bnu7KoYrkHzLUH3ggN4XFFeQb4Vqhen9UvEZ6ppump/header.png",
    //     "https://cdn.dexscreener.com/token-images/og/solana/H2Bnu7KoYrkHzLUH3ggN4XFFeQb4Vqhen9UvEZ6ppump?timestamp=1738335000000",
    //     "The scam launch of the year has arrived!\nPUNKTUAH",
    //     links1
    // );

    // tokens.add(sampleToken1);
}

  Optional<Token> getTokenByAddress(String address) {
    return Optional.ofNullable(tokens.stream()
        .filter(token -> token.tokenAddress().equals(address))
        .findFirst()
        .orElse(null));
}

}
