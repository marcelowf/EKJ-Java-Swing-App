# Yeti Meneger

Este é um projeto básico em Java que implementa operações CRUD (Create, Read, Update, Delete) para gerenciar informações de usuários. A interface gráfica é construída utilizando o framework Java Swing, permitindo uma interação intuitiva. Além disso, o projeto oferece a funcionalidade de salvar os dados dos usuários em um arquivo .txt.

## Funcionalidades

- **Cadastro de Usuários**: Adição de novos usuários com informações como nome, idade, e e-mail.
- **Listagem de Usuários**: Visualização da lista de usuários cadastrados.
- **Atualização de Usuários**: Modificação dos dados de usuários existentes.
- **Exclusão de Usuários**: Remoção de usuários do sistema.
- **Salvamento em Arquivo .txt**: Possibilidade de salvar os dados dos usuários em um arquivo de texto.

## Estrutura do Projeto

- `MainFrame.java`: Classe principal que cria a interface gráfica e interage com as operações CRUD.
- `User.java`: Representação da entidade usuário, com atributos como nome, idade, e e-mail.
- `FileHandler.java`: Gerencia a leitura e escrita dos dados em um arquivo .txt.
- `UserDAO.java`: Implementa as operações CRUD para manipulação dos dados dos usuários.

## Como Executar

1. Certifique-se de ter o ambiente Java configurado.
2. Compile e execute o projeto.

```bash
javac MainFrame.java
java MainFrame
