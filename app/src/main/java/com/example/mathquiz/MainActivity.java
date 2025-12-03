package com.example.mathquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Déclaration des vues
    private TextView tvNumber1;
    private TextView tvNumber2;
    private TextView tvResult;
    private Button btnAddition;
    private Button btnSubtraction;
    private Button btnMultiplication;
    private Button btnGenerate;

    // Variables pour stocker les nombres
    private int number1;
    private int number2;

    // Générateur de nombres aléatoires
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation du générateur aléatoire
        random = new Random();

        // Récupération des références aux vues
        initializeViews();

        // Génération des premiers nombres
        generateNumbers();

        // Configuration des écouteurs d'événements
        setupClickListeners();
    }

    /**
     * Initialise toutes les vues de l'interface
     */
    private void initializeViews() {
        tvNumber1 = findViewById(R.id.tvNumber1);
        tvNumber2 = findViewById(R.id.tvNumber2);
        tvResult = findViewById(R.id.tvResult);
        btnAddition = findViewById(R.id.btnAddition);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnGenerate = findViewById(R.id.btnGenerate);
    }

    /**
     * Génère deux nombres aléatoires entre 111 et 999
     */
    private void generateNumbers() {
        // Génération de nombres entre 111 et 999 inclus
        number1 = random.nextInt(889) + 111; // 889 = 999 - 111 + 1
        number2 = random.nextInt(889) + 111;

        // Affichage des nombres dans les TextView
        tvNumber1.setText(String.valueOf(number1));
        tvNumber2.setText(String.valueOf(number2));

        // Réinitialisation du résultat
        tvResult.setText("?");
    }

    /**
     * Configure les écouteurs de clics pour tous les boutons
     */
    private void setupClickListeners() {
        // Bouton Addition
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        // Bouton Soustraction
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        // Bouton Multiplication
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('×');
            }
        });

        // Bouton Générer
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumbers();
            }
        });
    }

    /**
     * Effectue l'opération mathématique demandée et affiche le résultat
     * @param operation Le type d'opération (+, -, ×)
     */
    private void performOperation(char operation) {
        int result = 0;

        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '×':
                result = number1 * number2;
                break;
        }

        // Affichage du résultat
        tvResult.setText(String.valueOf(result));
    }
}