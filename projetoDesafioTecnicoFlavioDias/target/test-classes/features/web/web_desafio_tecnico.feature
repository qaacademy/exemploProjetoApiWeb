# language: pt
Funcionalidade: Desafio Online

  Cenário: Web_valida_marca - consulta - Marca
    Dado que o usuário esteja na pagina de resultado da busca
    Quando selecionar a marca: "HONDA"
    E selecionar o modelo: "CITY"
    E selecionar a versão: "1.5 LX 16V FLEX 4P AUTOMÁTICO"
    Então validar se a marca, modelo e versão da ficha estão corretos

  Cenário: Web_valida_marca - consulta - Marca
    Dado que o usuário esteja na pagina de resultado da busca
    Quando selecionar a marca: "HONDA"
    E selecionar o modelo: "CITY"
    E selecionar a versão: "1.5 EX 16V FLEX 4P AUTOMÁTICO"
    Então validar se a marca, modelo e versão da ficha estão corretos

  Cenário: Web_valida_loja - consulta
    Dado que o usuário esteja na pagina da loja Mazola automóveis
    Quando selecionar a marca: "HONDA"
    E selecionar o modelo: "CITY"
    E selecionar a versão: "1.5 EX 16V FLEX 4P AUTOMÁTICO"
    E selecionar modelo no estoque da loja
    Então validar se a marca, modelo e versão da ficha estão corretos
