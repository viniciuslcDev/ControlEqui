# ControlEqui
<p align="center">
  <img src="https://github.com/user-attachments/assets/858277d1-ebfb-44cb-a239-aef2066aace7" alt="logo_controlequip">
</p>

# Descrição do Projeto

### 🏢 ControlEqui: Gestão Inteligente de Equipamentos

O **ControlEqui** é um projeto desenvolvido dentro do **Programa de Devs do Agi**, por meio de um **Hackathon** focado na gestão eficiente de equipamentos corporativos. Além de facilitar o **empréstimo de equipamentos** aos funcionários, a plataforma tem como objetivo **administrar todo o ciclo de vida dos ativos da empresa**.

Com o **ControlEqui**, é possível **cadastrar funcionários** e registrar os **equipamentos sob sua responsabilidade**, garantindo maior **organização** e **otimização das atividades profissionais**. O sistema também oferece um **histórico detalhado de movimentação**, permitindo o **rastreamento preciso** de quais equipamentos foram utilizados por cada colaborador ao longo do tempo.

🔹 **Benefícios do ControlEqui**:
- 📌 Maior **controle** sobre os equipamentos da empresa
- 🔍 **Transparência** na gestão dos ativos
- 🔒 **Segurança** no uso dos recursos tecnológicos

Com o **ControlEqui**, sua empresa ganha mais **eficiência** e **gestão estratégica**, tornando o uso dos equipamentos mais ágil e seguro. 🚀

# 🛠 Tecnologias Utilizadas

🚀 O desenvolvimento do projeto contou com diversas ferramentas e tecnologias modernas para garantir eficiência e escalabilidade. Entre elas:

- ☕ **Java 21** – Linguagem robusta e atualizada para desenvolvimento backend
- 🖥 **IntelliJ IDEA** – Ambiente de desenvolvimento integrado (IDE) para produtividade máxima
- 🎨 **Figma** – Plataforma de design colaborativo para criação de interfaces intuitivas
- ☁ **Aviencloud** – Solução de nuvem para armazenamento e integração de dados
- 🛢 **MySQL** – Banco de dados relacional para gestão eficiente de informações
- 🐬 **DBeaver** – Ferramenta poderosa para administração de bancos de dados
- 🔗 **GitHub** – Controle de versão e colaboração no desenvolvimento

Cada tecnologia desempenha um papel essencial no projeto, garantindo um fluxo de trabalho ágil e organizado. 💡✨

# 📂 Estrutura de Pastas

A organização do projeto foi pensada para refletir as regras de negócio e garantir manutenibilidade e escalabilidade do sistema:


### 📁 `controller/`
Contém as classes responsáveis por expor as APIs REST e orquestrar a comunicação entre o front-end e o back-end, atendendo às requisições como cadastro de funcionários, empréstimos de equipamentos, consultas de histórico, etc.

### 📁 `model/`
Define as entidades que representam as tabelas do banco de dados, como **Funcionário**, **Equipamento**, **Histórico**, entre outros. Cada regra de negócio (ex: um equipamento não ser emprestado a mais de uma pessoa) é refletida nas configurações dessas entidades.

### 📁 `repository/`
Contém as interfaces que fazem a comunicação com o banco de dados, utilizando **Spring Data JPA** para simplificar operações de persistência.

### 📁 `service/`
Agrupa a lógica de negócio do projeto, garantindo que todas as validações e restrições (ex: funcionário ativo para empréstimo, status de compra) sejam respeitadas antes de qualquer ação ser efetivada.

### 📁 `resources/`
Contém arquivos de configuração do projeto, como `application.properties` para definir as propriedades de conexão do banco de dados, além de recursos estáticos.

# 📜 Regras de Negócio

O ControlEqui foi construído respeitando uma série de regras importantes para garantir a integridade dos processos de gestão:

- ✅ **Cadastro único de funcionário**: Um funcionário pode ter apenas um cadastro ativo no sistema.
- ✅ **Equipamento com ID único**: Um equipamento não pode ser emprestado simultaneamente para várias pessoas.
- ✅ **Empréstimo de equipamentos do mesmo tipo**: Um funcionário pode receber múltiplos equipamentos do mesmo tipo, respeitando a disponibilidade.
- ✅ **Histórico de modificação**: Cada alteração nos dados de um equipamento é registrada para manter a rastreabilidade.
- ✅ **Solicitação de status do funcionário**: Funcionários podem ter os status **Ativo**, **Inativo** ou **Pendente**.
- ✅ **Bloqueio de inativação com pendências**: Funcionários só podem ser inativados após a devolução de todos os equipamentos sob sua responsabilidade.
- ✅ **Prioridades de empréstimos**: Definidas por cargo e ordem de serviço.
- ✅ **Solicitação de compra**: Possível quando não há equipamentos em estoque.
- ✅ **Gestão de status de compra e entrega**: Cada compra possui status controlado (**Aprovado**, **Pendente** ou **Reprovado**).

# 🏅 Badges

![Java Badge](https://img.shields.io/badge/Java-21-blue)
![Gradle Badge](https://img.shields.io/badge/Gradle-build_tool-green)
![Release Badge](https://img.shields.io/badge/Release-April-green)

# 👥 Autores

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/131699485?v=4" width=115><br><sub>Vinícius Lima</sub>](https://github.com/viniciuslcDev) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/174913258?v=4" width=115><br><sub>João Estevão</sub>](https://github.com/Joaocamilo1508) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/47798697?v=4" width=115><br><sub>Mateus Santis</sub>](https://github.com/MateuSantis) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/179650194?v=4" width=115><br><sub>Lilian Damasceno</sub>](https://github.com/Liliansod) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/68648529?v=4" width=115><br><sub>Heitor Delvecchi</sub>](https://github.com/Delvecchi) |
| :---: | :---: | :---: | :---: | :---: |


