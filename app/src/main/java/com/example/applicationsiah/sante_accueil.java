package com.example.applicationsiah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class sante_accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sante_accueil);

        int poidskg;
        int taille_m;
        int taille_cm;
        int imc;
        taille_m = taille_cm / 100;
        imc = poidskg / (taille_m) ^ 2;


        TextView text1 = (TextView) findViewById(R.id.textIMC);
        text1.setText("");


        if (imc <= 18.5) {
            text1.setText("Vous avez une insuffisance corporelle, il serait nécessaire d'avoir une alimentation plus importante :\n" +
                    " - privilégier les protéines \n" +
                    "- les féculents à chacun des repas \n" +
                    "- consommer des glucides\n" +
                    "- des vitamines et du fer : n’hésitez pas à entamer dès maintenant une cure de fer si vous vous sentez faible quotidiennement! \n");
        }
        if (18.51 >>= imc =<<24.5){
            text1.setText("Vous avez une corpulence de type normale continuer à avoir une alimentation saine et équilibrée, tout en privilégiant les protéines et les sucres lents avant chaque compétition. \n" +
                    "Voici le menu du champion: un bon plat de pate et une banane à la mi temps du match, le tout en buvant bien de l'eau. Vous possédez la morphologie idéale pour faire preuve de rapidité sur le terrain!\n");
        }

        if (24.51 >>= imc =<<30){
            text1.setText("Vous avez une corpulence assez dévelopée avec un léger surpoids mais ce n'est pas un problème avec une bonne alimentation et de bons exercices ! L'alimentation représente 80% de l'effort total à fournir ! Pour cela commencez par supprimer les sucreries et tous types de grignotage et adopter les protéines et les glucides à votre quotidien petit à petit !");
        }

        if (imc >= 30) {
            text1.setText("L’alimentation va être la clé pour une progression rapide et pour avoir des résutats visibles rapidement: il faut arretez toutes les sucreries, sucres rapides et produits trop gras. Il est necessaire d'adopter un régime stricte et méthodique; les seuls aliments autorisés :\n" +
                    "- les proteines\n" +
                    "- les glucides \n" +
                    "- les fruits et les légumes \n" +
                    "\n");
        }
    }
}