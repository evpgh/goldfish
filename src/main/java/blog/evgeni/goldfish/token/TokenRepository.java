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
    // Initialize the token repository with some sample data
    tokens.add(new Token("user1", "token123", 2, Chain.SOL));
    tokens.add(new Token("user2", "token456", 3, Chain.SOL));
  }

  Optional<Token> getTokenByAddress(String address) {
    return Optional.ofNullable(tokens.stream()
        .filter(token -> token.address().equals(address))
        .findFirst()
        .orElse(null));
}

}
