# language: pt
Funcionalidade: Desafio Online

  Cenário: Api_valida_marca - consulta - Marca
    Dado que o usuário deseja fazer uma consulta por marca
    Quando enviar a requisição
    Então validar se o código de resposta é 200
    E validar se existe a marca: "honda" no retorno

  Cenário: Api_valida_marca - consulta - Marca - Inválida - Path
    Dado que o usuário faça uma consulta inválida por marca
    Quando enviar a requisição
    Então validar se o código de resposta é 404
    
  Cenário: Api_valida_marca - consulta -  Modelo
    Dado que o usuário deseja fazer uma consulta pelo modelo: "city"
    Quando enviar a requisição de consulta
    Então validar se o código de resposta é 200
    E validar se existe o modelo: "city" no retorno
    
  Cenário: Api_valida_marca - consulta -  Modelo - Inválido
    Dado que o usuário deseja fazer uma consulta pelo modelo: "TestCity"
    Quando enviar a requisição de consulta
    Então validar se o código de resposta é 200
    E validar o retorno vazio
    
  Cenário: Api_valida_marca - consulta - Versão
    Dado que o usuário deseja fazer uma consulta pela versão: "1.5 LX 16V FLEX 4P MANUAL"
    Quando enviar a requisição de consulta
    Então validar se o código de resposta é 200
    E se existe a versão: "1.5 LX 16V FLEX 4P MANUAL" no retorno
    
  Cenário: Api_valida_marca - consulta - Versão - Inválida
    Dado que o usuário deseja fazer uma consulta pela versão: "Invalido - 1.5 LX 16V FLEX 4P MANUAL"
    Quando enviar a requisição de consulta
    Então validar se o código de resposta é 200
    E validar o retorno vazio
    
  Cenário: Api_valida_marca - consulta - Veiculos
    Dado que o usuário deseja fazer uma consulta por veiculos
    Quando enviar a requisição de consulta
    Então validar se o código de resposta é 200
    E validar se existe o veiculo: 
    |marca|modelo|versão|
    |honda|city  |2.0 EXL 4X4 16V GASOLINA 4P AUTOMÁTICO|
    
   
