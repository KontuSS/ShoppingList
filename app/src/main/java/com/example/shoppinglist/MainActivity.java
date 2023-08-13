package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout foldableMenu;
    private Animation foldAnimation;
    private boolean isMenuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define foldable menu
        foldableMenu = findViewById(R.id.foldableMenu);
        foldAnimation = AnimationUtils.loadAnimation(this, R.anim.fold_animation);
        findViewById(R.id.toggleButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View V){
                if(isMenuOpen) {
                    foldMenu();
                }
                else{
                    expandMenu();
                }
            }
        });
    }
    private void expandMenu(){
        foldableMenu.setVisibility(View.VISIBLE);
        foldableMenu.startAnimation(foldAnimation);
        isMenuOpen = true;
    }
    private void foldMenu(){
        foldableMenu.startAnimation(foldAnimation);
        foldableMenu.setVisibility(View.GONE);
        isMenuOpen = false;
    }


    public void createItem(View V){
        //Pop-up input list name
        
        //------------------------------------------
        ConstraintLayout layout = findViewById(R.id.constraintLayout);
        ImageButton btn = (ImageButton)V;
        ConstraintLayout.LayoutParams btnLayoutParams = (ConstraintLayout.LayoutParams)btn.getLayoutParams();

        //Add new field with checkBox and inputText
        CheckBox newCheckBox = new CheckBox(this);
        layout.addView(newCheckBox);
        ConstraintLayout.LayoutParams layoutParamsCB = (ConstraintLayout.LayoutParams)newCheckBox.getLayoutParams();
        layoutParamsCB.topToTop = btnLayoutParams.topToTop;
        layoutParamsCB.bottomToBottom = btnLayoutParams.bottomToBottom;
        layoutParamsCB.startToStart = btnLayoutParams.startToStart;
        layoutParamsCB.endToEnd = btnLayoutParams.endToEnd;
        layoutParamsCB.verticalBias=btnLayoutParams.verticalBias;
        layoutParamsCB.horizontalBias=btnLayoutParams.horizontalBias;
        newCheckBox.setLayoutParams(layoutParamsCB);
        //----------------------------------------------------------------------------------------------------------
        EditText newEditText = new EditText(this);
        layout.addView(newEditText);
        ConstraintLayout.LayoutParams layoutParamsET = (ConstraintLayout.LayoutParams)newEditText.getLayoutParams();
        layoutParamsET.topToTop = btnLayoutParams.topToTop;
        layoutParamsET.bottomToBottom = btnLayoutParams.bottomToBottom;
        layoutParamsET.startToStart = btnLayoutParams.startToStart;
        layoutParamsET.endToEnd = btnLayoutParams.endToEnd;
        layoutParamsET.verticalBias=btnLayoutParams.verticalBias;
        layoutParamsET.horizontalBias=btnLayoutParams.horizontalBias+0.1f;
        layoutParamsET.editorAbsoluteX=btnLayoutParams.editorAbsoluteX;
        newEditText.setLayoutParams(layoutParamsET);
        //Change position of an add Button
        btnLayoutParams.verticalBias += 0.06f;
        btn.setLayoutParams(btnLayoutParams);
    }


}