package br.com.g73.pdf_advise.api.controller.v1;

import br.com.g73.pdf_advise.domain.model.ChatInput;
import br.com.g73.pdf_advise.domain.service.PdfAdviseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController()
@RequestMapping("v1/advises")
@RequiredArgsConstructor
public class PdfAdviseController {

    private final PdfAdviseService pdfAdviseService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void uploadDocument(@RequestParam("file") MultipartFile document) {
        pdfAdviseService.loadDocument(document.getResource());
    }

    @GetMapping("/chat")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> chat(@RequestBody @Valid ChatInput input) {
        return ResponseEntity.ok(pdfAdviseService.askQuestion(input));
    }
}
