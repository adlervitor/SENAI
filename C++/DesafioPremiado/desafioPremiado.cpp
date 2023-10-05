//Maria Fernanda, Emilly Rodrigues, Tayna, Daniele, Gustavo Tobias, Gustavo de Oliveira Vital, Pedro Lucas Ponciano, Philipp Yuri, Adler Vitor

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <Windows.h>
#include <vector>

using namespace std;

// Função que verifica se a resposta está certa e se tiver adiciona um ponto ao contador de acertos
void verificadorResposta(char respostaCerta, char resposta, int &acertos) {
    if (resposta == respostaCerta) {
        cout << "\033[1;32mRESPOSTA CORRETA!\033[0m\n"
             << endl;
        acertos++;
    } else {
        cout << "\033[1;31mVOCÊ ERROU!\033[0m" << endl;
        cout << "\033[1;31mA alternativa correta era a letra: \033[0m\n"
             << respostaCerta << endl;
    }
}

// Função que valida a resposta do usuário
char receberResposta() {
    char resposta;
    while (true) {
        cin >> resposta;
        resposta = tolower(resposta); // Converte a resposta para minúscula
        if (resposta == 'a' || resposta == 'b' || resposta == 'c' || resposta == 'd') {
            break; // Sai do loop se a entrada for válida
        } else {
            cout << "\033[1;31mResposta inválida. Por favor, digite 'a', 'b', 'c' ou 'd': \033[0m";
            cin.clear();
            cin.ignore(10000, '\n'); // Limpa o buffer do teclado até a próxima linha
        }
    }
    return resposta;
}

// Função que determina o grupo vencedor
string determinarGrupoVencedor(int pontuacao1, int pontuacao2, int pontuacao3) {
    if (pontuacao1 > pontuacao2 && pontuacao1 > pontuacao3) {
        return "\033[1;32mGrupo 01\033[0m";
    }
    else if (pontuacao2 > pontuacao1 && pontuacao2 > pontuacao3) {
        return "\033[1;32mGrupo 02\033[0m";
    }
    else if (pontuacao3 > pontuacao1 && pontuacao3 > pontuacao2) {
        return "\033[1;32mGrupo 03\033[0m";
    }
    else {
        return "\033[1;34mEmpate\033[0m";
    }
}

