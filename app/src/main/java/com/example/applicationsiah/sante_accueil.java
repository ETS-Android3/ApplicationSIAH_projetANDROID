package com.example.applicationsiah;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class sante_accueil extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);

        return true;
        //  retu rn super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.retour){
            retour();


        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sante_accueil);

        Integer poidskg;
        float taille_m;
         Integer taille_cm;
        float imc;
        SharedPreferences sharedPreferences = getSharedPreferences("utilisateur", MODE_PRIVATE);
       poidskg = sharedPreferences.getInt("util_poids",1);
       taille_cm=sharedPreferences.getInt("util_taille",2);
        taille_m =( taille_cm.floatValue() )/ (100);
        imc=0;TextView text = findViewById(R.id.textView71);
        try {
            imc = (poidskg.floatValue()) / (taille_m*taille_m) ;

            text.setText("Votre IMC est de : " + String.valueOf(imc));
        }catch (NumberFormatException i){

            text.setText("Calcul IMC indisponible veuillez vérifiez la saissie de vos informations persnnelles ");
        }




        TextView text1 = (TextView) findViewById(R.id.textIMC);
        text1.setText("");


        if (imc <= 18.5) {
            text1.setText("Vous avez une insuffisance corporelle, il serait nécessaire d'avoir une alimentation plus importante :\n" +
                    " - privilégier les protéines \n" +
                    "- les féculents à chacun des repas \n" +
                    "- consommer des glucides\n" +
                    "- des vitamines et du fer : n’hésitez pas à entamer dès maintenant une cure de fer si vous vous sentez faible quotidiennement! \n");
        }
        if (18.51 <= imc && imc >=24.5){
            text1.setText("Vous avez une corpulence de type normale continuer à avoir une alimentation saine et équilibrée, tout en privilégiant les protéines et les sucres lents avant chaque compétition. \n" +
                    "Voici le menu du champion: un bon plat de pate et une banane à la mi temps du match, le tout en buvant bien de l'eau. Vous possédez la morphologie idéale pour faire preuve de rapidité sur le terrain!\n");
        }

        if (24.51 <= imc && imc >= 30){
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
    private void retour() {
        Intent intent60 = new Intent(this, Menu_principal.class);
        startActivity(intent60);
    }
}