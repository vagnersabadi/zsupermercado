# zsupermercado



O sistema desenvolvido, tem como finalidade e abranger dois tipos de usuário
1-ADM ou Responsável de um supermercado qualquer:
	O adm cria-se uma conta para seu login representando uma rede de supermercado, informando assim campos como Nome, Senha, Nome da rede de supermercado que representa, e endereço.
	Posteriormente o adm loga-se na primeira tela o adm será listado todos os produtos em que o supermercado tem cadastrado, caso não tenha nenhuma poderá ser cadastrado na segunda pagina passado assim o nome do produto (descrição), preço, e se o produto está ou não na promoção, já na terceira página e listado os produtos em que estão em promoção e podendo assim tirá-lo da promoção. Na lista produtos da primeira página poderá então deletar o produto e editar com os mesmos campos do cadastro do produto.
	Em outra pagina o adm poderá sair das páginas e editar ou excluir conta.
2-Cliente que deseja ver os preços e adicionar em seu carrinho para verificar o quanto irá gastar
	O Cliente cria-se uma conta para seu login informando assim campos como Nome, Senha. Já na primeira página após logar-se irá mostrar todos os produtos cadastrados pelos adm dos supermercados, tendo assim um botão “adicionar ao carrinho” para posteriormente formar uma lista de compras.
	Também poderá fazer busca por supermercados mostrando os respectivos produtos. E por último mostrando para cliente seu carrinho de compras/lista de compras.

Requisitos:
1- Requisitos de Uso do sistema (35 pontos):
1.1- O sistema deve ter no mínimo 3 CRUDs (Create, Read, Update, Delete); (15 pontos) SIM
Produto=1CRUDS
Adm e Cliente=2CRUDS
CarrinhoProdutos=1/2Cruds

1.2- O banco de dados deve contemplar chaves estrangeiras entre as tabelas; (5 pontos) SIM
1.3- O sistema deve ter implementado Layouts; (6 pontos) SIM
1.4- O sistema deve ter alguma tela que faz o processamento das informações inseridas no CRUD, por exemplo, vendas, relatórios, financeiro, etc.. (9 pontos) SIM
2- (35 pontos) Requisitos de Estrutura do código:
2.1 Padrões Java (nomenclatura de classes, métodos e atributos) (5 pontos) SIM
2.2 Arquitetura MVC (15 pontos) SIM
2.3 Utilização do Spring (10 pontos) SIM
2.4 Projeto estruturado no maven (5 pontos) SIM

OBS: Como comentado com senhor antes nas aulas, ao importa para outro eclipse o projeto apresenta erro para solucionar só criando um novo projeto e importando as classes java e toda pasta WebApp.