int main() {
    // Conserta os acentos no console
    SetConsoleOutputCP(CP_UTF8);

    cout << "+--------------------------------+" << endl;
    cout << "|   \033[1;35mBem-vindos ao questionário   |" << endl;
    cout << "|           do fundão!\033[0m           |" << endl;
    cout << "+--------------------------------+" << endl;
    // Inicialização das variáveis
    char respostaCerta1, respostaCerta2, respostaCerta3, respostaCerta4;
    char resposta1, resposta2, resposta3, resposta4;
    int pontuacao1 = 0, pontuacao2 = 0, pontuacao3 = 0, grupoNumero = 0;

    while (true) {
        cout << "╔════════════════════════════╗" << endl;
        cout << "║            \033[1;35mMenu\033[0m            ║" << endl;
        cout << "║ 1. Grupo 1                 ║" << endl;
        cout << "║ 2. Grupo 2                 ║" << endl;
        cout << "║ 3. Grupo 3                 ║" << endl;
        cout << "║ 4. Pontuações              ║" << endl;
        cout << "║ 5. Sair                    ║" << endl;
        cout << "║                            ║" << endl;
        cout << "║ Escolha uma opção:         ║";
        cout << "\n╚════════════════════════════╝" << endl;
        cout << endl;
        cin >> grupoNumero;
        // Validador de entrada do menu
        if (cin.fail()) {
            cout << "\033[1;31mEntrada inválida. Por favor, digite um número válido.\033[0m" << endl;
            cin.clear();
            cin.ignore(10000, '\n');
        } else if (grupoNumero == 5) {
            break;
        } else if (grupoNumero >= 1 && grupoNumero <= 4) {
            int acertos = 0;
            // Switch case principal
            switch (grupoNumero) {
            // Questionário do Grupo 1
            case 1:
                cout << "Olá Grupo 1!\n" << endl;

                cout << "\033[1m===== Pergunta 1. Loops =====\033[1m\n" << endl;
                cout << " Qual é o objetivo principal de usar loops em programação?" << endl;
                cout << " \033[3;36m[a]\033[0m Declarar variáveis" << endl;
                cout << " \033[3;36m[b]\033[0m Fazer cálculos complexos" << endl;
                cout << " \033[3;36m[c]\033[0m Executar um bloco de código repetidamente " << endl;
                cout << " \033[3;36m[d]\033[0m Definir funções " << endl;
                respostaCerta1 = 'c';
                resposta1 = receberResposta();
                verificadorResposta(respostaCerta1, resposta1, acertos);

                cout << "\033[1m===== Pergunta 2. Operadores lógicos =====\033[1m\n" << endl;
                cout << "Que operador lógico é usado para verificar se duas condições são ambas verdadeiras \n" << endl;
                cout << "\033[3;36m[a]\033[0m   || " << endl;
                cout << "\033[3;36m[b]\033[0m   &&" << endl;
                cout << "\033[3;36m[c]\033[0m   ! " << endl;
                cout << "\033[3;36m[d]\033[0m   == " << endl;
                respostaCerta4 = 'b';
                resposta4 = receberResposta();
                verificadorResposta(respostaCerta4, resposta4, acertos);

                cout << "\033[1m===== Pergunta 3. Bibliotecas =====\033[1m\n" << endl;
                cout << "Qual é a maneira correta de ler um número inteiro da entrada padrão (teclado) em C++? " << endl;
                cout << "\033[3;36m[a]\033[0m read() " << endl;
                cout << "\033[3;36m[b]\033[0m input() " << endl;
                cout << "\033[3;36m[c]\033[0m cin >> " << endl;
                cout << "\033[3;36m[d]\033[0m scanf() " << endl;
                respostaCerta3 = 'c';
                resposta3 = receberResposta();
                verificadorResposta(respostaCerta3, resposta3, acertos);

                cout << "\033[1m===== Pergunta 4. Vetores =====\033[1m\n" << endl;
                cout << "Para que serve um vetor em C++?" << endl;
                cout << "\033[3;36m[a]\033[0m Armazenar funções." << endl;
                cout << "\033[3;36m[b]\033[0m Armazenar tipos de dados diferentes." << endl;
                cout << "\033[3;36m[c]\033[0m Armazenar múltiplos valores do mesmo tipo" << endl;
                cout << "\033[3;36m[d]\033[0m Realizar operações lógicas" << endl;
                respostaCerta4 = 'c';
                resposta4 = receberResposta();
                verificadorResposta(respostaCerta4, resposta4, acertos);
                pontuacao1 = acertos;

                break;
            // Questionário do Grupo 2
            case 2:

                cout << "Olá Grupo 2!\n"<< endl;

                cout << "\033[1m===== Pergunta 1. Variáveis=====\033[1m\n" << endl; // Título da pergunta em itálico
                cout << "Qual das seguintes opções descreve corretamente a diferença entre as variáveis int e float?\n" << endl;
                cout << "\033[3;36m[a]\033[0m Ambos armazenam apenas números inteiros." << endl; // Alternativa em cor ciano (azul claro)
                cout << "\033[3;36m[b]\033[0m Variáveis int armazenam números inteiros, enquanto variáveis float armazenam números de ponto flutuante." << endl;
                cout << "\033[3;36m[c]\033[0m Variáveis float armazenam apenas números inteiros." << endl;
                cout << "\033[3;36m[d]\033[0m Variáveis int armazenam números inteiros, enquanto variáveis float armazenam aproximações de números reais com casas decimais." << endl;
                respostaCerta1 = 'b';
                resposta1 = receberResposta();
                verificadorResposta(respostaCerta1, resposta1, acertos);

                cout << "\033[1m===== Pergunta 2. Variáveis e Tipos de Dados =====\033[1m\n" << endl;
                cout << "Quais são os dois tipos de dados básicos em C++?\n" << endl;
                cout << "\033[3;36m[a]\033[0m Tipos de dados: int e char." << endl;
                cout << "\033[3;36m[b]\033[0m Tipos de dados: integer e double." << endl;
                cout << "\033[3;36m[c]\033[0m Tipos de dados: int e float." << endl;
                cout << "\033[3;36m[d]\033[0m Tipos de dados: double e string." << endl;
                respostaCerta2 = 'c';
                resposta2 = receberResposta();
                verificadorResposta(respostaCerta2, resposta2, acertos);

                cout << "\033[1m===== Pergunta 3. Funções  =====\033[1m\n" << endl;
                cout << "Qual é a sintaxe correta para declarar uma função em C++?\n" << endl;
                cout << "\033[3;36m[a]\033[0m funcao principal() " << endl;
                cout << "\033[3;36m[b]\033[0m tipo_da_funcao minhaFuncao() " << endl;
                cout << "\033[3;36m[c]\033[0m função : minhaFuncao " << endl;
                cout << "\033[3;36m[d]\033[0m declarar minhaFuncao; " << endl;
                respostaCerta3 = 'b';
                resposta3 = receberResposta();
                verificadorResposta(respostaCerta3, resposta3, acertos);

                cout << "\033[1m===== Pergunta 4. Vetores e Inserção de Informações =====\033[1m\n" << endl;
                cout << "Em C++, como você implementaria a inserção de um elemento em um vetor de forma eficiente, garantindo que a ordenação do vetor seja mantida?\n" << endl;
                cout << "\033[3;36m[a]\033[0m É impossível inserir um elemento em um vetor mantendo sua ordenação em C++." << endl;
                cout << "\033[3;36m[b]\033[0m Encontre a posição correta para inserção usando busca binária, mova os elementos maiores uma posição à frente e insira o novo elemento na posição adequada.\033[0m" << endl;
                cout << "\033[3;36m[c]\033[0m Copie o vetor original para um novo vetor, insira o novo elemento e, em seguida, reordene todo o vetor." << endl;
                cout << "\033[3;36m[d]\033[0m Utilize um algoritmo de ordenação para reorganizar o vetor após a inserção do novo elemento, mantendo a eficiência." << endl;
                respostaCerta4 = 'b';
                resposta4 = receberResposta();
                verificadorResposta(respostaCerta4, resposta4, acertos);
                pontuacao2 = acertos;
                break;
            // Questionário do Grupo 3
            case 3:
                cout << "Olá Grupo 3!" << endl;

                cout << "\033[1m===== Pergunta 1. Vetores =====\033[1m\n" << endl;
                cout << "Explique como declarar e inicializar um vetor de inteiros com 5 elementos em C++. Como você insere valores nesse vetor?" << endl;
                cout << "\033[3;36m[a]\033[0m vetor<int> = {5}; e insere valores usando a função push_back()." << endl;
                cout << "\033[3;36m[b]\033[0m int vetor[5] = {1, 2, 3, 4, 5}; e os valores são inseridos diretamente durante a inicialização." << endl;
                cout << "\033[3;36m[c]\033[0m vetor = [1, 2, 3, 4, 5]; e insere valores usando um loop for." << endl;
                cout << "\033[3;36m[d]\033[0m [d] int vetor[] = {5}; e insere valores usando um loop while." << endl;
                respostaCerta1 = 'b';
                resposta1 = receberResposta();
                verificadorResposta(respostaCerta1, resposta1, acertos);

                cout << "\033[1m===== Pergunta 2. Variáveis =====\033[1m\n" << endl;
                cout << "Qual é a função da diretiva #include ao utilizar bibliotecas em C++?" << endl;
                cout << "\033[3;36m[a]\033[0m Ela define o nome da biblioteca que será usada no programa." << endl;
                cout << "\033[3;36m[b]\033[0m Ela declara variáveis que serão usadas em todo o programa." << endl;
                cout << "\033[3;36m[c]\033[0m Ela inclui o conteúdo de uma biblioteca no código-fonte do programa." << endl;
                cout << "\033[3;36m[d]\033[0m Ela cria um novo espaço de memória para armazenar os elementos da biblioteca." << endl;

                respostaCerta2 = 'b';
                resposta2 = receberResposta();
                verificadorResposta(respostaCerta2, resposta2, acertos);

                cout << "\033[1m===== Pergunta 3. Vetores =====\033[1m\n" << endl;
                cout << "Como se declara um array unidimensional em C++?" << endl;
                cout << "\033[3;36m[a]\033[0m tipo_do_array nome_do_array[tamanho];" << endl;
                cout << "\033[3;36m[b]\033[0m array nome_do_array[tamanho];" << endl;
                cout << "\033[3;36m[c]\033[0m nome_do_array[tamanho] tipo_do_array;" << endl;
                cout << "\033[3;36m[d]\033[0m int nome_do_array[tamanho];;" << endl;
                respostaCerta3 = 'b';
                resposta3 = receberResposta();
                verificadorResposta(respostaCerta3, resposta3, acertos);

                cout << "\033[1m===== Pergunta 4. Loops =====\033[1m\n" << endl;
                cout << "O que faz o loop do-while em C++?" << endl;
                cout << "\033[3;36m[a]\033[0m Executa o bloco de código pelo menos uma vez, independentemente da condição." << endl;
                cout << "\033[3;36m[b]\033[0m É um loop exclusivo do C++ que não existe em outras linguagens de programação." << endl;
                cout << "\033[3;36m[c]\033[0m Executa o bloco de código enquanto a condição fornecida for verdadeira." << endl;
                cout << "\033[3;36m[d]\033[0m Realiza o loop por um número fixo de iterações, independentemente da condição." << endl;

                respostaCerta4 = 'a';
                resposta4 = receberResposta();
                verificadorResposta(respostaCerta4, resposta4, acertos);
                pontuacao3 = acertos;
                break;

            case 4:
                cout << "====== Pontuações ======" << endl;
                cout << "Pontuação do Grupo 1: " << pontuacao1 << "/4" << endl;
                cout << "Pontuação do Grupo 2: " << pontuacao2 << "/4" << endl;
                cout << "Pontuação do Grupo 3: " << pontuacao3 << "/4" << endl;
                break;

            default:
                cout << "Opção inválida." << endl;
                break;
            }
        } else {
            cout << "\033[1;31mOpção inválida.\033[0m" << endl;
        }
    }
    // Exibição do resultado
    cout << "Fim do questionário!" << endl;
    string vencedor = determinarGrupoVencedor(pontuacao1, pontuacao2, pontuacao3);
    cout << "\n\033[1m             Resultado: " << vencedor << "             \033[0m" << endl;

        return 0;

}
