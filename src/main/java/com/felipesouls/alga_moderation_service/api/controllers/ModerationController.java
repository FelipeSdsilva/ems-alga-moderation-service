package com.felipesouls.alga_moderation_service.api.controllers;

import com.felipesouls.alga_moderation_service.api.models.input.ModerationInput;
import com.felipesouls.alga_moderation_service.api.models.output.ModerationOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ModerationController {

  @PostMapping
  ResponseEntity<ModerationOutput> validModeration(@RequestBody ModerationInput moderation);
}
