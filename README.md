# projetoSistemasInteligentes

Busca LRTA* com aprendizado ID3

Objetivos de aprendizagem
*compreender a aplicação de um algoritmo de busca on-line
*compreender como utilizar um algoritmo de aprendizado simbólico
*compreender como integrar algoritmos on-line (LRTA*), off-line (ID3) e outras
*estratégias compondo um sistema
*compreender como avaliar o desempenho dos algoritmos na prática

Um agente situado em um labirinto (ambiente grid 2D) deve chegar até uma fonte de água. Para se deslocar no ambiente, o agente necessita de energia que obtém de frutas (se
movimenta em todas as direções). Há uma fruta em cada posição do labirinto alcançável pelo agente (posições com paredes não têm frutas) cujas características (ver adiante) são sorteadas
aleatoriamente no início do jogo. Quando está na mesma posição da fruta, o agente pode deixá-la, comê-la ou guardá-la para quando necessitar de energia. As frutas podem fornecer
quantias distintas de energia dependendo das suas características particulares as quais o agente desconhece e terá que aprender após sucessivas execuções do sistema para o mesmo
labirinto.
Uma fruta é caracterizada pela madureza e quantidade dos seguintes elementos:
- madureza ∈ {verde, madura, podre}
- carboidratos ∈ {pouca, moderada, alta}
- fibras ∈ {pouca, moderada, alta}
- proteínas ∈ {pouca, moderada, alta}
- lipídeos ∈ {pouca, moderada, alta}
- energia ∈ {30, 140, 200}

Ganho de energia
O agente inicia com 300 Kcal. Uma fruta pode fornecer 30 Kcal, 140 Kcal ou 200 Kcal de energia em função de suas características (ver quadro seguinte). A capacidade máxima de energia que o agente somente consegue armazenar é de 600 Kcal. Tudo que ingerir em
excesso será desperdiçado.

Se (lipídeos=alta or moderada)
  Se (carboidratos=alta or moderada)
    Se (madurez=verde) então energia:=140
    Se (madurez=madura) então energia:=200
    Se (madurez=podre) então energia=30
  Se (carboidratos=pouca)
    Se (madurez=verde ou podre) então energia:=30
    Se (madurez=madura) então energia:=140
    
Se (lipídeos=pouca)
  Se (carboidratos=alta or carboidratos=moderada)
    Se (madurez=verde ou podre) então energia:=30
    Se (madurez=madura) então energia:=200
  Se não
    Se (proteínas=alta e fibras=alta e madurez!=podre)
      energia:=140
Todos os casos distintos dos acima: energia:=30


Gasto de energia
O agente gasta:
- 100 Kcal por movimento em qualquer direção do grid;
- 40 Kcal para comer uma fruta; e
- 5 Kcal por fruta guardada por movimento. Por exemplo, se andar 3 casas com 2 frutas guardadas gastará (3*5)*2 = 30 Kcal

Objetivo da tarefa
A partir do ambiente Grid 2D e do agente construídos nas tarefas anteriores, implemente o LRTA* (Learning real-time A*) para calcular o caminho da posição inicial até a fonte de água.
Ao se deslocar no caminho, o agente encontrará frutas e deverá decidir por comê-las, guardá-las ou deixá-las onde estão. Cada vez que decidir comer uma fruta, o agente saberá quanta
energia ganhou (por meio de uma função que você implementará de acordo com o pseudocódigo do quadro 1). Neste momento, o sistema deve incluir um registro no arquivo de
treinamento para o ID3 com as características da fruta (.arff).

SOMENTE APÓS O LRTA* ter encontrado o caminho ótimo e do sistema ter gerado um número suficiente instâncias no arquivo .arff, treine o algoritmo ID3 com o arquivo gerado.
Implemente a árvore de decisão no agente (manualmente) a fim de comparar o desempenho do agente antes e depois do aprendizado.
