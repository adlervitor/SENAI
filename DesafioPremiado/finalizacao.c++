
    // Exibição das pontuações
    cout << "Pontuações finais:" << endl;
    for (int i = 0; i < 4; ++i) {
        cout << teamNames[i] << ": " << scores[i] << " ponto(s)" << endl;
    }

    // Encontrar a equipe vencedora
    int maxScoreIndex = 0;
    for (int i = 1; i < 4; ++i) {
        if (scores[i] > scores[maxScoreIndex]) {
            maxScoreIndex = i;
        }
    }
    cout << "A equipe vencedora é: " << teamNames[maxScoreIndex] << "!" << endl;

    return 0;
}