package com.felipesouls.alga_moderation_service.api.controllers.impl;


import com.felipesouls.alga_moderation_service.api.controllers.ModerationController;
import com.felipesouls.alga_moderation_service.api.models.input.ModerationInput;
import com.felipesouls.alga_moderation_service.api.models.output.ModerationOutput;
import com.felipesouls.alga_moderation_service.domain.services.ModerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationControllerImpl implements ModerationController {

  private final ModerationService moderationService;

  @Override
  public ResponseEntity<ModerationOutput> validModeration(ModerationInput moderation) {
    return ResponseEntity.ok(moderationService.moderationValidation(moderation));
  }
}
