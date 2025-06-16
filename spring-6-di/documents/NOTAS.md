# Notas

## Ambientes (Environments)

**DEV (Development | Desenvolvimento)**

É o ambiente onde os desenvolvedores trabalham para criar e testar novas funcionalidades. É um ambiente isolado, onde os
desenvolvedores podem experimentar e corrigir erros sem afetar outros ambientes.

**QA (Quality Control | Controle de Qualidade)**

Neste ambiente, as equipes de QA (Controle de Qualidade) realizam testes funcionais e não funcionais, como testes de
desempenho e segurança, para garantir que o software atenda aos requisitos e funcione corretamente.

**UAT (User Acceptance Testing | Teste de Aceitação do Usuário)**

É o ambiente onde os usuários finais testam o software para verificar se ele atende às suas necessidades e expectativas.
O UAT é a última etapa antes da implantação em produção e foca na validação dos requisitos de negócio.

**Prod (Production | Produção)**

É o ambiente onde o software é implantado para uso pelos usuários finais. O objetivo é garantir a estabilidade e a
disponibilidade do sistema para os usuários.

### Diferenças:

* O ambiente DEV é usado para desenvolvimento e testes iniciais pelos desenvolvedores.
* O ambiente QA é usado para testes mais abrangentes, incluindo testes funcionais e não funcionais, por equipes de
  controle de qualidade.
* O ambiente UAT é usado para testes finais pelos usuários finais antes do lançamento em produção.
* O ambiente Prod é o ambiente onde o software é utilizado pelos usuários finais.

### Importância:

Cada ambiente desempenha um papel importante no processo de desenvolvimento, garantindo que o software seja testado e
validado em diferentes etapas, desde a criação até a implantação em produção.

### Melhores Práticas:

* Manter o isolamento entre os ambientes é crucial para garantir a integridade dos testes e proteger o ambiente de
  produção.
* Utilizar tecnologias como contêineres ou virtualização para criar ambientes isolados que imitem de perto a
  configuração de produção.
* Implementar controle de versão para arquivos de configuração, garantindo a consistência entre os ambientes. 