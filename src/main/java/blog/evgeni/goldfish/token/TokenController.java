package blog.evgeni.goldfish.token;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tokens")
public class TokenController {
 
  private final TokenRepository tokenRepository;
  public TokenController(TokenRepository tokenRepository) {
    this.tokenRepository = tokenRepository;
  }

  @GetMapping("")
  public List<Token> getAllTokens() {
    return new ArrayList<>(tokenRepository.getTokens());
  }

  @GetMapping("/{address}")
  Token getTokenByAddress(@PathVariable String address) {
    Optional<Token> token = tokenRepository.getTokenByAddress(address);
    if(token.isPresent()) {
      return token.get();
    } else {
      throw new RuntimeException("Token not found");
    }
  }
}
