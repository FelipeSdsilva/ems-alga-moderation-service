package com.felipesouls.alga_moderation_service.api.models.output;

public record ModerationOutput(
    boolean approved,
    String reason
) {
}
