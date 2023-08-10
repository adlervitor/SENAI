// ADLER VITOR SANTIAGO BARBOSA & PHILIPP YURI NUNES
// Bibliotecas
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <Windows.h>

using namespace std;
// Função que gera um vetor de 6 números aleatórios
vector<int> geradorDeNumeros() {
    srand(time(0));
    vector<int> numerosSorteados;

    while(numerosSorteados.size() != 6) {
        int novoNumero = rand() % 60 + 1;
        bool jaExiste = false;
        for(size_t i = 0; i < numerosSorteados.size(); i++){
            if(novoNumero == numerosSorteados[i]){
                jaExiste = true;
                break;
            }
        }
        if(!jaExiste) {
            numerosSorteados.push_back(novoNumero);
        }
    }
    return numerosSorteados;
}
// Função que verifica se o usuário já digitou o número
bool jaDigitou(vector<int> numeros, int num) {
    for(size_t i = 0; i < numeros.size(); i++) {
        if(num == numeros[i]){
            return true;
        }
    }
    return false;
}

int main() {
    // Conserta a acentuação no console
    SetConsoleOutputCP(CP_UTF8);
    // Cria o vetor de números aleatórios
    vector<int> numerosSorteados = geradorDeNumeros();
    int opcaoDoUsuario = 0;
    int tentativas = 0;

    cout << "============= Bem-vindo ao MEGA-SENAI! =============" << endl;
    cout << "Para vencer acerte os 6 números gerados pelo programa!" << endl;
    // Loop principal do jogo
    while(opcaoDoUsuario != -1) {
        // Vetor que armazena os números digitados pelo usuário
        vector<int> numerosUsuario, numerosAcertos;

        cout << "\nDigite 6 números inteiros entre 1 e 60: " << endl;
        // While que roda até o vetor numerosUsuario tiver 6 números
        while(numerosUsuario.size() != 6) {

            int num;
            cin >> num;
            // Valida o input do usuário
            while (cin.fail()) {
                cout << "Não é um número válido. Por favor, insira um número inteiro positivo." << endl;
                cin.clear();  // Limpa o estado de erro
                cin.ignore(); // Ignora o restante da entrada inválida até a próxima linha
                cout << "Digite a novamente: " << endl;
                cin >> num;
            }
            // Verifica se o número digitado e válido, se for, dá pushback no vetor
            if(num <= 60 && num >= 0 && !jaDigitou(numerosUsuario, num)){
                numerosUsuario.push_back(num);
            } else if(jaDigitou(numerosUsuario, num)) {
                cout << "Você já digitou esse número, tente outro." << endl;
            } else {
                cout << "Número inválido." << endl;
            }
        }
        // Verifica os acertos, comparando o vetor de números do usuário com o vetor de números sorteados
        int acertos = 0;
        for(int i = 0; i <= 6; i++) {
            for(int j = 0; j <= 6; j++){
                if(numerosUsuario[j] == numerosSorteados[i]){
                    acertos++;
                    numerosAcertos.push_back(numerosUsuario[j]);
                    break;
                }
            }
        }

        tentativas++; 

        if(acertos == 6) {
            cout << "Parabéns! Você venceu em " << tentativas << " tentativa(s) e ganhou absolutamente NADA!!!" << endl;
        } else if (acertos > 0) {
            // Mostra a quantidade de acertos e os números acertados pelo usuário
            cout << "Você acertou " << acertos << " número(s): " << endl;
            for(size_t i = 0; i < numerosAcertos.size(); i++) {
                cout << numerosAcertos[i] << endl;
            }
        } else {
            cout << "Você não acertou nenhum número." << endl;
        }
        
        cout << "Digite qualquer número para continuar ou -1 para sair." << endl;
        cin >> opcaoDoUsuario;

    }

    cout << "Obrigado por participar do MEGA-SENAI!" << endl;
    cout << "Os números sorteados eram:" << endl;
    
        for (size_t i = 0; i < numerosSorteados.size(); i++) {
        cout << numerosSorteados[i];
        if (i < numerosSorteados.size()) {
            cout << "  ";
        }
    }

    return 0;
}

