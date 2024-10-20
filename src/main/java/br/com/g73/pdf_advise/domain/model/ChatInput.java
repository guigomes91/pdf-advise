package br.com.g73.pdf_advise.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatInput {

    @NotNull(message = "Field input must be not null")
    private String input;
}
