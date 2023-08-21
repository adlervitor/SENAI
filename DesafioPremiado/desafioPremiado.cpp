#include <iostream>
#include <cstdlib>
#include <ctime>
#include <Windows.h>
#include <vector>

using namespace std;

// Esta função gera um número aleatório que representa um grupo, de acordo com a quantidade máxima de grupos especificada.
 //Pedro Ponciano
int sortearGrupo() {
    srand(time(0));
    int grupo = rand() % 3 + 1;
    return grupo;
}

 // Função que verifica se a resposta está certa e se tiver adiciona um ponto ao contador de acertos
void verificadorResposta(char respostaCerta, char resposta, int &acertos) {
    if (resposta == respostaCerta) {
        cout << "\033[1;32mRESPOSTA CORRETA!\033[0m\n" << endl;
        acertos++; 
    } else {
        cout << "\033[1;31mVOCÊ ERROU!\033[0m" << endl;
        cout << "\033[1;31mA alternativa correta era a letra: \033[0m\n" << respostaCerta << endl;
    }
}

// Função que valida a resposta do usuário
char receberResposta() {
    char resposta;
    cin >> resposta;
    while (resposta != 'a' && resposta != 'b' && resposta != 'c') {
        cout << "\033[1;31mResposta inválida. Por favor, digite 'a', 'b' ou 'c': \033[0m";
        cin >> resposta;
    }
    return resposta;
}

