package br.com.g73.pdf_advise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ChatOutput {

    private LocalDateTime dateTime;
    private String response;
}
