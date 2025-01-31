package blog.evgeni.goldfish.token;

import java.util.List;

public record Token(
    String url,
    String chainId,
    String tokenAddress,
    String icon,
    String header,
    String openGraph,
    String description,
    List<Link> links
) {}