int main() {
    
    SetConsoleOutputCP(CP_UTF8);
    int opcao = 0;
    int maiorAcerto = 0;
    cout << "+--------------------------------+" << endl;
    cout << "|   \033[1mBem-vindos ao questionário   |" << endl;
    cout << "|           do fundão!\033[0m           |" << endl;
    cout << "+--------------------------------+" << endl;

    char respostaCerta1, respostaCerta2, respostaCerta3, respostaCerta4;
    char resposta1, resposta2, resposta3, resposta4;

    while (opcao != -1) {
        
        int grupoNumero = sortearGrupo();
        int acertos = 0;

        cout << "A grupo que responderá será a equipe: " << grupoNumero << endl;
        cout << "Pressione Enter para iniciar o questionário...\n";
        cin.get(); 

        // Switch-case do questionário, recebe o número do grupo sorteado como parâmetro
        switch (grupoNumero) {
        // Questionário do Grupo 1
        case 1:
            cout << "Olá Grupo 1!\n" << endl;

            cout << "\033[3;36m\033[m===== Pergunta 1. Tópico Variáveis e Tipos de Dados =====\033[1m\n" << endl;
            cout << "Qual é a diferença entre uma variável do tipo inteiro (int) e uma variável do tipo ponto flutuante (float) em C++?\n" << endl;
            cout << "[a] Ambos armazenam apenas números inteiros." << endl;
            cout << "[b] Variáveis int armazenam números inteiros, enquanto variáveis float armazenam números de ponto flutuante." << endl;
            cout << "\033[3;36m[c]\033[0m Variáveis float armazenam apenas números inteiros\033[3;36m\033[0m" << endl;
            respostaCerta1 = 'b';
            resposta1 = receberResposta();
            verificadorResposta(respostaCerta1, resposta1, acertos);

            cout << "\033[1m===== Pergunta 2: Funções e Bibliotecas =====\033[1m\n" << endl;
            cout << "Qual é a diferença entre uma variável do tipo inteiro (int) e uma variável do tipo ponto flutuante (float) em C++?\n" << endl;
            cout << "[a] Ambos armazenam apenas números inteiros." << endl;
            cout << "[b] Variáveis int armazenam números inteiros, enquanto variáveis float armazenam números de ponto flutuante." << endl;
            cout << "[c] Variáveis float armazenam apenas números inteiros" << endl;
            respostaCerta2 = 'b';
            resposta2 = receberResposta();
            verificadorResposta(respostaCerta2, resposta2, acertos);

            cout << "\033[1m===== Pergunta 3: Tópico =====\033[1m\n" << endl;
            cout << "Qual é a diferença entre uma variável do tipo inteiro (int) e uma variável do tipo ponto flutuante (float) em C++?\n" << endl;
            cout << "[a] Ambos armazenam apenas números inteiros." << endl;
            cout << "[b] Variáveis int armazenam números inteiros, enquanto variáveis float armazenam números de ponto flutuante." << endl;
            cout << "[a] Variáveis float armazenam apenas números inteiros" << endl;
            respostaCerta3 = 'b';
            resposta3 = receberResposta();
            verificadorResposta(respostaCerta3, resposta3, acertos);

            cout << "\033[1m===== Pergunta 4: Tópico =====\033[1m\n" << endl;
            cout << "Qual é a diferença entre uma variável do tipo inteiro (int) e uma variável do tipo ponto flutuante (float) em C++?\n" << endl;
            cout << "[a] Ambos armazenam apenas números inteiros." << endl;
            cout << "[b] Variáveis int armazenam números inteiros, enquanto variáveis float armazenam números de ponto flutuante.\033[0m" << endl;
            cout << "[c] Variáveis float armazenam apenas números inteiros" << endl;
            respostaCerta4 = 'b';
            resposta4 = receberResposta();
            verificadorResposta(respostaCerta4, resposta4, acertos);

            break;
        // Questionário do Grupo 2
        case 2:
            cout << "Olá Grupo 2!\n" << endl;

            cout << "\033[1m===== Pergunta 1. Tópico Funções e Bibliotecas\033[1m\n" << endl;
            cout << " Como você inclui a biblioteca de entrada e saída padrão (iostream) em um programa C++? Qual é o objetivo dessa biblioteca?" << endl;
            cout << " [a] Usando #include <inputoutput>. Ela lida com operações matemáticas." << endl;
            cout << " [b] Usando #include <iostream>. Ela lida com entrada e saída de dados." << endl;
            cout << " [c] Usando #include <stdio>. Ela lida com manipulação de strings." << endl;
            respostaCerta1 = 'b';
            resposta1 = receberResposta();
            verificadorResposta(respostaCerta1, resposta1, acertos);

            cout << "Pergunta 1. Tópico Funções e Bibliotecas" << endl;
            cout << "Qual é a diferença entre uma variável do tipo inteiro (int) e uma variável do tipo ponto flutuante (float) em C++?" << endl;
            cout << "[a] Ambos armazenam apenas números inteiros." << endl;
            cout << "[b] Variáveis int armazenam números inteiros, enquanto variáveis float armazenam números de ponto flutuante." << endl;
            cout << "[c] Variáveis float armazenam apenas números inteiros" << endl;
            respostaCerta2 = 'b';
            resposta2 = receberResposta();
            verificadorResposta(respostaCerta2, resposta2, acertos);

            cout << "Qual é a diferença entre uma variável do tipo inteiro (int) e uma variável do tipo ponto flutuante (float) em C++?" << endl;
            cout << "Pergunta 1. Tópico Exemplo?" << endl;
            cout << "[a] Ambos armazenam apenas números inteiros." << endl;
            cout << "[b] Variáveis int armazenam números inteiros, enquanto variáveis float armazenam números de ponto flutuante." << endl;
            cout << "[c] Variáveis float armazenam apenas números inteiros" << endl;
            respostaCerta3 = 'b';
            resposta3 = receberResposta();
            verificadorResposta(respostaCerta3, resposta3, acertos);

            cout << "Pergunta 1. Tópico" << endl;
            cout << "Qual é a diferença entre uma variável do tipo inteiro (int) e uma variável do tipo ponto flutuante (float) em C++?" << endl;
            cout << "[a] Ambos armazenam apenas números inteiros." << endl;
            cout << "[b] Variáveis int armazenam números inteiros, enquanto variáveis float armazenam números de ponto flutuante." << endl;
            cout << "[c] Variáveis float armazenam apenas números inteiros" << endl;
            respostaCerta4 = 'b';
            resposta4 = receberResposta();
            verificadorResposta(respostaCerta4, resposta4, acertos);
            break;
        // Questionário do Grupo 3
        case 3:
            cout << "Olá Grupo 3!" << endl;

            cout << "Pergunta 1. Tópico Vetores e Inserção de Informações" << endl;
            cout << "Explique como declarar e inicializar um vetor de inteiros com 5 elementos em C++. Como você insere valores nesse vetor?" << endl;
            cout << "[a] vetor<int> = {5}; e insere valores usando a função push_back()." << endl;
            cout << " [b] int vetor[5] = {1, 2, 3, 4, 5}; e os valores são inseridos diretamente durante a inicialização." << endl;
            cout << "[c] vetor = [1, 2, 3, 4, 5]; e insere valores usando um loop for." << endl;
            respostaCerta1 = 'b';
            resposta1 = receberResposta();
            verificadorResposta(respostaCerta1, resposta1, acertos);

            cout << "Pergunta 2. Tópico: Leitura de Dados e Loops " << endl;
            cout << "Qual função da biblioteca iostream é utilizada para ler um valor inteiro digitado pelo usuário? Descreva como você poderia usar um loop for para ler e armazenar 5 números inteiros fornecidos pelo usuário." << endl;
            cout << "[a] Ambos armazenam apenas números inteiros." << endl;
            cout << "[b] Variáveis int armazenam números inteiros, enquanto variáveis float armazenam números de ponto flutuante." << endl;
            cout << "[c] Variáveis float armazenam apenas números inteiros" << endl;
            respostaCerta2 = 'b';
            resposta2 = receberResposta();
            verificadorResposta(respostaCerta2, resposta2, acertos);
            
            cout << "Pergunta 3, Tópico: Vetores e Inserção de Informações " << endl;
            cout << "Em C++, como você implementaria a inserção de um elemento em um vetor de forma eficiente, garantindo que a ordenação do vetor seja mantida?" << endl;
            cout << "[a] É impossível inserir um elemento em um vetor mantendo sua ordenação em C++." << endl;
            cout << "[b] Encontre a posição correta para inserção usando busca binária, mova os elementos maiores uma posição à frente e insira o novo elemento na posição adequada." << endl;
            cout << "[c] Copie o vetor original para um novo vetor, insira o novo elemento e, em seguida, reordene todo o vetor." << endl;
            respostaCerta3 = 'b';
            resposta3 = receberResposta();
            verificadorResposta(respostaCerta3, resposta3, acertos);


            cout << "Pergunta 4, Tópico: Tipos de Dados e Conversões " << endl;
            cout << "Quais são os três tipos de dados básicos em C++? Se você tem uma variável do tipo int chamada valor, como você poderia convertê-la em um tipo double?" << endl;
            cout << "[a] Tipos de dados: int, double, char. Conversão: double novoValor = static_cast<double>(valor)" << endl;
            cout << "[b] Tipos de dados: integer, decimal, character. Conversão: novoValor = double(valor)" << endl;
            cout << "[c] Tipos de dados: int, float, string. Conversão: novoValor = (double) valor" << endl;
            respostaCerta4 = 'a';
            resposta4 = receberResposta();
            verificadorResposta(respostaCerta4, resposta4, acertos);

            break;

        default:
            cout << "Grupo não reconhecido." << endl;
        }
        
        if (acertos > maiorAcerto) {
            maiorAcerto = acertos; // Atualiza o maior número de acertos
        }
        cout << "Digite -1 para sair ou 0 para continuar: ";
        cin >> opcao;

        while (opcao != -1 && opcao != 0) {
            cout << "Opção inválida. Digite -1 para sair ou 0 para continuar: ";
            cin >> opcao;
        }
    }

    // Exibição da pontuação
    cout << "Fim do questionário!" << endl;
    cout << "Maior número de acertos: " << maiorAcerto << " pontos" << endl;

    return 0;

}

    


