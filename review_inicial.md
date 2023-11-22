(✓) Uso de listas.

(✓) API nova de datas.

###Classe Cliente
(✓) Eliminar o ``super()`` no **construtor**. Ele é redundante, se puder pesquisar porquê é um aprendizado importante em Java.

(✓) **CPF** é um número, mas como ficaria se tivéssemos um **CPF com zero à esquerda** ?

( ) Vamos supor que por enquanto um Cliente não pode alterar o nome no sistema e nem CPF. Que mudança vc faria ?

(✓) Acho que é importante guardar do cliente também o Gênero e a data de nascimento, consegue ?

(✓) Agora, vamos também guardar a modalidade do cliente, como se fosse uma classificação. Cliente **BASICO, PREMIUM, INTERMEDIARIO.**

````
Essa regra vai depender da renda do cliente.
Se ele tiver até 5000 renda é BASICO
Se ele tiver entre 5000 e 12.000 é INTERMEDIARIO
Se ele tiver acima de 12.000 é PREMIUM
````

( ) Vamos supor que um cliente chegue a agência e informe um **CPF inválido.** Como poderíamos tratar esse cenário ? *Não precisa fazer, vamos pensar juntos.*

###Classe Conta
(✓) Temos o atributo "movimentacao", mas **não** parece ser usado. Não seria melhor apagar então ?

(✓) Você conseguiu identificar porque nem sempre é bom usar ``protected``?

( ) Por enquanto no nosso sistema, uma conta não pode mudar seu número nem agência vinculada.

( ) ``imprimirExtrato()``, muito bacana o método. Eu mudaria para que ele não recebesse nome de Conta, e sim que trabalhasse com a instância interna do objeto, sabe do que tô falando ?

(✓) Os métodos de transações não podem receber valores negativos. Como vc trataria esse cenário, pode implementar pra gente ?

( ) Hoje uma conta faz quantas transações quiser. A partir de agora, contas de clientes tem limites de transação com base em sua modalidade

( ) Se **BASICO** pode fazer até 4 saques e transferências ao dia (ou seja, 4 saques + 4 transferências): 
Se exceder o limite negar a transação

( ) Se **INTERMEDIARIO** pode fazer até 8 saques ou transferências ao dia (ou seja, 8 saques + 8 transferências): Se exceder o limite cobrar 0,05% da transação

( ) Se **PREMIUM** pode fazer até quantas transações quiser.

###Classe GeradorDeContas
**Ponto de melhoria:**
✓
( ) Essa é um exemplo de classe utilitária: Pesquise como adaptar esse padrão a essa classe e execute as mudanças, é bem simples.

###Classe Movimentacao
( ) Em algum momento um sistema bancário vai precisar se adequar a quem sabe datas de movimentação diferente do momento atual. Antes de fazermos isso, que tal **mudar o nome do atributo "dataAtual" para "data".** E vamos talvez precisar **manipular datas, é melhor que não seja String.**

#####Pontos importantes para vc "profissionalizar" seu projeto
( ) Repositório com **gitignore** para evitar subir arquivos de IDEs

( ) Precisamos escrever **testes unitários,** conseguiu fazer algum ?

( ) Se der tempo, pesquise sobre como deveríamos configurar o ``pom.xml`` em relação aos campos ``groupId, artifactId e name``