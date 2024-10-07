# Projeto-LPOO
## Explicações 
Essa interação do projeto é controlada através do input do usuário, abaixo o fluxo de batalha:

![Captura de tela 2024-10-07 200153](https://github.com/user-attachments/assets/2e813100-789f-4629-8f24-96d1df47a765)

Aqui é a mão do primeiro jogador, onde aparece as cartas e os numeros ao lado esquerdo de cada carta é o numero do qual o jogador terá que digitar para colocar a carta no campo, cada carta informa o seu custo de mana, uma observação: alma de mana é um feitiço que aumenta um de mana do jogador, ele está representado como -1 pois toda vez que o jogador lançar uma carta ao campo é subtraido o custo de mana de carta da quantidade de mana que o jogador possui, alma de mana seria: mana do jogador - (-1) = mana do jogador + 1, isso será alterado quando tivermos a interface.
Caso a carta custe mais que a mana que o jogador possui aparece a seguinte mensagem:

![Captura de tela 2024-10-07 200917](https://github.com/user-attachments/assets/89c04e36-15a5-4f83-baaf-7f9f62093c5e)

Depois da ação de jogar a carta sendo ela válida ou não aparecerá a seguinte mensagem:

![Captura de tela 2024-10-07 201019](https://github.com/user-attachments/assets/ffedcb07-33f0-483e-bf74-ff2c2cf7aebf)
O jogador pode digitar c caso queira jogar outra carta e denovo apareceria a mão do jogador com suas cartas atuais.
Caso o jogador digitar b aparece isso:

![Captura de tela 2024-10-07 201223](https://github.com/user-attachments/assets/cb37cd0a-22ae-4441-a82f-c8ae2e841ff9)

Nesse exemplo o campo está vazio e como é o primeiro turno, esse jogador só pode ver o campo do oponente, ainda não foi implementado as habilidades especiais que fazem as criaturas atacarem no primeiro turno.
se o jogador digitar o aparecerá o campo do adversário e a vida do jogador inimigo

![Captura de tela 2024-10-07 201442](https://github.com/user-attachments/assets/051b14ef-73bc-48c4-9673-19301577ac27)
Digitando t vai passar a vez para o jogador 2 que repetirá o processo descrito acima
Porém a partir do segundo turno irá ocorrer uma mudança quando o jogador digitar b, aparece a opção de digitar a:

![Captura de tela 2024-10-07 201736](https://github.com/user-attachments/assets/582a9f4b-9bb7-4426-a5c4-af16609058bb)

Quando o jogador digitar a e ele ter alguma criatura em seu campo:

![Captura de tela 2024-10-07 201951](https://github.com/user-attachments/assets/f45c6d26-0390-46d3-8661-97a4f374b1bc)

Depois do Jogador digitar o número da criatura em seu campo:

![Captura de tela 2024-10-07 202118](https://github.com/user-attachments/assets/f4a1a853-c391-484b-8b22-9cfea4f8db9f)

Nesse caso, como o jogador inimigo não tem criaturas em seu campo, você poderá digitar 0 e atacar o jogador diretamente, caso o inimigo estivesse com criaturas em seu campo apareceria ao lado esquerdo um número começando de 1 até no máximo 30, alguns detalhes são: ainda não foi implementado a morte das criaturas, elas continuam no campo mesmo com sua resistência sendo menor ou igual a zero, não foi implementado um limite de ataques por criatura e as criaturas postas em campo já podem atacar a partir do segundo turno.

O fluxo do Jogo está ocorrendo no combate, ainda não foi feito outras partes como o menu de inicio e a montagem de decks, os dois jogadores estã com o mesmo deck, mas existe um sistema de embaralhamento para cada mão ser diferente.

O código roda na classe "principal" na pasta src e por enquanto existe apenas um único pacote chamado cartas.

Essas são as especificações por enquanto, algumas coisas como a visualização das cartas serão alteradas quando trabalharmos mais a interface, o projeto está rodando no terminal.


