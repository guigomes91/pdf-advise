package br.com.g73.pdf_advise.api.controller.exceptionhandler;

public class DocumentException extends RuntimeException {

    private static final long serialVersionUID = 1l;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public DocumentException(String message) {
        super(message);
    }
}
