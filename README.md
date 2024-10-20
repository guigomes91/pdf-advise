# Projeto de IA com Spring

Este projeto utiliza tecnologias de Inteligência Artificial com Spring, integrando vector databases com Chroma e a API do OpenAI. 
O objetivo é fornecer uma interface para upload de documentos PDF e interagir com um modelo de IA para ser o conselheiro o PDF enviado.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **spring-ai-pdf-document-reader**
- **spring-ai-openai-spring-boot-starter**
- **spring-ai-chroma-store-spring-boot-starter**
- **Docker Compose** (para subir o banco de vetor)

## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/guigomes91/pdf-advise
   cd pdf-advise

## Docker

Certifique-se de ter o Docker e o Docker Compose instalados.
Ao subir o projeto o próprio Spring irá gerenciar o container do Chroma DB.

## Endpoints

1. Upload de PDF

Para realizar o upload de um documento PDF, utilize o seguinte endpoint:

```POST http://localhost:8080/g7e/v1/advises/upload```

2. Conversa com a IA
   
Para interagir com a IA, utilize o seguinte endpoint:

```POST http://localhost:8080/g7e/v1/advises/chat```

Exemplo de Requisição

O corpo da requisição deve ser no seguinte formato:
```
{
    "input": "What is Space-Based Architecture?"
}
```

## Documentação

Para mais informações sobre a integração com vector databases Chroma, consulte a documentação oficial: https://docs.spring.io/spring-ai/reference/api/vectordbs/chroma.html.

