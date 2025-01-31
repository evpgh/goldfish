package blog.evgeni.goldfish.token;

public record Token(
    String name,
    String address,
    int age,
    Chain chain
) {}
