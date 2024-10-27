package br.com.g73.pdf_advise.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChatInput {

    @NotNull(message = "Field input must be not null")
    private String input;
}
