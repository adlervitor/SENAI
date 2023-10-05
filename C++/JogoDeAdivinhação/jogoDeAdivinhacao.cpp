//Adler Vitor Santiago Barbosa & Philipp Yuri Nunes

// Bibliotecas
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <Windows.h>

using namespace std;
// Função que gera letras aleatórias
char* gerarLetraAleatoria(char alfabeto[], int numeroLetras){  
    char* letrasAleatorias = new char [numeroLetras - 1];
    srand(time(0)); 

    for(int i = 0; i < numeroLetras; i++){
        int num = rand() % 26;
        letrasAleatorias[i] = alfabeto[num];
    }
    return letrasAleatorias;
}
// Função que verifica se a letra digitada tem no alfabeto
bool verificarLetraAlfabeto(char alfabeto[], char letra, size_t tamanho){
    bool contem = false;

    for(size_t i = 0; i < tamanho; i++){
        if(letra == alfabeto[i]){
            contem = true;
            break;
        }
    }
    return contem;
}
// Função que verifica quantas vogais existe na lista
int ehVogal(char letras[], int numeroLetras){
    char vogais[] = {"AEIOUaeiou"};
    int qtdVogais = 0;
    
    for(int i = 0; i < numeroLetras; i++){
        for(size_t j = 0; j < sizeof(vogais); j++){
            if(letras[i] == vogais[j]){
            qtdVogais++;
            break;
            }
        }
    }
    return qtdVogais;
}

int main() {
    // Conserta acentuação
    SetConsoleOutputCP(CP_UTF8); 

    char alfabeto[] = {"abcdefghijklmnopqrstuvxwyz"};
    char letraUsuario;
    int tamanhoAlfabeto = sizeof(alfabeto) - 1;
    int opcao = 0;
    int acertos = 0; 
    int erros = 0;
    // Loop principal do jogo
    while (opcao != 2){

        int numeroDeLetras = 0;
        cout << "Digite a quantidade de letras a serem adivinhadas: " << endl;
        cin >> numeroDeLetras;

        char* letraAleatoria = gerarLetraAleatoria(alfabeto, numeroDeLetras);
        int tentativas = 0;
        bool ganhou = false;
        
        while (tentativas < 5 && ganhou == false){
            cout << "Digite uma letra do alfabeto (A-Z): " << endl;
            cin >> letraUsuario;
            letraUsuario = char(tolower(letraUsuario));
            // Verifica se a letra existe no alfabeto
            if (verificarLetraAlfabeto(alfabeto, letraUsuario, tamanhoAlfabeto)){
                // Verifica se a letra digitada pelo usuário está certa
                for(size_t i = 0; i < sizeof(letraAleatoria); i++){
                    if(letraUsuario == letraAleatoria[i]){
                        ganhou = true;
                        break;
                    }
                }

                if(ganhou == false) {
                    cout << "Você errou!" << endl;
                    cout << "A lista de letras possuem: " << ehVogal(letraAleatoria, numeroDeLetras) << " vogais." << endl;
                }
            } else {
                cout << "Letra não existe no alfabeto." << endl;
            }

            tentativas++;

        }

        if(ganhou){
            cout << "Você acertou em " << tentativas << " tentativas, parabéns!" << endl;
            cout << "As letras secretas eram: " << endl;
            for(size_t i = 0; i < sizeof(letraAleatoria); i++){
                cout << letraAleatoria[i] << endl;
            }
            acertos++;

        } else {
            cout << "Você perdeu, as letras secretas eram: " << endl;
            for(size_t i = 0; i < sizeof(letraAleatoria); i++){
                cout << letraAleatoria[i] << endl;
            }
            erros++;
        }

        cout << "Digite 1 para continuar jogando e 2 para sair: " << endl;
        cin >> opcao;
    }

    cout << "Você acertou " << acertos << " vezes e errou " << erros << " vezes." << endl;
    
    return 0;
}
