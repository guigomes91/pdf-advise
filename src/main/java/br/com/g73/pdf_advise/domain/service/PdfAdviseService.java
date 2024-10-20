package br.com.g73.pdf_advise.domain.service;

import br.com.g73.pdf_advise.api.controller.exceptionhandler.DocumentException;
import br.com.g73.pdf_advise.domain.model.ChatInput;
import br.com.g73.pdf_advise.domain.model.ChatOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
public class PdfAdviseService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;
    private final TokenTextSplitter tokenSplitter = new TokenTextSplitter();

    PdfAdviseService(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(
                        new SimpleLoggerAdvisor(),
                        new QuestionAnswerAdvisor(vectorStore, SearchRequest.defaults())) // RAG advisor
                .build();
        this.vectorStore = vectorStore;
    }

    public void loadDocument(Resource resource) {
        try {
            if (Objects.isNull(resource)) {
                throw new DocumentException("File must be not null!");
            }

            log.info("Starting to load the document: {}", resource.getFilename());
            log.info("Reading PDF document...");
            var pdfReader = new PagePdfDocumentReader(resource, PdfDocumentReaderConfig.defaultConfig());
            vectorStore.write(tokenSplitter.split(pdfReader.read()));
            log.info("Document successfully uploaded.");
            log.info("Vector name: {}", vectorStore.getName());
        } catch (DocumentException ex) {
            log.error("Error to upload file. {}", ex.getMessage());
        }
    }

    public ChatOutput askQuestion(ChatInput input) {
        try {
            String response = chatClient
                    .prompt()
                    .user(input.getInput())
                    .call()
                    .content();

            return ChatOutput.builder()
                    .dateTime(LocalDateTime.now())
                    .response(response)
                    .build();
        } catch (Exception ex) {
            log.error("Error to chat. {}", ex.getMessage());
        }

        return new ChatOutput(LocalDateTime.now(), "No response found");
    }
}
