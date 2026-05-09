package com.felipesouls.alga_moderation_service.api.models.input;

public record ModerationInput(
    String text,
    String commentId
) {
}
