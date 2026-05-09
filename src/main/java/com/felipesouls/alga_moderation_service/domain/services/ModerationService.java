package com.felipesouls.alga_moderation_service.domain.services;

import java.text.Normalizer;
import java.util.List;

import com.felipesouls.alga_moderation_service.api.models.input.ModerationInput;
import com.felipesouls.alga_moderation_service.api.models.output.ModerationOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModerationService {

  private static final List<String> FORBIDDEN_WORDS = List.of(
      "ódio",
      "xingamento"
  );

  public ModerationOutput moderationValidation(ModerationInput input) {
    log.info("Starting comment moderation. commentId={}", input.commentId());

    String normalizedText = normalize(input.text());

    boolean containsForbiddenWord = FORBIDDEN_WORDS.stream()
        .map(this::normalize)
        .anyMatch(normalizedText::contains);

    if (containsForbiddenWord) {
      log.warn("Comment rejected by moderation. commentId={}", input.commentId());

      return new ModerationOutput(
          false,
          "Comment contains forbidden words"
      );
    }

    log.info("Comment approved by moderation. commentId={}", input.commentId());

    return new ModerationOutput(
        true,
        "Comment approved"
    );
  }

  private String normalize(String value) {
    return Normalizer.normalize(value, Normalizer.Form.NFD)
        .replaceAll("\\p{M}", "")
        .toLowerCase()
        .trim();
  }
}
